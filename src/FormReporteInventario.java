import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class FormReporteInventario extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JefeBodega auxiliar;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormReporteInventario frame = new FormReporteInventario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public FormReporteInventario(Actor actor) {
		try {
			auxiliar = new JefeBodega(actor.getId(), actor.getNombre(), actor.getContrasena());
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(contentPane, e2.getMessage());
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 703, 496);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 54, 667, 349);
		contentPane.add(scrollPane);
		
		String titulos[] = { "Id ", "Precio", "Tipo", "Garantia", "Marca",
		"Modelo", "Cantidad", "Ubicacion" };

		DefaultTableModel tableModel = new DefaultTableModel(titulos, 0);
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		
		JButton btnGenerar = new JButton("Generar");
		btnGenerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Producto> inventario = null;

				int rowCount = table.getRowCount();

				for (int i = rowCount - 1; i >= 0; i--) {
					tableModel.removeRow(i);
				}

				try {
					inventario = auxiliar.mostrarInventario();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}

				if (inventario != null) {
					for (int i = 0; i < inventario.size(); i++) {
						String id = inventario.get(i).getDescripcionProducto().getId();
						String precioVenta = String.valueOf(inventario.get(i).getDescripcionProducto().getPrecioVenta());
						String tipo = inventario.get(i).getDescripcionProducto().getTipo();
						String garantia = String.valueOf(inventario.get(i).getDescripcionProducto().getDiasGarantia());
						String marca = inventario.get(i).getDescripcionProducto().getMarca();
						String modelo = inventario.get(i).getDescripcionProducto().getModelo();
						String cantidad = String.valueOf(inventario.get(i).getCantidad());
						String ubicacion = inventario.get(i).getUbicacion();
						Object[] objs = { id, precioVenta, tipo, garantia, marca, modelo, cantidad, ubicacion };
						tableModel.addRow(objs);
					}
				} else {
					JOptionPane.showMessageDialog(null, "no hay productos en el inventario");
				}
			}
		});
		btnGenerar.setBounds(10, 414, 90, 36);
		contentPane.add(btnGenerar);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		btnCerrar.setBounds(588, 424, 89, 23);
		contentPane.add(btnCerrar);
		
		JLabel lblNewLabel = new JLabel("Reporte Inventario");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(256, 11, 179, 28);
		contentPane.add(lblNewLabel);
	}
}

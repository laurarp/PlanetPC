import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Choice;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;


public class FormRegistrarCompra  extends JFrame{

	private JFrame frame;
	private DefaultTableModel dtm ;
	private JTable table;
	private JTextField textIdCompra;
	private JLabel lblNewLabel_1;
	private JButton btnRegistrar;
	private AsesorVentas asesorVentas = null;
	private ListaProveedores lp=null;

	public FormRegistrarCompra(Actor actor) 
	{
		try 
		{
			this.asesorVentas=new AsesorVentas(actor.getId(), actor.getNombre(), actor.getContrasena());
			this.lp=new ListaProveedores();
			initialize();
		} 
		catch (Exception e) 
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		setFrame(new JFrame());
		getFrame().getContentPane().setBackground(Color.WHITE);
		getFrame().setBounds(100, 100, 581, 362);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Proveedor");
		lblNewLabel.setBounds(24, 22, 69, 14);
		getFrame().getContentPane().add(lblNewLabel);

		String titulos[] = { "Id Compra", "Tipo", "Cantidad", "Valor",
				"Fecha pedido", "Estado" };

		DefaultTableModel tableModel = new DefaultTableModel(titulos, 0);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 62, 506, 170);
		getFrame().getContentPane().add(scrollPane);
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);

		textIdCompra = new JTextField();
		textIdCompra.setBounds(24, 282, 86, 20);
		getFrame().getContentPane().add(textIdCompra);
		textIdCompra.setColumns(10);

		lblNewLabel_1 = new JLabel("Id Compra");
		lblNewLabel_1.setBounds(24, 257, 69, 14);
		getFrame().getContentPane().add(lblNewLabel_1);

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					asesorVentas.notificarCompraRecibida(textIdCompra.getText());

					for (int i = 0; i < tableModel.getRowCount(); i++) {
						tableModel.removeRow(i);
					}
					textIdCompra.setText("");
					JOptionPane.showMessageDialog(null,
							"Compra registrada correctamente");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		btnRegistrar.setBounds(176, 274, 89, 23);
		getFrame().getContentPane().add(btnRegistrar);

		Choice chProveedores = new Choice();
		for (int i = 0; i < lp.mostrarProveedores().size(); i++) {
			chProveedores.addItem(lp.mostrarProveedores().get(i).getNombre());
		}
		chProveedores.setBounds(99, 16, 79, 20);
		getFrame().getContentPane().add(chProveedores);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				ArrayList<Compra> pendientes = null;

				int rowCount = tableModel.getRowCount();

				for (int i = rowCount - 1; i >= 0; i--) {
					tableModel.removeRow(i);
				}

				try {
					pendientes = asesorVentas
							.obtenerPedidosPendientesProveedor(lp
									.buscarIdProveedor(chProveedores
											.getSelectedItem()));

					if (pendientes != null) {
						for (int i = 0; i < pendientes.size(); i++) {
							String idcompra = Integer.toString(pendientes
									.get(i).getIdCompra());
							String tipo = pendientes.get(i)
									.getDescripcionProducto().getTipo();
							String cantidad = Integer.toString(pendientes
									.get(i).getCantidad());
							String valor = Integer.toString(pendientes.get(i)
									.getPrecioCompra());
							String fechap = pendientes.get(i).getFechaPedido()
									.toString();
							String estado = pendientes.get(i).getEstado();
							Object[] objs = { idcompra, tipo, cantidad, valor,
									fechap, estado };
							tableModel.addRow(objs);
						}
					} else {
						JOptionPane.showMessageDialog(null,
								"No hay pedidos pendientes");
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		btnConsultar.setBounds(203, 18, 89, 23);
		getFrame().getContentPane().add(btnConsultar);
	}
		
	

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}

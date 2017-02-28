import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FormUbicarProducto extends JFrame {

	private JPanel contentPane;
	private JTextField textId;
	private JTextField textCantidad;
	private JTextField textUbicacion;
	private AuxiliarAlmacenamiento auxiliar;
	private JTable table;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormUbicarProducto frame = new FormUbicarProducto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 * @param actor 
	 */
	public FormUbicarProducto(Actor actor) {
		try {
			auxiliar = new AuxiliarAlmacenamiento(actor.getId(), actor.getNombre(), actor.getContrasena());
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(contentPane, e2.getMessage());
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 559, 549);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ubicar Producto");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(156, 11, 163, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblIdDelProducto = new JLabel("Id del producto en el catalogo");
		lblIdDelProducto.setBounds(10, 34, 150, 14);
		contentPane.add(lblIdDelProducto);
		
		textId = new JTextField();
		textId.setBounds(170, 31, 86, 20);
		contentPane.add(textId);
		textId.setColumns(10);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 59, 46, 14);
		contentPane.add(lblCantidad);
		
		JLabel lblUbicacion = new JLabel("Ubicacion");
		lblUbicacion.setBounds(10, 84, 46, 14);
		contentPane.add(lblUbicacion);
		
		textCantidad = new JTextField();
		textCantidad.setBounds(170, 56, 86, 20);
		contentPane.add(textCantidad);
		textCantidad.setColumns(10);
		
		textUbicacion = new JTextField();
		textUbicacion.setBounds(170, 81, 86, 20);
		contentPane.add(textUbicacion);
		textUbicacion.setColumns(10);
		try {
			auxiliar = new AuxiliarAlmacenamiento("1004s","Pepito","pepito1309");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JButton btnNewButton = new JButton("Ubicar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int c = 0;
				boolean intentar = true;
				boolean intentar2 = true;
				try{
					c = Integer.parseInt(textCantidad.getText());
					intentar = true;
				}catch (NumberFormatException e){
					  intentar = false;
					  JOptionPane.showMessageDialog(contentPane, "Cantidad debe ser un numero entero");
					  textCantidad.setText("");
				}
				if (textId.getText().isEmpty()){
					intentar2 = false;
					JOptionPane.showMessageDialog(contentPane, "No ha ingresado el id del producto para ubicar");
				}
				if (intentar == true & intentar2==true){
				try {
					auxiliar.ubicarProducto(textId.getText(), Integer.parseInt(textCantidad.getText()), textUbicacion.getText());
					textId.setText("");
					textCantidad.setText("");
					textUbicacion.setText("");
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(contentPane, e.getMessage());
				}
				}
				
			}
		});
		btnNewButton.setBounds(71, 108, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cerrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		btnNewButton_1.setBounds(446, 477, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 142, 426, 358);
		contentPane.add(scrollPane);
		String titulos[] = { "Id ", "Precio", "Tipo", "Garantia", "Marca",
		"Modelo" };
		DefaultTableModel tableModel = new DefaultTableModel(titulos, 0);
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		ArrayList<DescripcionProducto> catalogo = null;

		int rowCount = table.getRowCount();

		for (int i = rowCount - 1; i >= 0; i--) {
			tableModel.removeRow(i);
		}

		try {
			catalogo = auxiliar.mostrarCatalogo();
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}

		if (catalogo != null) {
			for (int i = 0; i < catalogo.size(); i++) {
				String id = catalogo.get(i).getId();
				String precioVenta = String.valueOf(catalogo.get(i).getPrecioVenta());
				String tipo = catalogo.get(i).getTipo();
				String garantia = String.valueOf(catalogo.get(i).getDiasGarantia());
				String marca = catalogo.get(i).getMarca();
				String modelo = String.valueOf(catalogo.get(i).getModelo());
				
				Object[] objs = { id, precioVenta, tipo, garantia, marca, modelo };
				tableModel.addRow(objs);
			}
		} else {
			JOptionPane.showMessageDialog(null, "no hay productos en el catalogo");
		}
	}
}

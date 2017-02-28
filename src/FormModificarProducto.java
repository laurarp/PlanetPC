import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;


public class FormModificarProducto extends JFrame {

	private JPanel contentPane;
	private AuxiliarAlmacenamiento auxiliar;
	private JTable table;
	private JTextField textField;
	private JLabel lblId;
	private JTextField textField_2;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JButton btnGuardarCambios;
	private JLabel lblNuevoId;
	private JLabel lblNuevoPrecioVenta;
	private JLabel lblNuevoTipo;
	private JLabel lblNuevaGarantia;
	private JLabel lblNuev;
	private JLabel lblNuevoModelo;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormModificarProducto frame = new FormModificarProducto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormModificarProducto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 667, 573);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCatalogo = new JLabel("Catalogo");
		lblCatalogo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCatalogo.setBounds(20, 40, 106, 23);
		contentPane.add(lblCatalogo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 69, 607, 297);
		contentPane.add(scrollPane);
		String titulos[] = { "Id ", "Precio", "Tipo", "Garantia", "Marca",
				"Modelo" };
		
		DefaultTableModel tableModel = new DefaultTableModel(titulos, 0);
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		try {
			auxiliar = new AuxiliarAlmacenamiento("1004s","Pepito","pepito1309");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JButton btnSeleccionar = new JButton("Mostrar");
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		});
		btnSeleccionar.setBounds(10, 377, 89, 23);
		contentPane.add(btnSeleccionar);
		
		textField = new JTextField();
		textField.setBounds(272, 378, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblId = new JLabel("Id del producto a modificar");
		lblId.setBounds(109, 381, 188, 14);
		contentPane.add(lblId);
		
		textField_2 = new JTextField();
		textField_2.setBounds(132, 442, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(132, 411, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(132, 473, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(384, 411, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(384, 442, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(384, 473, 86, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		btnGuardarCambios = new JButton("Guardar cambios");
		btnGuardarCambios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int pv = 0;
				int dg = 0;
				boolean intentar = true;
				boolean intentar2 = true;
				if (!textField_2.getText().isEmpty()){
					try{
						pv = Integer.parseInt(textField_2.getText());
						intentar = true;
					}catch (NumberFormatException e){
						  intentar = false;
						  JOptionPane.showMessageDialog(contentPane, "Precio debe ser numero entero");
						  textField_2.setText("");
					}
				}
				if (!textField_4.getText().isEmpty()){
					try{
						dg = Integer.parseInt(textField_4.getText());
						intentar = true;
					}catch (NumberFormatException e){
						  intentar = false;
						  JOptionPane.showMessageDialog(contentPane, "Garantia debe ser numero entero");
						  textField_4.setText("");
					}
				}	
				if (textField.getText().isEmpty()){
					intentar2 = false;
					JOptionPane.showMessageDialog(contentPane, "No ha ingresado el id del producto a modificar");
				}
				if (intentar==true && intentar2 ==true){
				try {
					auxiliar.modificarProductoCatalogo(textField.getText(), textField_1.getText(), textField_2.getText(), textField_3.getText(), textField_4.getText(), textField_5.getText(), textField_6.getText());
					textField.setText("");
					textField_2.setText("");
					textField_1.setText("");
					textField_3.setText("");
					textField_4.setText("");
					textField_5.setText("");
					textField_6.setText("");
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Excepciones e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(contentPane, e.getMessage());
				}
				}
				
			}
		});
		btnGuardarCambios.setBounds(222, 501, 151, 23);
		contentPane.add(btnGuardarCambios);
		
		lblNuevoId = new JLabel("Nuevo Id");
		lblNuevoId.setBounds(10, 414, 116, 14);
		contentPane.add(lblNuevoId);
		
		lblNuevoPrecioVenta = new JLabel("Nuevo precio");
		lblNuevoPrecioVenta.setBounds(10, 445, 116, 14);
		contentPane.add(lblNuevoPrecioVenta);
		
		lblNuevoTipo = new JLabel("Nuevo tipo");
		lblNuevoTipo.setBounds(10, 476, 116, 14);
		contentPane.add(lblNuevoTipo);
		
		lblNuevaGarantia = new JLabel("Nueva garantia");
		lblNuevaGarantia.setBounds(246, 414, 128, 14);
		contentPane.add(lblNuevaGarantia);
		
		lblNuev = new JLabel("Nueva marca");
		lblNuev.setBounds(246, 445, 128, 14);
		contentPane.add(lblNuev);
		
		lblNuevoModelo = new JLabel("Nuevo modelo");
		lblNuevoModelo.setBounds(246, 476, 128, 14);
		contentPane.add(lblNuevoModelo);
		
		JLabel lblModificarProducto = new JLabel("Modificar Producto");
		lblModificarProducto.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblModificarProducto.setBounds(222, 11, 235, 34);
		contentPane.add(lblModificarProducto);
		
		btnNewButton = new JButton("Cerrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		btnNewButton.setBounds(538, 501, 89, 23);
		contentPane.add(btnNewButton);
	}
}

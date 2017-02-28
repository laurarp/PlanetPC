import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class FormCrearProveedor extends JFrame {

	private JFrame frmCrearProveedor;
	private JTextField textField;
	private JTextField textField_1;
	private Administrador Admin;

	/**
	 * Create the application.
	 * @param actor 
	 */
	public FormCrearProveedor(Actor actor) {
		try 
		{
			Admin = new Administrador(actor.getId(),actor.getNombre(),actor.getContrasena());
			initialize();
		} 
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrmCrearProveedor(new JFrame());
		getFrmCrearProveedor().setBounds(100, 100, 450, 372);
		getFrmCrearProveedor().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getFrmCrearProveedor().getContentPane().setLayout(null);
		
		JLabel lblIngresaElNombre = new JLabel("Ingresa el nombre del proveedor");
		lblIngresaElNombre.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblIngresaElNombre.setBounds(15, 81, 257, 20);
		getFrmCrearProveedor().getContentPane().add(lblIngresaElNombre);
		
		textField = new JTextField();
		textField.setBounds(15, 117, 146, 26);
		getFrmCrearProveedor().getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblIngresaElId = new JLabel("Ingresa el id del proveedor");
		lblIngresaElId.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblIngresaElId.setBounds(15, 159, 257, 20);
		getFrmCrearProveedor().getContentPane().add(lblIngresaElId);
		
		textField_1 = new JTextField();
		textField_1.setBounds(15, 195, 146, 26);
		getFrmCrearProveedor().getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (textField.getText().isEmpty()||textField_1.getText().isEmpty()){
						JOptionPane.showMessageDialog(null, "Rellene todos los campos");
					}else{
					Admin.crearProveedor(textField.getText(), textField_1.getText());
					JOptionPane.showMessageDialog(null, "Proveedor creado correctamente");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		btnCrear.setBounds(157, 237, 115, 29);
		getFrmCrearProveedor().getContentPane().add(btnCrear);
		
		JLabel lblCrearProveedores = new JLabel("Crear Proveedores");
		lblCrearProveedores.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblCrearProveedores.setBounds(15, 30, 214, 35);
		frmCrearProveedor.getContentPane().add(lblCrearProveedores);
	}

	public JFrame getFrmCrearProveedor() {
		return frmCrearProveedor;
	}

	public void setFrmCrearProveedor(JFrame frmCrearProveedor) {
		this.frmCrearProveedor = frmCrearProveedor;
		frmCrearProveedor.getContentPane().setBackground(Color.WHITE);
	}
}
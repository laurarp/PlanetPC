import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class FormModificarProveedor {

	private JFrame frmModificarProveedor;
	private JTextField textField;
	private JTextField textField_1;
	private Administrador Admin;

	/**
	 * Create the application.
	 */
	public FormModificarProveedor(Actor actor) {
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
		frmModificarProveedor = new JFrame();
		frmModificarProveedor.getContentPane().setBackground(Color.WHITE);
		frmModificarProveedor.setBounds(100, 100, 450, 335);
		frmModificarProveedor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmModificarProveedor.getContentPane().setLayout(null);
		
		JLabel lblIngreseElId = new JLabel("Ingrese el id del proveedor");
		lblIngreseElId.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblIngreseElId.setBounds(15, 78, 215, 20);
		frmModificarProveedor.getContentPane().add(lblIngreseElId);
		
		textField = new JTextField();
		textField.setBounds(15, 114, 146, 26);
		frmModificarProveedor.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblIngreseElNuevo = new JLabel("Ingrese el nuevo nombre del proveedor");
		lblIngreseElNuevo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblIngreseElNuevo.setBounds(15, 156, 290, 20);
		frmModificarProveedor.getContentPane().add(lblIngreseElNuevo);
		
		textField_1 = new JTextField();
		textField_1.setBounds(15, 192, 146, 26);
		frmModificarProveedor.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnCambiar = new JButton("Cambiar");
		btnCambiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (textField.getText()==null||textField_1.getText()==null){
						JOptionPane.showMessageDialog(null, "El campo esta vacio");
					}else{
					Admin.modificarProveedor(textField.getText(),textField_1.getText());
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnCambiar.setBounds(144, 234, 115, 29);
		frmModificarProveedor.getContentPane().add(btnCambiar);
		
		JLabel lblModificarProveedor = new JLabel("Modificar proveedor");
		lblModificarProveedor.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblModificarProveedor.setBounds(15, 16, 244, 46);
		frmModificarProveedor.getContentPane().add(lblModificarProveedor);
	}
	public JFrame getFrmModificarProveedor() {
		return frmModificarProveedor;
	}

	public void setFrmModificarProveedor(JFrame frmBuscarProveedor) {
		this.frmModificarProveedor = frmBuscarProveedor;
	}
}

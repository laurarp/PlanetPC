import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		getFrmCrearProveedor().setTitle("Crear Proveedor");
		getFrmCrearProveedor().setBounds(100, 100, 450, 300);
		getFrmCrearProveedor().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getFrmCrearProveedor().getContentPane().setLayout(null);
		
		JLabel lblIngresaElNombre = new JLabel("Ingresa el nombre del proveedor");
		lblIngresaElNombre.setBounds(15, 16, 257, 20);
		getFrmCrearProveedor().getContentPane().add(lblIngresaElNombre);
		
		textField = new JTextField();
		textField.setBounds(15, 55, 146, 26);
		getFrmCrearProveedor().getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblIngresaElId = new JLabel("Ingresa el id del proveedor");
		lblIngresaElId.setBounds(15, 97, 257, 20);
		getFrmCrearProveedor().getContentPane().add(lblIngresaElId);
		
		textField_1 = new JTextField();
		textField_1.setBounds(15, 133, 146, 26);
		getFrmCrearProveedor().getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (textField.getText()==null||textField_1.getText()==null){
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
		btnCrear.setBounds(158, 183, 115, 29);
		getFrmCrearProveedor().getContentPane().add(btnCrear);
	}

	public JFrame getFrmCrearProveedor() {
		return frmCrearProveedor;
	}

	public void setFrmCrearProveedor(JFrame frmCrearProveedor) {
		this.frmCrearProveedor = frmCrearProveedor;
	}
}
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormEliminarUsuario extends JFrame {

	private JFrame frmEliminarUsuario;
	private JTextField textField;
	private Administrador Admin;

	/**
	 * Create the application.
	 */
	public FormEliminarUsuario(Actor actor) {
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
		frmEliminarUsuario = new JFrame();
		frmEliminarUsuario.setTitle("Eliminar usuario");
		frmEliminarUsuario.setBounds(100, 100, 450, 228);
		frmEliminarUsuario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmEliminarUsuario.getContentPane().setLayout(null);
		
		JLabel lblIngreseElId = new JLabel("Ingrese el id del usuario a eliminar");
		lblIngreseElId.setBounds(15, 16, 262, 20);
		frmEliminarUsuario.getContentPane().add(lblIngreseElId);
		
		textField = new JTextField();
		textField.setBounds(15, 52, 146, 26);
		frmEliminarUsuario.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (textField.getText()==null){
						JOptionPane.showMessageDialog(null, "Rellene todos los campos");
					}else{
					Admin.eliminarUsuario(textField.getText());
					JOptionPane.showMessageDialog(null, "Usuario eliminado");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		btnEliminar.setBounds(149, 118, 115, 29);
		frmEliminarUsuario.getContentPane().add(btnEliminar);
	}
	public JFrame getFrmEliminarUsuario() {
		return frmEliminarUsuario;
	}

	public void setFrmCrearProveedor(JFrame frmEliminarUsuario) {
		this.frmEliminarUsuario = frmEliminarUsuario;
	}
}

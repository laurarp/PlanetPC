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
		frmEliminarUsuario.getContentPane().setBackground(Color.WHITE);
		frmEliminarUsuario.setBounds(100, 100, 450, 304);
		frmEliminarUsuario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmEliminarUsuario.getContentPane().setLayout(null);
		
		JLabel lblIngreseElId = new JLabel("Ingrese el id del usuario a eliminar");
		lblIngreseElId.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblIngreseElId.setBounds(15, 73, 262, 20);
		frmEliminarUsuario.getContentPane().add(lblIngreseElId);
		
		textField = new JTextField();
		textField.setBounds(15, 109, 146, 26);
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
		btnEliminar.setBounds(148, 181, 115, 29);
		frmEliminarUsuario.getContentPane().add(btnEliminar);
		
		JLabel lblEliminarUsuario = new JLabel("Eliminar usuario");
		lblEliminarUsuario.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblEliminarUsuario.setBounds(15, 16, 262, 41);
		frmEliminarUsuario.getContentPane().add(lblEliminarUsuario);
	}
	public JFrame getFrmEliminarUsuario() {
		return frmEliminarUsuario;
	}

	public void setFrmCrearProveedor(JFrame frmEliminarUsuario) {
		this.frmEliminarUsuario = frmEliminarUsuario;
	}
}

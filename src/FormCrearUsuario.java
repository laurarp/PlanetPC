import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.awt.Choice;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;


public class FormCrearUsuario {

	private JFrame frame;
	private JTextField textNombre;
	private JTextField textCedula;
	private JPasswordField contrasena;
	private Administrador admin;

	/**
	 * Create the application.
	 */
	public FormCrearUsuario(Actor actor) {
		try 
		{
			admin= new Administrador(actor.getId(), actor.getNombre(), actor.getContrasena());
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
		getFrame().setBounds(100, 100, 415, 276);
		getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNombre.setBounds(31, 67, 92, 14);
		getFrame().getContentPane().add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textNombre.setBounds(145, 64, 223, 20);
		getFrame().getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblCedula = new JLabel("Cedula");
		lblCedula.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblCedula.setBounds(31, 92, 92, 14);
		getFrame().getContentPane().add(lblCedula);
		
		textCedula = new JTextField();
		textCedula.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textCedula.setBounds(145, 91, 223, 20);
		getFrame().getContentPane().add(textCedula);
		textCedula.setColumns(10);
		
		JLabel lblContrasena = new JLabel("Contrase\u00F1a");
		lblContrasena.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblContrasena.setBounds(31, 123, 92, 14);
		getFrame().getContentPane().add(lblContrasena);
		
		contrasena = new JPasswordField();
		contrasena.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		contrasena.setBounds(145, 122, 223, 20);
		getFrame().getContentPane().add(contrasena);
		
		Choice choiceTipo = new Choice();
		choiceTipo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		choiceTipo.addItem("Administrador");
		choiceTipo.addItem("Jefe de bodega");
		choiceTipo.addItem("Auxiliar de almacenamiento");
		choiceTipo.addItem("Auxiliar de servicio técnico");
		choiceTipo.addItem("Asistente de compras y ventas");
		choiceTipo.setBounds(145, 148, 223, 22);
		getFrame().getContentPane().add(choiceTipo);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTipo.setBounds(31, 154, 108, 14);
		getFrame().getContentPane().add(lblTipo);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try 
				{
					admin.crearUsuario(textCedula.getText(), textNombre.getText(),contrasena.getText(), choiceTipo.getSelectedItem());
					textNombre.setText("");
					textCedula.setText("");
					contrasena.setText("");
					JOptionPane.showMessageDialog(null, "Usuario creado correctamente");
				} 
				catch (Exception e) 
				{
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		btnCrear.setBounds(145, 184, 128, 23);
		getFrame().getContentPane().add(btnCrear);
		
		JLabel lblCrearUsuario = new JLabel("Crear usuario");
		lblCrearUsuario.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblCrearUsuario.setBounds(115, 22, 175, 23);
		frame.getContentPane().add(lblCrearUsuario);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
		frame.getContentPane().setBackground(new Color(255, 255, 255));
	}
}

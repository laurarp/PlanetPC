import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Choice;
import javax.swing.JButton;


public class FormCrearUsuario {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormCrearUsuario window = new FormCrearUsuario();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FormCrearUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(49, 46, 46, 14);
		frame.getContentPane().add(lblNombre);
		
		textField = new JTextField();
		textField.setBounds(145, 43, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblCedula = new JLabel("Cedula");
		lblCedula.setBounds(49, 92, 46, 14);
		frame.getContentPane().add(lblCedula);
		
		textField_1 = new JTextField();
		textField_1.setBounds(145, 89, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblContrasena = new JLabel("Contrase\u00F1a");
		lblContrasena.setBounds(49, 133, 46, 14);
		frame.getContentPane().add(lblContrasena);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(145, 130, 86, 20);
		frame.getContentPane().add(passwordField);
		
		Choice choice = new Choice();
		choice.addItem("Administrador");
		choice.setBounds(145, 170, 86, 20);
		frame.getContentPane().add(choice);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(49, 176, 46, 14);
		frame.getContentPane().add(lblTipo);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.setBounds(117, 212, 89, 23);
		frame.getContentPane().add(btnCrear);
	}
}

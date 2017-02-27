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
		getFrame().setBounds(100, 100, 450, 300);
		getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(49, 46, 46, 14);
		getFrame().getContentPane().add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(145, 43, 86, 20);
		getFrame().getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblCedula = new JLabel("Cedula");
		lblCedula.setBounds(49, 92, 46, 14);
		getFrame().getContentPane().add(lblCedula);
		
		textCedula = new JTextField();
		textCedula.setBounds(145, 89, 86, 20);
		getFrame().getContentPane().add(textCedula);
		textCedula.setColumns(10);
		
		JLabel lblContrasena = new JLabel("Contrase\u00F1a");
		lblContrasena.setBounds(49, 133, 46, 14);
		getFrame().getContentPane().add(lblContrasena);
		
		contrasena = new JPasswordField();
		contrasena.setBounds(145, 130, 86, 20);
		getFrame().getContentPane().add(contrasena);
		
		Choice choiceTipo = new Choice();
		choiceTipo.addItem("Administrador");
		choiceTipo.addItem("Jefe de bodega");
		choiceTipo.addItem("Auxiliar de almacenamiento");
		choiceTipo.addItem("Auxiliar de servicio técnico");
		choiceTipo.addItem("Asistente de compras y ventas");
		choiceTipo.setBounds(145, 170, 86, 20);
		getFrame().getContentPane().add(choiceTipo);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(49, 176, 46, 14);
		getFrame().getContentPane().add(lblTipo);
		
		JButton btnCrear = new JButton("Crear");
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
		btnCrear.setBounds(117, 212, 89, 23);
		getFrame().getContentPane().add(btnCrear);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}

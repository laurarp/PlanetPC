import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormEliminarUsuario {

	private JFrame frmEliminarUsuario;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormEliminarUsuario window = new FormEliminarUsuario();
					window.frmEliminarUsuario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FormEliminarUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEliminarUsuario = new JFrame();
		frmEliminarUsuario.setTitle("Eliminar usuario");
		frmEliminarUsuario.setBounds(100, 100, 450, 228);
		frmEliminarUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
				Administrador a;
				try {
					a = new Administrador("1037657390","juan","1234");
					a.eliminarUsuario(textField.getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnEliminar.setBounds(149, 118, 115, 29);
		frmEliminarUsuario.getContentPane().add(btnEliminar);
	}
}

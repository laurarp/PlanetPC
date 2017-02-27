import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormModificarProveedor {

	private JFrame frmModificarProveedor;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormModificarProveedor window = new FormModificarProveedor();
					window.frmModificarProveedor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FormModificarProveedor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmModificarProveedor = new JFrame();
		frmModificarProveedor.setTitle("Modificar proveedor");
		frmModificarProveedor.setBounds(100, 100, 450, 300);
		frmModificarProveedor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmModificarProveedor.getContentPane().setLayout(null);
		
		JLabel lblIngreseElId = new JLabel("Ingrese el id del proveedor");
		lblIngreseElId.setBounds(15, 16, 215, 20);
		frmModificarProveedor.getContentPane().add(lblIngreseElId);
		
		textField = new JTextField();
		textField.setBounds(15, 52, 146, 26);
		frmModificarProveedor.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblIngreseElNuevo = new JLabel("Ingrese el nuevo nombre del proveedor");
		lblIngreseElNuevo.setBounds(15, 94, 290, 20);
		frmModificarProveedor.getContentPane().add(lblIngreseElNuevo);
		
		textField_1 = new JTextField();
		textField_1.setBounds(15, 130, 146, 26);
		frmModificarProveedor.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnCambiar = new JButton("Cambiar");
		btnCambiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Administrador a;
				try {
					a = new Administrador("1037657390","juan","1234");
					a.crearProveedor(textField.getText(), textField_1.getText());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnCambiar.setBounds(145, 183, 115, 29);
		frmModificarProveedor.getContentPane().add(btnCambiar);
	}
}

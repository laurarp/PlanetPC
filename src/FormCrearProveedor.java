import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormCrearProveedor {

	private JFrame frmCrearProveedor;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormCrearProveedor window = new FormCrearProveedor();
					window.frmCrearProveedor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FormCrearProveedor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCrearProveedor = new JFrame();
		frmCrearProveedor.setTitle("Crear Proveedor");
		frmCrearProveedor.setBounds(100, 100, 450, 300);
		frmCrearProveedor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCrearProveedor.getContentPane().setLayout(null);
		
		JLabel lblIngresaElNombre = new JLabel("Ingresa el nombre del proveedor");
		lblIngresaElNombre.setBounds(15, 16, 257, 20);
		frmCrearProveedor.getContentPane().add(lblIngresaElNombre);
		
		textField = new JTextField();
		textField.setBounds(15, 55, 146, 26);
		frmCrearProveedor.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblIngresaElId = new JLabel("Ingresa el id del proveedor");
		lblIngresaElId.setBounds(15, 97, 257, 20);
		frmCrearProveedor.getContentPane().add(lblIngresaElId);
		
		textField_1 = new JTextField();
		textField_1.setBounds(15, 133, 146, 26);
		frmCrearProveedor.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Administrador a = new Administrador("1037657390","juan","1234");
					a.crearProveedor(textField.getText(), textField_1.getText());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnCrear.setBounds(158, 183, 115, 29);
		frmCrearProveedor.getContentPane().add(btnCrear);
	}
}
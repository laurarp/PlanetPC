import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormBucarProveedor {

	private JFrame frmBuscarProveedor;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormBucarProveedor window = new FormBucarProveedor();
					window.frmBuscarProveedor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FormBucarProveedor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBuscarProveedor = new JFrame();
		frmBuscarProveedor.setTitle("Buscar Proveedor");
		frmBuscarProveedor.setBounds(100, 100, 450, 300);
		frmBuscarProveedor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBuscarProveedor.getContentPane().setLayout(null);
		
		JLabel lblIngreseElId = new JLabel("Ingrese el id del proveedor");
		lblIngreseElId.setBounds(85, 39, 213, 20);
		frmBuscarProveedor.getContentPane().add(lblIngreseElId);
		
		textField = new JTextField();
		textField.setBounds(85, 75, 146, 26);
		frmBuscarProveedor.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Administrador a = new Administrador("1037657390","juan","1234");
					a.buscarProveedor(textField.getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnBuscar.setBounds(85, 117, 115, 29);
		frmBuscarProveedor.getContentPane().add(btnBuscar);
	}

}
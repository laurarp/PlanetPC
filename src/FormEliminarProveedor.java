import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormEliminarProveedor {

	private JFrame frmEliminarProveedor;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormEliminarProveedor window = new FormEliminarProveedor();
					window.frmEliminarProveedor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FormEliminarProveedor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEliminarProveedor = new JFrame();
		frmEliminarProveedor.setTitle("Eliminar proveedor");
		frmEliminarProveedor.setBounds(100, 100, 450, 300);
		frmEliminarProveedor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEliminarProveedor.getContentPane().setLayout(null);
		
		JLabel lblIngreseElId = new JLabel("Ingrese el id del proveedor que desea eliminar");
		lblIngreseElId.setBounds(15, 16, 342, 20);
		frmEliminarProveedor.getContentPane().add(lblIngreseElId);
		
		textField = new JTextField();
		textField.setBounds(15, 49, 146, 26);
		frmEliminarProveedor.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Administrador a;
				try {
					a = new Administrador("1037657390","juan","1234");
					a.eliminarProveedor(textField.getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnEliminar.setBounds(137, 104, 115, 29);
		frmEliminarProveedor.getContentPane().add(btnEliminar);
	}

}

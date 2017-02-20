import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Choice;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;


public class FormRegistrarVenta {

	private JFrame frame;
	private JTextField textIdCliente;
	private JTextField textCantidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormRegistrarVenta window = new FormRegistrarVenta();
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
	public FormRegistrarVenta() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 316, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Choice chProductos = new Choice();
		chProductos.setBounds(93, 27, 163, 20);
		frame.getContentPane().add(chProductos);
		
		JLabel lblProducto = new JLabel("Producto");
		lblProducto.setBounds(24, 27, 46, 14);
		frame.getContentPane().add(lblProducto);
		
		JLabel lblIdCliente = new JLabel("Id Cliente");
		lblIdCliente.setBounds(24, 74, 46, 14);
		frame.getContentPane().add(lblIdCliente);
		
		textIdCliente = new JTextField();
		textIdCliente.setBounds(93, 71, 86, 20);
		frame.getContentPane().add(textIdCliente);
		textIdCliente.setColumns(10);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(24, 122, 46, 14);
		frame.getContentPane().add(lblCantidad);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(71, 170, 89, 23);
		frame.getContentPane().add(btnRegistrar);
		
		textCantidad = new JTextField();
		textCantidad.setBounds(93, 119, 86, 20);
		frame.getContentPane().add(textCantidad);
		textCantidad.setColumns(10);
	}

}

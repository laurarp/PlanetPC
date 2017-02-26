import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Choice;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;


public class FormRegistrarVenta extends JFrame{

	private JFrame frame;
	private JTextField textIdCliente;
	private JTextField textCantidad;
	private Actor actor;

	/**
	 * Create the application.
	 * @param actor 
	 */
	public FormRegistrarVenta(Actor actor) {
		this.actor=actor;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 316, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		Choice chProductos = new Choice();
		chProductos.setBounds(93, 27, 163, 20);
		getFrame().getContentPane().add(chProductos);
		
		JLabel lblProducto = new JLabel("Producto");
		lblProducto.setBounds(24, 27, 46, 14);
		getFrame().getContentPane().add(lblProducto);
		
		JLabel lblIdCliente = new JLabel("Id Cliente");
		lblIdCliente.setBounds(24, 74, 46, 14);
		getFrame().getContentPane().add(lblIdCliente);
		
		textIdCliente = new JTextField();
		textIdCliente.setBounds(93, 71, 86, 20);
		getFrame().getContentPane().add(textIdCliente);
		textIdCliente.setColumns(10);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(24, 122, 46, 14);
		getFrame().getContentPane().add(lblCantidad);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(71, 170, 89, 23);
		getFrame().getContentPane().add(btnRegistrar);
		
		textCantidad = new JTextField();
		textCantidad.setBounds(93, 119, 86, 20);
		getFrame().getContentPane().add(textCantidad);
		textCantidad.setColumns(10);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Choice;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class FormRegistrarVenta extends JFrame{

	private JFrame frame;
	private JTextField textIdCliente;
	private JTextField textCantidad;
	private JTextField textIdProducto;
	private AsesorVentas asesorVentas;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					FormRegistrarVenta form = new FormRegistrarVenta(new Administrador("1","Laura","23"));


					form.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param actor 
	 */
	public FormRegistrarVenta(Actor actor) {
		try 
		{
			this.asesorVentas=new AsesorVentas(actor.getId(),actor.getNombre(),actor.getContrasena()) ;
			initialize();
		} 
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 316, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		JLabel lblProducto = new JLabel("id Producto");
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
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
					asesorVentas.registarVenta(textIdProducto.getText(), textIdCliente.getText(), asesorVentas.getId(), textCantidad.getText());
					JOptionPane.showMessageDialog(null, "Venta creada correctamente");
				} 
				catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnRegistrar.setBounds(71, 170, 89, 23);
		getFrame().getContentPane().add(btnRegistrar);
		
		textCantidad = new JTextField();
		textCantidad.setBounds(93, 119, 86, 20);
		getFrame().getContentPane().add(textCantidad);
		textCantidad.setColumns(10);
		
		textIdProducto = new JTextField();
		textIdProducto.setBounds(93, 24, 86, 20);
		frame.getContentPane().add(textIdProducto);
		textIdProducto.setColumns(10);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}

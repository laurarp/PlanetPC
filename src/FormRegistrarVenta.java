import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Choice;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;


public class FormRegistrarVenta extends JFrame{

	private JFrame frame;
	private JTextField textIdCliente;
	private JTextField textCantidad;
	private JTextField textIdProducto;
	private AsesorVentas asesorVentas;
	private JLabel lblRegistrarVenta;
	
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
		getFrame().setBounds(100, 100, 308, 281);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		JLabel lblProducto = new JLabel("Id Producto");
		lblProducto.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblProducto.setBounds(24, 77, 115, 14);
		getFrame().getContentPane().add(lblProducto);
		
		JLabel lblIdCliente = new JLabel("Id Cliente");
		lblIdCliente.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblIdCliente.setBounds(24, 113, 86, 14);
		getFrame().getContentPane().add(lblIdCliente);
		
		textIdCliente = new JTextField();
		textIdCliente.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textIdCliente.setBounds(120, 110, 131, 20);
		getFrame().getContentPane().add(textIdCliente);
		textIdCliente.setColumns(10);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblCantidad.setBounds(24, 153, 71, 14);
		getFrame().getContentPane().add(lblCantidad);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
					asesorVentas.registarVenta(textIdProducto.getText(), textIdCliente.getText(), asesorVentas.getId(), textCantidad.getText());
					textIdProducto.setText("");
					textIdCliente.setText("");
					textCantidad.setText("");
					JOptionPane.showMessageDialog(null, "Venta creada correctamente");
				} 
				catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnRegistrar.setBounds(99, 195, 89, 23);
		getFrame().getContentPane().add(btnRegistrar);
		
		textCantidad = new JTextField();
		textCantidad.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textCantidad.setBounds(120, 150, 131, 20);
		getFrame().getContentPane().add(textCantidad);
		textCantidad.setColumns(10);
		
		textIdProducto = new JTextField();
		textIdProducto.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textIdProducto.setBounds(118, 74, 133, 20);
		frame.getContentPane().add(textIdProducto);
		textIdProducto.setColumns(10);
		
		lblRegistrarVenta = new JLabel("Registrar venta");
		lblRegistrarVenta.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblRegistrarVenta.setBounds(48, 11, 209, 34);
		frame.getContentPane().add(lblRegistrarVenta);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
		frame.getContentPane().setBackground(new Color(255, 255, 255));
	}

}

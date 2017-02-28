import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class FormRegistrarPedido extends JFrame {

	private JFrame frmRegistrarPedido;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnRegistrar;
	private JefeBodega jefazo;
	private JLabel lblRegistrarPedido;

	/**
	 * Create the application.
	 */
	public FormRegistrarPedido(Actor actor) {
		try 
		{
			jefazo = new JefeBodega(actor.getId(),actor.getNombre(),actor.getContrasena());
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
		frmRegistrarPedido = new JFrame();
		frmRegistrarPedido.getContentPane().setBackground(Color.WHITE);
		frmRegistrarPedido.getContentPane().setFont(new Font("Segoe UI", Font.PLAIN, 14));
		frmRegistrarPedido.setBounds(100, 100, 521, 367);
		frmRegistrarPedido.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmRegistrarPedido.getContentPane().setLayout(null);
		
		JLabel lblDescripcionProducto = new JLabel("Descripcion producto");
		lblDescripcionProducto.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblDescripcionProducto.setBounds(15, 79, 156, 20);
		frmRegistrarPedido.getContentPane().add(lblDescripcionProducto);
		
		textField = new JTextField();
		textField.setBounds(15, 115, 464, 57);
		frmRegistrarPedido.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblIdProveedor = new JLabel("Id proveedor");
		lblIdProveedor.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblIdProveedor.setBounds(15, 188, 118, 20);
		frmRegistrarPedido.getContentPane().add(lblIdProveedor);
		
		textField_1 = new JTextField();
		textField_1.setBounds(15, 224, 146, 26);
		frmRegistrarPedido.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblCantidad.setBounds(204, 188, 84, 20);
		frmRegistrarPedido.getContentPane().add(lblCantidad);
		
		textField_2 = new JTextField();
		textField_2.setBounds(204, 224, 84, 26);
		frmRegistrarPedido.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblPrecioCompra = new JLabel("Precio compra");
		lblPrecioCompra.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblPrecioCompra.setBounds(340, 188, 139, 20);
		frmRegistrarPedido.getContentPane().add(lblPrecioCompra);
		
		textField_3 = new JTextField();
		textField_3.setBounds(333, 224, 146, 26);
		frmRegistrarPedido.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (textField.getText().isEmpty()||textField_1.getText().isEmpty()||textField_2.getText().isEmpty()||textField_3.getText().isEmpty()){
						JOptionPane.showMessageDialog(null, "El campo esta vacio");
					}else{
					jefazo.registrarPedido(textField.getText(), textField_1.getText(), Integer.parseInt(textField_2.getText()), Integer.parseInt(textField_3.getText()), "Pendiente");
					JOptionPane.showMessageDialog(null, ("pedido registrado exitosamente"));
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, ("pedido registrado exitosamente"));
				}
			}
		});
		btnRegistrar.setBounds(189, 266, 115, 29);
		frmRegistrarPedido.getContentPane().add(btnRegistrar);
		
		lblRegistrarPedido = new JLabel("Registrar pedido");
		lblRegistrarPedido.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblRegistrarPedido.setBounds(15, 16, 273, 47);
		frmRegistrarPedido.getContentPane().add(lblRegistrarPedido);
	}
	
	public JFrame getFrmRegistrarPedido() {
		return frmRegistrarPedido;
	}

	public void setFrmRegistrarPedido(JFrame frmRegistrarPedido) {
		this.frmRegistrarPedido = frmRegistrarPedido;
	}

}

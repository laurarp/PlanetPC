import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class FormEliminarProveedor {

	private JFrame frmEliminarProveedor;
	private JTextField textField;
	private Administrador Admin;

	/**
	 * Create the application.
	 */
	public FormEliminarProveedor(Actor actor) {
		try 
		{
			Admin = new Administrador(actor.getId(),actor.getNombre(),actor.getContrasena());
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
		frmEliminarProveedor = new JFrame();
		frmEliminarProveedor.getContentPane().setBackground(Color.WHITE);
		frmEliminarProveedor.setBounds(100, 100, 450, 300);
		frmEliminarProveedor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmEliminarProveedor.getContentPane().setLayout(null);
		
		JLabel lblIngreseElId = new JLabel("Ingrese el id del proveedor que desea eliminar");
		lblIngreseElId.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblIngreseElId.setBounds(15, 75, 342, 20);
		frmEliminarProveedor.getContentPane().add(lblIngreseElId);
		
		textField = new JTextField();
		textField.setBounds(15, 111, 146, 26);
		frmEliminarProveedor.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (textField.getText()==null){
						JOptionPane.showMessageDialog(null, "El campo esta vacio");
					}else{
					Admin.eliminarProveedor(textField.getText());
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnEliminar.setBounds(136, 180, 115, 29);
		frmEliminarProveedor.getContentPane().add(btnEliminar);
		
		JLabel lblEliminarProveedor = new JLabel("Eliminar proveedor");
		lblEliminarProveedor.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblEliminarProveedor.setBounds(15, 16, 236, 43);
		frmEliminarProveedor.getContentPane().add(lblEliminarProveedor);
	}
	public JFrame getFrmEliminarProveedor() {
		return frmEliminarProveedor;
	}

	public void setFrmEliminarProveedor(JFrame frmBuscarProveedor) {
		this.frmEliminarProveedor = frmBuscarProveedor;
	}

}

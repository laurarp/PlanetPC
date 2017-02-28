import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class FormBucarProveedor extends JFrame {

	private JFrame frmBuscarProveedor;
	private JTextField textField;
	private Administrador Admin;

	/**
	 * Create the application.
	 */
	public FormBucarProveedor(Actor actor) {
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
		setFrmBuscarProveedor(new JFrame());
		getFrmBuscarProveedor().setBounds(100, 100, 298, 300);
		getFrmBuscarProveedor().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getFrmBuscarProveedor().getContentPane().setLayout(null);
		
		JLabel lblIngreseElId = new JLabel("Ingrese el nombre del proveedor");
		lblIngreseElId.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblIngreseElId.setBounds(25, 77, 213, 20);
		getFrmBuscarProveedor().getContentPane().add(lblIngreseElId);
		
		textField = new JTextField();
		textField.setBounds(25, 113, 146, 26);
		getFrmBuscarProveedor().getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre;
				try {
					if (textField.getText().isEmpty()){
						JOptionPane.showMessageDialog(null, "El campo esta vacio");
					}else{
					nombre = Admin.buscarIdProveedor(textField.getText());
					JOptionPane.showMessageDialog(null, "el nombre de su proveedor es:"+nombre); 
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnBuscar.setBounds(25, 155, 115, 29);
		getFrmBuscarProveedor().getContentPane().add(btnBuscar);
		
		JLabel lblBuscarProveedor = new JLabel("Buscar proveedor");
		lblBuscarProveedor.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblBuscarProveedor.setBounds(15, 16, 213, 45);
		frmBuscarProveedor.getContentPane().add(lblBuscarProveedor);
	}

	public JFrame getFrmBuscarProveedor() {
		return frmBuscarProveedor;
	}

	public void setFrmBuscarProveedor(JFrame frmBuscarProveedor) {
		this.frmBuscarProveedor = frmBuscarProveedor;
	}

}
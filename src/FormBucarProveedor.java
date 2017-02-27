import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		getFrmBuscarProveedor().setTitle("Buscar Proveedor");
		getFrmBuscarProveedor().setBounds(100, 100, 450, 300);
		getFrmBuscarProveedor().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getFrmBuscarProveedor().getContentPane().setLayout(null);
		
		JLabel lblIngreseElId = new JLabel("Ingrese el id del proveedor");
		lblIngreseElId.setBounds(85, 39, 213, 20);
		getFrmBuscarProveedor().getContentPane().add(lblIngreseElId);
		
		textField = new JTextField();
		textField.setBounds(85, 75, 146, 26);
		getFrmBuscarProveedor().getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (textField.getText()==null){
						JOptionPane.showMessageDialog(null, "El campo esta vacio");
					}else{
					Admin.buscarProveedor(textField.getText());
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnBuscar.setBounds(85, 117, 115, 29);
		getFrmBuscarProveedor().getContentPane().add(btnBuscar);
	}

	public JFrame getFrmBuscarProveedor() {
		return frmBuscarProveedor;
	}

	public void setFrmBuscarProveedor(JFrame frmBuscarProveedor) {
		this.frmBuscarProveedor = frmBuscarProveedor;
	}

}
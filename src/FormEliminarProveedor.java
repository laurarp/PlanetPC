import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		frmEliminarProveedor.setTitle("Eliminar proveedor");
		frmEliminarProveedor.setBounds(100, 100, 450, 300);
		frmEliminarProveedor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		btnEliminar.setBounds(137, 104, 115, 29);
		frmEliminarProveedor.getContentPane().add(btnEliminar);
	}
	public JFrame getFrmEliminarProveedor() {
		return frmEliminarProveedor;
	}

	public void setFrmEliminarProveedor(JFrame frmBuscarProveedor) {
		this.frmEliminarProveedor = frmBuscarProveedor;
	}

}

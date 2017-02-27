import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class FormModificarUsuarioContrasena extends JFrame {

	private JPanel contentPane;
	private Actor actor;
	private JTable table;
	private JTextField txtID;
	private JPasswordField passContrasenaAct;
	private JPasswordField passNewPass;
	private JPasswordField passVerNewPass;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormModificarUsuarioContrasena frame = new FormModificarUsuarioContrasena();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public FormModificarUsuarioContrasena(Actor actor) throws Exception {
		this.actor=actor;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 720, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblListaDeUsuarios = new JLabel("Lista de usuarios");
		lblListaDeUsuarios.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblListaDeUsuarios.setBounds(260, 26, 166, 26);
		contentPane.add(lblListaDeUsuarios);
		
		Administrador x = new Administrador(actor.getNombre(), actor.getId(), actor.getContrasena());

		String titulos[] = { "Id", "Nombre", "Tipo", "Contraseña"};

		DefaultTableModel tableModel = new DefaultTableModel(titulos, 0);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 50, 616, 283);
		contentPane.add(scrollPane);
		
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		
		JButton btnMostrarUsuarios = new JButton("Mostrar usuarios");
		btnMostrarUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Actor> reportes = null;

				int rowCount = tableModel.getRowCount();

				for (int i = rowCount - 1; i >= 0; i--) {
					tableModel.removeRow(i);
				}

				try {
					reportes = x.mostrarActores();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}

				if (reportes != null) {
					for (int i = 0; i < reportes.size(); i++) {
						String id = reportes.get(i).getId();
						String nombre = reportes.get(i).getNombre();
						String contrasena= reportes.get(i).getContrasena();
						String tipo = reportes.get(i).getClass().getName();
						Object[] objs = { id, nombre,tipo, contrasena};
						tableModel.addRow(objs);
					}
				} else {
					JOptionPane.showMessageDialog(null, "No hay usuarios en la lista");
				}
			}
		});
		btnMostrarUsuarios.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnMostrarUsuarios.setBounds(44, 382, 135, 31);
		contentPane.add(btnMostrarUsuarios);
		
		JLabel lblIngreseElId = new JLabel("Ingrese el Id del usuario:");
		lblIngreseElId.setBounds(202, 373, 124, 14);
		contentPane.add(lblIngreseElId);
		
		txtID = new JTextField();
		txtID.setBounds(219, 388, 86, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		passContrasenaAct = new JPasswordField();
		passContrasenaAct.setBounds(465, 344, 93, 20);
		contentPane.add(passContrasenaAct);
		
		passNewPass = new JPasswordField();
		passNewPass.setBounds(465, 370, 93, 20);
		contentPane.add(passNewPass);
		
		passVerNewPass = new JPasswordField();
		passVerNewPass.setBounds(465, 393, 93, 20);
		contentPane.add(passVerNewPass);
		
		JLabel lblContraseaActual = new JLabel("Contrase\u00F1a actual:");
		lblContraseaActual.setBounds(352, 347, 103, 14);
		contentPane.add(lblContraseaActual);
		
		JLabel lblNuevaContrasea = new JLabel("Nueva contrase\u00F1a:");
		lblNuevaContrasea.setBounds(352, 373, 106, 14);
		contentPane.add(lblNuevaContrasea);
		
		JLabel lblVerificarContrasea = new JLabel("Verificar contrase\u00F1a:");
		lblVerificarContrasea.setBounds(352, 396, 103, 14);
		contentPane.add(lblVerificarContrasea);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					x.modificarUsuario(passContrasenaAct.getText(), txtID.getText(), passNewPass.getText(), passVerNewPass.getText());
					txtID.setText("");
					passContrasenaAct.setText("");
					passNewPass.setText("");
					passVerNewPass.setText("");
					int rowCount = tableModel.getRowCount();

					for (int i = rowCount - 1; i >= 0; i--) {
						tableModel.removeRow(i);
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(btnGuardar, e1.getMessage());;
				}
			}
		});
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGuardar.setBounds(581, 382, 103, 31);
		contentPane.add(btnGuardar);
	}
}

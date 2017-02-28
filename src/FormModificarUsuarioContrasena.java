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
import java.awt.Color;

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
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblListaDeUsuarios = new JLabel("Modificar contrase\u00F1a");
		lblListaDeUsuarios.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblListaDeUsuarios.setBounds(44, 24, 254, 31);
		contentPane.add(lblListaDeUsuarios);
		
		Administrador x = new Administrador(actor.getNombre(), actor.getId(), actor.getContrasena());

		String titulos[] = { "Id", "Nombre", "Tipo", "Contraseña"};

		DefaultTableModel tableModel = new DefaultTableModel(titulos, 0);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 121, 616, 190);
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
		btnMostrarUsuarios.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnMostrarUsuarios.setBounds(44, 66, 151, 31);
		contentPane.add(btnMostrarUsuarios);
		
		JLabel lblIngreseElId = new JLabel("Ingrese el Id del usuario:");
		lblIngreseElId.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblIngreseElId.setBounds(219, 71, 163, 21);
		contentPane.add(lblIngreseElId);
		
		txtID = new JTextField();
		txtID.setBounds(381, 73, 86, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		passContrasenaAct = new JPasswordField();
		passContrasenaAct.setBounds(217, 346, 93, 20);
		contentPane.add(passContrasenaAct);
		
		passNewPass = new JPasswordField();
		passNewPass.setBounds(217, 372, 93, 20);
		contentPane.add(passNewPass);
		
		passVerNewPass = new JPasswordField();
		passVerNewPass.setBounds(217, 396, 93, 20);
		contentPane.add(passVerNewPass);
		
		JLabel lblContraseaActual = new JLabel("Contrase\u00F1a actual:");
		lblContraseaActual.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblContraseaActual.setBounds(76, 347, 124, 14);
		contentPane.add(lblContraseaActual);
		
		JLabel lblNuevaContrasea = new JLabel("Nueva contrase\u00F1a:");
		lblNuevaContrasea.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNuevaContrasea.setBounds(76, 373, 119, 14);
		contentPane.add(lblNuevaContrasea);
		
		JLabel lblVerificarContrasea = new JLabel("Verificar contrase\u00F1a:");
		lblVerificarContrasea.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblVerificarContrasea.setBounds(76, 399, 131, 14);
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
		btnGuardar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnGuardar.setBounds(408, 364, 103, 31);
		contentPane.add(btnGuardar);
	}
}

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class FormBuscarUsuario extends JFrame {

	private JPanel contentPane;
	private Actor actor;
	private JTextField txtID;
	private JTable table;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormBuscarUsuario frame = new FormBuscarUsuario();
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
	public FormBuscarUsuario(Actor actor) throws Exception {
		this.actor=actor;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 553, 353);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Buscar usuario");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblNewLabel.setBounds(27, 11, 189, 40);
		contentPane.add(lblNewLabel);
		
		txtID = new JTextField();
		txtID.setBounds(304, 62, 86, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblIngreseIdDel = new JLabel("Ingrese Id del usuario:");
		lblIngreseIdDel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblIngreseIdDel.setBounds(56, 62, 149, 17);
		contentPane.add(lblIngreseIdDel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 118, 480, 103);
		contentPane.add(scrollPane);
		
		String titulos[] = {"Id", "Nombre", "Tipo"};

		DefaultTableModel tableModel = new DefaultTableModel(titulos, 0);
		
		
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		Administrador x= new Administrador(actor.getId(), actor.getNombre(),actor.getContrasena());
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Actor reportes = null;

				int rowCount = tableModel.getRowCount();

				for (int i = rowCount - 1; i >= 0; i--) {
					tableModel.removeRow(i);
				}

				try {
					reportes = x.buscarUsuario(txtID.getText());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}

				if (reportes != null) {
					
						String id = reportes.getId();
						String nombre = reportes.getNombre();
						String contrasena = reportes.getContrasena();
						String tipo= reportes.getClass().getName();
						Object[] objs = { id, nombre, tipo, contrasena};
						tableModel.addRow(objs);
					
				} else {
					JOptionPane.showMessageDialog(null, "No hay usuarios en la lista");
				}
			}
			
		});
		btnBuscar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnBuscar.setBounds(209, 257, 89, 29);
		contentPane.add(btnBuscar);
	}
}

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
	 */
	public FormBuscarUsuario(Actor actor) {
		this.actor=actor;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 553, 353);
		contentPane = new JPanel();
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
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<ServicioTecnico> reportes = null;

				int rowCount = tableModel.getRowCount();

				for (int i = rowCount - 1; i >= 0; i--) {
					tableModel.removeRow(i);
				}

				try {
					reportes = x.generarReporteServicios((String) cbxParametroBusqueda.getSelectedItem());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}

				if (reportes != null) {
					for (int i = 0; i < reportes.size(); i++) {
						String idServicio = reportes.get(i).getIdServicio();
						String descripcion = reportes.get(i).getDescripcion();
						String idCliente = reportes.get(i).getIdCliente();
						String fechaEntrada = reportes.get(i).getFechaEntrada();
						String fechaSalida = reportes.get(i).getFechaSalida();
						String precio = String.valueOf(reportes.get(i).getPrecio());
						String estado = reportes.get(i).getEstado();
						Object[] objs = { idServicio, descripcion, idCliente, fechaEntrada, fechaSalida, precio,
								estado };
						tableModel.addRow(objs);
					}
				} else {
					JOptionPane.showMessageDialog(null, "no hay servicios en la lista");
				}
			}
			}
		});
		btnBuscar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnBuscar.setBounds(209, 257, 89, 29);
		contentPane.add(btnBuscar);
	}
}

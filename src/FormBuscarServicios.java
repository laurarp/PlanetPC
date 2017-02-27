import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.ScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class FormBuscarServicios extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Actor actor;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormBuscarServicios frame = new FormBuscarServicios();
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
	public FormBuscarServicios( Actor actor) {
		this.actor=actor;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 729, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox cbxParametroBusqueda = new JComboBox();
		cbxParametroBusqueda.addItem("Pendiente");
		cbxParametroBusqueda.addItem("Activo");
		cbxParametroBusqueda.addItem("Finalizado");
		cbxParametroBusqueda.setFont(new Font("Tahoma", Font.BOLD, 12));
		cbxParametroBusqueda.setBounds(116, 322, 165, 20);
		contentPane.add(cbxParametroBusqueda);
		AuxiliarServicio x = new AuxiliarServicio(actor.getNombre(), actor.getId(), actor.getContrasena());

		String titulos[] = { "Id Servicio", "Descripción", "Id Cliente", "Fecha de entrada", "Fecha de salida",
				"Precio", "Estado" };

		DefaultTableModel tableModel = new DefaultTableModel(titulos, 0);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 40, 619, 271);
		contentPane.add(scrollPane);
		// frame.getContentPane().add(scrollPane);
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
		});
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBuscar.setBounds(459, 320, 89, 23);
		contentPane.add(btnBuscar);

		JLabel lblListaDeServicios = new JLabel("Lista de servicios");
		lblListaDeServicios.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblListaDeServicios.setBounds(287, 10, 129, 14);
		contentPane.add(lblListaDeServicios);

	}
}

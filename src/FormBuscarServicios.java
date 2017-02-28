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
import java.awt.Color;

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
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox cbxParametroBusqueda = new JComboBox();
		cbxParametroBusqueda.addItem("Pendiente");
		cbxParametroBusqueda.addItem("Activo");
		cbxParametroBusqueda.addItem("Finalizado");
		cbxParametroBusqueda.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cbxParametroBusqueda.setBounds(419, 60, 165, 20);
		contentPane.add(cbxParametroBusqueda);
		AuxiliarServicio x = new AuxiliarServicio(actor.getNombre(), actor.getId(), actor.getContrasena());

		String titulos[] = { "Id Servicio", "Descripción", "Id Cliente", "Fecha de entrada", "Fecha de salida",
				"Precio", "Estado" };

		DefaultTableModel tableModel = new DefaultTableModel(titulos, 0);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(55, 101, 619, 207);
		contentPane.add(scrollPane);
		// frame.getContentPane().add(scrollPane);
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);

		JButton btnBuscar = new JButton("Mostrar");
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
					JOptionPane.showMessageDialog(btnBuscar, e.getMessage());
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
					//JOptionPane.showMessageDialog(null, "No hay servicios en la lista");
				}
			}
		});
		btnBuscar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnBuscar.setBounds(287, 319, 113, 36);
		contentPane.add(btnBuscar);

		JLabel lblListaDeServicios = new JLabel("Reporte de servicios");
		lblListaDeServicios.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblListaDeServicios.setBounds(55, 11, 253, 41);
		contentPane.add(lblListaDeServicios);
		
		JLabel lblSeleccioneElTipo = new JLabel("Seleccione el tipo de servicios que desea mostrar:");
		lblSeleccioneElTipo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblSeleccioneElTipo.setBounds(83, 56, 326, 26);
		contentPane.add(lblSeleccioneElTipo);

	}
}

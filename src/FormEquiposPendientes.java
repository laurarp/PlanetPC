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
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class FormEquiposPendientes extends JFrame {

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
					FormEquiposPendientes frame = new FormEquiposPendientes();
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
	public FormEquiposPendientes(Actor actor) {
		this.actor=actor;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 669, 446);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblListaDeServicios = new JLabel("Equipos pendientes");
		lblListaDeServicios.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblListaDeServicios.setBounds(37, 11, 232, 41);
		contentPane.add(lblListaDeServicios);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 75, 580, 246);
		contentPane.add(scrollPane);
		
		AuxiliarServicio x = new AuxiliarServicio(actor.getNombre(), actor.getId(), actor.getContrasena());

		String titulos[] = { "Id Servicio", "Descripción", "Id Cliente", "Fecha de entrada", "Fecha de salida",
				"Precio", "Estado" };

		DefaultTableModel tableModel = new DefaultTableModel(titulos, 0);
		
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		
		JButton btnMostrar = new JButton("Mostrar servicios");
		btnMostrar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<ServicioTecnico> reportes = null;

				int rowCount = tableModel.getRowCount();

				for (int i = rowCount - 1; i >= 0; i--) {
					tableModel.removeRow(i);
				}

				try {
					reportes = x.generarReporteServicios("Pendiente");
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
					//JOptionPane.showMessageDialog(null, "no hay servicios en la lista");
				}
				
				
			}
		});
		btnMostrar.setBounds(243, 343, 154, 37);
		contentPane.add(btnMostrar);
	}

}

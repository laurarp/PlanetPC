import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class FormModificarEstadoServicioTecnico extends JFrame {

	private JPanel contentPane;
	private Actor actor;
	private JTable table;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormModificarEstadoServicioTecnico frame = new FormModificarEstadoServicioTecnico();
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
	public FormModificarEstadoServicioTecnico( Actor actor) {
		this.actor=actor;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 622, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 53, 516, 248);
		contentPane.add(scrollPane);
		
		String titulos[] = { "Id Servicio", "Descripción", "Id Cliente", "Fecha de entrada", "Fecha de salida",
				"Precio", "Estado" };
		
		DefaultTableModel tableModel = new DefaultTableModel(titulos, 0);
		
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		AuxiliarServicio x= new AuxiliarServicio(actor.getNombre(), actor.getId(), actor.getContrasena());
		JButton btnMostrarServicios = new JButton("Mostrar servicios");
		
		btnMostrarServicios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//x.mostrarServicios();
				ArrayList<ServicioTecnico> reportes = null;

				int rowCount = tableModel.getRowCount();

				for (int i = rowCount - 1; i >= 0; i--) {
					tableModel.removeRow(i);
				}

				try {
					reportes = x.mostrarServicios();
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
		btnMostrarServicios.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnMostrarServicios.setBounds(29, 315, 147, 40);
		contentPane.add(btnMostrarServicios);
		
		JTextField txtID = new JTextField();
		txtID.setBounds(186, 326, 98, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		JComboBox cbxEstado = new JComboBox();
		cbxEstado.setFont(new Font("Tahoma", Font.BOLD, 11));
		cbxEstado.setBounds(294, 326, 111, 20);
		contentPane.add(cbxEstado);
		cbxEstado.addItem("Pendiente");
		cbxEstado.addItem("Activo");
		cbxEstado.addItem("Finalizado");
		
		
		JButton btnCambiarEstado = new JButton("Cambiar estado");
		btnCambiarEstado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					x.modificarServicio(txtID.getText(), (String) cbxEstado.getSelectedItem());
					int rowCount = tableModel.getRowCount();

					for (int i = rowCount - 1; i >= 0; i--) {
						tableModel.removeRow(i);
					}
				} catch (Excepciones e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(btnCambiarEstado, e.getMessage());
				}
			}
		});
		btnCambiarEstado.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCambiarEstado.setBounds(415, 315, 157, 38);
		contentPane.add(btnCambiarEstado);
		
		JLabel lblListaDeServicios = new JLabel("Lista de servicios");
		lblListaDeServicios.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblListaDeServicios.setBounds(233, 11, 147, 31);
		contentPane.add(lblListaDeServicios);
		
		JLabel lblIngresarId = new JLabel("Ingresar Id");
		lblIngresarId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIngresarId.setBounds(201, 312, 71, 14);
		contentPane.add(lblIngresarId);
	}
}

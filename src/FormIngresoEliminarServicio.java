import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import java.awt.Color;

public class FormIngresoEliminarServicio extends JFrame {

	private JPanel contentPane;
	private JTextField txtEliminar;
	private Actor actor;
	private JButton btnMostrar;
	private JLabel lblSeleccioneElTipo;
	private JLabel lblListaDeServicios;
	private JScrollPane scrollPane;
	private JTable table;
	private JComboBox cbxEstado;
	private JLabel lblIngreseElId;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormIngresoEliminarServicio frame = new FormIngresoEliminarServicio();
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
	public FormIngresoEliminarServicio(Actor actor) {
		this.actor=actor;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setBounds(100, 100, 697, 465);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtEliminar = new JTextField();
		txtEliminar.setBounds(216, 355, 86, 20);
		contentPane.add(txtEliminar);
		txtEliminar.setColumns(10);
		AuxiliarServicio auxiliar=new AuxiliarServicio(actor.getNombre(), actor.getId(), actor.getContrasena());
		
		
		String titulos[] = { "Id Servicio", "Descripción", "Id Cliente", "Fecha de entrada", "Fecha de salida",
				"Precio", "Estado" };

		DefaultTableModel tableModel = new DefaultTableModel(titulos, 0);
		
		
		
		JButton btnEliminar = new JButton("Eliminar servicio");
		btnEliminar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnEliminar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			try {
				auxiliar.eliminarServicio(txtEliminar.getText());
				int rowCount = tableModel.getRowCount();

				for (int i = rowCount - 1; i >= 0; i--) {
					tableModel.removeRow(i);
				}
				txtEliminar.setText("");
			} catch (Excepciones e1) {
				
				JOptionPane.showMessageDialog(btnEliminar, e1.getMessage());
			}
				
			}
		});
		btnEliminar.setBounds(341, 341, 154, 44);
		contentPane.add(btnEliminar);
		
		btnMostrar = new JButton("Mostrar");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ArrayList<ServicioTecnico> reportes = null;

				int rowCount = tableModel.getRowCount();

				for (int i = rowCount - 1; i >= 0; i--) {
					tableModel.removeRow(i);
				}

				try {
					reportes = auxiliar.generarReporteServicios((String) cbxEstado.getSelectedItem());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(btnMostrar, e.getMessage());
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
					JOptionPane.showMessageDialog(btnMostrar, "no hay servicios en la lista");
				}
				
			}
		});
		btnMostrar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnMostrar.setBounds(507, 49, 141, 44);
		contentPane.add(btnMostrar);
		
		lblSeleccioneElTipo = new JLabel("Seleccione el tipo de servicio que desea borrar:");
		lblSeleccioneElTipo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblSeleccioneElTipo.setBounds(39, 58, 325, 26);
		contentPane.add(lblSeleccioneElTipo);
		
		lblListaDeServicios = new JLabel("Eliminar servicios");
		lblListaDeServicios.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblListaDeServicios.setBounds(39, 11, 214, 36);
		contentPane.add(lblListaDeServicios);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 112, 609, 178);
		contentPane.add(scrollPane);
		
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		
		cbxEstado = new JComboBox();
		cbxEstado.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cbxEstado.setBounds(341, 58, 100, 26);
		contentPane.add(cbxEstado);
		cbxEstado.addItem("Pendiente");
		cbxEstado.addItem("Activo");
		cbxEstado.addItem("Finalizado");
		
		lblIngreseElId = new JLabel("Ingrese el Id:");
		lblIngreseElId.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblIngreseElId.setBounds(112, 350, 94, 26);
		contentPane.add(lblIngreseElId);
	}
}

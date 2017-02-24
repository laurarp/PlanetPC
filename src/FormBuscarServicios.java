import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.ScrollPane;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class FormBuscarServicios extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	}

	/**
	 * Create the frame.
	 */
	public FormBuscarServicios() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 729, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 40, 619, 271);
		contentPane.add(scrollPane);
		JComboBox cbxParametroBusqueda = new JComboBox();
		cbxParametroBusqueda.addItem("Pendiente");
		cbxParametroBusqueda.addItem("Activo");
		cbxParametroBusqueda.setFont(new Font("Tahoma", Font.BOLD, 12));
		cbxParametroBusqueda.setBounds(116, 322, 165, 20);
		contentPane.add(cbxParametroBusqueda);
		AuxiliarServicio x= new AuxiliarServicio("default", "default", "default");	
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String titulos[] = { "Id Servicio", "Descripción", "Id Cliente", "Fecha de entrada", "Fecha de salida", "Precio", "Estado" };
				table = new JTable(x.generarReporteServicios((String) cbxParametroBusqueda.getSelectedItem()), titulos);
				scrollPane.setViewportView(table);
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

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormServicioTecnico {

	private JFrame FormAuxiliarServicio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormServicioTecnico window = new FormServicioTecnico();
					window.FormAuxiliarServicio.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FormServicioTecnico() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		FormAuxiliarServicio = new JFrame();
		FormAuxiliarServicio.setTitle("\u00C1rea Servicio Tecnico");
		FormAuxiliarServicio.setBounds(100, 100, 666, 433);
		FormAuxiliarServicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FormAuxiliarServicio.getContentPane().setLayout(null);
		
		JButton btnIngresarServicio = new JButton("Ingresar nuevo servicio");
		btnIngresarServicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				IngresoDatosCrearServicios datos= new IngresoDatosCrearServicios();
				datos.setVisible(true);
			}
		});
		btnIngresarServicio.setBounds(90, 67, 145, 67);
		FormAuxiliarServicio.getContentPane().add(btnIngresarServicio);
		
		JButton btnModificarServicio = new JButton("Modificar servicio");
		btnModificarServicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnModificarServicio.setBounds(405, 67, 145, 67);
		FormAuxiliarServicio.getContentPane().add(btnModificarServicio);
	}
}

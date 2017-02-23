import java.awt.EventQueue;

import javax.swing.JFrame;
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
		AuxiliarServicio auxiliar=new AuxiliarServicio("guillermo", "1017196884", "12345");
		JButton btnIngresarServicio = new JButton("Ingresar nuevo servicio");
		btnIngresarServicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				auxiliar.ingresarServicio("12345","portatil dell", "1017196884", 35000, 10);
			}
		});
		btnIngresarServicio.setBounds(90, 67, 145, 67);
		
		FormAuxiliarServicio.getContentPane().add(btnIngresarServicio);
		
		JButton btnModificarServicio = new JButton("ModificarServicio");
		btnModificarServicio.setBounds(405, 67, 145, 67);
		FormAuxiliarServicio.getContentPane().add(btnModificarServicio);
		
		JButton btnGenerarReporteServicio = new JButton("Generar reporte");
		btnGenerarReporteServicio.setBounds(90, 209, 145, 67);
		FormAuxiliarServicio.getContentPane().add(btnGenerarReporteServicio);
		
		JButton btnEliminarServicio = new JButton("Eliminar servicio");
		btnEliminarServicio.setBounds(405, 209, 145, 67);
		FormAuxiliarServicio.getContentPane().add(btnEliminarServicio);
	}
}

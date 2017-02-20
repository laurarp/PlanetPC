import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;


public class FormReporteVentas {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormReporteVentas window = new FormReporteVentas();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FormReporteVentas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 481, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		String titulos[] = { "Producto", "Fecha", "Cliente", "Vendedor","Cantidad" };
		String informacion[][] = {{"11","Nombre","Edad","Prof","2"},{"11","Nombre","Edad","Prof","55"}};
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 34, 313, 183);
		frame.getContentPane().add(scrollPane);
		table = new JTable(informacion,titulos);
		scrollPane.setViewportView(table);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(366, 207, 89, 23);
		frame.getContentPane().add(btnConsultar);
	}

}

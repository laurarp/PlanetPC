import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;


public class FormReporteCompras {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormReporteCompras window = new FormReporteCompras();
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
	public FormReporteCompras() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 520, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		String titulos[] = { "Producto", "Proveedor", "Cantidad", "Valor","Fecha pedido","Fecha ingreso"};
		String informacion[][] = {{"11","Nombre","Edad","Prof","2","1"},{"11","Nombre","Edad","Prof","55","1"}};
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 34, 474, 181);
		frame.getContentPane().add(scrollPane);	
		table = new JTable(informacion,titulos);
		scrollPane.setViewportView(table);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(30, 226, 89, 23);
		frame.getContentPane().add(btnConsultar);
	}

}

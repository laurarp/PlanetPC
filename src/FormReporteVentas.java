import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;


public class FormReporteVentas {

	private JFrame frame;
	private JTable table;

	/**
	 * Create the application.
	 * @param actor 
	 */
	public FormReporteVentas(Actor actor) {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 481, 300);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		String titulos[] = { "Producto", "Fecha", "Cliente", "Vendedor","Cantidad" };
		String informacion[][] = {{"11","Nombre","Edad","Prof","2"},{"11","Nombre","Edad","Prof","55"}};
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 34, 313, 183);
		getFrame().getContentPane().add(scrollPane);
		table = new JTable(informacion,titulos);
		scrollPane.setViewportView(table);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(366, 207, 89, 23);
		getFrame().getContentPane().add(btnConsultar);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}

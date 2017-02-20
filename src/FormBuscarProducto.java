import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Choice;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class FormBuscarProducto {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormBuscarProducto window = new FormBuscarProducto();
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
	public FormBuscarProducto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Choice chProductos = new Choice();
		chProductos.setBounds(103, 32, 120, 20);
		frame.getContentPane().add(chProductos);
		
		Label label = new Label("Producto");
		label.setBounds(34, 32, 62, 22);
		frame.getContentPane().add(label);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(237, 32, 89, 23);
		frame.getContentPane().add(btnBuscar);
		
		String titulos[] = { "Ubicacion", "Cantidad", "Valor", "Garantia" };
		String informacion[][] = {{"11","Nombre","Edad","Prof"},{"11","Nombre","Edad","Prof"}};
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 72, 289, 160);
		frame.getContentPane().add(scrollPane);		
		table = new JTable(informacion,titulos);
		scrollPane.setViewportView(table);
	}
}

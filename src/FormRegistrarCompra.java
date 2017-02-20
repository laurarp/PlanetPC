import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Choice;


public class FormRegistrarCompra {

	private JFrame frame;
	DefaultTableModel dtm ;
	private JTable table;
	private JTextField textIdCompra;
	private JLabel lblNewLabel_1;
	private JButton btnRegistrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormRegistrarCompra window = new FormRegistrarCompra();
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
	public FormRegistrarCompra() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Proveedor");
		lblNewLabel.setBounds(24, 22, 69, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(203, 18, 89, 23);
		frame.getContentPane().add(btnConsultar);
				
		String titulos[] = { "Id Compra", "Tipo", "Cantidad", "Valor","Fecha pedido","Estado" };
		String informacion[][] = {{"11","Nombre","Edad","Prof","Telefono","pen"},{"11","Nombre","Edad","Prof","Telefono","pen"}};
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 62, 268, 170);
		frame.getContentPane().add(scrollPane);
		table = new JTable(informacion,titulos);
		scrollPane.setViewportView(table);
		
		textIdCompra = new JTextField();
		textIdCompra.setBounds(321, 108, 86, 20);
		frame.getContentPane().add(textIdCompra);
		textIdCompra.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Id Compra");
		lblNewLabel_1.setBounds(321, 83, 69, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(321, 151, 89, 23);
		frame.getContentPane().add(btnRegistrar);
		
		Choice chProveedores = new Choice();
		chProveedores.setBounds(99, 16, 79, 20);
		frame.getContentPane().add(chProveedores);
		
	}
}
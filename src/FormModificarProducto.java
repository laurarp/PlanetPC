import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;


public class FormModificarProducto extends JFrame {

	private JPanel contentPane;
	private AuxiliarAlmacenamiento auxiliar;
	private JTable table;
	private JTextField textField;
	private JLabel lblId;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JButton btnGuardarCambios;
	private JLabel lblNuevoId;
	private JLabel lblNuevoPrecioVenta;
	private JLabel lblNuevoTipo;
	private JLabel lblNuevaGarantia;
	private JLabel lblNuev;
	private JLabel lblNuevoModelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormModificarProducto frame = new FormModificarProducto();
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
	public FormModificarProducto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 734, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCatalogo = new JLabel("Catalogo");
		lblCatalogo.setBounds(10, 11, 46, 14);
		contentPane.add(lblCatalogo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 25, 674, 341);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		try {
			auxiliar = new AuxiliarAlmacenamiento("1004s","Pepito","pepito1309");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JButton btnSeleccionar = new JButton("Mostrar");
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				auxiliar.mostrarCatalogo();
			}
		});
		btnSeleccionar.setBounds(10, 377, 89, 23);
		contentPane.add(btnSeleccionar);
		
		textField = new JTextField();
		textField.setBounds(20, 411, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblId = new JLabel("Id");
		lblId.setBounds(10, 414, 22, 14);
		contentPane.add(lblId);
		
		textField_1 = new JTextField();
		textField_1.setBounds(211, 377, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(211, 408, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(389, 377, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(389, 408, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(558, 377, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(558, 408, 86, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		btnGuardarCambios = new JButton("Guardar cambios");
		btnGuardarCambios.setBounds(317, 436, 113, 23);
		contentPane.add(btnGuardarCambios);
		
		lblNuevoId = new JLabel("Nuevo Id");
		lblNuevoId.setBounds(116, 381, 46, 14);
		contentPane.add(lblNuevoId);
		
		lblNuevoPrecioVenta = new JLabel("Nuevo Precio Venta");
		lblNuevoPrecioVenta.setBounds(116, 411, 94, 14);
		contentPane.add(lblNuevoPrecioVenta);
		
		lblNuevoTipo = new JLabel("Nuevo tipo");
		lblNuevoTipo.setBounds(307, 381, 52, 14);
		contentPane.add(lblNuevoTipo);
		
		lblNuevaGarantia = new JLabel("Nueva garantia");
		lblNuevaGarantia.setBounds(307, 411, 74, 14);
		contentPane.add(lblNuevaGarantia);
		
		lblNuev = new JLabel("Nueva marca");
		lblNuev.setBounds(485, 381, 63, 14);
		contentPane.add(lblNuev);
		
		lblNuevoModelo = new JLabel("Nuevo modelo");
		lblNuevoModelo.setBounds(485, 411, 86, 14);
		contentPane.add(lblNuevoModelo);
	}
}

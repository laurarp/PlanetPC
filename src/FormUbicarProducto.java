import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class FormUbicarProducto extends JFrame {

	private JPanel contentPane;
	private JTextField textId;
	private JTextField text;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormUbicarProducto frame = new FormUbicarProducto();
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
	public FormUbicarProducto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ubicar Producto");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(156, 11, 163, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblIdDelProducto = new JLabel("Id del producto en el catalogo");
		lblIdDelProducto.setBounds(10, 34, 150, 14);
		contentPane.add(lblIdDelProducto);
		
		textId = new JTextField();
		textId.setBounds(170, 31, 86, 20);
		contentPane.add(textId);
		textId.setColumns(10);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 59, 46, 14);
		contentPane.add(lblCantidad);
		
		JLabel lblUbicacion = new JLabel("Ubicacion");
		lblUbicacion.setBounds(10, 84, 46, 14);
		contentPane.add(lblUbicacion);
		
		text = new JTextField();
		text.setBounds(170, 56, 86, 20);
		contentPane.add(text);
		text.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(170, 81, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}
}

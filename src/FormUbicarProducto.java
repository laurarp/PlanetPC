import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormUbicarProducto extends JFrame {

	private JPanel contentPane;
	private JTextField textId;
	private JTextField textCantidad;
	private JTextField textUbicacion;
	private AuxiliarAlmacenamiento auxiliar;

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
		
		textCantidad = new JTextField();
		textCantidad.setBounds(170, 56, 86, 20);
		contentPane.add(textCantidad);
		textCantidad.setColumns(10);
		
		textUbicacion = new JTextField();
		textUbicacion.setBounds(170, 81, 86, 20);
		contentPane.add(textUbicacion);
		textUbicacion.setColumns(10);
		try {
			auxiliar = new AuxiliarAlmacenamiento("1004s","Pepito","pepito1309");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JButton btnUbicar = new JButton("Ubicar");
		btnUbicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					auxiliar.ubicarProducto(textId.getText(), Integer.parseInt(textCantidad.getText()), textUbicacion.getText());
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				textId.setText("");
				textCantidad.setText("");
				textUbicacion.setText("");
			
			}
		});
		btnUbicar.setBounds(92, 112, 89, 23);
		contentPane.add(btnUbicar);
	}
}

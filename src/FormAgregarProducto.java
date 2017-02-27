import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;
import java.awt.event.ActionEvent;

public class FormAgregarProducto extends JFrame {
	private JPanel contentPane;
	private JTextField textId;
	private JTextField textprecioVenta;
	private JTextField textTipo;
	private JTextField textGarantia;
	private JTextField textMarca;
	private JTextField textModelo;
	private AuxiliarAlmacenamiento auxiliar;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormAgregarProducto frame = new FormAgregarProducto();
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
	public FormAgregarProducto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Id");
		lblNewLabel.setBounds(20, 38, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Precio");
		lblNewLabel_1.setBounds(20, 63, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(20, 88, 46, 14);
		contentPane.add(lblTipo);
		
		JLabel lblGarantia = new JLabel("Garantia");
		lblGarantia.setBounds(20, 113, 46, 14);
		contentPane.add(lblGarantia);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(20, 138, 46, 14);
		contentPane.add(lblMarca);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(20, 163, 46, 14);
		contentPane.add(lblModelo);
		
		JLabel lblNewLabel_2 = new JLabel("Agregar Producto");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(134, 0, 175, 31);
		contentPane.add(lblNewLabel_2);
		
		textId = new JTextField();
		textId.setBounds(76, 35, 86, 20);
		contentPane.add(textId);
		textId.setColumns(10);
		
		textprecioVenta = new JTextField();
		textprecioVenta.setBounds(76, 60, 86, 20);
		contentPane.add(textprecioVenta);
		textprecioVenta.setColumns(10);
		
		textTipo = new JTextField();
		textTipo.setBounds(76, 85, 86, 20);
		contentPane.add(textTipo);
		textTipo.setColumns(10);
		
		textGarantia = new JTextField();
		textGarantia.setText("");
		textGarantia.setBounds(76, 110, 86, 20);
		contentPane.add(textGarantia);
		textGarantia.setColumns(10);
		
		textMarca = new JTextField();
		textMarca.setBounds(76, 135, 86, 20);
		contentPane.add(textMarca);
		textMarca.setColumns(10);
		
		textModelo = new JTextField();
		textModelo.setBounds(76, 160, 86, 20);
		contentPane.add(textModelo);
		textModelo.setColumns(10);
		try {
			auxiliar = new AuxiliarAlmacenamiento("1004s","Pepito","pepito1309");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int pv = 0;
				int dg = 0;
				boolean intentar = true;
					try{
						pv = Integer.parseInt(textprecioVenta.getText());
						dg = Integer.parseInt(textGarantia.getText());
						intentar = true;
					}catch (NumberFormatException e){
						  intentar = false;
						  JOptionPane.showMessageDialog(contentPane, "Precio o garantia deben ser numeros enteros");
						  textprecioVenta.setText("");
						  textGarantia.setText("");
					}
				if (intentar == true){
					try{
						auxiliar.ingresarProductoCatalogo(textId.getText(), pv, textTipo.getText(), dg,textMarca.getText(),textModelo.getText());
						textId.setText("");
						textprecioVenta.setText("");
						textTipo.setText("");
						textGarantia.setText("");
						textMarca.setText("");
						textModelo.setText("");
						intentar = true;
					} catch (NumberFormatException e){
						  intentar = false;
						  JOptionPane.showMessageDialog(contentPane, "Precio o garantia deben ser numeros enteros");
						  textprecioVenta.setText("");
						  textGarantia.setText("");
					  }	  
				}
	
			}
		});
		btnNewButton.setBounds(30, 188, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cerrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		btnNewButton_1.setBounds(335, 228, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormListaDescProducto extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormListaDescProducto frame = new FormListaDescProducto();
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
	public FormListaDescProducto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Agregar Producto");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				FormAgregarProducto adp = new FormAgregarProducto();
				adp.setVisible(true);
			}
		});
		btnNewButton.setBounds(23, 62, 168, 51);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Eliminar Producto");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormEliminarProducto edp = new FormEliminarProducto();
				edp.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(258, 62, 176, 51);
		contentPane.add(btnNewButton_1);
		
		JButton btnModificarProducto = new JButton("Modificar Producto");
		btnModificarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormModificarProducto mdp = new FormModificarProducto();
				mdp.setVisible(true);
			}
		});
		btnModificarProducto.setBounds(23, 163, 176, 51);
		contentPane.add(btnModificarProducto);
		
		JButton btnNewButton_2 = new JButton("Ubicar Producto");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormUbicarProducto ubp = new FormUbicarProducto();
				ubp.setVisible(true);			
			}
		});
		btnNewButton_2.setBounds(258, 163, 162, 51);
		contentPane.add(btnNewButton_2);
		
		JLabel lblAuxiliarDeAlmacenamiento = new JLabel("Auxiliar de almacenamiento");
		lblAuxiliarDeAlmacenamiento.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAuxiliarDeAlmacenamiento.setBounds(105, 11, 224, 40);
		contentPane.add(lblAuxiliarDeAlmacenamiento);
	}
}

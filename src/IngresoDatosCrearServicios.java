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

public class IngresoDatosCrearServicios extends JFrame {
	private JPanel contentPane;
	private JTextField txtDescripcion;
	private JTextField txtIdCliente;
	private JTextField txtPrecio;
	private JTextField txtDiasEstimados;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IngresoDatosCrearServicios frame = new IngresoDatosCrearServicios();
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
	public IngresoDatosCrearServicios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 346, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDescripcion = new JLabel("Descripci\u00F3n");
		lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDescripcion.setBounds(24, 33, 91, 31);
		contentPane.add(lblDescripcion);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(154, 33, 138, 31);
		contentPane.add(txtDescripcion);
		txtDescripcion.setColumns(10);
		
		JLabel lblIdCliente = new JLabel("Id Cliente");
		lblIdCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIdCliente.setBounds(24, 96, 91, 31);
		contentPane.add(lblIdCliente);
		
		txtIdCliente = new JTextField();
		txtIdCliente.setBounds(154, 96, 138, 31);
		contentPane.add(txtIdCliente);
		txtIdCliente.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrecio.setBounds(24, 171, 46, 14);
		contentPane.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(154, 165, 138, 31);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		JLabel lblDiasEstimados = new JLabel("Dias estimados");
		lblDiasEstimados.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDiasEstimados.setBounds(24, 222, 107, 19);
		contentPane.add(lblDiasEstimados);
		
		txtDiasEstimados = new JTextField();
		txtDiasEstimados.setBounds(154, 218, 138, 31);
		contentPane.add(txtDiasEstimados);
		txtDiasEstimados.setColumns(10);
		AuxiliarServicio auxiliar=new AuxiliarServicio("guillermo", "1017196884", "12345");
		JButton btnCargarServicio = new JButton("Cargar servicio");
		btnCargarServicio.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				auxiliar.ingresarServicio(txtDescripcion.getText(), txtIdCliente.getText(), Double.parseDouble(txtPrecio.getText()),Integer.parseInt(txtDiasEstimados.getText()));
				txtDescripcion.setText("");
				txtIdCliente.setText("");
				txtPrecio.setText("");
				txtDiasEstimados.setText("");
			}

			
		});
		btnCargarServicio.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCargarServicio.setBounds(103, 280, 138, 23);
		contentPane.add(btnCargarServicio);
	}
}

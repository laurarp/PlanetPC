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
import java.awt.event.ActionEvent;
import java.awt.Color;

public class FormIngresoDatosCrearServicios extends JFrame {
	private JPanel contentPane;
	private JTextField txtDescripcion;
	private JTextField txtIdCliente;
	private JTextField txtPrecio;
	private JTextField txtDiasEstimados;
	private Actor actor;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormIngresoDatosCrearServicios frame = new FormIngresoDatosCrearServicios();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public FormIngresoDatosCrearServicios(Actor actor) {
		this.actor=actor;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 513, 432);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDescripcion = new JLabel("Descripci\u00F3n:");
		lblDescripcion.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblDescripcion.setBounds(67, 121, 91, 31);
		contentPane.add(lblDescripcion);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(290, 123, 138, 31);
		contentPane.add(txtDescripcion);
		txtDescripcion.setColumns(10);
		
		JLabel lblIdCliente = new JLabel("Id Cliente:");
		lblIdCliente.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblIdCliente.setBounds(67, 163, 91, 31);
		contentPane.add(lblIdCliente);
		
		txtIdCliente = new JTextField();
		txtIdCliente.setBounds(290, 165, 138, 31);
		contentPane.add(txtIdCliente);
		txtIdCliente.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblPrecio.setBounds(67, 216, 56, 14);
		contentPane.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(290, 207, 138, 31);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		JLabel lblDiasEstimados = new JLabel("Dias estimados:");
		lblDiasEstimados.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblDiasEstimados.setBounds(67, 258, 107, 19);
		contentPane.add(lblDiasEstimados);
		
		txtDiasEstimados = new JTextField();
		txtDiasEstimados.setBounds(290, 254, 138, 31);
		contentPane.add(txtDiasEstimados);
		txtDiasEstimados.setColumns(10);
		AuxiliarServicio auxiliar=new AuxiliarServicio(actor.getNombre(),actor.getId(), actor.getContrasena());
		JButton btnCargarServicio = new JButton("Cargar servicio");
		btnCargarServicio.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				try {
					auxiliar.ingresarServicio(txtDescripcion.getText(), txtIdCliente.getText(), Double.parseDouble(txtPrecio.getText()),Integer.parseInt(txtDiasEstimados.getText()));
				} catch (NumberFormatException e) {
					
					JOptionPane.showMessageDialog(btnCargarServicio, "Todos los campos deben llenarse");
				} catch (Excepciones e) {
					
					JOptionPane.showMessageDialog(btnCargarServicio, e.getMessage());
				}
				txtDescripcion.setText("");
				txtIdCliente.setText("");
				txtPrecio.setText("");
				txtDiasEstimados.setText("");
			}

			
		});
		btnCargarServicio.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnCargarServicio.setBounds(174, 318, 138, 48);
		contentPane.add(btnCargarServicio);
		
		JLabel lblCrearNuevoServicio = new JLabel("Crear nuevo servicio");
		lblCrearNuevoServicio.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblCrearNuevoServicio.setBounds(47, 29, 254, 31);
		contentPane.add(lblCrearNuevoServicio);
	}
}

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormIngresoEliminarServicio extends JFrame {

	private JPanel contentPane;
	private JTextField txtEliminar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormIngresoEliminarServicio frame = new FormIngresoEliminarServicio();
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
	public FormIngresoEliminarServicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtEliminar = new JTextField();
		txtEliminar.setBounds(55, 34, 86, 20);
		contentPane.add(txtEliminar);
		txtEliminar.setColumns(10);
		AuxiliarServicio auxiliar=new AuxiliarServicio("guillermo", "1017196884", "12345");
		JButton btnEliminar = new JButton("eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			try {
				auxiliar.eliminarServicio(txtEliminar.getText());
			} catch (Excepciones e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
			}
		});
		btnEliminar.setBounds(73, 125, 89, 23);
		contentPane.add(btnEliminar);
	}
}

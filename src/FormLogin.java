import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.JButton;


public class FormLogin {

	private JFrame frame;
	private JTextField textUsuario;
	private JPasswordField Contrasena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormLogin window = new FormLogin();
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
	public FormLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBackground(SystemColor.inactiveCaption);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 373, 402);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel.setBounds(34, 153, 85, 21);
		frame.getContentPane().add(lblNewLabel);
		
		textUsuario = new JTextField();
		textUsuario.setBackground(SystemColor.text);
		textUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		textUsuario.setFont(new Font("Calibri", Font.PLAIN, 20));
		textUsuario.setBounds(34, 180, 295, 36);
		frame.getContentPane().add(textUsuario);
		textUsuario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a");
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_1.setBounds(34, 227, 117, 21);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel Logo = new JLabel("");
		Image img= new ImageIcon(this.getClass().getResource("/Logo.png")).getImage();
		Logo.setIcon(new ImageIcon(img));
		Logo.setBounds(21, -50, 346, 269);
		frame.getContentPane().add(Logo);
		
		JLabel Border = new JLabel("");
		Border.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Border.setBackground(new Color(47, 79, 79));
		Border.setBounds(0, 0, 17, 373);
		Border.setOpaque(true);
		frame.getContentPane().add(Border);
		
		JLabel label = new JLabel("");
		label.setOpaque(true);
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBackground(new Color(47, 79, 79));
		label.setBounds(350, 0, 21, 373);
		frame.getContentPane().add(label);
		
		Contrasena = new JPasswordField();
		Contrasena.setFont(new Font("Calibri", Font.PLAIN, 20));
		Contrasena.setHorizontalAlignment(SwingConstants.CENTER);
		Contrasena.setBounds(34, 256, 295, 36);
		frame.getContentPane().add(Contrasena);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setBackground(new Color(32, 178, 170));
		btnIngresar.setFont(new Font("Calibri", Font.BOLD, 20));
		btnIngresar.setBounds(34, 315, 295, 36);
		frame.getContentPane().add(btnIngresar);
	}
}

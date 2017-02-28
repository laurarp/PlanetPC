import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.util.Arrays;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class FormLogin {

	JFrame frame;
	private JTextField textUsuario;
	private JPasswordField textContrasena;
	private ListaActores actores=null;
	static FormLogin window;

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
					window = new FormLogin();
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
		try 
		{
			actores = new ListaActores();
		} 
		catch (Exception e) 
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
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
		
		textContrasena = new JPasswordField();
		textContrasena.setFont(new Font("Calibri", Font.PLAIN, 20));
		textContrasena.setHorizontalAlignment(SwingConstants.CENTER);
		textContrasena.setBounds(34, 256, 295, 36);
		frame.getContentPane().add(textContrasena);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					actores.cargarActores();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Error cargando actores");
				}
				if(actores!=null)
				{
					int i=0;
							
					while( i<actores.getActores().size() &&  (textUsuario.getText().compareTo(actores.getActores().get(i).getId())!=0 || String.valueOf(textContrasena.getPassword()).compareTo(actores.getActores().get(i).getContrasena())!=0 ))
					{
						i++;
					}
					
					if(i<actores.getActores().size())
					{
						Actor a=null;
						
						try
						{
							//Crea de nuevo el actor para actualizar las listas a las que accede
							switch(actores.getActores().get(i).getClass().getName())
							{
								case "Administrador":
									a=new Administrador(actores.getActores().get(i).getId(),actores.getActores().get(i).getNombre(),actores.getActores().get(i).getContrasena());
									break;
									
								case "AuxiliarAlmacenamiento":
									a=new AuxiliarAlmacenamiento(actores.getActores().get(i).getId(),actores.getActores().get(i).getNombre(),actores.getActores().get(i).getContrasena());
									break;
									
								case "JefeBodega":
									a=new JefeBodega(actores.getActores().get(i).getId(),actores.getActores().get(i).getNombre(),actores.getActores().get(i).getContrasena());
									break;
									
								case "AsesorVentas":
									a=new AsesorVentas(actores.getActores().get(i).getId(),actores.getActores().get(i).getNombre(),actores.getActores().get(i).getContrasena());
									break;
								
								case "AuxiliarServicio":
									a=new AuxiliarServicio(actores.getActores().get(i).getId(),actores.getActores().get(i).getNombre(),actores.getActores().get(i).getContrasena());
									break;
							}
							
							FormPrincipal principal=new FormPrincipal(a);
							
							frame.setVisible(false);
							
							principal.getFrame().setVisible(true);
						}
						catch(Exception e)
						{
							JOptionPane.showMessageDialog(null, "Error generando página principal");
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Verifique el usuario o la contraseña");
						textContrasena.setText("");
						textContrasena.requestFocusInWindow();
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "No existe ningún usuario creado");
					textUsuario.setText("");
					textContrasena.setText("");
					textUsuario.requestFocusInWindow();
				}
			}
		});
		btnIngresar.setBackground(new Color(32, 178, 170));
		btnIngresar.setFont(new Font("Calibri", Font.BOLD, 20));
		btnIngresar.setBounds(34, 315, 295, 36);
		frame.getContentPane().add(btnIngresar);
	}

}

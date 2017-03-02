import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Choice;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.util.ArrayList;


public class FormRegistrarVenta extends JFrame{

	private JFrame frame;
	private JTextField textIdCliente;
	private JTextField textCantidad;
	private JTextField textIdProducto;
	private AsesorVentas asesorVentas;
	private JLabel lblRegistrarVenta;
	private JTable table;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					FormRegistrarVenta form = new FormRegistrarVenta(new Administrador("1","Laura","23"));


					form.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param actor 
	 */
	public FormRegistrarVenta(Actor actor) {
		try 
		{
			this.asesorVentas=new AsesorVentas(actor.getId(),actor.getNombre(),actor.getContrasena()) ;
			initialize();
		} 
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 645, 546);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		JLabel lblProducto = new JLabel("Id Producto");
		lblProducto.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblProducto.setBounds(57, 64, 86, 14);
		getFrame().getContentPane().add(lblProducto);
		
		JLabel lblIdCliente = new JLabel("Id Cliente");
		lblIdCliente.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblIdCliente.setBounds(218, 64, 86, 14);
		getFrame().getContentPane().add(lblIdCliente);
		
		textIdCliente = new JTextField();
		textIdCliente.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textIdCliente.setBounds(190, 82, 131, 20);
		getFrame().getContentPane().add(textIdCliente);
		textIdCliente.setColumns(10);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblCantidad.setBounds(376, 64, 71, 14);
		getFrame().getContentPane().add(lblCantidad);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
					asesorVentas.registarVenta(textIdProducto.getText(), textIdCliente.getText(), asesorVentas.getId(), textCantidad.getText());
					textIdProducto.setText("");
					textIdCliente.setText("");
					textCantidad.setText("");
					JOptionPane.showMessageDialog(null, "Venta creada correctamente");
				} 
				catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnRegistrar.setBounds(498, 81, 89, 23);
		getFrame().getContentPane().add(btnRegistrar);
		
		textCantidad = new JTextField();
		textCantidad.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textCantidad.setBounds(343, 82, 131, 20);
		getFrame().getContentPane().add(textCantidad);
		textCantidad.setColumns(10);
		
		textIdProducto = new JTextField();
		textIdProducto.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textIdProducto.setBounds(36, 82, 133, 20);
		frame.getContentPane().add(textIdProducto);
		textIdProducto.setColumns(10);
		
		lblRegistrarVenta = new JLabel("Registrar venta");
		lblRegistrarVenta.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblRegistrarVenta.setBounds(24, 19, 209, 34);
		frame.getContentPane().add(lblRegistrarVenta);
		
String titulos[] = { "Tipo","Marca","Modelo", "Fecha", "Cliente", "Vendedor","Cantidad" };
		
		DefaultTableModel tableModel = new DefaultTableModel(titulos, 0);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 119, 552, 306);
		getFrame().getContentPane().add(scrollPane);
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		
		JButton btnConsultar = new JButton("Mostrar ventas");
		btnConsultar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Venta> ventas = null;

				int rowCount = tableModel.getRowCount();
				
				for (int i = rowCount - 1; i >= 0; i--) {
					tableModel.removeRow(i);
				}

				try 
				{
					ventas = asesorVentas.reporteVentas();

					if (ventas.size()!=0) {
						for (int i = 0; i < ventas.size(); i++) {
							String tipo = ventas.get(i).getDescripcionProducto().getTipo();
							String marca = ventas.get(i).getDescripcionProducto().getMarca();
							String modelo = ventas.get(i).getDescripcionProducto().getModelo();
							String fecha = ventas.get(i).getFechaVenta().toString();
							String cliente = ventas.get(i).getIdCliente();
							String vendedor = ventas.get(i).getIdVendedor();
							String cantidad = String.valueOf(ventas.get(i).getCantidad());

							Object[] objs = { tipo,marca,modelo, fecha, cliente, vendedor,cantidad};
							
							tableModel.addRow(objs);
						}
					} 
					else 
					{
						JOptionPane.showMessageDialog(null, "No existen ventas");
					}

				} 
				catch (Exception e1) 
				{
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "No se pudo generar el reporte");
				}				

			}
		});
		
		btnConsultar.setBounds(228, 449, 151, 23);
		getFrame().getContentPane().add(btnConsultar);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
		frame.getContentPane().setBackground(new Color(255, 255, 255));
	}

}

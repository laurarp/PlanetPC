import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Choice;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;


public class FormBuscarProducto extends JFrame{

	private JFrame frame;
	private JTable table;
	private AsesorVentas asesorVentas;
	private ListaDescProducto listaProductos;
	private JTextField textIdProducto;
	
	public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {

				FormBuscarProducto form = new FormBuscarProducto(new Administrador("1","Laura","23"));


				form.getFrame().setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
}


	/**
	 * Create the application.
	 */
	public FormBuscarProducto(Actor actor) {
		try 
		{
			asesorVentas = new AsesorVentas(actor.getId(), actor.getNombre(), actor.getContrasena());
			listaProductos=new ListaDescProducto();
			initialize();
		} 
		catch (Exception e) 
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().getContentPane().setBackground(new Color(255, 255, 255));
		getFrame().setBounds(100, 100, 372, 350);
		getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		Choice chProductos = new Choice();
		chProductos.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		for (int i = 0; i < listaProductos.mostrarProductos().size(); i++) {
			chProductos.addItem(listaProductos.mostrarProductos().get(i).getTipo()+" / "+listaProductos.mostrarProductos().get(i).getMarca()+" / "+listaProductos.mostrarProductos().get(i).getModelo());
		}
		chProductos.setBounds(117, 109, 201, 22);
		getFrame().getContentPane().add(chProductos);
		
		Label label = new Label("Producto");
		label.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		label.setBounds(29, 109, 62, 22);
		getFrame().getContentPane().add(label);
		
		String titulos[] = { "Ubicacion", "Cantidad", "Valor", "Garantia" };
		DefaultTableModel tableModel = new DefaultTableModel(titulos, 0);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 204, 289, 70);
		getFrame().getContentPane().add(scrollPane);		
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		
		JLabel lblIdProducto = new JLabel("Id Producto");
		lblIdProducto.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblIdProducto.setBounds(29, 73, 124, 14);
		getFrame().getContentPane().add(lblIdProducto);
		
		textIdProducto = new JTextField();
		textIdProducto.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textIdProducto.setBounds(117, 70, 201, 20);
		getFrame().getContentPane().add(textIdProducto);
		textIdProducto.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try 
				{
					int rowCount = tableModel.getRowCount();
					
					for (int i = rowCount - 1; i >= 0; i--) {
						tableModel.removeRow(i);
					}
					
					String delimiter = " / ";
					String[] temp;
					temp = chProductos.getSelectedItem().split(delimiter);
					Producto p=asesorVentas.buscarProducto(textIdProducto.getText(),temp[0], temp[1],temp[2]);
					
					String ubicacion =p.getUbicacion();
					String cantidad = String.valueOf(p.getCantidad());
					String valor = String.valueOf(p.getDescripcionProducto().getPrecioVenta());
					String garantia = String.valueOf(p.getDescripcionProducto().getDiasGarantia());
					
					Object[] objs = {ubicacion, cantidad,valor,garantia};
					
					tableModel.addRow(objs);
				} 
				catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnBuscar.setBounds(117, 156, 89, 23);
		getFrame().getContentPane().add(btnBuscar);
		
		JLabel lblBuscarProducto = new JLabel("Buscar Producto");
		lblBuscarProducto.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblBuscarProducto.setBounds(29, 22, 244, 30);
		getFrame().getContentPane().add(lblBuscarProducto);
		
	}


	public JFrame getFrame() {
		return frame;
	}


	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}

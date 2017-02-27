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


public class FormBuscarProducto {

	private JFrame frame;
	private JTable table;
	private AsesorVentas asesorVentas;
	private ListaDescProducto listaProductos;
	private JTextField textIdProducto;

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
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Choice chProductos = new Choice();
		for (int i = 0; i < listaProductos.mostrarProductos().size(); i++) {
			chProductos.addItem(listaProductos.mostrarProductos().get(i).getTipo()+" / "+listaProductos.mostrarProductos().get(i).getMarca()+" / "+listaProductos.mostrarProductos().get(i).getModelo());
		}
		chProductos.setBounds(79, 45, 192, 20);
		frame.getContentPane().add(chProductos);
		
		Label label = new Label("Producto");
		label.setBounds(20, 43, 62, 22);
		frame.getContentPane().add(label);
		
		String titulos[] = { "Ubicacion", "Cantidad", "Valor", "Garantia" };
		DefaultTableModel tableModel = new DefaultTableModel(titulos, 0);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 94, 289, 70);
		frame.getContentPane().add(scrollPane);		
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		
		JLabel lblIdProducto = new JLabel("id Producto");
		lblIdProducto.setBounds(20, 11, 46, 14);
		frame.getContentPane().add(lblIdProducto);
		
		textIdProducto = new JTextField();
		textIdProducto.setBounds(79, 8, 86, 20);
		frame.getContentPane().add(textIdProducto);
		textIdProducto.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try 
				{
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
		btnBuscar.setBounds(324, 32, 89, 23);
		frame.getContentPane().add(btnBuscar);
		
	}
}

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;


public class FormReporteCompras {

	private JFrame frame;
	private JTable table;
	AsesorVentas asesorVentas = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormReporteCompras window = new FormReporteCompras();
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
	public FormReporteCompras() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		try 
		{
			asesorVentas = new AsesorVentas(null, null, null);
		} 
		catch (Exception e) 
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		frame = new JFrame();
		frame.setBounds(100, 100, 583, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
<<<<<<< HEAD
		String titulos[] = { "Tipo","Marca","Modelo", "Proveedor", "Cantidad", "Valor","Fecha pedido","Fecha ingreso","Estado"};
=======
		String titulos[] = { "Producto", "Proveedor", "Cantidad", "Valor","Fecha pedido","Fecha ingreso"};
>>>>>>> origin/master
		
		DefaultTableModel tableModel = new DefaultTableModel(titulos, 0);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 25, 506, 170);
		frame.getContentPane().add(scrollPane);
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Compra> compras = null;

				for (int i = 0; i < tableModel.getRowCount(); i++) 
				{
					tableModel.removeRow(i);
				}

				try 
				{
					compras = asesorVentas.reporteCompras();
<<<<<<< HEAD
					if (compras.size()!=0) {
						for (int i = 0; i < compras.size(); i++) {
							String tipo = compras.get(i).getDescripcionProducto().getTipo();
							String marca = compras.get(i).getDescripcionProducto().getMarca();
							String modelo = compras.get(i).getDescripcionProducto().getModelo();
							String proveedor = compras.get(i).getIdProveedor();
							String cantidad = Integer.toString(compras.get(i).getCantidad());
							String valor = Integer.toString(compras.get(i).getPrecioCompra());
							String fechap = compras.get(i).getFechaPedido().toString();
							String fechai = compras.get(i).getFechaIngreso().toString();
							String estado=compras.get(i).getEstado();
							
							Object[] objs = { tipo,marca,modelo, proveedor, cantidad, valor,
									fechap, fechai ,estado};
							
							tableModel.addRow(objs);
						}
					} 
					else 
					{
						JOptionPane.showMessageDialog(null, "No existen compras");
					}
=======
>>>>>>> origin/master
				} 
				catch (Exception e1) 
				{
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "No se pudo generar el reporte");
				}				

				if (compras != null) {
					for (int i = 0; i < compras.size(); i++) {
						String producto = compras.get(i).getDescripcionProducto().getTipo();
						String proveedor = compras.get(i).getIdProveedor();
						String cantidad = Integer.toString(compras.get(i).getCantidad());
						String valor = Integer.toString(compras.get(i).getPrecioCompra());
						String fechap = compras.get(i).getFechaPedido().toString();
						String fechai = compras.get(i).getFechaIngreso().toString();
						
						Object[] objs = { producto, proveedor, cantidad, valor,
								fechap, fechai };
						// Object[] objs = {"1",
						// "PC","2","3600","Hoy","Pendiente"};
						tableModel.addRow(objs);
					}
				} else {
					JOptionPane.showMessageDialog(null,
							"No hay pedidos pendientes");
				}
			}
		});
		btnConsultar.setBounds(30, 226, 89, 23);
		frame.getContentPane().add(btnConsultar);
	}

}

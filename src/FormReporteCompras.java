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
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;


public class FormReporteCompras {

	private JFrame frame;
	private JTable table;
	private AsesorVentas asesorVentas = null;
	private JLabel lblReporteCompras;

	/**
	 * Create the application.
	 * @param actor 
	 */
	public FormReporteCompras(Actor actor) {
		try 
		{
			asesorVentas = new AsesorVentas(actor.getId(), actor.getNombre(), actor.getContrasena());
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
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 809, 569);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		String titulos[] = { "Tipo","Marca","Modelo", "Proveedor", "Cantidad", "Valor","Fecha pedido","Fecha ingreso","Estado"};
		
		DefaultTableModel tableModel = new DefaultTableModel(titulos, 0);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 69, 720, 374);
		frame.getContentPane().add(scrollPane);
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		
		JButton btnConsultar = new JButton("Generar");
		btnConsultar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Compra> compras = null;

				int rowCount = tableModel.getRowCount();
				
				for (int i = rowCount - 1; i >= 0; i--) {
					tableModel.removeRow(i);
				}

				try 
				{
					compras = asesorVentas.reporteCompras();

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
		btnConsultar.setBounds(324, 472, 145, 23);
		frame.getContentPane().add(btnConsultar);
		
		lblReporteCompras = new JLabel("Reporte compras");
		lblReporteCompras.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblReporteCompras.setBounds(37, 25, 214, 31);
		frame.getContentPane().add(lblReporteCompras);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}

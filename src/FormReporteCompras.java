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


public class FormReporteCompras extends JFrame{

	private JFrame frame;
	private JTable table;
	AsesorVentas asesorVentas = null;

	/**
	 * Create the application.
	 * @param actor 
	 */
	public FormReporteCompras(Actor actor) {
		try 
		{
			this.asesorVentas=new AsesorVentas(actor.getId(), actor.getNombre(), actor.getContrasena());
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
		getFrame().setBounds(100, 100, 583, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		String titulos[] = { "Tipo","Marca","Modelo", "Proveedor", "Cantidad", "Valor","Fecha pedido","Fecha ingreso","Estado"};
		
		DefaultTableModel tableModel = new DefaultTableModel(titulos, 0);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 25, 506, 170);
		getFrame().getContentPane().add(scrollPane);
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Compra> compras = null;

				int rowCount = tableModel.getRowCount();

				for (int i = rowCount - 1; i >= 0; i--) 
				{
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
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}					
			}
		});
		btnConsultar.setBounds(30, 226, 89, 23);
		getFrame().getContentPane().add(btnConsultar);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}

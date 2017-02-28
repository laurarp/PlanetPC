import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;


public class FormReporteVentas {

	private JFrame frame;
	private JTable table;
	private AsesorVentas asesorVentas = null;
	private JLabel lblReporteVentas;

	/**
	 * Create the application.
	 * @param actor 
	 */
	public FormReporteVentas(Actor actor) {
		try 
		{
			asesorVentas = new AsesorVentas(actor.getId(), actor.getNombre(), actor.getContrasena());
			initialize();
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 623, 367);
		getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		String titulos[] = { "Tipo","Marca","Modelo", "Fecha", "Cliente", "Vendedor","Cantidad" };
		
		DefaultTableModel tableModel = new DefaultTableModel(titulos, 0);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 71, 550, 183);
		getFrame().getContentPane().add(scrollPane);
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		
		JButton btnConsultar = new JButton("Consultar");
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
		
		btnConsultar.setBounds(25, 277, 112, 23);
		getFrame().getContentPane().add(btnConsultar);
		
		lblReporteVentas = new JLabel("Reporte ventas");
		lblReporteVentas.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblReporteVentas.setBounds(25, 25, 214, 23);
		frame.getContentPane().add(lblReporteVentas);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
		frame.getContentPane().setBackground(new Color(255, 255, 255));
	}

}

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


public class FormReporteVentas {

	private JFrame frame;
	private JTable table;
	private AsesorVentas asesorVentas = null;

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
		getFrame().setBounds(100, 100, 481, 300);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		String titulos[] = { "Producto", "Fecha", "Cliente", "Vendedor","Cantidad" };
		
		DefaultTableModel tableModel = new DefaultTableModel(titulos, 0);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 34, 313, 183);
		getFrame().getContentPane().add(scrollPane);
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		
		JButton btnConsultar = new JButton("Consultar");
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
							String tipo = "";
							String marca = "";
							String modelo = "";
							String fecha = "";
							String cliente = "";
							String vendedor = "";
							String cantidad = "";

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
		
		btnConsultar.setBounds(366, 207, 89, 23);
		getFrame().getContentPane().add(btnConsultar);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}

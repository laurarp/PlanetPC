import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Choice;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class FormRegistrarCompra {

	private JFrame frame;
	DefaultTableModel dtm ;
	private JTable table;
	private JTextField textIdCompra;
	private JLabel lblNewLabel_1;
	private JButton btnRegistrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormRegistrarCompra window = new FormRegistrarCompra();
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
	public FormRegistrarCompra() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Proveedor");
		lblNewLabel.setBounds(24, 22, 69, 14);
		frame.getContentPane().add(lblNewLabel);
			
		String titulos[] = { "Id Compra", "Tipo", "Cantidad", "Valor","Fecha pedido","Estado" };
		
		DefaultTableModel tableModel = new DefaultTableModel(titulos, 0);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 62, 268, 170);
		frame.getContentPane().add(scrollPane);
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AsesorVentas asesorVentas= new AsesorVentas();
				
				//for(int i=0;i<asesorVentas.obtenerPedidosPendientes().size();i++)
				{
					//String idcompra=Integer.toString(asesorVentas.obtenerPedidosPendientes().get(i).getIdCompra());
					//String tipo=asesorVentas.obtenerPedidosPendientes().get(i).getDescripcionProducto().getTipo();
					//String cantidad=Integer.toString(asesorVentas.obtenerPedidosPendientes().get(i).getCantidad());
					//String valor=Integer.toString(asesorVentas.obtenerPedidosPendientes().get(i).getPrecioCompra());
					//String fechap=asesorVentas.obtenerPedidosPendientes().get(i).getFechaPedido().toString();
					//String estado=asesorVentas.obtenerPedidosPendientes().get(i).getEstado();
					//Object[] objs = {idcompra, tipo,cantidad,valor,fechap,estado};
					Object[] objs = {"1", "PC","2","3600","Hoy","Pendiente"};
					tableModel.addRow(objs);
				}
				
				
				
			}
		});
		btnConsultar.setBounds(203, 18, 89, 23);
		frame.getContentPane().add(btnConsultar);
		
		textIdCompra = new JTextField();
		textIdCompra.setBounds(321, 108, 86, 20);
		frame.getContentPane().add(textIdCompra);
		textIdCompra.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Id Compra");
		lblNewLabel_1.setBounds(321, 83, 69, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(321, 151, 89, 23);
		frame.getContentPane().add(btnRegistrar);
		
		ListaProveedores lp=new ListaProveedores();
		
		Choice chProveedores = new Choice();
		for(int i=0;i<lp.mostrarProveedores().size();i++)
		{
			chProveedores.addItem(lp.mostrarProveedores().get(i).getNombre());
		}
		chProveedores.setBounds(99, 16, 79, 20);
		frame.getContentPane().add(chProveedores);
		
	}
}

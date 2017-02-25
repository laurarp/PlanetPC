import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class FormPrincipal extends JFrame{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormPrincipal window = new FormPrincipal();
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
	public FormPrincipal() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 509, 245);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setBackground(new Color(255, 255, 255));
		frame.getContentPane().setLayout(null);
		
		JLabel Logo = new JLabel("");
		Image img= new ImageIcon(this.getClass().getResource("/Logo.png")).getImage();
		Logo.setIcon(new ImageIcon(img));
		Logo.setBounds(84, 3, 346, 167);
		frame.getContentPane().add(Logo);
		
		JLabel label = new JLabel("");
		label.setBackground(new Color(47, 79, 79));
		label.setBounds(0, 181, 503, 14);
		label.setOpaque(true);
		frame.getContentPane().add(label);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnUsuarios = new JMenu("Usuarios");
		mnUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnUsuarios);
		
		JMenuItem mntmCrearUsuario = new JMenuItem("Crear usuario");
		mnUsuarios.add(mntmCrearUsuario);
		
		JMenuItem mntmModificarUsuario = new JMenuItem("Modificar usuario");
		mnUsuarios.add(mntmModificarUsuario);
		
		JMenuItem mntmBuscarUsuario = new JMenuItem("Buscar usuario");
		mnUsuarios.add(mntmBuscarUsuario);
		
		JMenuItem mntmEliminarUsuario = new JMenuItem("Eliminar usuario");
		mnUsuarios.add(mntmEliminarUsuario);
		
		JMenu mnCatlogo = new JMenu("Cat\u00E1logo");
		mnCatlogo.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnCatlogo);
		
		JMenuItem mntmAadirProducto = new JMenuItem("Ingresar producto");
		mnCatlogo.add(mntmAadirProducto);
		
		JMenuItem mntmModificarProducto = new JMenuItem("Modificar producto");
		mnCatlogo.add(mntmModificarProducto);
		
		JMenuItem mntmEliminarProducto = new JMenuItem("Eliminar producto");
		mnCatlogo.add(mntmEliminarProducto);
		
		JMenu mnCompras = new JMenu("Compras");
		mnCompras.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnCompras);
		
		JMenuItem mntmRegistrarPedido = new JMenuItem("Registrar pedido");
		mnCompras.add(mntmRegistrarPedido);
		
		JMenuItem mntmRegistrarCompra = new JMenuItem("Registrar compra");
		mnCompras.add(mntmRegistrarCompra);
		
		JMenuItem mntmGenerarReporteCompras = new JMenuItem("Generar reporte compras");
		mnCompras.add(mntmGenerarReporteCompras);
		
		JMenu mnVentas = new JMenu("Ventas");
		mnVentas.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnVentas);
		
		JMenuItem mntmRegistrarVenta = new JMenuItem("Registrar venta");
		mnVentas.add(mntmRegistrarVenta);
		
		JMenuItem mntmGenerarReporteVentas = new JMenuItem("Generar reporte ventas");
		mnVentas.add(mntmGenerarReporteVentas);
		
		JMenu mnInventario = new JMenu("Inventario");
		mnInventario.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnInventario);
		
		JMenuItem mntmBuscarProducto = new JMenuItem("Buscar producto");
		mnInventario.add(mntmBuscarProducto);
		
		JMenuItem mntmReporteInventarioActual = new JMenuItem("Reporte inventario actual");
		mnInventario.add(mntmReporteInventarioActual);
		
		JMenuItem mntmUbicarProducto = new JMenuItem("Ubicar producto");
		mnInventario.add(mntmUbicarProducto);
		
		JMenu mnProveedores = new JMenu("Proveedores");
		mnProveedores.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnProveedores);
		
		JMenuItem mntmCrearProveedor = new JMenuItem("Crear proveedor");
		mnProveedores.add(mntmCrearProveedor);
		
		JMenuItem mntmBuscarProveedor = new JMenuItem("Buscar proveedor");
		mnProveedores.add(mntmBuscarProveedor);
		
		JMenuItem mntmEliminarProveedor = new JMenuItem("Eliminar proveedor");
		mnProveedores.add(mntmEliminarProveedor);
		
		JMenuItem mntmModificarProveedor = new JMenuItem("Modificar proveedor");
		mnProveedores.add(mntmModificarProveedor);
		
		JMenu mnServicioTcnico = new JMenu("Servicio t\u00E9cnico");
		mnServicioTcnico.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnServicioTcnico);
		
		JMenuItem mntmIngresarEquipo = new JMenuItem("Ingresar equipo");
		mnServicioTcnico.add(mntmIngresarEquipo);
		mntmIngresarEquipo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FormIngresoDatosCrearServicios ingreso= new FormIngresoDatosCrearServicios();
				ingreso.setVisible(true);
			}
		});
		
		JMenuItem mntmEquiposPendientes = new JMenuItem("Equipos pendientes");
		mnServicioTcnico.add(mntmEquiposPendientes);
		
		JMenuItem mntmEliminarEquipo = new JMenuItem("Eliminar equipo");
		mnServicioTcnico.add(mntmEliminarEquipo);
		mntmEliminarEquipo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FormIngresoEliminarServicio eliminar= new FormIngresoEliminarServicio();
				eliminar.setVisible(true);				
			}
		});
		
		JMenuItem mntmModificarReporteEquipo = new JMenuItem("Modificar estado del equipo");
		mnServicioTcnico.add(mntmModificarReporteEquipo);
		
		JMenuItem mntmGenerarReporteServicios = new JMenuItem("Generar reporte servicios realizados");
		mnServicioTcnico.add(mntmGenerarReporteServicios);
		mntmGenerarReporteServicios.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FormBuscarServicios mostrar= new FormBuscarServicios();
				mostrar.setVisible(true);
			}
		});
	}
}

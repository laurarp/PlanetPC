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
	private Actor actor;

	/**
	 * Create the application.
	 * @param actor 
	 */
	public FormPrincipal(Actor actor) 
	{
		this.actor=actor;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().getContentPane().setBackground(Color.WHITE);
		getFrame().setBounds(100, 100, 509, 245);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().setResizable(false);
		getFrame().setBackground(new Color(255, 255, 255));
		getFrame().getContentPane().setLayout(null);
		
		JLabel Logo = new JLabel("");
		Image img= new ImageIcon(this.getClass().getResource("/Logo.png")).getImage();
		Logo.setIcon(new ImageIcon(img));
		Logo.setBounds(84, 3, 346, 167);
		getFrame().getContentPane().add(Logo);
		
		JLabel label = new JLabel("");
		label.setBackground(new Color(47, 79, 79));
		label.setBounds(0, 181, 503, 14);
		label.setOpaque(true);
		getFrame().getContentPane().add(label);
		
		JMenuBar menuBar = new JMenuBar();
		getFrame().setJMenuBar(menuBar);
		
		if(actor.getClass().getName().compareTo("Administrador")==0)
		{
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
		}
		
		if(actor.getClass().getName().compareTo("JefeBodega")==0 || actor.getClass().getName().compareTo("AuxiliarAlmacenamiento")==0 )
		{
			JMenu mnCatlogo = new JMenu("Cat\u00E1logo");
			mnCatlogo.setHorizontalAlignment(SwingConstants.CENTER);
			menuBar.add(mnCatlogo);
			
			if(actor.getClass().getName().compareTo("JefeBodega")==0 || actor.getClass().getName().compareTo("AuxiliarAlmacenamiento")==0 )
			{
				JMenuItem mntmAadirProducto = new JMenuItem("Ingresar producto");
				mnCatlogo.add(mntmAadirProducto);
				
				JMenuItem mntmModificarProducto = new JMenuItem("Modificar producto");
				mnCatlogo.add(mntmModificarProducto);
				
				JMenuItem mntmEliminarProducto = new JMenuItem("Eliminar producto");
				mnCatlogo.add(mntmEliminarProducto);
			}
		}
		
		if(actor.getClass().getName().compareTo("Administrador")==0 || actor.getClass().getName().compareTo("JefeBodega")==0 || actor.getClass().getName().compareTo("AsesorVentas")==0)
		{
			JMenu mnCompras = new JMenu("Compras");
			mnCompras.setHorizontalAlignment(SwingConstants.CENTER);
			menuBar.add(mnCompras);
			
			if(actor.getClass().getName().compareTo("JefeBodega")==0)
			{
				JMenuItem mntmRegistrarPedido = new JMenuItem("Registrar pedido");
				mnCompras.add(mntmRegistrarPedido);
			}
			
			if(actor.getClass().getName().compareTo("AsesorVentas")==0)
			{
				JMenuItem mntmRegistrarCompra = new JMenuItem("Registrar compra");
				mnCompras.add(mntmRegistrarCompra);
				mntmRegistrarCompra.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						FormRegistrarCompra registrarCompra= new FormRegistrarCompra(actor);
						registrarCompra.getFrame().setVisible(true);
					}
				});
			}
			
			if(actor.getClass().getName().compareTo("Administrador")==0 || actor.getClass().getName().compareTo("AsesorVentas")==0)
			{
				JMenuItem mntmGenerarReporteCompras = new JMenuItem("Generar reporte compras");
				mnCompras.add(mntmGenerarReporteCompras);
				mnCompras.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						FormReporteCompras reporteCompras= new FormReporteCompras(actor);
						reporteCompras.getFrame().setVisible(true);
					}
				});
			}
		}
		
		if(actor.getClass().getName().compareTo("Administrador")==0 || actor.getClass().getName().compareTo("AsesorVentas")==0)
		{
			JMenu mnVentas = new JMenu("Ventas");
			mnVentas.setHorizontalAlignment(SwingConstants.CENTER);
			menuBar.add(mnVentas);
			
			if(actor.getClass().getName().compareTo("AsesorVentas")==0)
			{
				JMenuItem mntmRegistrarVenta = new JMenuItem("Registrar venta");
				mnVentas.add(mntmRegistrarVenta);
				mntmRegistrarVenta.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						FormRegistrarVenta registrarVenta= new FormRegistrarVenta(actor);
						registrarVenta.getFrame().setVisible(true);
					}
				});
			}
			
			if(actor.getClass().getName().compareTo("Administrador")==0 || actor.getClass().getName().compareTo("AsesorVentas")==0 )
			{
				JMenuItem mntmGenerarReporteVentas = new JMenuItem("Generar reporte ventas");
				mnVentas.add(mntmGenerarReporteVentas);
				
			}
		}
		
		if(actor.getClass().getName().compareTo("Administrador")==0 || actor.getClass().getName().compareTo("AuxiliarAlmacenamiento")==0 || actor.getClass().getName().compareTo("JefeBodega")==0 || actor.getClass().getName().compareTo("AsesorVentas")==0)
		{
			JMenu mnInventario = new JMenu("Inventario");
			mnInventario.setHorizontalAlignment(SwingConstants.CENTER);
			menuBar.add(mnInventario);
			
			if( actor.getClass().getName().compareTo("AuxiliarAlmacenamiento")==0 || actor.getClass().getName().compareTo("JefeBodega")==0 || actor.getClass().getName().compareTo("AsesorVentas")==0)
			{
				JMenuItem mntmBuscarProducto = new JMenuItem("Buscar producto");
				mnInventario.add(mntmBuscarProducto);
			}
			
			if(actor.getClass().getName().compareTo("AuxiliarAlmacenamiento")==0)
			{
				JMenuItem mntmUbicarProducto = new JMenuItem("Ubicar producto");
				mnInventario.add(mntmUbicarProducto);
			}
			
			if(actor.getClass().getName().compareTo("Administrador")==0 || actor.getClass().getName().compareTo("JefeBodega")==0)
			{
				JMenuItem mntmReporteInventarioActual = new JMenuItem("Reporte inventario actual");
				mnInventario.add(mntmReporteInventarioActual);
			}
		}
		
		if(actor.getClass().getName().compareTo("Administrador")==0 )
		{
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
		}
		
		if(actor.getClass().getName().compareTo("Administrador")==0 || actor.getClass().getName().compareTo("AuxiliarServicio")==0 )
		{
			JMenu mnServicioTcnico = new JMenu("Servicio t\u00E9cnico");
			mnServicioTcnico.setHorizontalAlignment(SwingConstants.CENTER);
			menuBar.add(mnServicioTcnico);
			
			if(actor.getClass().getName().compareTo("AuxiliarServicio")==0)
			{
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
			}
			
			if(actor.getClass().getName().compareTo("Administrador")==0 || actor.getClass().getName().compareTo("AuxiliarServicio")==0)
			{
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
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}

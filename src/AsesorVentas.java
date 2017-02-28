import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class AsesorVentas extends Actor implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1110176987574427259L;
	private ListaCompras listaCompras;
	private ListaVentas listaVentas;
	private Inventario inventario;
	private ListaDescProducto productos;
	
	public AsesorVentas(String id, String nombre, String contrasena) throws Exception {
		super(id, nombre, contrasena);
		this.listaCompras = new ListaCompras();
		this.listaVentas = new ListaVentas();
		this.inventario = new Inventario();
		this.productos= new ListaDescProducto();
	}

	public ArrayList<Compra> reporteCompras() throws Exception
	{
		return listaCompras.getListaCompras();
	}
	
	public ArrayList<Venta> reporteVentas() throws Exception
	{
		return listaVentas.getListaVentas();
	}
	
	public Producto buscarProducto(String idProducto,String tipo, String marca, String modelo) throws Exception
	{
		return inventario.buscarProducto(idProducto,tipo,marca,modelo);
	}
	
	public void notificarCompraRecibida(String idCompra) throws Exception
	{
		listaCompras.notificarCompraRecibida(idCompra);
	}
	
	public ArrayList<Compra> obtenerPedidosPendientesProveedor(String idProveedor) throws Exception
	{
		ArrayList<Compra> pendientes=new ArrayList<Compra>();
		ArrayList<Compra> compras=listaCompras.getListaCompras();
		
		if(compras!=null)
		{
			for(int i=0;i<compras.size();i++)
			{
				if("Pendiente".compareTo(compras.get(i).getEstado())==0 && idProveedor.compareTo(compras.get(i).getIdProveedor())==0)
				{
					pendientes.add(compras.get(i));
				}
			}
			if(pendientes.size()!=0)
			{
				return pendientes;
			}
			else
			{
				throw new Exception("El proveedor no tiene pedidos pendientes");
			}
		}
		else
		{
			throw new Exception("No hay compras registradas");
		}	
	}
	
	public void registarVenta(String idProducto, String idCliente, String idVendedor, String Cantidad) throws Exception
	{
		if(idProducto.compareTo("")==0 || idCliente.compareTo("")==0 || Cantidad.compareTo("")==0)
		{
			throw new Exception("Alguno de los campos se encuentra vacio");
		}
		else
		{
			if(Integer.parseInt(Cantidad)>=0)
			{
				inventario.anadirCantidad(productos.buscarProducto(idProducto), Integer.parseInt(Cantidad));
				listaVentas.anadirVenta(productos.buscarProducto(idProducto), idCliente, idVendedor, Integer.parseInt(Cantidad));	
			}
			else
			{
				throw new Exception("No se puede registrar una venta con cantidades negativas");
			}
		}
	}
	
	public static void main(String[] args) {
		AsesorVentas v;
		
		

	}

	
}

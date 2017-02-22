import java.util.ArrayList;
import java.util.Date;


public class AsesorVentas {
	private ListaCompras listaCompras;
	private ListaVentas listaVentas;
	private Inventario inventario;
	
	public AsesorVentas(ListaCompras listaCompras, ListaVentas listaVentas,
			Inventario inventario) throws Exception {
		super();
		this.listaCompras = new ListaCompras();
		this.listaVentas = new ListaVentas();
		this.inventario = inventario;
	}

	public ArrayList<Compra> reporteCompras() throws Exception
	{
		return listaCompras.getListaCompras();
	}
	
	public ArrayList<Venta> reporteVentas() throws Exception
	{
		return listaVentas.getListaVentas();
	}
	
	public Producto buscarProducto(String idProducto)
	{
		return inventario.buscarProducto(idProducto);
	}
	
	public void modificarEstadoCompra(String idCompra,String estado) throws Exception
	{
		listaCompras.modificarCompra(idCompra, estado);
	}
	
	public ArrayList<Compra> obtenerPedidosPendientesProveedor(String idProveedor) throws Exception
	{
		ArrayList<Compra> pendientes=null;
		ArrayList<Compra> compras=listaCompras.getListaCompras();
		
		if(compras!=null)
		{
			for(int i=0;i<compras.size();i++)
			{
				if(compras.get(i).getEstado()=="Pendiente")
				{
					pendientes.add(compras.get(i));
				}
			}
		}
		return pendientes;
	}
	
	public void registarVenta(DescripcionProducto descripcionProducto, Date fechaVenta, String idCliente, String idVendedor, int Cantidad) throws Exception
	{
		listaVentas.añadirVenta(descripcionProducto, fechaVenta, idCliente, idVendedor, Cantidad);
	}

	
}

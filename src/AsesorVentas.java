import java.util.ArrayList;
import java.util.Date;


public class AsesorVentas {
	private ListaCompras listaCompras=new ListaCompras();
	private ListaVentas listaVentas=new ListaVentas();
	
	public ArrayList<Compra> reporteCompras()
	{
		return listaCompras.getListaCompras();
	}
	
	public ArrayList<Venta> reporteVentas()
	{
		return listaVentas.getListaVentas();
	}
	
	public Producto buscarProducto(Inventario inventario, String idProducto)
	{
		return null;
	}
	
	public void modificarCompra(ListaCompras listaCompras, Compra compra)
	{
		
	}
	
	public ArrayList<Compra> obtenerPedidosPendientes()
	{
		ArrayList<Compra> pendientes=null;
		
		for(int i=0;i<listaCompras.getListaCompras().size();i++)
		{
			if(listaCompras.getListaCompras().get(i).getEstado()=="Pendiente")
			{
				pendientes.add(listaCompras.getListaCompras().get(i));
			}
		}
		return pendientes;
	}
	
	
	public void registarVenta(ListaVentas listaVentas,DescripcionProducto descripcionProducto, Date fechaVenta, String idCliente, String idVendedor, int Cantidad)
	{
		
	}
}

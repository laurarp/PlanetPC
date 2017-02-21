import java.util.ArrayList;
import java.util.Date;


public class AsesorVentas {
	private ListaCompras listaCompras;
	private ListaVentas listaVentas;
	
	
	public ArrayList<Compra> reporteCompras() throws Exception
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
	
	public void modificarEstadoCompra(String idCompra,String estado) throws Exception
	{
		int i=0;
		ArrayList<Compra> compras= new ArrayList<Compra>();
		compras=listaCompras.getListaCompras();
		
		if(compras!=null)
		{
			while(i<compras.size() && String.valueOf(compras.get(i).getIdCompra())!=idCompra)
			{
				i++;
			}
			if(i<compras.size())
			{
				compras.get(i).setEstado("recibido");
				listaCompras.setListaCompras(compras);
				
			}
			else
			{
				throw new Exception ("La compra no existe");
			}
		}
		else
		{
			throw new Exception("No hay compras disponibles");
		}
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
	
	
	public void registarVenta(ListaVentas listaVentas,DescripcionProducto descripcionProducto, Date fechaVenta, String idCliente, String idVendedor, int Cantidad)
	{
		
	}
}

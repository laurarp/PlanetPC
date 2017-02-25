import java.util.ArrayList;
import java.util.Date;

public class AsesorVentas {
	private ListaCompras listaCompras;
	private ListaVentas listaVentas;
	private Inventario inventario;
	
	public AsesorVentas() throws Exception {
		super();
		this.listaCompras = new ListaCompras();
		this.listaVentas = new ListaVentas();
		this.inventario = new Inventario();
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
		ArrayList<Compra> pendientes=new ArrayList<Compra>();
		ArrayList<Compra> compras=listaCompras.getListaCompras();
		
		if(compras!=null)
		{
			for(int i=0;i<compras.size();i++)
			{
				String l=compras.get(i).getEstado();
				String d=compras.get(i).getIdProveedor();
				Boolean a="Pendiente".compareTo(compras.get(i).getEstado())!=0;
				Boolean b=idProveedor.compareTo(compras.get(i).getIdProveedor())!=0;
				if("Pendiente".compareTo(compras.get(i).getEstado())==0 && idProveedor.compareTo(compras.get(i).getIdProveedor())==0)
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			AsesorVentas av=new AsesorVentas();
			
			av.obtenerPedidosPendientesProveedor("1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
}

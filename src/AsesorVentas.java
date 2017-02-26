import java.util.ArrayList;
import java.util.Date;

public class AsesorVentas extends Actor {
	private ListaCompras listaCompras;
	private ListaVentas listaVentas;
	private Inventario inventario;
	
	public AsesorVentas(String id, String nombre, String contrasena) throws Exception {
		super(id, nombre, contrasena);
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
	
	public Producto buscarProducto(String idProducto,String tipo, String marca, String modelo) throws Exception
	{
		return inventario.buscarProducto(idProducto,tipo,marca,modelo);
	}
	
	public void notificarCompraRecibida(String idCompra,String estado) throws Exception
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


	}

	
}

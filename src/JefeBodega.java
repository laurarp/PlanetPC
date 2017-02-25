import java.util.Date;


public class JefeBodega {
	
	private ListaCompras listaCompras;
	
	public JefeBodega(ListaCompras listaCompras){
		this.listaCompras = listaCompras;
	}
	
	public void ingresarProducto(ListaDescProducto listaDescProducto,DescripcionProducto descripcionProducto)
	{
		
	}
	
	public void eliminarProducto(ListaDescProducto listaDescProducto,String id)
	{
		
	}
	
	public void modificarProducto(ListaDescProducto listaDescProducto,DescripcionProducto descripcionProducto)
	{
		
	}
	
	public Inventario reporteInventario()
	{
		return null;
	}
	
	public void registrarPedido(DescripcionProducto descripcionProducto, String idProveedor, int cantidad, int precioCompra, Date fechaPedido, Date fechaIngreso, String estado) throws Exception{
		listaCompras.añadirCompra(descripcionProducto, idProveedor, cantidad, precioCompra, fechaPedido, fechaIngreso, estado);
	}

}

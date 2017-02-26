import java.io.Serializable;
import java.util.Date;


public class JefeBodega extends Actor implements Serializable{
	
	private ListaCompras listaCompras;
	
	public JefeBodega(String id, String nombre, String contrasena) throws Exception
	{
		super(id, nombre, contrasena);
		this.listaCompras = new ListaCompras();
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

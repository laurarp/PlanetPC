import java.io.Serializable;
import java.util.Date;


public class JefeBodega extends Actor implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2532793658550877109L;
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
	
	public void registrarPedido(String descripcion, String idProveedor, int cantidad, int precioCompra, String estado) throws Exception{
		listaCompras.añadirPedido(descripcion, idProveedor, cantidad, precioCompra, estado);
	}

}

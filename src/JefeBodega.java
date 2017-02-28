import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;


public class JefeBodega extends Actor implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2532793658550877109L;
	private ListaCompras listaCompras;
	private ListaDescProducto catalogo;
	private Inventario inventario;


	public JefeBodega(String id, String nombre, String contrasena) throws Exception
	{
		super(id, nombre, contrasena);
		this.catalogo = new ListaDescProducto();
		this.inventario = new Inventario();
		this.listaCompras = new ListaCompras();
	}
	
	public void ingresarProducto(String id, int precioVenta, String tipo, int diasGarantia, String marca, String modelo)
	{
		catalogo.nuevoProducto(id, precioVenta, tipo, diasGarantia, marca, modelo);
	}
	
	public void eliminarProducto(String id) throws Excepciones
	{
		catalogo.eliminarProducto(id);
	}
	
	public void modificarProducto(String id, String nuevoId, String nuevoPrecio, String nuevoTipo, String nuevaGarantia, String nuevaMarca, String nuevoModelo) throws Excepciones
	{
		catalogo.modificarProducto(id, nuevoId, nuevoPrecio, nuevoTipo, nuevaGarantia, nuevaMarca, nuevoModelo);
	}
	
	public Inventario reporteInventario()
	{
		return null;
	}
	
	public void registrarPedido(String idProducto, String idProveedor, int cantidad, int precioCompra, String estado) throws Exception{
		listaCompras.añadirPedido(catalogo.buscarProducto(idProducto), idProveedor, cantidad, precioCompra, estado);
	}

	public ArrayList<Producto> mostrarInventario() throws Exception {
		return inventario.mostrarInventario();
		// TODO Auto-generated method stub
	}

}

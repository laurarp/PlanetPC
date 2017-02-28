import java.io.Serializable;
import java.util.ArrayList;

public class AuxiliarAlmacenamiento extends Actor implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9013827925897536008L;
	private ListaDescProducto catalogo;
	private Inventario inventario;
	
	public AuxiliarAlmacenamiento(String id, String nombre, String contrasena) throws Exception {
		super(id, nombre, contrasena);
		this.catalogo = new ListaDescProducto();
		this.inventario = new Inventario();
	}
	public void ingresarProductoCatalogo(String id, int precioVenta, String tipo, int diasGarantia, String marca, String modelo)
	{
		catalogo.nuevoProducto(id, precioVenta, tipo, diasGarantia, marca, modelo);
		
	}
	public void eliminarProductoCatalogo(String id) throws Excepciones
	{
			catalogo.eliminarProducto(id);
		}
	public ArrayList<DescripcionProducto> mostrarCatalogo() throws Exception {
		ArrayList<DescripcionProducto> lista;
			lista = catalogo.ReadFileCatalogo("Catalogo.txt");
			return lista;
	}
	
	public void modificarProductoCatalogo(String id, String nuevoId, String nuevoPrecio, String nuevoTipo, String nuevaGarantia, String nuevaMarca, String nuevoModelo) throws Excepciones
	{
		catalogo.modificarProducto(id, nuevoId, nuevoPrecio, nuevoTipo, nuevaGarantia, nuevaMarca, nuevoModelo);
		//
	}
	
	public void ubicarProducto(String id, int cantidad, String ubicacion) throws Exception
	{
		int indiceUbicar = catalogo.buscarCatalogo(id);
		if (indiceUbicar == -1)
		{
			throw new Exception("el producto no se encuentra en el catalogo");
		}
		else
		{
			try
			{
				Producto p = inventario.buscarProducto(id, "", "", "");
				inventario.getListaProductos().get(indiceUbicar).setCantidad(inventario.getListaProductos().get(indiceUbicar).getCantidad()+cantidad);
				inventario.WriteFileInventario("Inventario.txt", inventario.getListaProductos());
			}catch(Exception e)
			{
				Producto x = new Producto(catalogo.getProductos().get(indiceUbicar),cantidad, ubicacion);
				inventario.getListaProductos().add(x);
				inventario.WriteFileInventario("Inventario.txt", inventario.getListaProductos());		
			}
			
		}
	}
	public DescripcionProducto buscarEnCatalogo(String idProducto) throws Exception
	{
		return catalogo.buscarProducto(idProducto);
	}
	public ArrayList<Producto> mostrarInventario() throws Exception {
		return inventario.mostrarInventario();
		// TODO Auto-generated method stub
	}

}

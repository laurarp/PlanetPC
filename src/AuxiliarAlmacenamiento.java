import java.io.Serializable;


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
	public void eliminarProductoCatalogo(String id)
	{
		try {
			catalogo.eliminarProducto(id);
		} catch (Excepciones e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void modificarProductoCatalogo(ListaDescProducto listaDescProductos,DescripcionProducto descProducto)
	{
		
	}
	
	public void ubicarProducto(Producto producto)
	{
		
	}

}

import java.io.Serializable;


public class Administrador extends Actor  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6744013657278938999L;
	private ListaProveedores listaProveedores;
	private ListaActores listaActores;
	
	public Administrador(String id, String nombre, String contrasena) throws Exception {
		super(id, nombre, contrasena);
		this.listaProveedores = new ListaProveedores();
		this.listaActores = new ListaActores();
	}

	public void crearUsuario(String id,String nombre, String contrasena,String tipo) throws Exception
	{
		listaActores.nuevoActor(id,nombre, contrasena, tipo);
	}
	
	public Actor buscarUsuario(String id)
	{
		return null;
	}
	
	public void modificarUsuario(Actor actor)
	//Guillermo
	{
		
	}
	
	public void eliminarUsuario(String id)
	{
		
	}
	
	public void crearProveedor(ListaProveedores listaProveedores,String nombre, String id){
		listaProveedores.nuevoProveedor(nombre, id);
	}
	
	public void buscarProveedor(String id){
		listaProveedores.buscarProveedor(id);
	}
	
	public void modificarProveedor(Proveedor proveedor)
	{
		
	}
	
	public void eliminarProveedor(String id) throws Exception{
		listaProveedores.eliminarProveedor(id);
	}
	
	public ListaServicios reporteTecnico()
	{
		//Guillermo
		return null;
	}
	
	public ListaCompras reporteCompras()
	{
		return null;
	}
	
	public ListaVentas reporteVentas()
	{
		return null;
	}

}


public class Administrador {
	private ListaProveedores listaProveedores;
	private ListaActores listaActores;
	
	public Administrador() throws Exception {
		super();
		this.listaProveedores = new ListaProveedores();
		this.listaActores = new ListaActores();
	}
	
	public void crearUsuario(String id,String nombre, String contrasena,String tipo)
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

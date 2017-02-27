import java.io.Serializable;
import java.util.ArrayList;


public class Administrador extends Actor implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -5631227700597205391L;
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
	
	public void eliminarUsuario(String id) throws Exception{
		listaActores.eliminarActor(id);
	}
	
	public void crearProveedor(String nombre, String id){
		listaProveedores.nuevoProveedor(nombre, id);
	}
	
	public void buscarProveedor(String id){
		listaProveedores.buscarProveedor(id);
	}
	
	public void modificarProveedor(String id, String nombre)
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
	
	public static void main(String[] args) 
	{
		try 
		{		
			Administrador admin=new Administrador("1017217551","Laura Camila Rodriguez Peña", "123");
			
			admin.crearUsuario("1017217556","Laura Camila Rodriguez Peña", "123", "Asistente de compras y ventas");
			
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}

}

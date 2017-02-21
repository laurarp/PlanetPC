
public abstract class Actor {
	private String Nombre;
	private String id;
	private String contrasena;
	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public Actor(String nombre, String id, String contrasena) {
		super();
		Nombre = nombre;
		this.id = id;
		this.contrasena = contrasena;
	}
	public void borrar22()
	{
		
	}
	

}

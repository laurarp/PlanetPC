import java.util.Calendar;
import java.util.GregorianCalendar;


public abstract class Actor {
	private String nombre;
	private String id;
	private String contrasena;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		nombre = nombre;
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
	
	public Actor(String id,String nombre, String contrasena) {
		super();
		
		this.id=id;
		this.nombre = nombre;
		this.contrasena = contrasena;
	}

}

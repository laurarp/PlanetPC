
public class Proveedor {
	private String Nombre;
	private String id;
	
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
	
	public Proveedor(String nombre) {
		super();
		Nombre = nombre;
		
	}
	
	

}

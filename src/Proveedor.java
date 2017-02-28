import java.io.Serializable;


public class Proveedor implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8798707564030262353L;
	private String nombre;
	private String id;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public Proveedor(String nombre,String id) {
		super();
		this.id=id;
		this.nombre = nombre;
		
	}
	
	

}

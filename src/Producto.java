import java.io.Serializable;


public class Producto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9107635776970541338L;
	private DescripcionProducto descripcionProducto;
	private int cantidad;
	private String ubicacion;
	public Producto(DescripcionProducto descripcionProducto, int cantidad, String ubicacion) {
		super();
		this.descripcionProducto = descripcionProducto;
		this.cantidad = cantidad;
		this.ubicacion = ubicacion;
	}
	public DescripcionProducto getDescripcionProducto() {
		return descripcionProducto;
	}
	public void setDescripcionProducto(DescripcionProducto descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	
}

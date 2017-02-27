import java.io.Serializable;


public class Producto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9107635776970541338L;
	private DescripcionProducto descripcionProducto;
	private int cantidad;
	private String ubicacion;
	
	public Producto(DescripcionProducto descripcionProducto2, int cantidad2, String ubicacion2) {
		this.descripcionProducto = descripcionProducto2;
		this.cantidad = cantidad2;
		this.ubicacion = ubicacion2;	
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

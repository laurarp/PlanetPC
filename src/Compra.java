import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class Compra implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4562210406616396L;
	private String idCompra;
	private DescripcionProducto descripcionProducto;
	private String idProveedor;
	private int cantidad;
	private int precioCompra;
	private Date fechaPedido;
	private Date fechaIngreso;
	private String estado;
	private String descripcion;
	
	public void setDescripcion(String descripcion){
		this.descripcion = descripcion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public String getIdCompra() {
		return idCompra;
	}
	public void setIdCompra(String idCompra) {
		this.idCompra = idCompra;
	}
	public DescripcionProducto getDescripcionProducto() {
		return descripcionProducto;
	}
	public void setDescripcionProducto(DescripcionProducto descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}
	public String getIdProveedor() {
		return idProveedor;
	}
	public void setIdProveedor(String idProveedor) {
		this.idProveedor = idProveedor;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getPrecioCompra() {
		return precioCompra;
	}
	public void setPrecioCompra(int precioCompra) {
		this.precioCompra = precioCompra;
	}
	public Date getFechaPedido() {
		return fechaPedido;
	}
	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public Compra(DescripcionProducto descripcionProducto, String idProveedor, int cantidad, int precioCompra, Date fechaPedido, Date fechaIngreso, String estado){
		
		Calendar calendario = Calendar.getInstance();
		calendario = new GregorianCalendar();
		String hora, minutos, segundos;
		hora =Integer.toString(calendario.get(Calendar.HOUR_OF_DAY));
		minutos = Integer.toString(calendario.get(Calendar.MINUTE));
		segundos = Integer.toString(calendario.get(Calendar.SECOND));
		
		this.descripcionProducto = descripcionProducto;
		this.idCompra= hora+minutos+segundos;
		this.idProveedor = idProveedor;
		this.cantidad = cantidad;
		this.precioCompra = precioCompra;
		this.fechaPedido = fechaPedido;
		this.fechaIngreso = fechaIngreso;
		this.estado = estado;
	}

public Compra(String descripcion, String idProveedor, int cantidad, int precioCompra, String estado){
		
		Calendar calendario = Calendar.getInstance();
		calendario = new GregorianCalendar();
		String hora, minutos, segundos;
		hora =Integer.toString(calendario.get(Calendar.HOUR_OF_DAY));
		minutos = Integer.toString(calendario.get(Calendar.MINUTE));
		segundos = Integer.toString(calendario.get(Calendar.SECOND));
		
		this.descripcion = descripcion;
		this.idCompra= hora+minutos+segundos;
		this.idProveedor = idProveedor;
		this.cantidad = cantidad;
		this.precioCompra = precioCompra;
		this.fechaPedido = new Date(System.currentTimeMillis());
		this.fechaIngreso = fechaIngreso;
		this.estado = estado;
	}
	
}

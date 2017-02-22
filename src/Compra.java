import java.io.Serializable;
import java.util.Date;


public class Compra implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4562210406616396L;
	private int idCompra;
	private DescripcionProducto descripcionProducto;
	private String idProveedor;
	private int cantidad;
	private int precioCompra;
	private Date fechaPedido;
	private Date fechaIngreso;
	private String estado;
	
	public int getIdCompra() {
		return idCompra;
	}
	public void setIdCompra(int idCompra) {
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
		this.descripcionProducto = descripcionProducto;
		this.idCompra=1;
		this.idProveedor = idProveedor;
		this.cantidad = cantidad;
		this.precioCompra = precioCompra;
		this.fechaPedido = fechaPedido;
		this.fechaIngreso = fechaIngreso;
		this.estado = estado;
	}

}

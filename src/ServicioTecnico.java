import java.io.Serializable;
import java.util.Date;

public class ServicioTecnico implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4896187308543036429L;
	private String idProducto;
	private Date fechaEntrada;
	private Date fechaSalida;
	private String idCliente;
	private double precio;
	private String estado;

	public String getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

	public Date getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public ServicioTecnico(String idProducto, Date fechaEntrada, Date fechaSalida, String idCliente, double precio,
			String estado) {
		super();
		this.idProducto = idProducto;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.idCliente = idCliente;
		this.precio = precio;
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "ServicioTecnico [idProducto=" + idProducto + ", fechaEntrada=" + fechaEntrada + ", fechaSalida="
				+ fechaSalida + ", idCliente=" + idCliente + ", precio=" + precio + ", estado=" + estado + "]";
	}
	

}

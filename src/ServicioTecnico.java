import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ServicioTecnico implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4896187308543036429L;
	private String idServicio;
	private String descripcion;
	private Date fechaEntrada;
	private Date fechaSalida;
	private String idCliente;
	private double precio;
	private String estado;

	public String getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(String idServicio) {
		this.idServicio = idServicio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String idProducto) {
		this.descripcion = idProducto;
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
	public static String getFechaActual() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
        return formateador.format(ahora);
    }
	public static Date sumarFechasDias(Date fch, int dias) {
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fch.getTime());
        cal.add(Calendar.DATE, dias);
        return new Date(cal.getTimeInMillis());
    }


	public ServicioTecnico(String idServicio, String descripcion, String idCliente, double precio,
			String estado, int diasEstimados) {
		super();
		this.idServicio=idServicio;
		this.descripcion = descripcion;
		fechaSalida =sumarFechasDias(new Date(), diasEstimados);
		this.idCliente = idCliente;
		this.precio = precio;
		this.estado = estado;
		fechaEntrada=new Date(System.currentTimeMillis());
	}
	SimpleDateFormat s=new SimpleDateFormat("dd-MM-yyyy");

	@Override
	public String toString() {
		return "ServicioTecnico [idServicio=" + idServicio + ", descripcion=" + descripcion + ", fechaEntrada="
				+ fechaEntrada + ", fechaSalida=" + fechaSalida + ", idCliente=" + idCliente + ", precio=" + precio
				+ ", estado=" + estado + "]";
	}

	

	

}

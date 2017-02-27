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
	private String fechaEntrada;
	private String fechaSalida;
	private String idCliente;
	private Double precio;
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

	public String getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(String fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public String getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
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


	public ServicioTecnico(String descripcion, String idCliente, double precio, Integer diasEstimados) {
		super();
		SimpleDateFormat s=new SimpleDateFormat("dd-MM-yyyy");
		idServicio=ListaServicios.crearIdServicio();
		this.descripcion = descripcion;
		fechaSalida =s.format(sumarFechasDias(new Date(), diasEstimados));
		this.idCliente = idCliente;
		this.precio = precio;
		estado = "Pendiente";
		fechaEntrada=s.format(new Date(System.currentTimeMillis()));
	}
	

	

	

	

}

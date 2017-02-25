import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class Venta implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2469525108621734286L;
	private String idFecha;
	private DescripcionProducto descripcionProducto;
	private Date fechaVenta;
	private String idCliente;
	private String idVendedor;
	private int cantidad;
	
	public Venta(DescripcionProducto descripcionProducto, Date fechaVenta,
			String idCliente, String idVendedor, int cantidad) {
		super();
		
		Calendar calendario = Calendar.getInstance();
		calendario = new GregorianCalendar();
		String hora, minutos, segundos;
		hora =Integer.toString(calendario.get(Calendar.HOUR_OF_DAY));
		minutos = Integer.toString(calendario.get(Calendar.MINUTE));
		segundos = Integer.toString(calendario.get(Calendar.SECOND));
		
		this.idFecha=hora+minutos+segundos;
		this.descripcionProducto = descripcionProducto;
		this.fechaVenta = fechaVenta;
		this.idCliente = idCliente;
		this.idVendedor = idVendedor;
		this.cantidad = cantidad;
	}
	
	public static void main(String[] args) {
		//Prueba hora actual para crear id de Venta
		Calendar calendario = Calendar.getInstance();
		calendario = new GregorianCalendar();
		int hora, minutos, segundos;
		hora =calendario.get(Calendar.HOUR_OF_DAY);
		minutos = calendario.get(Calendar.MINUTE);
		segundos = calendario.get(Calendar.SECOND);
		System.out.println(hora + ":" + minutos + ":" + segundos);
	}
	
}

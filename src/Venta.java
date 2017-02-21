import java.io.Serializable;
import java.util.Date;


public class Venta implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2469525108621734286L;
	private DescripcionProducto descripcionProducto;
	private Date fechaVenta;
	private String idCliente;
	private String idVendedor;
	private int cantidad;

}

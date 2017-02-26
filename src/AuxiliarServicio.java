import java.io.Serializable;
import java.util.Date;


public class AuxiliarServicio extends Actor implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6073013571954600949L;
	private static ListaServicios lista;
	
	public AuxiliarServicio(String nombre, String id, String contrasena) {
		super(nombre, id, contrasena);
		ListaServicios list =new ListaServicios();
		lista=list;
		// TODO Auto-generated constructor stub
	}
	
	public void ingresarServicio(String descripcion, String idCiente, double precio, int diasEstimados)
	{
		lista.crearServicio(descripcion, idCiente, precio, diasEstimados);
	}
	
	public String[][] generarReporteServicios(String estado)
	{
		return lista.mostrarServiciosTabla(estado);
	}
	
	public void eliminarServicio(String idServicio) throws Excepciones{
		lista.eliminarServicio(idServicio);
	}
	
	
	public void modificarServicio(String id, String estado) throws Excepciones
	{
		lista.modificarEstado(id, estado);
	}
}

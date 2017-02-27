import java.io.Serializable;
import java.util.ArrayList;
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
	
	public void ingresarServicio(String descripcion, String idCiente, Double precio, Integer diasEstimados) throws Excepciones
	{
		lista.crearServicio(descripcion, idCiente, precio, diasEstimados);
	}
	
	public ArrayList<ServicioTecnico> generarReporteServicios(String estado)
	{
		return lista.mostrarServiciosEstado(estado);
		
	}
	public ArrayList<ServicioTecnico> mostrarServicios()
	{
		return lista.mostrarServicios();
		
	}
	
	public void eliminarServicio(String idServicio) throws Excepciones{
		lista.eliminarServicio(idServicio);
	}
	
	
	public void modificarServicio(String id, String estado) throws Excepciones
	{
		if(id.compareTo("")!=0){
		lista.modificarEstado(id, estado);
		}else{
			throw new Excepciones("No hay un Id de servicio que modificar, por favor rellene el campo con un Id válido");
		}
	}
}

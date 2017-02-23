import java.util.Date;


public class AuxiliarServicio extends Actor {
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
	
	public void generarReporteServicios()
	{
		lista.mostrarServicios();
	}
	
	public void eliminarServicio(String idServicio) throws Excepciones{
		lista.eliminarServicio(idServicio);
	}
	
	
	public void modificarServicio(String id, String estado) throws Excepciones
	{
		lista.modificarEstado(id, estado);
	}
}

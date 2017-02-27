import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ListaServicios {
	protected static ArrayList<ServicioTecnico> listaServicios;

	// gets y sets de la clase
	public ArrayList<ServicioTecnico> getListaServicios() {
		return listaServicios;
	}

	public void setListaServicios(ArrayList<ServicioTecnico> listaServicios) {
		ListaServicios.listaServicios = listaServicios;
	}

	// --------------------------------------------------------------------------------------------------------
	// Constructor de la clase
	public ListaServicios() {
		super();
		File lista = new File("ListaServicios.txt");
		if (lista.exists() == false) {
			crearArchivo("ListaServicios.txt", listaServicios);
			listaServicios = new ArrayList<ServicioTecnico>();
		} else {
			listaServicios = leerArchivoObjeto("ListaServicios.txt");
			if (listaServicios == null) {
				listaServicios = new ArrayList<ServicioTecnico>();
			}
		}
	}
//----------------------------------------------------------------------------------------------------------------
	//metodo para crear numeros diferentes
	public static String crearIdServicio() {
		Calendar calendario = Calendar.getInstance();
		calendario = new GregorianCalendar();
		String hora, minutos, segundos;
		hora =Integer.toString(calendario.get(Calendar.HOUR_OF_DAY));
		minutos = Integer.toString(calendario.get(Calendar.MINUTE));
		segundos = Integer.toString(calendario.get(Calendar.SECOND));
		String i = hora+minutos+segundos;
		return i;
	}
//----------------------------------------------------------------------------------------------------------------
	//metodo para crear nuevos servicios y agregarlos a la lista
	public void crearServicio(String descripcion, String idCiente, Double precio, Integer diasEstimados)throws Excepciones {
		if(descripcion.compareTo("")!=0 && idCiente.compareTo("")!=0 && precio!=null && diasEstimados!=null){
		ServicioTecnico a = new ServicioTecnico(descripcion, idCiente, precio, diasEstimados);
		listaServicios.add(a);
		escribirArchivoObjeto("ListaServicios.txt", listaServicios);
		}else{
			throw new Excepciones("Todos los campos deben llenarse");
		}
	}
//----------------------------------------------------------------------------------------------------------------
	//metodo para mostrar servicios de la lista (en consola)
	public ArrayList<ServicioTecnico> mostrarServicios() {
		ArrayList<ServicioTecnico> lista = leerArchivoObjeto("ListaServicios.txt");
		return lista;
	}
//-----------------------------------------------------------------------------------------------------------------
	
	public ArrayList<ServicioTecnico> mostrarServiciosEstado(String estado) {
		ArrayList<ServicioTecnico> lista = leerArchivoObjeto("ListaServicios.txt");
		
		ArrayList<ServicioTecnico> auxiliar = new ArrayList<ServicioTecnico>();
		
		for (int i = 0; i < lista.size(); i++) {
			if(estado.compareTo(lista.get(i).getEstado())==0)
			{
				auxiliar.add(lista.get(i));
			}
		}
		return auxiliar;
	}

	
//-------------------------------------------------------------------------------------------------------------------
	//metodo auxiliar de busqueda por indice que es usado por los metodos eliminar y modificar
	public static int buscarServicio(String idServicio) {
		listaServicios = leerArchivoObjeto("ListaServicios.txt");
		int indice = 0;
		while (indice < listaServicios.size()) {
			if (idServicio.compareTo(listaServicios.get(indice).getIdServicio()) == 0) {
				return indice;
			} else {
				indice++;
			}
		}
		return -1;
	}
//-------------------------------------------------------------------------------------------------------------------
	//metodo eliminar servicio de la lista y del fichero ListaServicios.txt
	public void eliminarServicio(String idServicio) throws Excepciones {

		ArrayList<ServicioTecnico> auxiliar = new ArrayList<ServicioTecnico>();
		int posicionEliminar = buscarServicio(idServicio);
		if (buscarServicio(idServicio) == -1) {
			throw new Excepciones("el usuario no se encuentra en la lista");
		} else {
			for (int i = 0; i < listaServicios.size(); i++) {
				if (posicionEliminar != i) {
					auxiliar.add(listaServicios.get(i));
				}
			}
			listaServicios = auxiliar;
			File fichero = new File("ListaServicios.txt");
			fichero.delete();
			escribirArchivoObjeto("ListaServicios.txt", listaServicios);
		}

	}
//--------------------------------------------------------------------------------------------------------------------
	//metodo para escribir objetos en el fichero
	public static void escribirArchivoObjeto(String archivo, ArrayList<ServicioTecnico> listaServicios) {
		FileOutputStream fo = null;
		ObjectOutputStream oI = null;
		try {
			fo = new FileOutputStream(archivo);
			oI = new ObjectOutputStream(fo);
			for (ServicioTecnico o : listaServicios) {
				try {
					oI.writeObject(o);
				} catch (IOException e) {
					System.out.println("problema al crear las clases");
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("problemas con la direcion para crear el fichero");
		} catch (IOException e) {
			System.out.println("el fichero tiene problemas al crearse");
		} finally {
			try {
				if (fo != null) {
					fo.close();
				}
				if (oI != null) {
					oI.close();
				}

			} catch (IOException e) {
				System.out.println("no se pudo cerrar el archivo");
			}
		}
	}
//------------------------------------------------------------------------------------------------------------------------------
	//metodo para crear archivos vacios en caso tal de que la lista no exista (este metodo es escencial al arrancar el programa)
	public static void crearArchivo(String archivo, ArrayList<ServicioTecnico> listaServicios) {
		FileOutputStream fo = null;
		ObjectOutputStream oI = null;
		try {
			fo = new FileOutputStream(archivo);
			oI = new ObjectOutputStream(fo);

		} catch (FileNotFoundException e) {
			System.out.println("problemas con la direcion para crear el fichero");
		} catch (IOException e) {
			System.out.println("el fichero tiene problemas al crearse");
		} finally {
			try {
				if (fo == null) {
					fo.close();
				}
				if (oI == null) {
					oI.close();
				}

			} catch (IOException e) {
				System.out.println("no se pudo cerrar el archivo");
			}
		}
	}
//--------------------------------------------------------------------------------------------------------------------------
	//metodo para leer el fichero y pasarlos a la lista
	public static ArrayList<ServicioTecnico> leerArchivoObjeto(String archivo) {
		ObjectInputStream oI = null;
		FileInputStream fI = null;
		ArrayList<ServicioTecnico> listaServicios = new ArrayList<ServicioTecnico>();
		try {
			fI = new FileInputStream(archivo);
			oI = new ObjectInputStream(fI);
			while (fI.available() > 0) {
				ServicioTecnico p = (ServicioTecnico) oI.readObject();
				listaServicios.add(p);
			}
		} catch (FileNotFoundException e) {
			System.out.println("problemas con la direcion para leer el fichero");
		} catch (IOException e) {
			System.out.println("el fichero tiene problemas al leerlo");
		} catch (ClassNotFoundException e) {
			System.out.println("problema al leer fichero");
		} finally {
			try {
				oI.close();
			} catch (IOException e) {
				System.out.println("el fichero tiene problemas al leerlo");
			}
		}
		if (listaServicios.size() == 0) {
			return null;
		} else {
			return listaServicios;
		}
	}
//-----------------------------------------------------------------------------------------------------------------------------
	//metodo que genera la fecha actual y le da formato de fecha dd-MM-yyyy
	public static String getFechaActual() {
		Date ahora = new Date();
		SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
		return formateador.format(ahora);
	}
//-----------------------------------------------------------------------------------------------------------------------------
	//metodo para buscar servicios como objetos
	public static ServicioTecnico buscarServicioOb(String idServicio) throws Excepciones {
		if (listaServicios == null) {
			throw new Excepciones("la lista de servicios esta vacia");
		}
		int i = 0;
		while (i < listaServicios.size() && listaServicios.get(i).getIdServicio().compareTo(idServicio) != 0) {
			i++;
		}
		if (i < listaServicios.size()) {
			return listaServicios.get(i);
		} else {
			throw new Excepciones("El servicio no esta en la lista");
		}
	}
//-----------------------------------------------------------------------------------------------------------------------------
	//metodo para modificar el estado de los servicios
	public void modificarEstado(String idServicio, String estado) throws Excepciones {
		int indice = buscarServicio(idServicio);
		if (buscarServicio(idServicio) == -1) {
			throw new Excepciones("El servicio no esta cargado en la lista");
		} else {
			listaServicios.get(indice).setEstado(estado);
			File s = new File("ListaServicios.txt");
			s.delete();
			escribirArchivoObjeto("ListaServicios.txt", listaServicios);
		}
	}
//-----------------------------------------------------------------------------------------------------------------------------
	//metodo main para pruebas internas de la clase
	public static void main(String[] args) {
		ListaServicios lista = new ListaServicios();
		lista.mostrarServicios();
		try {
			lista.modificarEstado("148797846", "Activo");
		} catch (Excepciones e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * try { lista.eliminarServicio("3.53041002399089E8"); } catch
		 * (Excepciones e) { // TODO Auto-generated catch block
		 * System.out.println(e.getMessage()); } lista.mostrarServicios();
		 */
	}

	/*
	 * public static void main(String[] args) { ListaServicios lista = new
	 * ListaServicios(); lista.crearServicio("12345","portatil dell",
	 * "1017196884", 35000, 10); lista.crearServicio("12346","PC clon",
	 * "1017196885", 35000,5); lista.crearServicio("12347","portatil panasonic",
	 * "1017196883", 35000,4); try { lista.eliminarServicio("12346");
	 * lista.eliminarServicio("12347");
	 * System.out.println(buscarServicioOb("12345"));
	 * lista.crearServicio("12348","pantalla lg", "1017196883", 35000,3);
	 * lista.mostrarServicios(); lista.modificarEstado("12348", "activo");
	 * 
	 * System.out.println(buscarServicioOb("12348"));
	 * 
	 * } catch (Excepciones e) { System.out.println(e.getMessage()); }
	 * 
	 * 
	 * }
	 */

}

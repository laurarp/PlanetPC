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
import java.util.Date;

public class ListaServicios {
	protected static ArrayList <ServicioTecnico> listaServicios;

	public ArrayList<ServicioTecnico> getListaServicios() {
		return listaServicios;
	}

	public void setListaServicios(ArrayList<ServicioTecnico> listaServicios) {
		ListaServicios.listaServicios = listaServicios;
	}

	public ListaServicios() {
		super();
		File lista=new File("ListaServicios.txt");
		if(lista.exists()==false){
			crearArchivo("ListaServicios.txt", listaServicios);
			this.listaServicios=new ArrayList <ServicioTecnico>();
		}else{
			this.listaServicios=leerArchivoObjeto("ListaServicios.txt");
		}
		
		
	}
	public static String crearIdServicio(){
		String i=String.valueOf((int)(Math.random()*500000000));
		return i;
	}

	public void crearServicio(String descripcion, String idCiente, double precio, int diasEstimados) {
		ServicioTecnico a = new ServicioTecnico(descripcion, idCiente, precio, diasEstimados);
		listaServicios.add(a);
		escribirArchivoObjeto("ListaServicios.txt", listaServicios);
	}

	public void mostrarServicios() {
		ArrayList<ServicioTecnico> lista = leerArchivoObjeto("ListaServicios.txt");
		if (lista != null) {
			for (ServicioTecnico p : lista) {
				System.out.println(p);
			}
		}
	}

	public static int buscarServicio(String idServicio) {
		int indice = 0;
		while (indice < listaServicios.size()) {
			if (idServicio == (listaServicios.get(indice).getIdServicio())) {
				return indice;
			} else {
				indice++;
			}
		}
		return -1;
	}

	public void eliminarServicio(String idServicio) throws Excepciones {

		ArrayList<ServicioTecnico> auxiliar = new ArrayList <ServicioTecnico>();
		int posicionEliminar = buscarServicio(idServicio);
		if (buscarServicio(idServicio) == -1) {
			throw new Excepciones("el usuario no se encuentra en la lista");
		} else {
			for (int i = 0; i < listaServicios.size(); i++) {
				if (posicionEliminar != i) {
					auxiliar.add(listaServicios.get(i));
				}
			}
			listaServicios=auxiliar;
			File fichero= new File("ListaServicios.txt");
			fichero.delete();
			escribirArchivoObjeto("ListaServicios.txt", listaServicios);
		}

	}

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
	
	public static ArrayList<ServicioTecnico> leerArchivoObjeto(String archivo) {
		ObjectInputStream oI = null;
		FileInputStream fI = null;
		ArrayList<ServicioTecnico> listaServicios = new ArrayList <ServicioTecnico>();
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
	
	
	public static String getFechaActual() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
        return formateador.format(ahora);
    }
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
		} else{
			throw new Excepciones("El servicio no esta en la lista");
		}
	}
	public void modificarEstado(String idServicio,String estado) throws Excepciones{
		int indice=buscarServicio(idServicio);
		if(buscarServicio(idServicio)==-1){
			throw new Excepciones("El servicio no esta cargado en la lista");
		}else{
			listaServicios.get(indice).setEstado(estado);
			File s=new File("ListaServicios.txt");
			s.delete();
			escribirArchivoObjeto("ListaServicios.txt", listaServicios);
		}
	}
	public static void main(String[] args){
		ListaServicios lista = new ListaServicios();
		lista.mostrarServicios();
	}

	/*public static void main(String[] args) {
		ListaServicios lista = new ListaServicios();
		lista.crearServicio("12345","portatil dell", "1017196884", 35000, 10);
		lista.crearServicio("12346","PC clon", "1017196885", 35000,5);
		lista.crearServicio("12347","portatil panasonic", "1017196883", 35000,4);
		try {
			lista.eliminarServicio("12346");
			lista.eliminarServicio("12347");
			System.out.println(buscarServicioOb("12345"));
			lista.crearServicio("12348","pantalla lg", "1017196883", 35000,3);
			lista.mostrarServicios();
			lista.modificarEstado("12348", "activo");
			
			System.out.println(buscarServicioOb("12348"));
			
		} catch (Excepciones e) {
			System.out.println(e.getMessage());
		}
		
		
	}
*/
	
}

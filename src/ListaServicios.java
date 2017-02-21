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
		this.listaServicios=listaServicios;
		crearArchivo("ListServicios.txt", listaServicios);
		
		
	}

	public void crearServicio(String id, String descripcion, String idCiente, String estado, double precio, int diasEstimados) {
		ServicioTecnico a = new ServicioTecnico(id, descripcion, idCiente, precio, estado, diasEstimados);
		listaServicios.add(a);
		escribirArchivoObjeto("ListaServicios.txt", listaServicios);
	}

	/*public void mostrarServicios() {
		for (int i = 0; i < listaServicios.length; i++) {
			System.out.println(listaServicios[i]);
		}
	}*/

	public int buscarServicio(String idCliente) {
		int indice = 0;
		while (indice < listaServicios.size()) {
			if (idCliente == (listaServicios.get(indice).getIdCliente())) {
				return indice;
			} else {
				indice++;
			}
		}
		return -1;
	}

	public void eliminarServicio(String idCliente) throws Excepciones {

		ArrayList<ServicioTecnico> auxiliar = new ArrayList <ServicioTecnico>();
		int posicionEliminar = buscarServicio(idCliente);
		if (buscarServicio(idCliente) == -1) {
			throw new Excepciones("el usuario no se encuentra en la lista");
		} else {
			int j = 0;
			for (int i = 0; i < listaServicios.size(); i++) {
				if (posicionEliminar != i) {
					auxiliar.add(listaServicios.get(i));
					j++;
				}
			}
			File fichero= new File("fichero.txt");
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

	public static void main(String[] args) {
		ArrayList<ServicioTecnico> listaServicios = new ArrayList <ServicioTecnico>();
		ListaServicios lista = new ListaServicios();
		lista.crearServicio("12345","portatil dell", "1017196884", "activo", 35000, 10);
		lista.crearServicio("12345","PC clon", "1017196885", "activo", 35000,5);
		lista.crearServicio("12345","portatil panasonic", "1017196883", "activo", 35000,4);
		ArrayList<ServicioTecnico> listaLeer = leerArchivoObjeto("fichero.txt");
		System.out.println(getFechaActual());
		if (listaLeer != null) {
			for (ServicioTecnico p : listaLeer) {
				System.out.println(p);
			}
		}
		try {
			lista.eliminarServicio("1017196883");
			lista.eliminarServicio("1017196884");
		} catch (Excepciones e) {
			System.out.println(e.getMessage());
		}
		ArrayList<ServicioTecnico> listaLeer1 = leerArchivoObjeto("C:\\Users\\Guillermo Uribe G\\Desktop\\fichero.txt");
		if (listaLeer1 != null) {
			for (ServicioTecnico p : listaLeer1) {
				System.out.println(p);
			}
		}
		lista.crearServicio("12345","pantalla lg", "1017196883", "activo", 35000,3);
		ArrayList<ServicioTecnico> listaLeer11 = leerArchivoObjeto("C:\\Users\\Guillermo Uribe G\\Desktop\\fichero.txt");
		if (listaLeer11 != null) {
			for (ServicioTecnico p : listaLeer11) {
				System.out.println(p);
			}

		}
	}

}

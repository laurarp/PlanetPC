import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;

public class ListaProveedores implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8874840702437700348L;
	private ArrayList<Proveedor> listaProveedores;

	public ListaProveedores() {
		super();
		if (ReadFileProveedores("ListaProveedores.txt") != null) {
			this.listaProveedores = ReadFileProveedores("ListaProveedores.txt");
		} else {
			this.listaProveedores = null;
		}
	}

	public void nuevoProveedor(String nombre, String id) {
		Proveedor tempProveedor = new Proveedor(nombre, id);
		listaProveedores.add(tempProveedor);
		writeFileObject("listaProveedores.txt", listaProveedores);
		System.out.println("El proveedor" + listaProveedores.get(0).getNombre() + ", con Id: "
				+ listaProveedores.get(0).getId() + " ha sido creado.");
	}

	public static void writeFileObject(String file, ArrayList<Proveedor> listaProveedores) {
		FileOutputStream fo = null;
		ObjectOutputStream oI = null;
		try {
			fo = new FileOutputStream(file);
			oI = new ObjectOutputStream(fo);
			for (Proveedor o : listaProveedores) {
				try {
					oI.writeObject(o);
				} catch (IOException e) {
					System.out.println("problema al crear las clases");
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Problemas con la direccion para crear e fichero");
		} catch (IOException e) {
			System.out.println("El fichero tiene problema al crearse");
		} finally {
			try {
				if (fo != null) {
					fo.close();
					oI.close();
				}
			} catch (IOException e) {

			}
		}
	}

	// cuando se busca por parametro unico es mas eficiente un while....isis nos
	// mata si buscamos con un for
	public int buscarProveedor(String id) {
		/*
		 * for (Proveedor a : listaProveedores) if (id.equals(a.getId())){
		 * return a.getNombre(); }else{ throw new
		 * Exception("El proveedor no existe"); } return id;
		 */
		listaProveedores = ReadFileProveedores("ListaProveedores.txt");
		int indice = 0;
		while (indice < listaProveedores.size()) {
			if (id.compareTo(listaProveedores.get(indice).getId()) == 0) {
				return indice;
			} else {
				indice++;
			}
		}
		//pequeña modificacion para que no lance error cada vez que pruebo el programa
		return -1;
	}

	public void modificarProveedor(Proveedor proveedor, String id, String nombre) {
		proveedor.setId(id);
		proveedor.setNombre(nombre);
	}

	public void eliminarProveedor(String id) throws Exception {
		ArrayList<Proveedor> auxiliar = new ArrayList<Proveedor>();
		int posicionEliminar = buscarProveedor(id);
		if (buscarProveedor(id) == -1) {
			throw new Exception("el proveedor no se encuentra en la lista");
		} else {
			for (int i = 0; i < listaProveedores.size(); i++) {
				if (posicionEliminar != i) {
					auxiliar.add(listaProveedores.get(i));
				}
			}
			listaProveedores = auxiliar;
			File fichero = new File("ListaProveedores.txt");
			fichero.delete();
			writeFileObject("ListaProveedores.txt", listaProveedores);
		}
	}

	public ArrayList<Proveedor> mostrarProveedores() {
		listaProveedores = ReadFileProveedores("ListaProveedores.txt");
		return listaProveedores;
	}

	public String buscarIdProveedor(String nombreProveedor) throws Exception {
		String idProveedor = "";

		if (listaProveedores != null) {
			int i = 0;
			String l = listaProveedores.get(i).getNombre();
			while (i < listaProveedores.size() && nombreProveedor.compareTo(listaProveedores.get(i).getNombre()) != 0) {
				i++;
			}
			if (i < listaProveedores.size()) {
				idProveedor = listaProveedores.get(i).getId();
			} else {
				throw new Exception("El proveedor no se encontró");
			}
		} else {
			throw new Exception("No existen proveedores");
		}
		return idProveedor;
	}

	public static ArrayList<Proveedor> ReadFileProveedores(String file) {
		FileInputStream fi = null;
		ObjectInputStream oi = null;
		ArrayList<Proveedor> listaProveedores = new ArrayList<Proveedor>();

		try {
			fi = new FileInputStream(file);
			oi = new ObjectInputStream(fi);
			int i = 0;

			while (fi.available() > 0) {
				Proveedor proveedor = (Proveedor) oi.readObject();
				listaProveedores.add(proveedor);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Problemas con la direccion para abrir el fichero");
		} catch (IOException e) {
			System.out.println("El fichero tiene problema al leer los objetos");
		} catch (ClassNotFoundException e) {
			System.out.println("Problema al leer el fichero");
		} finally {
			try {
				if (fi != null) {
					fi.close();
					oi.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("No se pudo cerrar el fichero");
			}
		}
		if (listaProveedores.size() == 0) {
			return null;
		} else {
			return listaProveedores;
		}
	}

	public static void WriteFileProveedores(String file, Proveedor[] listProveedores) {
		FileOutputStream fo = null;
		ObjectOutputStream ol = null;

		try {
			fo = new FileOutputStream(file);
			ol = new ObjectOutputStream(fo);

			for (Proveedor o : listProveedores) {
				try {
					ol.writeObject(o);
				} catch (IOException e) {
					System.out.println("Problema al crear las clases");
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Problemas con la direccion para crear el fichero");
		} catch (IOException e) {
			System.out.println("El fichero tiene problema al crearse");
		} finally {
			try {
				if (fo != null) {
					fo.close();
					ol.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("No se pudo cerrar el fichero");
			}
		}
	}

}

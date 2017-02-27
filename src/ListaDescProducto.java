import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class ListaDescProducto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5371723452641887410L;
	private static ArrayList<DescripcionProducto> productos = new ArrayList<DescripcionProducto>();;
	public ListaDescProducto() throws Exception {
		super();
		if(ReadFileCatalogo("Catalogo.txt")!=null)
		{
			this.productos = ReadFileCatalogo("Catalogo.txt");
		}
		else
		{
			
			this.productos =new ArrayList<DescripcionProducto>();
		}

	}

	public void escribirArchivoObjeto(String archivo, ArrayList<DescripcionProducto> listaDescProducto) {
		FileOutputStream fo = null;
		ObjectOutputStream oI = null;
		try {
			fo = new FileOutputStream(archivo);
			oI = new ObjectOutputStream(fo);
			for (DescripcionProducto o : listaDescProducto) {
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

	@SuppressWarnings("null")
	public static void crearArchivo(String archivo, ArrayList<DescripcionProducto> listaDescProducto) {
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

	public static ArrayList<DescripcionProducto> ReadFileCatalogo(String file) throws Exception
	{
		FileInputStream fi=null;
		ObjectInputStream oi=null;
		ArrayList<DescripcionProducto> catalogo= new ArrayList<DescripcionProducto>();
		
		try{
			fi=new FileInputStream(file);
			oi=new ObjectInputStream(fi);
			
			while(fi.available()>0)
			{
				DescripcionProducto descProducto=(DescripcionProducto) oi.readObject();
				catalogo.add(descProducto);
			}
		}
		catch(FileNotFoundException e)
		{
			throw new Exception("Problemas con la direccion para abrir el fichero");
		}
		catch(IOException e)
		{
			throw new Exception("El fichero tiene problema al leer los objetos");
		}
		catch(ClassNotFoundException e)
		{
			throw new Exception("Problema al leer el fichero");
		}
		finally
		{
			try
			{
				if(fi!=null)
				{
					fi.close();
					oi.close();
				}
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				throw new Exception("No se pudo cerrar el fichero");
			}
		}
		if(catalogo.size()==0)
		{
			return null;
		}
		else
		{
			return catalogo;
		}
	}

	public void mostrarServicios() {
		ArrayList<DescripcionProducto> lista;
		try {
			lista = ReadFileCatalogo("Catalogo.txt");
			
			if (lista != null) {
				for (DescripcionProducto p : lista) {
					System.out.println(p);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static int buscarCatalogo(String id) {
		int indice = 0;
		while (indice < productos.size()) {
			if (id.compareTo(productos.get(indice).getId())==0) {
				return indice;
			} else {
				indice++;
			}
		}
		return -1;
	}

	

	public static ArrayList<DescripcionProducto> getListaDescProducto() {
		return productos;
	}

	public static void setListaDescProducto(ArrayList<DescripcionProducto> listaDescProducto) {
		ListaDescProducto.productos = listaDescProducto;
	}
	public void nuevoProducto(String id, int precioVenta, String tipo, int diasGarantia, String marca, String modelo) {
		DescripcionProducto s= new DescripcionProducto(id, precioVenta, tipo, diasGarantia, marca, modelo);
		productos.add(s);
		escribirArchivoObjeto("Catalogo.txt", productos);
	}
	
	public void modificarProducto(DescripcionProducto descripcionProducto)
	{
		
	}
	
	public void eliminarProducto(String id) throws Excepciones {

		ArrayList<DescripcionProducto> auxiliar = new ArrayList<DescripcionProducto>();
		int posicionEliminar = buscarCatalogo(id);
		if (buscarCatalogo(id) == -1) {
			throw new Excepciones("el usuario no se encuentra en la lista");
		} else {
			for (int i = 0; i < productos.size(); i++) {
				if (posicionEliminar != i) {
					auxiliar.add(productos.get(i));
				}
			}
			productos = auxiliar;
			File fichero = new File("Catalogo.txt");
			fichero.delete();
			escribirArchivoObjeto("Catalogo.txt", productos);
		}

	}
	
	public ArrayList<DescripcionProducto> mostrarProductos()
	{
		return productos;
	}
	public static void main(String[] args){
	}

}

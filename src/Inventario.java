import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;


public class Inventario implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6701912040108424384L;
	private ArrayList<Producto> listaProductos;
	private String ruta;
	
	public Inventario() throws Exception {
		super();
		ruta="Inventario.txt";
		
		if(ReadFileInventario(ruta)!=null)
		{
			this.listaProductos = ReadFileInventario(ruta);
		}
		else
		{
			this.listaProductos =new ArrayList<Producto>();
		}
	}

	public void nuevoProducto(Producto producto)
	{
		
	}
	
	public ArrayList<Producto> getListaProductos()
	{
		return null;
	}
	
	public Producto buscarProducto(String idProducto,String tipo, String marca, String modelo) throws Exception
	{
		if(listaProductos.size()!=0)
		{
			int i=0;
				
			if(idProducto.compareTo("")!=0)
			{
				while(i<listaProductos.size() && (listaProductos.get(i).getDescripcionProducto().getId().compareTo(idProducto) != 0))
				{
					i++;
				}
			}
			else
			{
				while(i<listaProductos.size() && (listaProductos.get(i).getDescripcionProducto().getTipo().compareTo(tipo)!=0 || listaProductos.get(i).getDescripcionProducto().getMarca().compareTo(marca)!=0 || listaProductos.get(i).getDescripcionProducto().getModelo().compareTo(modelo)!=0))
				{
					i++;
				}
			}
			

			if(i<listaProductos.size())
			{
				return listaProductos.get(i);
			}
			else
			{
				throw new Exception("El producto no se encuentra en el inventario");
			}
		}
		else
		{
			throw new Exception("No existen productos en el inventario");
		}
	}
	
	public void añadirCantidad(DescripcionProducto descripcionProducto,int Cantidad)
	{
		
	}
	
	public void restarCantidad(DescripcionProducto descripcionProducto,int Cantidad)
	{
		
	}

	public static ArrayList<Producto> ReadFileInventario(String file) throws Exception
	{
		FileInputStream fi=null;
		ObjectInputStream oi=null;
		ArrayList<Producto> inventario= new ArrayList<Producto>();
		
		try{
			fi=new FileInputStream(file);
			oi=new ObjectInputStream(fi);
			
			while(fi.available()>0)
			{
				Producto producto=(Producto) oi.readObject();
				inventario.add(producto);
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
		if(inventario.size()==0)
		{
			return null;
		}
		else
		{
			return inventario;
		}
	}
	
	public static void WriteFileInventario(String file, ArrayList<Producto> productosNuevos) throws Exception
	{
		FileOutputStream fo=null;
		ObjectOutputStream ol=null;
		
		try{
			fo=new FileOutputStream(file);
			ol=new ObjectOutputStream(fo);
			
			for(Producto o:productosNuevos)
			{
				try
				{
					ol.writeObject(o);
				}
				catch(IOException e)
				{
					throw new Exception("Problema en la escritura del archivo");
				}
			}
		}
		catch(FileNotFoundException e)
		{
			throw new Exception("Problemas con la direccion para crear el fichero");
		}
		catch(IOException e)
		{
			throw new Exception("El fichero tiene problema al crearse");
		}
		finally
		{
			try
			{
				if(fo!=null)
				{
					fo.close();
					ol.close();
				}
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				throw new Exception("No se pudo cerrar el fichero");
			}
		}
	}
	
	public static void main(String[] args) 
	{
		/*ArrayList<Producto> productos=new ArrayList<Producto>();
		try {
			WriteFileInventario("Inventario.txt",productos);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}
}

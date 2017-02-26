import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;


public class ListaCompras {
	private ArrayList<Compra> compras;
	private String ruta;

	public ListaCompras() throws Exception 
	{
		super();
		ruta="ListaCompras.txt";
		
		if(ReadFileCompras(ruta)!=null)
		{
			this.compras = ReadFileCompras(ruta);
		}
		else
		{
			this.compras =new ArrayList<Compra>();
		}
	}

	public void añadirCompra (DescripcionProducto  descripcionProducto, String idProveedor, int cantidad, int precioCompra, Date fechaPedido, Date fechaIngreso, String estado) throws Exception{
		
		Compra tempCompra = new Compra(descripcionProducto, idProveedor, cantidad, precioCompra, fechaPedido, fechaIngreso, estado);
		compras.add(tempCompra);
		WriteFileCompras(ruta, compras);
	}

	
	public ArrayList<Compra> getListaCompras() throws Exception
	{
		return compras; 
	}

	public void notificarCompraRecibida(String idCompra) throws Exception
	{
		int i=0;
		
		if(compras!=null)
		{
			while(i<compras.size() && String.valueOf(compras.get(i).getIdCompra())!=idCompra)
			{
				i++;
			}
			if(i<compras.size())
			{
				compras.get(i).setEstado("Recibida");//Cambia el estado de la compra a recibida		
			}
			else
			{
				throw new Exception ("La compra no existe");
			}
		}
		else
		{
			throw new Exception("No hay compras disponibles");
		}
		
		//Escribe en el fichero las compras con la modificación
		WriteFileCompras(ruta, compras);
	}
	
	public static ArrayList<Compra> ReadFileCompras(String file) throws Exception
	{
		FileInputStream fi=null;
		ObjectInputStream oi=null;
		ArrayList<Compra> listaCompras= new ArrayList<Compra>();
		
		try{
			fi=new FileInputStream(file);
			oi=new ObjectInputStream(fi);
			
			while(fi.available()>0)
			{
				Compra compra=(Compra) oi.readObject();
				listaCompras.add(compra);
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
		if(listaCompras.size()==0)
		{
			return null;
		}
		else
		{
			return listaCompras;
		}
	}
	
	public static void WriteFileCompras(String file, ArrayList<Compra> comprasNuevas) throws Exception
	{
		FileOutputStream fo=null;
		ObjectOutputStream ol=null;
		
		try{
			fo=new FileOutputStream(file);
			ol=new ObjectOutputStream(fo);
			
			for(Compra o:comprasNuevas)
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
		ArrayList<Compra> compras=new ArrayList<Compra>();
		try {
			WriteFileCompras("ListaCompras.txt", compras);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		ListaCompras lc = null;
		try {
			lc = new ListaCompras();
			DescripcionProducto dc=new DescripcionProducto("1", 25488, "PC", 0, "Apple", "2010");
			
			lc.añadirCompra(dc, "1", 2, 25412, new Date(5855), new Date(454), "Pendiente");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}

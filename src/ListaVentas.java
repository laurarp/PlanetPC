import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;


public class ListaVentas {
	private ArrayList<Venta> ventas;
	private String ruta;
	
	public ListaVentas() throws Exception {
		super();
		ruta="ListaVentas.txt";
		
		if(ReadFileVentas(ruta)!=null)
		{
			this.ventas = ReadFileVentas(ruta);
		}
		else
		{
			this.ventas =new ArrayList<Venta>();
		}
	}

	public void añadirVenta (DescripcionProducto descripcionProducto, Date fechaVenta, String idCliente, String idVendedor, int Cantidad) throws Exception
	{
		if(ReadFileVentas(ruta)!=null)
		{
			this.ventas =ReadFileVentas(ruta);
		}
		else
		{
			this.ventas =null;
		}
		Venta ventaNueva=new Venta();
		this.ventas.add(ventaNueva);
		
		//Convierte el arrayList en array para escribirlo en fichero
		Venta[] arrayVentas = new Venta[ventas.size()];
		arrayVentas = ventas.toArray(arrayVentas);
		WriteFileVentas(ruta, arrayVentas);
	}
	
	public ArrayList<Venta> getListaVentas() throws Exception
	{
		if(ReadFileVentas(ruta)!=null)
		{
			ventas = ReadFileVentas(ruta);
		}
		else
		{
			ventas =null;
		}
		return ventas; 
	}
	
	public static ArrayList<Venta> ReadFileVentas(String file) throws Exception 
	{
		FileInputStream fi=null;
		ObjectInputStream oi=null;
		ArrayList<Venta> listaVentas= new ArrayList<Venta>();
		
		try{
			fi=new FileInputStream(file);
			oi=new ObjectInputStream(fi);
			int i=0;
			
			while(fi.available()>0)
			{
				Venta venta=(Venta) oi.readObject();
				listaVentas.add(venta);
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
		if(listaVentas.size()==0)
		{
			return null;
		}
		else
		{
			return listaVentas;
		}
	}

	public static void WriteFileVentas(String file, Venta[] ventas) throws Exception
	{
		FileOutputStream fo=null;
		ObjectOutputStream ol=null;
		
		try{
			fo=new FileOutputStream(file);
			ol=new ObjectOutputStream(fo);
			
			for(Venta o:ventas)
			{
				try
				{
					ol.writeObject(o);
				}
				catch(IOException e)
				{
					throw new Exception("Problema al crear las clases");
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
}

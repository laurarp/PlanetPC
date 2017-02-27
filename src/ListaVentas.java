import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;


public class ListaVentas implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5130292729510420277L;
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

	public void añadirVenta (DescripcionProducto descProducto, String idCliente, String idVendedor, int cantidad) throws Exception
	{
		Venta ventaNueva=new Venta(descProducto,new Date(System.currentTimeMillis()),idCliente,idVendedor,cantidad);
		ventas.add(ventaNueva);
		WriteFileVentas(ruta, ventas);
	}
	
	public ArrayList<Venta> getListaVentas()
	{
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

	public static void WriteFileVentas(String file, ArrayList<Venta> ventasNuevas) throws Exception
	{
		FileOutputStream fo=null;
		ObjectOutputStream ol=null;
		
		try{
			fo=new FileOutputStream(file);
			ol=new ObjectOutputStream(fo);
			
			for(Venta o:ventasNuevas)
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
		try 
		{
			ListaVentas lv= new ListaVentas();
			DescripcionProducto descripcionProducto=new DescripcionProducto("1",52455,"PC",5,"Apple","2015");
			lv.añadirVenta(descripcionProducto, "159632", "542586", 5);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
}

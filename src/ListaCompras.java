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

	public ListaCompras() 
	{
		super();
		ruta="ListaCompras.txt";
	}

	public void aņadirCompra (DescripcionProducto  descripcionProducto, String idProveedor, int cantidad, int precioCompra, Date fechaPedido, Date fechaIngreso, String estado)
	{
		
	}
	
	public ArrayList<Compra> getListaCompras() throws Exception
	{
		if(ReadFileCompras(ruta)!=null)
		{
			compras = (ArrayList<Compra>) (Arrays.asList(ReadFileCompras(ruta)));
		}
		else
		{
			compras =null;
		}
		return compras; 
	}

	public void modificarCompra(String idCompra,String estado) throws Exception
	{
		int i=0;
		
		if(ReadFileCompras(ruta)!=null)//Actualiza lista compras
		{
			compras = (ArrayList<Compra>) (Arrays.asList(ReadFileCompras(ruta)));
		}
		else
		{
			compras =null;
		}
		
		if(compras!=null)
		{
			while(i<compras.size() && String.valueOf(compras.get(i).getIdCompra())!=idCompra)
			{
				i++;
			}
			if(i<compras.size())
			{
				compras.get(i).setEstado("recibido");//Cambia el estado de la compra a recibido			
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
	}
	
	public static Compra[] ReadFileCompras(String file) throws Exception
	{
		FileInputStream fi=null;
		ObjectInputStream oi=null;
		Compra[] listaCompras= new Compra[0];
		
		try{
			fi=new FileInputStream(file);
			oi=new ObjectInputStream(fi);
			int i=0;
			
			while(fi.available()>0)
			{
				Compra compra=(Compra) oi.readObject();
				listaCompras=Arrays.copyOf(listaCompras, listaCompras.length+1);
				listaCompras[i++]=compra;
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
		if(listaCompras.length==0)
		{
			return null;
		}
		else
		{
			return listaCompras;
		}
	}
	
	public static void WriteFileCompras(String file, Compra[] Compras) throws Exception
	{
		FileOutputStream fo=null;
		ObjectOutputStream ol=null;
		
		try{
			fo=new FileOutputStream(file);
			ol=new ObjectOutputStream(fo);
			
			for(Compra o:Compras)
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

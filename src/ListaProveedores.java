import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;


public class ListaProveedores {
	private ArrayList<Proveedor> listaProveedores; 

	public void nuevoProveedor(String Nombre, String id)
	{
		
	}
	
	public Proveedor buscarProveedor(String id)
	{
		return null;
	}
	
	public void modificarProveedor(Proveedor proveedor)
	{
		
	}
	
	public void eliminarProveedor(String id)
	{
		
	}
	
	public ArrayList<Proveedor> mostrarProveedores()
	{
		return new ArrayList<Proveedor>(Arrays.asList(ReadFileProveedores("ListaProveedor.txt")));
	}
	
	public static Proveedor[] ReadFileProveedores(String file)
	{
		FileInputStream fi=null;
		ObjectInputStream oi=null;
		Proveedor[] listaProveedores= new Proveedor[0];
		
		try{
			fi=new FileInputStream(file);
			oi=new ObjectInputStream(fi);
			int i=0;
			
			while(fi.available()>0)
			{
				Proveedor proveedor=(Proveedor) oi.readObject();
				listaProveedores=Arrays.copyOf(listaProveedores, listaProveedores.length+1);
				listaProveedores[i++]=proveedor;
			}
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Problemas con la direccion para abrir el fichero");
		}
		catch(IOException e)
		{
			System.out.println("El fichero tiene problema al leer los objetos");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Problema al leer el fichero");
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
				System.out.println("No se pudo cerrar el fichero");
			}
		}
		if(listaProveedores.length==0)
		{
			return null;
		}
		else
		{
			return listaProveedores;
		}
	}
	
	public static void WriteFileObject(String file, Proveedor[] listProveedores)
	{
		FileOutputStream fo=null;
		ObjectOutputStream ol=null;
		
		try{
			fo=new FileOutputStream(file);
			ol=new ObjectOutputStream(fo);
			
			for(Proveedor o:listProveedores)
			{
				try
				{
					ol.writeObject(o);
				}
				catch(IOException e)
				{
					System.out.println("Problema al crear las clases");
				}
			}
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Problemas con la direccion para crear el fichero");
		}
		catch(IOException e)
		{
			System.out.println("El fichero tiene problema al crearse");
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
				System.out.println("No se pudo cerrar el fichero");
			}
		}
	}
	

}

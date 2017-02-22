import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;


public class ListaProveedores {
	private ArrayList<Proveedor> listaProveedores; 
	
	

	public ListaProveedores() {
		super();
		if(ReadFileProveedores("ListaProveedores.txt")!=null)
		{
			this.listaProveedores = (ArrayList<Proveedor>) (Arrays.asList(ReadFileProveedores("ListaProveedores.txt")));
		}
		else
		{
			this.listaProveedores =null;
		}
	}

	public void nuevoProveedor(String nombre, String id){
		Proveedor tempProveedor = new Proveedor(nombre, id);
		listaProveedores.add(tempProveedor);
		System.out.println("El proveedor"+listaProveedores.get(0).getNombre()+", con Id: "+listaProveedores.get(0).getId()+" ha sido creado.");
	}
	
	public String buscarProveedor(String id) throws Exception {
		for (Proveedor a : listaProveedores)
			if (id.equals(a.getId())){
				return a.getNombre();
			}else{
			throw new Exception("El proveedor no existe");
			}
		return id;
		}
	
	
	public void modificarProveedor(Proveedor proveedor, String id, String nombre){
		proveedor.setId(id);
		proveedor.setNombre(nombre);
	}
	
	public void eliminarProveedor(String id) throws Exception{
		for (Proveedor a : listaProveedores)
			if (id.equals(a.getId())){
				listaProveedores.remove(a);
			}else{
			throw new Exception("La Id ingresada es incorrecta");
			}
	}
	
	public ArrayList<Proveedor> mostrarProveedores()
	{
		listaProveedores=new ArrayList<Proveedor>(Arrays.asList(ReadFileProveedores("ListaProveedores.txt")));
		return listaProveedores; 
	}
	
	public String buscarIdProveedor(String nombreProveedor) throws Exception
	{
		String idProveedor="";
		
		if(listaProveedores!=null)
		{
			int i=0;
					
			while(i<listaProveedores.size() && listaProveedores.get(i).getNombre()!=nombreProveedor)
			{
				i++;
			}
			if(i<listaProveedores.size())
			{
				idProveedor=listaProveedores.get(i).getId();
			}
			else
			{
				throw new Exception("El proveedor no se encontró");
			}
		}
		else
		{
			throw new Exception("No existen proveedores");
		}
		return idProveedor;
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
	
	public static void WriteFileProveedores(String file, Proveedor[] listProveedores)
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

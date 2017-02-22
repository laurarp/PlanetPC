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

	public void nuevoProveedor(String nombre, String id){
		Proveedor tempProveedor = new Proveedor(nombre, id);
		listaProveedores.add(tempProveedor);
		writeFileObject("listaProveedores.txt", listaProveedores);
		System.out.println("El proveedor"+listaProveedores.get(0).getNombre()+", con Id: "+listaProveedores.get(0).getId()+" ha sido creado.");
	}
	
	public static void writeFileObject(String file, ArrayList<Proveedor> listaProveedores){
		FileOutputStream fo = null;
		ObjectOutputStream oI = null;
		try{
			fo = new FileOutputStream(file);
			oI = new ObjectOutputStream(fo);
			for (Proveedor o:listaProveedores){
				try{
					oI.writeObject(o);
				}catch (IOException e){
					System.out.println("problema al crear las clases");
				}
			}
		}catch (FileNotFoundException e){
			System.out.println("Problemas con la direccion para crear e fichero");
		}catch (IOException e){
			System.out.println("El fichero tiene problema al crearse");
		}finally{
			try{
				if (fo!=null){
					fo.close();
					oI.close();
				}
			}catch (IOException e){
				
			}
		}
	}
	
	public String buscarProveedor(String id) throws Exception {
		for (Proveedor a : listaProveedores)
			if (id.equals(a.getId())){
				return a.getNombre();
			}else{
			throw new Exception("El proveedor no existe");
			}
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

}

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;


public class ListaActores implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1467478525274105375L;
	private ArrayList<Actor> actores;
	private String ruta;
	
	
	public ListaActores() throws Exception {
		super();
		ruta="ListaActores.txt";
		
		if(ReadFileActores(ruta)!=null)
		{
			this.actores = ReadFileActores(ruta);
		}
		else
		{
			this.actores =new ArrayList<Actor>();
		}
	
	}

	public void nuevoActor(String id,String nombre, String contrasena,String tipo) throws Exception
	{
		Actor a = null;
		
		try
		{
			a=buscarActor(id);
		}
		catch(Exception e)
		{
			if(id.compareTo("")!=0 && nombre.compareTo("")!=0 && contrasena.compareTo("")!=0)
			{
				Actor nuevoActor = null;
				switch(tipo)
				{
					case "Administrador":
						nuevoActor=new Administrador(id,nombre,contrasena);
						break;
					case "Jefe de bodega":
						nuevoActor=new JefeBodega(id,nombre,contrasena);
						break;
					case "Auxiliar de almacenamiento":
						nuevoActor=new AuxiliarAlmacenamiento(id,nombre,contrasena);
						break;
					case "Auxiliar de servicio técnico":
						nuevoActor=new AuxiliarServicio(id,nombre,contrasena);
						break;
					case "Asistente de compras y ventas":
						nuevoActor=new AsesorVentas(id,nombre,contrasena);
						break;
				}
				if(nuevoActor != null)
				{
					actores.add(nuevoActor);
					WriteFileActores(ruta,actores);
				}
				else
				{
					throw new Exception("El actor no se pudo crear");
				}
			}
			else
			{
				throw new Exception("Algunos atributos del actor están vacíos");
			}
		}
		
		if(a!=null)
		{
			throw new Exception("El usuario ya existe");
		}

	}
	
	public Actor buscarActor(String id) throws Exception
	{
		if(actores != null)
		{
			int i=0;
			
			while(i<actores.size() && actores.get(i).getId().compareTo(id)!=0)
			{
				i++;
			}
			
			if(i<actores.size())
			{
				return actores.get(i);
			}
			else
			{
				throw new Exception("El actor no se pudo encontrar");
			}
		}
		else
		{
			throw new Exception("El sistema no contiene usuarios");
		}
	}
	
	public void modificarActor(Actor actor)
	{
		
	}
	
	public void eliminarActor(String id)
	{
		
	}
	
	public ArrayList <Actor> mostrarActores()
	{
		return null;
	}

	public static ArrayList<Actor> ReadFileActores(String file) throws Exception
	{
		FileInputStream fi=null;
		ObjectInputStream oi=null;
		ArrayList<Actor> listaActores= new ArrayList<Actor>();
		
		try{
			fi=new FileInputStream(file);
			oi=new ObjectInputStream(fi);
			
			while(fi.available()>0)
			{
				Actor actor=(Actor) oi.readObject();
				listaActores.add(actor);
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
		if(listaActores.size()==0)
		{
			return null;
		}
		else
		{
			return listaActores;
		}
	}
	
	public static void WriteFileActores(String file, ArrayList<Actor> actoresNuevos) throws Exception
	{
		FileOutputStream fo=null;
		ObjectOutputStream ol=null;
		
		try{
			fo=new FileOutputStream(file);
			ol=new ObjectOutputStream(fo);
			
			for(Actor o:actoresNuevos)
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
			ArrayList<Actor> lecturaActores=ReadFileActores("ListaActores.txt");
			if(lecturaActores!=null)
			{
				for(Actor a:lecturaActores)
				{
					System.out.println(a.getClass());
					//System.out.println(p.toString());
				}
			}
			
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}

}

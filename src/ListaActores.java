import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;


public class ListaActores {
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

	public void nuevoActor(String id,String nombre, String contrasena,String tipo)
	{
		Actor nuevoActor=new Actor(nombre,contrasena);
		
	}
	
	public Actor buscarActor(String id)
	{
		return null;
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

}

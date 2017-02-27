import java.io.File;
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

	public ArrayList<Actor> getActores() {
		return actores;
	}

	public void setActores(ArrayList<Actor> actores) {
		this.actores = actores;
	}

	public ListaActores() throws Exception 
	{
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
//---------------------------------------------------------------------------------------------------------------------------------	
	public static int buscarIndice(String id) throws Exception {
		ArrayList<Actor> auxiliar= new ArrayList<Actor>();
		auxiliar= ReadFileActores("ListaActores.txt");
		int indice = 0;
		while (indice < auxiliar.size()) {
			if (id.compareTo(auxiliar.get(indice).getId()) == 0) {
				return indice;
			} else {
				indice++;
			}
		}
		return -1;
	}
	
	public void modificarActor(String contrasena, String id, String newContrasena, String validContrasena) throws Exception
	{
		int indice = buscarIndice(id);
		if (buscarIndice(id) == -1) {
			throw new Excepciones("El usuario no esta cargado en la lista");
		} else {
			if(contrasena.compareTo(actores.get(indice).getContrasena())==0){
				if(validContrasena.compareTo(newContrasena)==0){
					actores.get(indice).setContrasena(validContrasena);
				}
				else{
					throw new Excepciones("no se puede cambiar la contraseña");
				}
			}else{
				throw new Excepciones("la contraseña anterior es incorrecta");
			}
			File s = new File("ListaActores.txt");
			s.delete();
			WriteFileActores("ListaActores.txt", actores);
		}
		
		
	}
	
	public ArrayList<Actor> mostrarUsuarios() throws Exception{
		return actores=ReadFileActores(ruta);
	}
//---------------------------------------------------------------------------------------------------------------------------------
	public void eliminarActor(String id) throws Exception
	{
		ArrayList<Actor> auxiliar = new ArrayList<Actor>();
		int posicionEliminar = buscarIndice(id);
		if (buscarIndice(id) == -1) {
			throw new Excepciones("el usuario no se encuentra en la lista");
		} else {
			for (int i = 0; i < actores.size(); i++) {
				if (posicionEliminar != i) {
					auxiliar.add(actores.get(i));
				}
			}
			actores = auxiliar;
			File fichero = new File("ListaActores.txt");
			fichero.delete();
			WriteFileActores("ListaActores.txt", actores);
		}
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
			//WriteFileActores("ListaActores.txt",new ArrayList<Actor>());
			ArrayList<Actor> lecturaActores=ReadFileActores("ListaActores.txt");
			if(lecturaActores!=null)
			{
				for(Actor a:lecturaActores)
				{
					System.out.println(a.getId()+": "+a.getClass().getName());
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

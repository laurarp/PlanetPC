import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;


public class ListaVentas {
	private ArrayList<Venta> listaVentas;
	
	public ListaVentas() {
		super();
		if(ReadFileVentas("ListaVentas.txt")!=null)
		{
			this.listaVentas = (ArrayList<Venta>) (Arrays.asList(ReadFileVentas("ListaVentas.txt")));
		}
		else
		{
			this.listaVentas =null;
		}
	}

	public void añadirVenta (DescripcionProducto descripcionProducto, Date fechaVenta, String idCliente, String idVendedor, int Cantidad)
	{
		
	}
	
	public ArrayList<Venta> getListaVentas()
	{
		listaVentas=(ArrayList<Venta>) (Arrays.asList(ReadFileVentas("ListaVentas.txt")));
		return listaVentas; 
	}
	
	public static Venta[] ReadFileVentas(String file)
	{
		FileInputStream fi=null;
		ObjectInputStream oi=null;
		Venta[] listaVentas= new Venta[0];
		
		try{
			fi=new FileInputStream(file);
			oi=new ObjectInputStream(fi);
			int i=0;
			
			while(fi.available()>0)
			{
				Venta venta=(Venta) oi.readObject();
				listaVentas=Arrays.copyOf(listaVentas, listaVentas.length+1);
				listaVentas[i++]=venta;
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
		if(listaVentas.length==0)
		{
			return null;
		}
		else
		{
			return listaVentas;
		}
	}

}

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;


public class ListaCompras {
	private ArrayList<Compra> listaCompras;
	

	public ListaCompras() {
		super();
		if(ReadFileCompras("ListaCompras.txt")!=null)
		{
			this.listaCompras = (ArrayList<Compra>) (Arrays.asList(ReadFileCompras("ListaCompras.txt")));
		}
		else
		{
			this.listaCompras =null;
		}
	}

	public void añadirCompra (DescripcionProducto  descripcionProducto, String idProveedor, int cantidad, int precioCompra, Date fechaPedido, Date fechaIngreso, String estado)
	{
		
	}
	
	public void modificarCompra(Compra compra)
	{
		
	}
	
	public ArrayList<Compra> getListaCompras()
	{
		if(ReadFileCompras("ListaCompras.txt")!=null)
		{
			listaCompras = (ArrayList<Compra>) (Arrays.asList(ReadFileCompras("ListaCompras.txt")));
		}
		else
		{
			listaCompras =null;
		}
		return listaCompras; 
	}
	
	public static Compra[] ReadFileCompras(String file)
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
		if(listaCompras.length==0)
		{
			return null;
		}
		else
		{
			return listaCompras;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Compra[] listR=ReadFileCompras("ListaCompras.txt");
		if(listR!=null)
		{
			for(Compra p:listR)
			{
				//System.out.println(p.getNombre());
				System.out.println(p.toString());
			}
		}

	}

}

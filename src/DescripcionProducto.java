import java.io.Serializable;


public class DescripcionProducto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6774304565029299067L;
	private String id;
	private int precioVenta;
	private String Tipo;
	private int diasGarantia;
	private String marca;
	private String modelo;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(int precioVenta) {
		this.precioVenta = precioVenta;
	}
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String tipo) {
		Tipo = tipo;
	}
	public int getDiasGarantia() {
		return diasGarantia;
	}
	public void setDiasGarantia(int diasGarantia) {
		this.diasGarantia = diasGarantia;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public DescripcionProducto(String id, int precioVenta, String tipo,
			int diasGarantia, String marca, String modelo) {
		super();
		this.id = id;
		this.precioVenta = precioVenta;
		Tipo = tipo;
		this.diasGarantia = diasGarantia;
		this.marca = marca;
		this.modelo = modelo;
	}
	
	
	
	

}

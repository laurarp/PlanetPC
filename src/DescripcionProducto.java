import java.io.Serializable;


public class DescripcionProducto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 297942904750611527L;
	protected String id;
	protected int precioVenta;
	protected String tipo;
	protected int diasGarantia;
	protected String marca;
	protected String modelo;
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
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
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
	public DescripcionProducto(String id, int precioVenta, String tipo, int diasGarantia, String marca, String modelo) {
		super();
		this.id = id;
		this.precioVenta = precioVenta;
		this.tipo = tipo;
		this.diasGarantia = diasGarantia;
		this.marca = marca;
		this.modelo = modelo;
	}
	
	
	public DescripcionProducto() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "DescripcionProducto [id=" + id + ", precioVenta=" + precioVenta + ", tipo=" + tipo + ", diasGarantia="
				+ diasGarantia + ", marca=" + marca + ", modelo=" + modelo + "]";
	}
	
	
	
	

}

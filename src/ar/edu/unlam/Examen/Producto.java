package ar.edu.unlam.Examen;

public class Producto implements Vendible{
	
	private String nombre; 
	private String codigo;
	private Integer stock;
	private double precio;
	
	public Producto(String codigo, String nombre, double precio) {
		// TODO Auto-generated constructor stub
		this.nombre = nombre;
		this.codigo = codigo;
		this.precio = precio;
		this.stock = 0;
	}

	@Override
	public String getCodigo() {
		// TODO Auto-generated method stub
		return this.codigo;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return this.nombre;
	}

	@Override
	public Double getPrecio() {
		// TODO Auto-generated method stub
		return this.precio;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = getStock() + stock;
	}
	
	public void sacarStock(Integer stock) {
		this.stock = getStock() - stock;
	}
}

package ar.edu.unlam.Examen;

public class Servicio implements Vendible {
	
	private String codigo;
	private String nombre;
	private double precio;
	private String fechaInicio;
	private String fechaFin;
	
	public Servicio(String codigo, String nombre, double precio, String fechaInicio, String fechaFin) {
		// TODO Auto-generated constructor stub
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}

	@Override
	public String getCodigo() {
		// TODO Auto-generated method stub
		return codigo;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return nombre;
	}

	@Override
	public Double getPrecio() {
		// TODO Auto-generated method stub
		return precio;
	}

}

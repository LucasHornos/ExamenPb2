package ar.edu.unlam.Examen;

public class Vendedor {

	private String dni;
	private String nombre;
	private double gananciaComision;
	
	public Vendedor(String dniEjemplo, String nombre) {
		this.dni = dniEjemplo;
		this.nombre = nombre;
		this.gananciaComision = 0;
	}

	public Object getDni() {
		// TODO Auto-generated method stub
		return dni;
	}

	public double getGananciaComision() {
		return gananciaComision;
	}

	public void setGananciaComision(double totalComision) {
		this.gananciaComision = totalComision;
	}
	
	
}

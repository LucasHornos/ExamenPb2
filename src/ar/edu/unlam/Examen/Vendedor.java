package ar.edu.unlam.Examen;

import java.util.ArrayList;

public class Vendedor {

	private String dni;
	private String nombre;
	private double gananciaComision;
	private ArrayList<Venta> ventas;
	
	public Vendedor(String dniEjemplo, String nombre) {
		this.dni = dniEjemplo;
		this.nombre = nombre;
		this.gananciaComision = 0;
		this.ventas = new ArrayList<Venta>();
	}

	public Object getDni() {
		// TODO Auto-generated method stub
		return dni;
	}

	public double getGananciaComision() {
		return gananciaComision;
	}

	public void setGananciaComision(double totalComision) {
		this.gananciaComision = getGananciaComision() + totalComision;
	}
	
	
}

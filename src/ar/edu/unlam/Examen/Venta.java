package ar.edu.unlam.Examen;

import java.util.ArrayList;

public class Venta {

	private String codigo;
	private Cliente cliente;
	private Vendedor vendedor;
	private ArrayList<Producto> productosCompra;
	private ArrayList<Servicio> serviciosCompra;
	private double precio;
	
	public Venta(String codigo, Cliente cliente, Vendedor vendedor) {
		// TODO Auto-generated constructor stub
		this.codigo = codigo;
		this.cliente = cliente;
		this.vendedor=vendedor;
		this.serviciosCompra = new ArrayList<Servicio>();
		this.productosCompra = new ArrayList<Producto>();
		this.precio = 0;
	}

	public String getCodigo() {
		// TODO Auto-generated method stub
		return codigo;
	}
	
	

	public void setPrecio(double precio) {
		this.precio += precio;
	}

	public Double getTotal() {
		// TODO Auto-generated method stub
	
		return precio;
	}

	public void agregarProducto(Producto producto, Integer cantidadVendida) {
		// TODO Auto-generated method stub
		productosCompra.add(producto);
		setPrecio(producto.getPrecio()*cantidadVendida);
	}
	public void agregarServicio(Servicio servicio) {
		// TODO Auto-generated method stub
		serviciosCompra.add(servicio);
		setPrecio(servicio.getPrecio());
	}

}

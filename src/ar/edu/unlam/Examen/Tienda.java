package ar.edu.unlam.Examen;

import java.util.ArrayList;

public class Tienda {
	
	private String codigo;
	private String nombre;
	private ArrayList<Producto> productos;
	private ArrayList<Cliente> clientes;
	private ArrayList<Vendedor> vendedores;
	private ArrayList<Venta> ventas;
	private ArrayList<Servicio> servicios;
	

	public Tienda(String codigo, String nombre) {
		this.nombre = nombre;
		this.codigo = codigo;
		this.productos = new ArrayList<Producto>();
		this.clientes = new ArrayList<Cliente>();
		this.vendedores = new ArrayList<Vendedor>();
		this.ventas = new ArrayList<Venta>();
		this.servicios = new ArrayList<Servicio>();
	}

	public void agregarProducto(Producto producto) {
		// TODO Auto-generated method stub
		productos.add(producto);
	}

	public Producto getVendible(String codigo) throws VendibleInexistenteException {
		// TODO Auto-generated method stub
		return buscarProductoPorCod(codigo);
	}

	private Producto buscarProductoPorCod(String codigo) throws VendibleInexistenteException {
		// TODO Auto-generated method stub
		for (Producto producto : productos) {
			if (producto.getCodigo().equals(codigo)) {
				return producto;
			}
			else {
				throw new VendibleInexistenteException();
			}
		}
		return null;
	}

	public Integer getStock(Producto producto) throws VendibleInexistenteException {
		// TODO Auto-generated method stub
		return buscarProductoPorCod(producto.getCodigo()).getStock();
	}

	public void agregarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		clientes.add(cliente);
	}

	public Cliente getCliente(String cuitEjemplo) throws ClienteInexistenteException {
		// TODO Auto-generated method stub
		return buscarClientePorCuit(cuitEjemplo);
	}

	private Cliente buscarClientePorCuit(String cuitEjemplo) throws ClienteInexistenteException {
		for (Cliente cliente : clientes) {
			if (cliente.getCuit().equals(cuitEjemplo)) {
				return cliente;
			} else {
				throw new ClienteInexistenteException();
			}
		}
		return null;
	}

	public void agregarVendedor(Vendedor vendedor) {
		// TODO Auto-generated method stub
		vendedores.add(vendedor);
	}

	public Vendedor getVendedor(String dniEjemplo) throws VendedorInexistenteException {
		// TODO Auto-generated method stub
		return buscarVendedorPorDni(dniEjemplo);
	}

	private Vendedor buscarVendedorPorDni(String dniEjemplo) throws VendedorInexistenteException {
		for (Vendedor vendedor : vendedores) {
			if (vendedor.getDni().equals(dniEjemplo)) {
				return vendedor;
			} 
			else {
				throw new VendedorInexistenteException();
			} 
		}
		return null;
	}

	public void agregarServicio(Servicio servicio) {
		// TODO Auto-generated method stub
		
	}

	public void agregarProducto(Producto producto, Integer cantidad) {
		// TODO Auto-generated method stub
		producto.setStock(producto.getStock() + cantidad);
		productos.add(producto);
	}

	public void agregarVenta(Venta ticket) {
		// TODO Auto-generated method stub
		ventas.add(ticket);
		
	}

	public void agregarProductoAVenta(String codigoVenta, Producto producto, Integer cantidadVendida) throws StockInsuficienteException, VentaInexistenteException {
		// TODO Auto-generated method stub
		Venta ventaElegida = null;
		for (Venta venta : ventas) {
			if (venta.getCodigo().equals(codigoVenta)) {
				ventaElegida = venta;
			} else {
				throw new VentaInexistenteException();
			}  
		}
		
		if (ventaElegida != null) {
			if (producto.getStock() >= cantidadVendida) {
				producto.sacarStock(cantidadVendida);
				ventaElegida.agregarProducto(producto, cantidadVendida);
			} else {
				throw new StockInsuficienteException();
			}
		}
	}

	public void agregarServicioAVenta(String codigoVenta, Servicio servicio) {
		// TODO Auto-generated method stub
		Venta ventaElegida = null;
		for (Venta venta : ventas) {
			if (venta.getCodigo().equals(codigoVenta)) {
				ventaElegida = venta;
			}
		}
		
		if (ventaElegida != null) {
			ventaElegida.agregarServicio(servicio);
		}
	}
	
	
}

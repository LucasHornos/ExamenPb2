package ar.edu.unlam.pb2.Parcial01;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ar.edu.unlam.Examen.Cliente;
import ar.edu.unlam.Examen.Vendible;
import ar.edu.unlam.Examen.ClienteInexistenteException;
import ar.edu.unlam.Examen.Producto;
import ar.edu.unlam.Examen.Servicio;
import ar.edu.unlam.Examen.StockInsuficienteException;
import ar.edu.unlam.Examen.Tienda;
import ar.edu.unlam.Examen.Vendedor;
import ar.edu.unlam.Examen.VendedorInexistenteException;
import ar.edu.unlam.Examen.VendibleInexistenteException;
import ar.edu.unlam.Examen.Venta;
import ar.edu.unlam.Examen.VentaInexistenteException;

public class testTienda {
	
	@Test
	public void queSePuedaAgregarProductos() throws VendibleInexistenteException {
		Tienda tienda = new Tienda("30123456780", "Tienda de ejemplo");
		Producto producto = new Producto("1", "Producto nuevo", 100d);
		tienda.agregarProducto(producto);
		Vendible productoActual = (Producto) tienda.getVendible(producto.getCodigo());
		assertEquals(producto, productoActual);
	}
	
	@Test
	public void queSePuedaAgregarStock() throws VendibleInexistenteException {
		Tienda tienda = new Tienda("30123456780", "Tienda de ejemplo");
		Producto producto = new Producto("1", "Producto nuevo", 100d);
		Integer cantidad = 10;
		tienda.agregarProducto(producto, cantidad);
		Integer stockActual = tienda.getStock((Producto) producto); 
		assertEquals(cantidad, stockActual);
		
		
	}
	
	@Test
	public void queSePuedaAgregarUnCliente() throws ClienteInexistenteException {
		Tienda tienda = new Tienda("30123456780", "Tienda de ejemplo");
		String cuitEjemplo = "30123456780";
		Cliente cliente = new Cliente(cuitEjemplo, "Cliente de ejemplo");
		tienda.agregarCliente(cliente);
		Cliente clienteActual = tienda.getCliente(cuitEjemplo);
		assertEquals(cliente, clienteActual);
		
	}
	
	@Test
	public void queSePuedaAgregarUnVendedor() throws VendedorInexistenteException {
		Tienda tienda = new Tienda("30123456780", "Tienda de ejemplo");
		String dniEjemplo = "12345678";
		Vendedor vendedor = new Vendedor (dniEjemplo, "Vendedor de ejemplo");
		tienda.agregarVendedor(vendedor);
		Vendedor vendedorActual = tienda.getVendedor(dniEjemplo);
		assertEquals(vendedor, vendedorActual);
		
	}
	
	@Test
	public void queSePuedaHacerUnaVentaDeUnProducto() throws VentaInexistenteException, VendibleInexistenteException, StockInsuficienteException {
		Tienda tienda = new Tienda("30123456780", "Tienda de ejemplo");
		String cuitCliente = "30123456780";
		Cliente cliente = new Cliente(cuitCliente, "Cliente de ejemplo");
		tienda.agregarCliente(cliente);
		String dniEjemplo = "12345678";
		Vendedor vendedor = new Vendedor (dniEjemplo, "Vendedor de ejemplo");
		Vendible producto = new Producto("1", "Producto nuevo", 100d);
		Integer stockInicial = 10;
		tienda.agregarProducto((Producto) producto, stockInicial);
		Venta ticket = new Venta("C-0001", cliente, vendedor);
		tienda.agregarVenta(ticket);
		Integer cantidadVendida = 5;
		tienda.agregarProductoAVenta(ticket.getCodigo(), (Producto) producto, cantidadVendida);
		Integer stockEsperado = 5;
		Integer stockActual = tienda.getStock((Producto) producto);
		assertEquals(stockEsperado, stockActual);
		
	}
	
	
	@Test (expected = StockInsuficienteException.class)
	public void queNoSePuedaAgregarUnaVentaPorStockInsuficiente() throws VentaInexistenteException, VendibleInexistenteException, StockInsuficienteException {
		Tienda tienda = new Tienda("30123456780", "Tienda de ejemplo");
		String cuitCliente = "30123456780";
		Cliente cliente = new Cliente(cuitCliente, "Cliente de ejemplo");
		tienda.agregarCliente(cliente);
		String dniEjemplo = "12345678";
		Vendedor vendedor = new Vendedor (dniEjemplo, "Vendedor de ejemplo");
		Producto producto = new Producto("1", "Producto nuevo", 100d);
		Integer stockInicial = 10;
		tienda.agregarProducto(producto, stockInicial);
		Venta ticket = new Venta("C-0001", cliente, vendedor);
		tienda.agregarVenta(ticket);
		Integer cantidadVendida = 15;
		tienda.agregarProductoAVenta(ticket.getCodigo(), producto, cantidadVendida);
		
	}
	
	@Test
	public void queSePuedaHacerUnaVentaDeUnServicio() throws VentaInexistenteException, VendibleInexistenteException {
		Tienda tienda = new Tienda("30123456780", "Tienda de ejemplo");
		String cuitCliente = "30123456780";
		Cliente cliente = new Cliente(cuitCliente, "Cliente de ejemplo");
		tienda.agregarCliente(cliente);
		String dniEjemplo = "12345678";
		Vendedor vendedor = new Vendedor (dniEjemplo, "Vendedor de ejemplo");
		Servicio servicio = new Servicio("1", "Servicio Técnico", 100d, "2023-02-01", "2023-03-01");
		Vendible producto = new Producto("3", "Producto nuevo", 100d);
		Integer stockInicial = 10;
		tienda.agregarProducto((Producto) producto, stockInicial);
		
		tienda.agregarServicio((Servicio) servicio);
		Venta venta = new Venta("C-0001", cliente, vendedor);
		tienda.agregarVenta(venta);
		tienda.agregarServicioAVenta(venta.getCodigo(), servicio);
		Double totalEsperado = 100d;
		Double totalActual = venta.getTotal();
		assertEquals(totalEsperado, totalActual);
		
	}
	
	@Test
	public void queSePuedaHacerUnaVentaDeUnProductosYServicios() throws VentaInexistenteException, VendibleInexistenteException, StockInsuficienteException {
		Tienda tienda = new Tienda("30123456780", "Tienda de ejemplo");
		String cuitCliente = "30123456780";
		Cliente cliente = new Cliente(cuitCliente, "Cliente de ejemplo");
		tienda.agregarCliente(cliente);
		String dniEjemplo = "12345678";
		Vendedor vendedor = new Vendedor (dniEjemplo, "Vendedor de ejemplo");
		
		Venta venta = new Venta("C-0001", cliente, vendedor);
		tienda.agregarVenta(venta);
		Vendible vendible;
		
		vendible = new Servicio("1", "Servicio Técnico", 100d, "2023-02-01", "2023-03-01");
		tienda.agregarServicio((Servicio) vendible);
		tienda.agregarServicioAVenta(venta.getCodigo(), (Servicio) vendible);
		
		vendible = new Producto("2", "Producto nuevo", 350d);
		Integer stockInicial = 10;
		tienda.agregarProducto((Producto) vendible, stockInicial);
		Integer cantidadVendida = 2;
		tienda.agregarProductoAVenta(venta.getCodigo(), (Producto) vendible, cantidadVendida);
				
		Double totalEsperado = 800d;
		Double totalActual = venta.getTotal();
		assertEquals(totalEsperado, totalActual);
		
	}
	
	
	@Test
	public void queSePuedaEstablecerElPorcentajeDeComisionDeUnVendedor() throws VendedorInexistenteException, VentaInexistenteException, VendibleInexistenteException, StockInsuficienteException {
		Tienda tienda = new Tienda("30123456780", "Tienda de ejemplo");
		String cuitCliente = "30123456780";
		Cliente cliente = new Cliente(cuitCliente, "Cliente de ejemplo");
		tienda.agregarCliente(cliente);
		String dniEjemplo = "12345678";
		Vendedor vendedor = new Vendedor (dniEjemplo, "Vendedor de ejemplo");
		Producto producto = new Producto("1", "Producto nuevo", 100d);
		Integer stockInicial = 10;
		tienda.agregarProducto(producto, stockInicial);
		Venta ticket = new Venta("C-0001", cliente, vendedor);
		tienda.agregarVenta(ticket);
		Integer cantidadVendida = 5;
		tienda.agregarProductoAVenta(ticket.getCodigo(), producto, cantidadVendida);
		
		Double montoTotal = ticket.darComisionAlVendedor();
		Double montoEsperado = 50d; // seria el 10% de la venta que se hizo para el vendedor
		
		vendedor.setGananciaComision(montoTotal);
		
		assertEquals(montoEsperado, montoTotal);
	}
	
	@Test
	public void queSeCalculeElMontoTotalDeComisionesQueTieneUnVendedor() throws VendedorInexistenteException, VentaInexistenteException, VendibleInexistenteException, StockInsuficienteException {
		Tienda tienda = new Tienda("30123456780", "Tienda de ejemplo");
		String cuitCliente = "30123456780";
		Cliente cliente = new Cliente(cuitCliente, "Cliente de ejemplo");
		tienda.agregarCliente(cliente);
		String dniEjemplo = "12345678";
		Vendedor vendedor = new Vendedor (dniEjemplo, "Vendedor de ejemplo");
		Producto producto = new Producto("1", "Producto nuevo", 100d);
		Integer stockInicial = 10;
		tienda.agregarProducto(producto, stockInicial);
		Venta ticket = new Venta("C-0001", cliente, vendedor);
		tienda.agregarVenta(ticket);
		Integer cantidadVendida = 5;
		
		tienda.agregarProductoAVenta(ticket.getCodigo(), producto, cantidadVendida);
		
		String cuitCliente2 = "1233";
		Cliente cliente2 = new Cliente(cuitCliente2, "Cliente de ejemplo");
		
		Producto producto2 = new Producto("2", "Coca", 150d);
		Integer stockInicial2 = 10;
		tienda.agregarProducto(producto2, stockInicial2);
		Venta ticket2 = new Venta("C-0002", cliente2, vendedor);
		tienda.agregarVenta(ticket2);
		Integer cantidadVendida2 = 2;
		
		tienda.agregarProductoAVenta(ticket2.getCodigo(), producto2, cantidadVendida2);
		
		Double montoVenta1 = ticket.darComisionAlVendedor();
		
		Double montoVenta2 = ticket2.darComisionAlVendedor();
		
		Double montoFinal = montoVenta1 + montoVenta2; 
		
		Double montoEsperado = 80d; // seria el 10% por cada venta que se hizo para el vendedor
		
		montoFinal = vendedor.getGananciaComision();
		
		assertEquals(montoEsperado, montoFinal);
	}
}

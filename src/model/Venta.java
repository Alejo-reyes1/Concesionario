package model;

import java.time.LocalDate;

public class Venta {
	private Cliente cliente;
	private Vehiculo vehiculo;
	private final LocalDate fechaVenta;
	private final double precioVenta;
	
	public Venta(Cliente cliente, Vehiculo vehiculo, double precioVenta) {
		this.cliente = cliente;
		this.vehiculo = vehiculo;
		this.precioVenta = precioVenta;
		this.fechaVenta=LocalDate.now();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}
	public LocalDate getFechaVenta() {
		return fechaVenta;
	}

	@Override
	public String toString() {
		return "Venta [cliente=" + cliente + ", vehiculo=" + vehiculo + ", fechaVenta=" + fechaVenta + ", precioVenta="
				+ precioVenta + "]";
	}
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.time.LocalDate;

public class VentaTest {

    private Cliente cliente;
    private Vehiculo vehiculo;
    private Venta venta;

    @Before
    public void setUp() {
        // Crear una instancia de Cliente y Vehiculo antes de cada test
        cliente = new Cliente("Juan Pérez", "Calle Falsa 123", "555-1234", "juan.perez@example.com");
        vehiculo = new Automovil("Toyota", "Corolla", "ABC123", "Rojo", 50000, 2019, 4, "Gasolina", "Manual", "Delantera");
        venta = new Venta(cliente, vehiculo, 15000.00);
    }

    // Test para el método getCliente
    @Test
    public void testGetCliente() {
        assertEquals(cliente, venta.getCliente());
    }

    // Test para el método setCliente
    @Test
    public void testSetCliente() {
        Cliente nuevoCliente = new Cliente("Carlos López", "Avenida Siempre Viva 742", "555-4321", "carlos.lopez@example.com");
        venta.setCliente(nuevoCliente);
        assertEquals(nuevoCliente, venta.getCliente());
    }

    // Test para el método getVehiculo
    @Test
    public void testGetVehiculo() {
        assertEquals(vehiculo, venta.getVehiculo());
    }

    // Test para el método setVehiculo
    @Test
    public void testSetVehiculo() {
        Vehiculo nuevoVehiculo = new Camion("Ford", "F-150", "XYZ789", "Azul", 70000, 2020, 10000, "Camioneta", 6, "Disco", 3000);
        venta.setVehiculo(nuevoVehiculo);
        assertEquals(nuevoVehiculo, venta.getVehiculo());
    }

    // Test para el método getPrecioVenta
    @Test
    public void testGetPrecioVenta() {
        assertEquals(15000.00, venta.getPrecioVenta(), 0.01);
    }

    // Test para el método getFechaVenta
    @Test
    public void testGetFechaVenta() {
        LocalDate fechaEsperada = LocalDate.now();
        assertEquals(fechaEsperada, venta.getFechaVenta());
    }

    // Test para el método toString
    @Test
    public void testToString() {
        String expected = "Venta [cliente=" + cliente + ", vehiculo=" + vehiculo + ", fechaVenta=" + LocalDate.now() + ", precioVenta=15000.0]";
        assertTrue(venta.toString().contains("Venta"));
    }
}

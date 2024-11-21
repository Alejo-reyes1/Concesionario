package model;

public interface VentaVehiculo {
	
	public double calcularPrecioVenta(double precioVenta);
	}

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class VentaVehiculoTest {

    private Automovil automovil;
    private Camion camion;
    private Motocicleta motocicleta;

    @Before
    public void setUp() {
        // Crear las instancias de los vehículos antes de cada test
        automovil = new Automovil("Toyota", "Corolla", "ABC123", "Rojo", 50000, 2019, 4, "Gasolina", "Manual", "Delantera");
        camion = new Camion("Ford", "F-150", "XYZ789", "Azul", 70000, 2020, 10000, "Camioneta", 6, "Disco", 3000);
        motocicleta = new Motocicleta("Yamaha", "R1", "R1234", "Negra", 15000, 2021, "Deportivo", 2, "Disco", 1);
    }

    // Test para el cálculo del precio de venta en un Automovil
    @Test
    public void testCalcularPrecioVentaAutomovil() {
        double precioVenta = 15000.00;
        double precioEsperado = (precioVenta * 0.1) + precioVenta;  // 10% de comisión
        assertEquals(precioEsperado, automovil.calcularPrecioVenta(precioVenta), 0.01);
    }

    // Test para el cálculo del precio de venta en un Camion
    @Test
    public void testCalcularPrecioVentaCamion() {
        double precioVenta = 20000.00;
        double precioEsperado = (precioVenta * 0.15) + precioVenta;  // 15% de comisión
        assertEquals(precioEsperado, camion.calcularPrecioVenta(precioVenta), 0.01);
    }

    // Test para el cálculo del precio de venta en una Motocicleta
    @Test
    public void testCalcularPrecioVentaMotocicleta() {
        double precioVenta = 8000.00;
        double precioEsperado = (precioVenta * 0.07) + precioVenta;  // 7% de comisión
        assertEquals(precioEsperado, motocicleta.calcularPrecioVenta(precioVenta), 0.01);
    }
}

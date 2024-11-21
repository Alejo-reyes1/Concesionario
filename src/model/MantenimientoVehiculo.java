package model;

public interface MantenimientoVehiculo {
	public double calcularPrecioMantenimiento(double precioMantenimiento);

	}

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MantenimientoVehiculoTest {

    private MantenimientoVehiculo automovil;
    private MantenimientoVehiculo camion;
    private MantenimientoVehiculo motocicleta;

    @Before
    public void setUp() {
        // Crear instancias de cada tipo de vehículo
        automovil = new Automovil("Toyota", "Corolla", "ABC123", "Rojo", 50000, 2019, 4, "Gasolina", "Manual", "Delantera");
        camion = new Camion("Volvo", "FH", "XYZ789", "Azul", 100000, 2018, 20000.0, "Pesado", 12, "ABS", 15000);
        motocicleta = new Motocicleta("Honda", "CBR", "DEF456", "Negra", 20000, 2020, "Deportivo", 2, "Disco", 2);
    }

    @Test
    public void testCalcularPrecioMantenimientoAutomovil() {
        // Test para Automovil (con 10% de aumento)
        double precioMantenimiento = 100.00;
        double precioEsperado = precioMantenimiento * 1.1; // 10% de aumento
        assertEquals(precioEsperado, automovil.calcularPrecioMantenimiento(precioMantenimiento), 0.01);
    }

    @Test
    public void testCalcularPrecioMantenimientoCamion() {
        // Test para Camion (con 15% de aumento)
        double precioMantenimiento = 200.00;
        double precioEsperado = precioMantenimiento * 1.15; // 15% de aumento
        assertEquals(precioEsperado, camion.calcularPrecioMantenimiento(precioMantenimiento), 0.01);
    }

    @Test
    public void testCalcularPrecioMantenimientoMotocicleta() {
        // Test para Motocicleta (con 7% de aumento)
        double precioMantenimiento = 50.00;
        double precioEsperado = precioMantenimiento * 1.07; // 7% de aumento
        assertEquals(precioEsperado, motocicleta.calcularPrecioMantenimiento(precioMantenimiento), 0.01);
    }
}

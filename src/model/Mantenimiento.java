package model;

import java.time.LocalDate;

public class Mantenimiento {
	private Vehiculo vehiculo;
	private String tipoMantenimiento;
	private final LocalDate fechaMantenimiento;
	private double costo;
	
	public Mantenimiento(Vehiculo vehiculo, String tipoMantenimiento, double costo) {
		super();
		this.vehiculo = vehiculo;
		this.tipoMantenimiento = tipoMantenimiento;
		this.fechaMantenimiento =LocalDate.now();
		this.costo = costo;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public String getTipoMantenimiento() {
		return tipoMantenimiento;
	}

	public void setTipoMantenimiento(String tipoMantenimiento) {
		this.tipoMantenimiento = tipoMantenimiento;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public LocalDate getFechaMantenimiento() {
		return fechaMantenimiento;
	}

	@Override
	public String toString() {
		return "Mantenimiento [vehiculo=" + vehiculo + ", tipoMantenimiento=" + tipoMantenimiento
				+ ", fechaMantenimiento=" + fechaMantenimiento + ", costo=" + costo + "]";
	}
	
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.time.LocalDate;

public class MantenimientoTest {

    private Mantenimiento mantenimiento;
    private Vehiculo vehiculo;

    @Before
    public void setUp() {
        // Suponiendo que tenemos un Vehiculo para pasar al mantenimiento
        vehiculo = new Automovil("Toyota", "Corolla", "ABC123", "Rojo", 50000, 2019, 4, "Gasolina", "Manual", "Delantera");
        mantenimiento = new Mantenimiento(vehiculo, "Cambio de aceite", 150.00);
    }

    // Test para verificar el vehículo asociado al mantenimiento
    @Test
    public void testGetVehiculo() {
        assertEquals(vehiculo, mantenimiento.getVehiculo());
    }

    // Test para verificar el tipo de mantenimiento
    @Test
    public void testGetTipoMantenimiento() {
        assertEquals("Cambio de aceite", mantenimiento.getTipoMantenimiento());
    }

    // Test para verificar el costo de mantenimiento
    @Test
    public void testGetCosto() {
        assertEquals(150.00, mantenimiento.getCosto(), 0.01);
    }

    // Test para verificar la fecha de mantenimiento
    @Test
    public void testGetFechaMantenimiento() {
        // Verifica que la fecha de mantenimiento sea la fecha actual
        assertEquals(LocalDate.now(), mantenimiento.getFechaMantenimiento());
    }

    // Test para modificar el costo de mantenimiento
    @Test
    public void testSetCosto() {
        mantenimiento.setCosto(200.00);
        assertEquals(200.00, mantenimiento.getCosto(), 0.01);
    }

    // Test para modificar el tipo de mantenimiento
    @Test
    public void testSetTipoMantenimiento() {
        mantenimiento.setTipoMantenimiento("Revisión general");
        assertEquals("Revisión general", mantenimiento.getTipoMantenimiento());
    }
}

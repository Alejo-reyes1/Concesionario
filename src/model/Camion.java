package model;

public class Camion extends Vehiculo implements VentaVehiculo,MantenimientoVehiculo {
	private double capacidadCarga;
	private String tipoCamion;
	private int ruedas;
	private String tipoFreno;
	private int cilindraje;
	
	public Camion(String marca, String modelo, String vIN, String color, int kilometraje, int año,
			double capacidadCarga, String tipoCamion, int ruedas, String tipoFreno, int cilindraje) {
		super(marca, modelo, vIN, color, kilometraje, año);
		this.capacidadCarga = capacidadCarga;
		this.tipoCamion = tipoCamion;
		this.ruedas = ruedas;
		this.tipoFreno = tipoFreno;
		this.cilindraje = cilindraje;
	}

	public double getCapacidadCarga() {
		return capacidadCarga;
	}

	public void setCapacidadCarga(double capacidadCarga) {
		this.capacidadCarga = capacidadCarga;
	}

	public String getTipoCamion() {
		return tipoCamion;
	}

	public void setTipoCamion(String tipoCamion) {
		this.tipoCamion = tipoCamion;
	}

	public int getRuedas() {
		return ruedas;
	}

	public void setRuedas(int ruedas) {
		this.ruedas = ruedas;
	}

	public String getTipoFreno() {
		return tipoFreno;
	}

	public void setTipoFreno(String tipoFreno) {
		this.tipoFreno = tipoFreno;
	}

	public int getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}

	@Override
	public double calcularPrecioVenta(double precioVenta) {
		double precioConComision=(precioVenta*0.15)+precioVenta;
		return precioConComision;
	}

	@Override
	public double calcularPrecioMantenimiento(double precioMantenimiento) {
		double precioConComision=(precioMantenimiento*0.15)+precioMantenimiento;
		return precioConComision;
	}
	
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CamionTest {

    private Camion camion;

    @Before
    public void setUp() {
        // Crear una instancia de Camion antes de cada test
        camion = new Camion("Mercedes", "Actros", "WDB97012345678901", "Blanco", 100000, 2021,
                            8000.5, "Carga pesada", 18, "Neumático de aire", 4500);
    }

    // Test para la clase Vehiculo (heredados)
    @Test
    public void testGetMarca() {
        assertEquals("Mercedes", camion.getMarca());
    }

    @Test
    public void testSetMarca() {
        camion.setMarca("Volvo");
        assertEquals("Volvo", camion.getMarca());
    }

    @Test
    public void testGetModelo() {
        assertEquals("Actros", camion.getModelo());
    }

    @Test
    public void testSetModelo() {
        camion.setModelo("FMX");
        assertEquals("FMX", camion.getModelo());
    }

    @Test
    public void testGetVIN() {
        assertEquals("WDB97012345678901", camion.getVIN());
    }

    @Test
    public void testSetVIN() {
        camion.setVIN("WDB97012345678902");
        assertEquals("WDB97012345678902", camion.getVIN());
    }

    @Test
    public void testGetColor() {
        assertEquals("Blanco", camion.getColor());
    }

    @Test
    public void testSetColor() {
        camion.setColor("Negro");
        assertEquals("Negro", camion.getColor());
    }

    @Test
    public void testGetKilometraje() {
        assertEquals(100000, camion.getKilometraje());
    }

    @Test
    public void testSetKilometraje() {
        camion.setKilometraje(110000);
        assertEquals(110000, camion.getKilometraje());
    }

    @Test
    public void testGetAño() {
        assertEquals(2021, camion.getAño());
    }

    @Test
    public void testSetAño() {
        camion.setAño(2022);
        assertEquals(2022, camion.getAño());
    }

    // Test para la clase Camion
    @Test
    public void testGetCapacidadCarga() {
        assertEquals(8000.5, camion.getCapacidadCarga(), 0.01);
    }

    @Test
    public void testSetCapacidadCarga() {
        camion.setCapacidadCarga(8500.0);
        assertEquals(8500.0, camion.getCapacidadCarga(), 0.01);
    }

    @Test
    public void testGetTipoCamion() {
        assertEquals("Carga pesada", camion.getTipoCamion());
    }

    @Test
    public void testSetTipoCamion() {
        camion.setTipoCamion("Carga ligera");
        assertEquals("Carga ligera", camion.getTipoCamion());
    }

    @Test
    public void testGetRuedas() {
        assertEquals(18, camion.getRuedas());
    }

    @Test
    public void testSetRuedas() {
        camion.setRuedas(22);
        assertEquals(22, camion.getRuedas());
    }

    @Test
    public void testGetTipoFreno() {
        assertEquals("Neumático de aire", camion.getTipoFreno());
    }

    @Test
    public void testSetTipoFreno() {
        camion.setTipoFreno("Hidráulico");
        assertEquals("Hidráulico", camion.getTipoFreno());
    }

    @Test
    public void testGetCilindraje() {
        assertEquals(4500, camion.getCilindraje());
    }

    @Test
    public void testSetCilindraje() {
        camion.setCilindraje(5000);
        assertEquals(5000, camion.getCilindraje());
    }

    // Test para los métodos de las interfaces (VentaVehiculo y MantenimientoVehiculo)
    @Test
    public void testCalcularPrecioVenta() {
        double precioVenta = 20000;
        double precioEsperado = 23000; // 15% de comisión sobre 20000
        assertEquals(precioEsperado, camion.calcularPrecioVenta(precioVenta), 0.01);
    }

    @Test
    public void testCalcularPrecioMantenimiento() {
        double precioMantenimiento = 1000;
        double precioEsperado = 1150; // 15% de comisión sobre 1000
        assertEquals(precioEsperado, camion.calcularPrecioMantenimiento(precioMantenimiento), 0.01);
    }
}

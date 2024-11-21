package model;

public class Automovil extends Vehiculo implements VentaVehiculo,MantenimientoVehiculo {
	private int puertas;
	private String tipoCombustible;
	private String transmision;
	private String traccion;
	
	public Automovil(String marca, String modelo, String vIN, String color, int kilometraje, int año, int puertas,
			String tipoCombustible, String transmision, String traccion) {
		super(marca, modelo, vIN, color, kilometraje, año);
		this.puertas = puertas;
		this.tipoCombustible = tipoCombustible;
		this.transmision = transmision;
		this.traccion = traccion;
	}

	public int getPuertas() {
		return puertas;
	}

	public void setPuertas(int puertas) {
		this.puertas = puertas;
	}

	public String getTipoCombustible() {
		return tipoCombustible;
	}

	public void setTipoCombustible(String tipoCombustible) {
		this.tipoCombustible = tipoCombustible;
	}

	public String getTransmision() {
		return transmision;
	}

	public void setTransmision(String transmision) {
		this.transmision = transmision;
	}

	public String getTraccion() {
		return traccion;
	}

	public void setTraccion(String traccion) {
		this.traccion = traccion;
	}

	@Override
	public double calcularPrecioVenta(double precioVenta) {
		double precioConComision=(precioVenta*0.1)+precioVenta;
		return precioConComision;
	}

	@Override
	public double calcularPrecioMantenimiento(double precioMantenimiento) {
		double precioConComision=(precioMantenimiento*0.1)+precioMantenimiento;
		return precioConComision;
	}
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AutomovilTest {

    private Automovil automovil;

    @Before
    public void setUp() {
        // Crear una instancia de Automovil antes de cada test
        automovil = new Automovil("Toyota", "Corolla", "1HGBH41JXMN109186", "Rojo", 50000, 2020, 4, "Gasolina", "Automática", "Delantera");
    }

    // Test para la clase Vehiculo (heredados)
    @Test
    public void testGetMarca() {
        assertEquals("Toyota", automovil.getMarca());
    }

    @Test
    public void testSetMarca() {
        automovil.setMarca("Honda");
        assertEquals("Honda", automovil.getMarca());
    }

    @Test
    public void testGetModelo() {
        assertEquals("Corolla", automovil.getModelo());
    }

    @Test
    public void testSetModelo() {
        automovil.setModelo("Civic");
        assertEquals("Civic", automovil.getModelo());
    }

    @Test
    public void testGetVIN() {
        assertEquals("1HGBH41JXMN109186", automovil.getVIN());
    }

    @Test
    public void testSetVIN() {
        automovil.setVIN("1HGBH41JXMN109200");
        assertEquals("1HGBH41JXMN109200", automovil.getVIN());
    }

    @Test
    public void testGetColor() {
        assertEquals("Rojo", automovil.getColor());
    }

    @Test
    public void testSetColor() {
        automovil.setColor("Azul");
        assertEquals("Azul", automovil.getColor());
    }

    @Test
    public void testGetKilometraje() {
        assertEquals(50000, automovil.getKilometraje());
    }

    @Test
    public void testSetKilometraje() {
        automovil.setKilometraje(60000);
        assertEquals(60000, automovil.getKilometraje());
    }

    @Test
    public void testGetAño() {
        assertEquals(2020, automovil.getAño());
    }

    @Test
    public void testSetAño() {
        automovil.setAño(2021);
        assertEquals(2021, automovil.getAño());
    }

    // Test para la clase Automovil
    @Test
    public void testGetPuertas() {
        assertEquals(4, automovil.getPuertas());
    }

    @Test
    public void testSetPuertas() {
        automovil.setPuertas(5);
        assertEquals(5, automovil.getPuertas());
    }

    @Test
    public void testGetTipoCombustible() {
        assertEquals("Gasolina", automovil.getTipoCombustible());
    }

    @Test
    public void testSetTipoCombustible() {
        automovil.setTipoCombustible("Diesel");
        assertEquals("Diesel", automovil.getTipoCombustible());
    }

    @Test
    public void testGetTransmision() {
        assertEquals("Automática", automovil.getTransmision());
    }

    @Test
    public void testSetTransmision() {
        automovil.setTransmision("Manual");
        assertEquals("Manual", automovil.getTransmision());
    }

    @Test
    public void testGetTraccion() {
        assertEquals("Delantera", automovil.getTraccion());
    }

    @Test
    public void testSetTraccion() {
        automovil.setTraccion("Trasera");
        assertEquals("Trasera", automovil.getTraccion());
    }

    // Test para los métodos de las interfaces (VentaVehiculo y MantenimientoVehiculo)
    @Test
    public void testCalcularPrecioVenta() {
        double precioVenta = 10000;
        double precioEsperado = 11000; // 10% de comisión sobre 10000
        assertEquals(precioEsperado, automovil.calcularPrecioVenta(precioVenta), 0.01);
    }

    @Test
    public void testCalcularPrecioMantenimiento() {
        double precioMantenimiento = 500;
        double precioEsperado = 550; // 10% de comisión sobre 500
        assertEquals(precioEsperado, automovil.calcularPrecioMantenimiento(precioMantenimiento), 0.01);
    }
}

package model;

public class Motocicleta extends Vehiculo  implements VentaVehiculo,MantenimientoVehiculo{
	private String manillar;
	private int ruedas;
	private String tipoFreno;
	private int numeroEjes;
	
	public Motocicleta(String marca, String modelo, String vIN, String color, int kilometraje, int año, String manillar,
			int ruedas, String tipoFreno, int numeroEjes) {
		super(marca, modelo, vIN, color, kilometraje, año);
		this.manillar = manillar;
		this.ruedas = ruedas;
		this.tipoFreno = tipoFreno;
		this.numeroEjes = numeroEjes;
	}

	public String getManillar() {
		return manillar;
	}

	public void setManillar(String manillar) {
		this.manillar = manillar;
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

	public int getNumeroEjes() {
		return numeroEjes;
	}

	public void setNumeroEjes(int numeroEjes) {
		this.numeroEjes = numeroEjes;
	}

	@Override
	public double calcularPrecioVenta(double precioVenta) {
		double precioConComision=(precioVenta*0.07)+precioVenta;
		return precioConComision;
	}

	@Override
	public double calcularPrecioMantenimiento(double precioMantenimiento) {
		double precioConComision=(precioMantenimiento*0.07)+precioMantenimiento;
		return precioConComision;
	}

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MotocicletaTest {

    private Motocicleta motocicleta;

    @Before
    public void setUp() {
        // Crear una instancia de Motocicleta antes de cada test
        motocicleta = new Motocicleta("Yamaha", "MT-09", "JYARJ15E9GA000000", "Rojo", 20000, 2022,
                                      "Ergonómico", 2, "Disco", 2);
    }

    // Test para la clase Vehiculo (heredados)
    @Test
    public void testGetMarca() {
        assertEquals("Yamaha", motocicleta.getMarca());
    }

    @Test
    public void testSetMarca() {
        motocicleta.setMarca("Kawasaki");
        assertEquals("Kawasaki", motocicleta.getMarca());
    }

    @Test
    public void testGetModelo() {
        assertEquals("MT-09", motocicleta.getModelo());
    }

    @Test
    public void testSetModelo() {
        motocicleta.setModelo("Ninja");
        assertEquals("Ninja", motocicleta.getModelo());
    }

    @Test
    public void testGetVIN() {
        assertEquals("JYARJ15E9GA000000", motocicleta.getVIN());
    }

    @Test
    public void testSetVIN() {
        motocicleta.setVIN("JYARJ15E9GA000001");
        assertEquals("JYARJ15E9GA000001", motocicleta.getVIN());
    }

    @Test
    public void testGetColor() {
        assertEquals("Rojo", motocicleta.getColor());
    }

    @Test
    public void testSetColor() {
        motocicleta.setColor("Azul");
        assertEquals("Azul", motocicleta.getColor());
    }

    @Test
    public void testGetKilometraje() {
        assertEquals(20000, motocicleta.getKilometraje());
    }

    @Test
    public void testSetKilometraje() {
        motocicleta.setKilometraje(25000);
        assertEquals(25000, motocicleta.getKilometraje());
    }

    @Test
    public void testGetAño() {
        assertEquals(2022, motocicleta.getAño());
    }

    @Test
    public void testSetAño() {
        motocicleta.setAño(2023);
        assertEquals(2023, motocicleta.getAño());
    }

    // Test para la clase Motocicleta
    @Test
    public void testGetManillar() {
        assertEquals("Ergonómico", motocicleta.getManillar());
    }

    @Test
    public void testSetManillar() {
        motocicleta.setManillar("De carreras");
        assertEquals("De carreras", motocicleta.getManillar());
    }

    @Test
    public void testGetRuedas() {
        assertEquals(2, motocicleta.getRuedas());
    }

    @Test
    public void testSetRuedas() {
        motocicleta.setRuedas(3);
        assertEquals(3, motocicleta.getRuedas());
    }

    @Test
    public void testGetTipoFreno() {
        assertEquals("Disco", motocicleta.getTipoFreno());
    }

    @Test
    public void testSetTipoFreno() {
        motocicleta.setTipoFreno("Tambor");
        assertEquals("Tambor", motocicleta.getTipoFreno());
    }

    @Test
    public void testGetNumeroEjes() {
        assertEquals(2, motocicleta.getNumeroEjes());
    }

    @Test
    public void testSetNumeroEjes() {
        motocicleta.setNumeroEjes(3);
        assertEquals(3, motocicleta.getNumeroEjes());
    }

    // Test para los métodos de las interfaces (VentaVehiculo y MantenimientoVehiculo)
    @Test
    public void testCalcularPrecioVenta() {
        double precioVenta = 15000;
        double precioEsperado = 16050; // 7% de comisión sobre 15000
        assertEquals(precioEsperado, motocicleta.calcularPrecioVenta(precioVenta), 0.01);
    }

    @Test
    public void testCalcularPrecioMantenimiento() {
        double precioMantenimiento = 500;
        double precioEsperado = 535; // 7% de comisión sobre 500
        assertEquals(precioEsperado, motocicleta.calcularPrecioMantenimiento(precioMantenimiento), 0.01);
    }
}

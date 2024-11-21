package model;

public class Vehiculo{
	private String marca;
	private String modelo;
	private String VIN;
	private String color;
	private int kilometraje;
	private int año;
	public Vehiculo(String marca, String modelo, String vIN, String color, int kilometraje, int año) {
		this.marca = marca;
		this.modelo = modelo;
		this.VIN = vIN;
		this.color = color;
		this.kilometraje = kilometraje;
		this.año = año;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getVIN() {
		return VIN;
	}
	public void setVIN(String vIN) {
		VIN = vIN;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getKilometraje() {
		return kilometraje;
	}
	public void setKilometraje(int kilometraje) {
		this.kilometraje = kilometraje;
	}
	public int getAño() {
		return año;
	}
	public void setAño(int año) {
		this.año = año;
	}
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class VehiculoTest {

    private Vehiculo vehiculo;

    @Before
    public void setUp() {
        // Crear una instancia de Vehiculo antes de cada test
        vehiculo = new Vehiculo("Toyota", "Corolla", "1HGBH41JXMN109186", "Rojo", 50000, 2020);
    }

    @Test
    public void testGetMarca() {
        assertEquals("Toyota", vehiculo.getMarca());
    }

    @Test
    public void testSetMarca() {
        vehiculo.setMarca("Honda");
        assertEquals("Honda", vehiculo.getMarca());
    }

    @Test
    public void testGetModelo() {
        assertEquals("Corolla", vehiculo.getModelo());
    }

    @Test
    public void testSetModelo() {
        vehiculo.setModelo("Civic");
        assertEquals("Civic", vehiculo.getModelo());
    }

    @Test
    public void testGetVIN() {
        assertEquals("1HGBH41JXMN109186", vehiculo.getVIN());
    }

    @Test
    public void testSetVIN() {
        vehiculo.setVIN("1HGBH41JXMN109200");
        assertEquals("1HGBH41JXMN109200", vehiculo.getVIN());
    }

    @Test
    public void testGetColor() {
        assertEquals("Rojo", vehiculo.getColor());
    }

    @Test
    public void testSetColor() {
        vehiculo.setColor("Azul");
        assertEquals("Azul", vehiculo.getColor());
    }

    @Test
    public void testGetKilometraje() {
        assertEquals(50000, vehiculo.getKilometraje());
    }

    @Test
    public void testSetKilometraje() {
        vehiculo.setKilometraje(60000);
        assertEquals(60000, vehiculo.getKilometraje());
    }

    @Test
    public void testGetAño() {
        assertEquals(2020, vehiculo.getAño());
    }

    @Test
    public void testSetAño() {
        vehiculo.setAño(2021);
        assertEquals(2021, vehiculo.getAño());
    }
}

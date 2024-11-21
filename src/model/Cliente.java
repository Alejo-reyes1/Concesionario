package model;

public class Cliente {
	private String nombre;
	private String direccion;
	private String telefono;
	private String correo;
	
	public Cliente(String nombre, String direccion, String telefono, String correo) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correo = correo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + ", correo="
				+ correo + "]";
	}
	
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ClienteTest {

    private Cliente cliente;

    @Before
    public void setUp() {
        // Crear una instancia de Cliente antes de cada test
        cliente = new Cliente("Juan Pérez", "Calle Falsa 123", "555-1234", "juan.perez@example.com");
    }

    // Test para el método getNombre
    @Test
    public void testGetNombre() {
        assertEquals("Juan Pérez", cliente.getNombre());
    }

    // Test para el método setNombre
    @Test
    public void testSetNombre() {
        cliente.setNombre("Carlos López");
        assertEquals("Carlos López", cliente.getNombre());
    }

    // Test para el método getDireccion
    @Test
    public void testGetDireccion() {
        assertEquals("Calle Falsa 123", cliente.getDireccion());
    }

    // Test para el método setDireccion
    @Test
    public void testSetDireccion() {
        cliente.setDireccion("Avenida Siempre Viva 742");
        assertEquals("Avenida Siempre Viva 742", cliente.getDireccion());
    }

    // Test para el método getTelefono
    @Test
    public void testGetTelefono() {
        assertEquals("555-1234", cliente.getTelefono());
    }

    // Test para el método setTelefono
    @Test
    public void testSetTelefono() {
        cliente.setTelefono("555-4321");
        assertEquals("555-4321", cliente.getTelefono());
    }

    // Test para el método getCorreo
    @Test
    public void testGetCorreo() {
        assertEquals("juan.perez@example.com", cliente.getCorreo());
    }

    // Test para el método setCorreo
    @Test
    public void testSetCorreo() {
        cliente.setCorreo("carlos.lopez@example.com");
        assertEquals("carlos.lopez@example.com", cliente.getCorreo());
    }

    // Test para el método toString
    @Test
    public void testToString() {
        String expected = "Cliente [nombre=Juan Pérez, direccion=Calle Falsa 123, telefono=555-1234, correo=juan.perez@example.com]";
        assertEquals(expected, cliente.toString());
    }
}

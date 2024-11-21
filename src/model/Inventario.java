package model;

import java.util.ArrayList;

public class Inventario {
	private ArrayList<Vehiculo>vehiculos;

	public Inventario() {
		this.vehiculos = new ArrayList<>();
	}

	public ArrayList<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}
	
	public void agregarVehiculo(Vehiculo vehiculo) {
		this.vehiculos.add(vehiculo);
	}

import model.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class InventarioTest {
    
    private Inventario inventario;
    private Automovil automovil;
    private Camion camion;
    private Motocicleta motocicleta;

    @Before
    public void setUp() {
        // Crear una instancia de Inventario
        inventario = new Inventario();
        
        // Crear instancias de los vehículos
        automovil = new Automovil("Toyota", "Corolla", "ABC123", "Rojo", 50000, 2019, 4, "Gasolina", "Manual", "Delantera");
        camion = new Camion("Volvo", "FH", "XYZ789", "Azul", 100000, 2018, 20000.0, "Pesado", 12, "ABS", 15000);
        motocicleta = new Motocicleta("Honda", "CBR", "DEF456", "Negra", 20000, 2020, "Deportivo", 2, "Disco", 2);
    }

    @Test
    public void testAgregarVehiculo() {
        // Verificar que el inventario esté vacío inicialmente
        assertEquals(0, inventario.getVehiculos().size());
        
        // Agregar un vehículo
        inventario.agregarVehiculo(automovil);
        
        // Verificar que el vehículo se haya agregado correctamente
        assertEquals(1, inventario.getVehiculos().size());
        assertTrue(inventario.getVehiculos().contains(automovil));
    }

    @Test
    public void testAgregarVariosVehiculos() {
        // Agregar varios vehículos
        inventario.agregarVehiculo(automovil);
        inventario.agregarVehiculo(camion);
        inventario.agregarVehiculo(motocicleta);
        
        // Verificar que los tres vehículos se han agregado correctamente
        assertEquals(3, inventario.getVehiculos().size());
        assertTrue(inventario.getVehiculos().contains(automovil));
        assertTrue(inventario.getVehiculos().contains(camion));
        assertTrue(inventario.getVehiculos().contains(motocicleta));
    }

    @Test
    public void testSetVehiculos() {
        // Crear una lista de vehículos
        ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();
        listaVehiculos.add(automovil);
        listaVehiculos.add(camion);
        
        // Establecer la lista de vehículos en el inventario
        inventario.setVehiculos(listaVehiculos);
        
        // Verificar que la lista se haya establecido correctamente
        assertEquals(2, inventario.getVehiculos().size());
        assertTrue(inventario.getVehiculos().contains(automovil));
        assertTrue(inventario.getVehiculos().contains(camion));
    }
}	

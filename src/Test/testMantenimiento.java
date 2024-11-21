package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import model.Automovil;
import model.Camion;
import model.Cliente;
import model.Concesionario;
import model.Inventario;
import model.Mantenimiento;
import model.MantenimientoVehiculo;
import model.Motocicleta;
import model.Vehiculo;
import model.Venta;

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
    Test para el método toString
    
    @Test
    public void testToString() {
        String expected = "Cliente [nombre=Juan Pérez, direccion=Calle Falsa 123, telefono=555-1234, correo=juan.perez@example.com]";
        assertEquals(expected, cliente.toString());
    }


public class CamionTest<testCalcularPrecioMantenimientoCamion> {

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
        Assert(precioEsperado, camion.calcularPrecioVenta(precioVenta), 0.01);
    }

    private void Assert(double precioEsperado, double calcularPrecioVenta, double d) {
		// TODO Auto-generated method stub
		
	}

	@Test
    public void testCalcularPrecioMantenimiento() {
        double precioMantenimiento = 1000;
        double precioEsperado = 1150; // 15% de comisión sobre 1000
        assertEquals(precioEsperado, Camion.calcularPrecioMantenimiento(precioMantenimiento), 0.01);
    }



    public class ConcesionarioTest {

        private Concesionario concesionario;
        private Cliente cliente;
        private Vehiculo vehiculo;
        private Venta venta;
        private Mantenimiento mantenimiento;

        @Before
        public void setUp() {
            concesionario = new Concesionario("AutoConcesion");
            cliente = new Cliente("Juan Pérez", "Calle 123", "555123456", "juanperez@email.com");
            vehiculo = new Automovil("Toyota", "Corolla", "1234VIN", "Azul", 15000, 2022, 4, "Gasolina", "Manual", "Tracción delantera");
            Venta venta = new Venta(cliente, vehiculo, LocalDate.now(), 20000.0);
            Mantenimiento mantenimiento = new Mantenimiento(vehiculo, LocalDate.now(), "Cambio de aceite", 200.0);
        }

        @Test
        public void testAgregarCliente() {
            assertTrue("El cliente debería ser agregado correctamente", concesionario.agregarCliente(cliente));
        }

        @Test
        public void testEliminarCliente() {
            concesionario.agregarCliente(cliente);
            assertTrue("El cliente debería ser eliminado correctamente", concesionario.eliminarCliente("555123456", "juanperez@email.com"));
            assertFalse("El cliente ya ha sido eliminado", concesionario.eliminarCliente("555123456", "juanperez@email.com"));
        }

        @Test
        public void testBuscarCliente() {
            concesionario.agregarCliente(cliente);
            Cliente encontrado = concesionario.buscarCliente("Juan Pérez", "Calle 123", "555123456");
            assertNotNull("El cliente debería ser encontrado", encontrado);
            assertEquals("El cliente encontrado debería ser el correcto", cliente, encontrado);
        }

        @Test
        public void testAgregarVehiculo() {
            assertTrue("El vehículo debería ser agregado correctamente", concesionario.agregarVehiculo(vehiculo));
        }

        @Test
        public void testEliminarVehiculo() {
            concesionario.agregarVehiculo(vehiculo);
            assertTrue("El vehículo debería ser eliminado correctamente", concesionario.eliminarVehiculo("Toyota", "Corolla"));
            assertFalse("El vehículo ya ha sido eliminado", concesionario.eliminarVehiculo("Toyota", "Corolla"));
        }

        @Test
        public void testBuscarVehiculo() {
            concesionario.agregarVehiculo(vehiculo);
            Vehiculo encontrado = concesionario.buscarVehiculo("Toyota", "Corolla", 1); // 1 para Automovil
            assertNotNull("El vehículo debería ser encontrado", encontrado);
            assertEquals("El vehículo encontrado debería ser el correcto", vehiculo, encontrado);
        }

        @Test
        public void testAgregarVenta() {
            concesionario.agregarCliente(cliente);
            concesionario.agregarVehiculo(vehiculo);
            assertTrue("La venta debería ser agregada correctamente", concesionario.agregarVenta(vehiculo, cliente, venta));
        }

        @Test
        public void testCalcularPrecioVenta() {
            concesionario.agregarVehiculo(vehiculo);
            double precioVentaComision = concesionario.calcularPrecioVenta(1, 20000.0, vehiculo);
            assertEquals("El precio de la venta debería ser calculado correctamente", 20000.0, precioVentaComision, 0.01);
        }

        @Test
        public void testConsultarVentasPorCliente() {
            concesionario.agregarCliente(cliente);
            concesionario.agregarVehiculo(vehiculo);
            concesionario.agregarVenta(vehiculo, cliente, venta);
            String historial = concesionario.consultarVentas(cliente);
            assertTrue("El historial de ventas debería contener la venta realizada", historial.contains("Venta"));
        }

        @Test
        public void testRegistrarMantenimiento() {
            concesionario.agregarVehiculo(vehiculo);
            assertTrue("El mantenimiento debería ser registrado correctamente", concesionario.registrarMantenimiento(mantenimiento));
        }

        @Test
        public void testCalcularPrecioMantenimiento() {
            concesionario.agregarVehiculo(vehiculo);
            double precioMantenimientoComision = concesionario.calcularPrecioMantenimiento(1, 200.0, vehiculo);
            assertEquals("El precio del mantenimiento debería ser calculado correctamente", 200.0, precioMantenimientoComision, 0.01);
        }

        @Test
        public void testConsultarMantenimiento() {
            concesionario.agregarVehiculo(vehiculo);
            concesionario.registrarMantenimiento(mantenimiento);
            String historialMantenimiento = concesionario.consultarMantenimiento(vehiculo);
            assertTrue("El historial de mantenimiento debería contener el mantenimiento registrado", historialMantenimiento.contains("Cambio de aceite"));
        }
        
    

        
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
                Automovil automovil = new Automovil("Toyota", "Corolla", "ABC123", "Rojo", 50000, 2019, 4, "Gasolina", "Manual", "Delantera");
                Camion camion = new Camion("Volvo", "FH", "XYZ789", "Azul", 100000, 2018, 20000.0, "Pesado", 12, "ABS", 15000);
                Motocicleta motocicleta = new Motocicleta("Honda", "CBR", "DEF456", "Negra", 20000, 2020, "Deportivo", 2, "Disco", 2);
            }

            @Test
            public void testAgregarVehiculo() {
                // Verificar que el inventario esté vacío inicialmente
                assertEquals(0, Inventario.getVehiculos().size());
                
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
         
            public class MantenimientoTest {

                private Mantenimiento mantenimiento;
                private Vehiculo vehiculo;

                @Before
                public void setUp() {
                    // Suponiendo que tenemos un Vehiculo para pasar al mantenimiento
                    vehiculo = new Automovil("Toyota", "Corolla", "ABC123", "Rojo", 50000, 2019, 4, "Gasolina", "Manual", "Delantera");
                    mantenimiento = new Mantenimiento(vehiculo, null, "Cambio de aceite", 150.00);
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

                      
                public class MantenimientoVehiculoTest<testCalcularPrecioMantenimientoAutomovil> {

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
                    public <testCalcularPrecioMantenimientoCamion> void testCalcularPrecioMantenimientoCamion() {
                        // Test para Camion (con 15% de aumento)
                        double precioMantenimiento = 200.00;
                        double precioEsperado = precioMantenimiento * 1.15; // 15% de aumento
                        assertEquals(precioEsperado, CamionTest.calcularPrecioMantenimiento(precioMantenimiento), 0.01);
                    }

                    @Test
                    public void testCalcularPrecioMantenimientoMotocicleta() {
                        // Test para Motocicleta (con 7% de aumento)
                        double precioMantenimiento = 50.00;
                        double precioEsperado = precioMantenimiento * 1.07; // 7% de aumento
                        assertEquals(precioEsperado, motocicleta.calcularPrecioMantenimiento(precioMantenimiento), 0.01);
                    }

                   

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
                            assertEquals(precioEsperado, Motocicleta.calcularPrecioMantenimiento(precioMantenimiento), 0.01);
                        }
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
                        
                         
                            public class VentaTest {

                                private Cliente cliente;
                                private Vehiculo vehiculo;
                                private Venta venta;

                                @Before
                                public void setUp() {
                                    // Crear una instancia de Cliente y Vehiculo antes de cada test
                                    cliente = new Cliente("Juan Pérez", "Calle Falsa 123", "555-1234", "juan.perez@example.com");
                                    vehiculo = new Automovil("Toyota", "Corolla", "ABC123", "Rojo", 50000, 2019, 4, "Gasolina", "Manual", "Delantera");
                                    venta = new Venta(cliente, vehiculo, null, 15000.00);
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
                                

                                public class VentaVehiculoTest{

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
                                
                            

	public static double calcularPrecioMantenimiento(double precioMantenimiento) {
		// TODO Auto-generated method stub
		return 0;
	}
}


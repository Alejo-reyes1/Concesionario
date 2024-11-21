package model;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Concesionario {
	private String nombre;
	private ArrayList<Venta>ventas;
	private ArrayList<Cliente>clientes;
	private ArrayList<Vehiculo>inventario;
	private ArrayList<Mantenimiento>mantenimientos;
	
	
	public Concesionario(String nombre) {
		this.nombre=nombre;
		this.ventas = new ArrayList<>();
		this.clientes = new ArrayList<>();
		this.inventario=new ArrayList<>();
		this.mantenimientos=new ArrayList<>();
	}
	
	public ArrayList<Mantenimiento> getMantenimientos() {
		return mantenimientos;
	}

	public void setMantenimientos(ArrayList<Mantenimiento> mantenimientos) {
		this.mantenimientos = mantenimientos;
	}

	public ArrayList<Cliente> getCliente() {
		return clientes;
	}
	public void setCliente(ArrayList<Cliente> cliente) {
		this.clientes = cliente;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Venta> getVentas() {
		return ventas;
	}
	public void setVentas(ArrayList<Venta> ventas) {
		this.ventas = ventas;
	}
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}
	public ArrayList<Vehiculo> getInventario() {
		return inventario;
	}
	public void setInventario(ArrayList<Vehiculo> inventario) {
		this.inventario = inventario;
	}
	//Metodos para gestion de clientes
	public boolean agregarCliente(Cliente cliente) {
		boolean existe=existeEmpleado(cliente);
		if(!existe) {
			this.clientes.add(cliente);
			return true;
		}
		return false;
	}
	private boolean existeEmpleado(Cliente cliente) {
		for(Cliente c:this.clientes) {
			String telefono=cliente.getTelefono();
			String correo=cliente.getCorreo();
			if(c.getCorreo().equalsIgnoreCase(correo)&&c.getTelefono().equalsIgnoreCase(telefono)) {
				return true;
			}
		}
		return false;
	}
	public boolean eliminarCliente(String telefono, String correo) {
		for(Cliente c:this.clientes) {
			if(c.getCorreo().equalsIgnoreCase(correo)&&c.getTelefono().equalsIgnoreCase(telefono)) {
				this.clientes.remove(c);
				return true;
			}
		}
		return false;
	}
	public Cliente buscarCliente(String nombre, String direccion, String telefono) {
		for(Cliente c:this.clientes) {
			if(c.getNombre().equalsIgnoreCase(nombre)||c.getDireccion().equalsIgnoreCase(direccion)||c.getTelefono().equalsIgnoreCase(telefono)) {
				return c;
			}
		}
		return null;
	}
	//Metodos de gestion de vehiculos
	public boolean agregarVehiculo(Vehiculo vehiculo) {
		boolean isExistInventory=vehiculoIsExist(vehiculo);
		if(!isExistInventory) {
			this.inventario.add(vehiculo);
			return true;
		}
		return false;
	}
	private boolean vehiculoIsExist(Vehiculo vehiculo) {
		for(Vehiculo v:this.inventario) {
			String marca=vehiculo.getMarca();
			String modelo=vehiculo.getModelo();
			Class<? extends Vehiculo> tipoVehiculo=vehiculo.getClass();
			if(v.getMarca().equalsIgnoreCase(marca)||v.getModelo().equalsIgnoreCase(modelo)) {
				return true;
			}
		}
		return false;
	}
	public boolean eliminarVehiculo(String marca, String modelo) {
		for(Vehiculo v:this.inventario) {
			if(v.getMarca().equalsIgnoreCase(marca)||v.getModelo().equalsIgnoreCase(modelo)) {
				this.inventario.remove(v);
				return true;
			}
		}
		return false;
	}
	public boolean actualizarInformacionVehiculo(String marca,String modelo) {
		for(Vehiculo v:this.inventario) {
			if(v.getMarca().equalsIgnoreCase(marca)||v.getModelo().equalsIgnoreCase(modelo)) {
				actualizarInformacionBasica(v);
				if(v instanceof Camion) {
					actualizarInformacionCamion(v);
				}else if(v instanceof Motocicleta) {
					actualizarInformacionMotocicleta(v);
					}
				else if(v instanceof Automovil) {
					actualizarInformacionAutomovil(v);
				}
				return true;
			}
		}
		return false;
	}
	public Vehiculo buscarVehiculo(String marca,String modelo,int tipoVehiculo) {
		for(Vehiculo v:this.inventario) {
			if(tipoVehiculo==1) {
				if(v.getMarca().equalsIgnoreCase(marca)&&v.getModelo().equalsIgnoreCase(modelo)&&v instanceof Automovil) {
					return v;
				}
				else if(tipoVehiculo==2) {
					if(v.getMarca().equalsIgnoreCase(marca)&&v.getModelo().equalsIgnoreCase(modelo)&&v instanceof Motocicleta) {
						return v;
					}
					else if(tipoVehiculo==3) {
						if(v.getMarca().equalsIgnoreCase(marca)&&v.getModelo().equalsIgnoreCase(modelo)&&v instanceof Camion) {
							return v;
						}
					}
				}
			}
		}
		return null;
	}
	private void actualizarInformacionAutomovil(Vehiculo v) {
		((Automovil)v).setPuertas(Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de puertas del Automovil")));
		((Automovil)v).setTipoCombistible(JOptionPane.showInputDialog("Ingrese el tipo de combustible del Automovil"));
		((Automovil)v).setTransmision(JOptionPane.showInputDialog("Ingrese el tipo de transmision del Automovil")));
		((Automovil)v).setTraccion(JOptionPane.showInputDialog("Ingrese el tipo de ttracion del Automovil"));
	}
	private void actualizarInformacionMotocicleta(Vehiculo v) {
		((Motocicleta)v).setManillar(JOptionPane.showInputDialog("Ingrese el tipo de manillar de la motocicelta")));
		((Motocicleta)v).setRuedas(Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de ruedas de la mototcicleta")));
		((Motocicleta)v).setTipoFreno(JOptionPane.showInputDialog("Ingrese el tipo de freno de la motocicleta"));
		((Motocicleta)v).setNumeroEjes(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de ejes de la motocicleta")));
	}
	private void actualizarInformacionBasica(Vehiculo v) {
		v.setMarca(JOptionPane.showInputDialog("Ingrese la marca del vehiculo"));
		v.setModelo(JOptionPane.showInputDialog("Ingrese el modelo del vehiculo"));
		v.setVIN(JOptionPane.showInputDialog("Ingrese el VIN del vehiculo"));
		v.setColor(JOptionPane.showInputDialog("Ingrese el color del vehiculo"));
		v.setKilometraje(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el kilometraje del vehiculo")));
		v.setAño(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año del vehiculo")));
	}
	
	private void actualizarInformacionCamion(Vehiculo v) {
		((Camion)v).setCapacidadCarga(Double.parseDouble(JOptionPane.showInputDialog("Ingrese la capacidad de carga del camion")));
		((Camion)v).setTipoCamion(JOptionPane.showInputDialog("Ingrese el tipo de camion"));
		((Camion)v).setRuedas(Integer.parseInt(JOptionPane.showInputDialog("Ingrese las ruedas del camion")));
		((Camion)v).setTipoFreno(JOptionPane.showInputDialog("Ingrese el tipo de freno del camion"));
		((Camion)v).setCilindraje(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el cilindraje del camion")));
	}
	
	//Metodos de gestion de ventas
	public boolean agregarVenta(Vehiculo vehiculo, Cliente cliente,Venta e) {
		boolean existeVenta=existeVenta(cliente,vehiculo);
		if(!existeVenta) {
			this.ventas.add(e);
			return true;
		}
		return false;
		
	}
	private boolean existeVenta(Cliente cliente,Vehiculo vehiculo) {
		for(Venta venta:this.ventas) {
			if(venta.getCliente().equals(cliente)&&venta.getVehiculo().equals(vehiculo)) {
				return true;
			}
		}
		return false;
	}
	//Metodo para calcular la comision de la venta de un vehiculo
	public double calcularPrecioVenta(int tipoVehiculo,double precioVenta,Vehiculo v) {
		double precioVentaComision=0;
		switch(tipoVehiculo) {
		case 1:
			return  precioVentaComision=((Automovil)v).calcularPrecioVenta(precioVenta);
		case 2:
			return  precioVentaComision=((Motocicleta)v).calcularPrecioVenta(precioVenta);
		case 3:
			return  precioVentaComision=((Camion)v).calcularPrecioVenta(precioVenta);
		}
		return precioVentaComision;
	}
	//Polimorfismo de metodo consultar venta
	public String consultarVentas(Cliente cliente) {
		String historialVentas="";
		for(Venta v:this.ventas) {
			if(v.getCliente().equals(cliente)) {
				historialVentas+=v.toString()+"\n";
			}
		}
		return historialVentas;
	}
	public String consultarVentas(Vehiculo vehiculo) {
		String historialVentas="";
		for(Venta v:this.ventas) {
			if(v.getVehiculo().equals(vehiculo)) {
				historialVentas+=v.toString()+"\n";
			}
		}
		return historialVentas;
	}
	public String consultarVenta(LocalDate fechaVenta) {
		String historialVentas="";
		for(Venta v:this.ventas) {
			if(v.getFechaVenta().equals(fechaVenta)) {
				historialVentas+=v.toString()+"\n";
			}
		}
		return historialVentas;
	}
	
	//Metodos de gestion de mantenimineto
	public boolean registrarMantenimiento(Mantenimiento mantenimiento) {
		boolean existeMantenimiento=existeMantenimiento(mantenimiento);
		if(!existeMantenimiento) {
			this.mantenimientos.add(mantenimiento);
			return true;
		}
		return false;
		
		
	}
	private boolean existeMantenimiento(Mantenimiento mantenimiento) {
		for(Mantenimiento m:this.mantenimientos) {
			if(m.equals(mantenimiento)) {
				return true;
			}
		}
		return false;
	}
	public double calcularPrecioMantenimiento(int tipoVehiculo, double precioMantenimiento, Vehiculo v) {
		double precioMantenimientoComision=0;
		switch(tipoVehiculo) {
		case 1:
			return  precioMantenimientoComision=((Automovil)v).calcularPrecioMantenimiento(precioMantenimiento);
		case 2:
			return  precioMantenimientoComision=((Motocicleta)v).calcularPrecioMantenimiento(precioMantenimiento);
		case 3:
			return  precioMantenimientoComision=((Camion)v).calcularPrecioMantenimiento(precioMantenimiento);
		}
		return precioMantenimientoComision;
	}
	public String consultarMantenimiento(Vehiculo v) {
		String mantenimientoVehiculo="";
		for(Mantenimiento m:this.mantenimientos) {
			if(m.getVehiculo().equals(v)) {
				mantenimientoVehiculo+=m.toString()+"\n";
			}
		}
		return mantenimientoVehiculo;
	}

package test;

import model.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.time.LocalDate;

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
        venta = new Venta(cliente, vehiculo, LocalDate.now(), 20000.0);
        mantenimiento = new Mantenimiento(vehiculo, LocalDate.now(), "Cambio de aceite", 200.0);
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
}

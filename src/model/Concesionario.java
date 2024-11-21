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
			if(c.getNombre().equalsIgnoreCase(nombre)&&c.getDireccion().equalsIgnoreCase(direccion)&&c.getTelefono().equalsIgnoreCase(telefono)) {
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
			if(v.getMarca().equalsIgnoreCase(marca)&&v.getModelo().equalsIgnoreCase(modelo)) {
				this.inventario.remove(v);
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
	public void actualizarInformacionVehiculo(Vehiculo v,String nuevoColor,int nuevoKilometraje,int puertas, String tipoCombustible, String transmsion, String traccion) {
		v.setColor(nuevoColor);
		v.setKilometraje(nuevoKilometraje);
		((Automovil)v).setTipoCombustible(tipoCombustible);
		((Automovil)v).setPuertas(puertas);
		((Automovil)v).setTransmision(transmsion);
		((Automovil)v).setTraccion(traccion);
		
		
	}
	public void actualizarInformacionVehiculo(Vehiculo v,String nuevoColor,int nuevoKilometraje,String manillar, int ruedas, String tipoFreno, int numeroEjes ) {
		v.setColor(nuevoColor);
		v.setKilometraje(nuevoKilometraje);
		((Motocicleta)v).setKilometraje(nuevoKilometraje);
		((Motocicleta)v).setManillar(manillar);
		((Motocicleta)v).setRuedas(ruedas);
		((Motocicleta)v).setManillar(manillar);
		((Motocicleta)v).setNumeroEjes(numeroEjes);
	}
	public void actualizarInformacionVehiculo(Vehiculo v,String nuevoColor,int nuevoKilometraje,double capacidadCarga,String tipoCamion,int ruedas, String tipoFreno, int cilindraje) {
		v.setColor(nuevoColor);
		v.setKilometraje(nuevoKilometraje);
		((Camion)v).setCapacidadCarga(capacidadCarga);
		((Camion)v).setTipoCamion(tipoCamion);
		((Camion)v).setRuedas(ruedas);
		((Camion)v).setTipoFreno(tipoFreno);
		((Camion)v).setCilindraje(cilindraje);
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
	//Metodos de gestion de inventario
	public String actualizarInventario() {
		String listaInventario="La lista del inventario del concesionario es\n";
		for(Venta ventas:this.ventas) {
			for(Vehiculo vehiculo:this.inventario) {
				if(ventas.getVehiculo().equals(vehiculo)) {
					listaInventario+="El "+vehiculo.toString()+" fue vendido\n";
				}
				else {
					listaInventario+="El "+vehiculo.toString()+" no ha sido vendido\n";
				}
			}
		}
		return listaInventario;
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
}

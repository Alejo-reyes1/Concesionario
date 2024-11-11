package model;

import java.util.ArrayList;

public class Concesionario {
	private String nombre;
	private ArrayList<Vehiculo>vehiculos;
	private ArrayList<Cliente>clientes;
	private ArrayList<Vehiculo>inventario;
	
	
	public Concesionario(String nombre) {
		this.nombre=nombre;
		this.vehiculos = new ArrayList<>();
		this.clientes = new ArrayList<>();
		this.inventario=new ArrayList<>();
	}
	public ArrayList<Vehiculo> getVehiculos() {
		return vehiculos;
	}
	public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}
	public ArrayList<Cliente> getCliente() {
		return clientes;
	}
	public void setCliente(ArrayList<Cliente> cliente) {
		this.clientes = cliente;
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
}

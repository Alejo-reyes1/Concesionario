package model;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Concesionario {
	private String nombre;
	private ArrayList<Venta>ventas;
	private ArrayList<Cliente>clientes;
	private ArrayList<Vehiculo>inventario;
	
	
	public Concesionario(String nombre) {
		this.nombre=nombre;
		this.ventas = new ArrayList<>();
		this.clientes = new ArrayList<>();
		this.inventario=new ArrayList<>();
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
			Class<? extends Vehiculo> clase = v.getClass();
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
	private void actualizarInformacionAutomovil(Vehiculo v) {
		
	}
	private void actualizarInformacionMotocicleta(Vehiculo v) {
		
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
	
	
	//Metodos de gestion de
}

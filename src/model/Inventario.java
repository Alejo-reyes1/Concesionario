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
	
}

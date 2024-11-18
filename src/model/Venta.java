package model;

import java.time.LocalDate;

public class Venta {
	private Cliente cliente;
	private Vehiculo vehiculo;
	private final LocalDate fechaVenta;
	private double precioVenta;
	
	public Venta(Cliente cliente, Vehiculo vehiculo, double precioVenta) {
		this.cliente = cliente;
		this.vehiculo = vehiculo;
		this.precioVenta = precioVenta;
		this.fechaVenta=LocalDate.now();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public LocalDate getFechaVenta() {
		return fechaVenta;
	}
	
	
	
	

}

package model;

import java.time.LocalDate;

public class Mantenimiento {
	private Vehiculo vehiculo;
	private String tipoMantenimiento;
	private final LocalDate fechaMantenimiento;
	private double costo;
	
	public Mantenimiento(Vehiculo vehiculo, String tipoMantenimiento, double costo) {
		super();
		this.vehiculo = vehiculo;
		this.tipoMantenimiento = tipoMantenimiento;
		this.fechaMantenimiento =LocalDate.now();
		this.costo = costo;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public String getTipoMantenimiento() {
		return tipoMantenimiento;
	}

	public void setTipoMantenimiento(String tipoMantenimiento) {
		this.tipoMantenimiento = tipoMantenimiento;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public LocalDate getFechaMantenimiento() {
		return fechaMantenimiento;
	}

	@Override
	public String toString() {
		return "Mantenimiento [vehiculo=" + vehiculo + ", tipoMantenimiento=" + tipoMantenimiento
				+ ", fechaMantenimiento=" + fechaMantenimiento + ", costo=" + costo + "]";
	}
	
	
	
	
	
	
	

}

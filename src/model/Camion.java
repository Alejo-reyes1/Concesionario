package model;

public class Camion extends Vehiculo {
	private double capacidadCarga;
	private String tipoCamion;
	private int ruedas;
	private String tipoFreno;
	private int cilindraje;
	
	public Camion(String marca, String modelo, String vIN, String color, int kilometraje, int año,
			double capacidadCarga, String tipoCamion, int ruedas, String tipoFreno, int cilindraje) {
		super(marca, modelo, vIN, color, kilometraje, año);
		this.capacidadCarga = capacidadCarga;
		this.tipoCamion = tipoCamion;
		this.ruedas = ruedas;
		this.tipoFreno = tipoFreno;
		this.cilindraje = cilindraje;
	}

	public double getCapacidadCarga() {
		return capacidadCarga;
	}

	public void setCapacidadCarga(double capacidadCarga) {
		this.capacidadCarga = capacidadCarga;
	}

	public String getTipoCamion() {
		return tipoCamion;
	}

	public void setTipoCamion(String tipoCamion) {
		this.tipoCamion = tipoCamion;
	}

	public int getRuedas() {
		return ruedas;
	}

	public void setRuedas(int ruedas) {
		this.ruedas = ruedas;
	}

	public String getTipoFreno() {
		return tipoFreno;
	}

	public void setTipoFreno(String tipoFreno) {
		this.tipoFreno = tipoFreno;
	}

	public int getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}
}

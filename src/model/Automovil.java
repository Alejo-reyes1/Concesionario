package model;

public class Automovil extends Vehiculo {
	private int puertas;
	private String tipoCombustible;
	private String transmision;
	private String traccion;
	
	public Automovil(String marca, String modelo, String vIN, String color, int kilometraje, int año, int puertas,
			String tipoCombustible, String transmision, String traccion) {
		super(marca, modelo, vIN, color, kilometraje, año);
		this.puertas = puertas;
		this.tipoCombustible = tipoCombustible;
		this.transmision = transmision;
		this.traccion = traccion;
	}

	public int getPuertas() {
		return puertas;
	}

	public void setPuertas(int puertas) {
		this.puertas = puertas;
	}

	public String getTipoCombustible() {
		return tipoCombustible;
	}

	public void setTipoCombustible(String tipoCombustible) {
		this.tipoCombustible = tipoCombustible;
	}

	public String getTransmision() {
		return transmision;
	}

	public void setTransmision(String transmision) {
		this.transmision = transmision;
	}

	public String getTraccion() {
		return traccion;
	}

	public void setTraccion(String traccion) {
		this.traccion = traccion;
	}
}

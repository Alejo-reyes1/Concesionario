package model;

public class Vehiculo{
	private String marca;
	private String modelo;
	private String VIN;
	private String color;
	private int kilometraje;
	private int año;
	public Vehiculo(String marca, String modelo, String vIN, String color, int kilometraje, int año) {
		this.marca = marca;
		this.modelo = modelo;
		this.VIN = vIN;
		this.color = color;
		this.kilometraje = kilometraje;
		this.año = año;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getVIN() {
		return VIN;
	}
	public void setVIN(String vIN) {
		VIN = vIN;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getKilometraje() {
		return kilometraje;
	}
	public void setKilometraje(int kilometraje) {
		this.kilometraje = kilometraje;
	}
	public int getAño() {
		return año;
	}
	public void setAño(int año) {
		this.año = año;
	}
}

package model;

public class Motocicleta extends Vehiculo {
	private String manillar;
	private int ruedas;
	private String tipoFreno;
	private int numeroEjes;
	
	public Motocicleta(String marca, String modelo, String vIN, String color, int kilometraje, int año, String manillar,
			int ruedas, String tipoFreno, int numeroEjes) {
		super(marca, modelo, vIN, color, kilometraje, año);
		this.manillar = manillar;
		this.ruedas = ruedas;
		this.tipoFreno = tipoFreno;
		this.numeroEjes = numeroEjes;
	}

	public String getManillar() {
		return manillar;
	}

	public void setManillar(String manillar) {
		this.manillar = manillar;
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

	public int getNumeroEjes() {
		return numeroEjes;
	}

	public void setNumeroEjes(int numeroEjes) {
		this.numeroEjes = numeroEjes;
	}
}

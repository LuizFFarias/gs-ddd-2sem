package br.com.fiap.imunocheck.model.bean;

public class Vacinas {
	private int id;
	private String statusVac;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatusVac() {
		return statusVac;
	}
	public void setStatusVac(String statusVac) {
		this.statusVac = statusVac;
	}
	public Vacinas() {

	}
	public Vacinas(int id, String statusVac) {
		this.id = id;
		this.statusVac = statusVac;
	}
	
	
}

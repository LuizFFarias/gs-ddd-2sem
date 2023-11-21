package br.com.fiap.imunocheck.model.bean;

public class Vacinas {
	private int id;
	private String statusVac;
	private String usuarioVac;
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
	
	public String getUsuarioVac() {
		return usuarioVac;
	}
	public void setUsuarioVac(String usuarioVac) {
		this.usuarioVac = usuarioVac;
	}
	public Vacinas() {

	}
	public Vacinas(int id, String statusVac, String usuarioVac) {
		this.id = id;
		this.statusVac = statusVac;
		this.usuarioVac = usuarioVac;
	}
	
	
}

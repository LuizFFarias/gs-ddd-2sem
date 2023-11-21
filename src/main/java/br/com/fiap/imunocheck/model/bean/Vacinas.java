package br.com.fiap.imunocheck.model.bean;

import jakarta.validation.constraints.NotNull;

public class Vacinas {
	@NotNull
	private int id;
	@NotNull
	private String statusVac;
	@NotNull
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
	public Vacinas(@NotNull int id,@NotNull String statusVac,@NotNull String usuarioVac) {
		this.id = id;
		this.statusVac = statusVac;
		this.usuarioVac = usuarioVac;
	}
	
	
}

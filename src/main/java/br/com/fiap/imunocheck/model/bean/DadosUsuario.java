package br.com.fiap.imunocheck.model.bean;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class DadosUsuario {
	@NotBlank
	private String nome;
	@Positive
	private int idade;
	@NotBlank
	private String estado;
	@NotBlank
	private String usuario;
	@NotBlank
	private String senha;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public DadosUsuario() {
		
	}
	
	
	public DadosUsuario(@NotBlank String nome, @Positive int idade, @NotBlank String estado, @NotBlank String usuario,
			@NotBlank String senha) {
		this.nome = nome;
		this.idade = idade;
		this.estado = estado;
		this.usuario = usuario;
		this.senha = senha;
	}
	
	
	
}

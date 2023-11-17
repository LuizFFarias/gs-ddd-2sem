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
	private String cidade;
	@NotBlank
	private String usuario;
	@NotBlank
	private String senha;
	@NotNull
	private String vacinasTomadas;
	
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
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
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
	
	public String getVacinasTomadas() {
		return vacinasTomadas;
	}
	public void setVacinasTomadas(String vacinasTomadas) {
		this.vacinasTomadas = vacinasTomadas;
	}
	public DadosUsuario() {
		
	}
	
	
	public DadosUsuario(@NotBlank String nome, @Positive int idade, @NotBlank String cidade, @NotBlank String usuario,
			@NotBlank String senha, @NotNull String vacinasTomadas) {
		this.nome = nome;
		this.idade = idade;
		this.cidade = cidade;
		this.usuario = usuario;
		this.senha = senha;
	}
	
	
	
}

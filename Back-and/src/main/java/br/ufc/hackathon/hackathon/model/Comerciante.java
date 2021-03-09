package br.ufc.hackathon.hackathon.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="comerciantes")
public class Comerciante {
	@Id
	@GeneratedValue
	int id;
	String login;
	String senha;
	String nome;
	String endereco;
	String itens;
	String email;
	
	public Comerciante(int id, String login, String senha, String nome, String endereco, String itens, String email) {
		super();
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.nome = nome;
		this.endereco = endereco;
		this.itens = itens;
		this.email = email;
	}
	
	public Comerciante(String login, String senha, String nome, String endereco, String itens, String email) {
		super();
		this.login = login;
		this.senha = senha;
		this.nome = nome;
		this.endereco = endereco;
		this.itens = itens;
		this.email = email;
	}
	
	public Comerciante() {
		super();
		
	}
	
	
	@Override
	public String toString() {
		return "Comerciante [id=" + id + ", login=" + login + ", senha=" + senha + ", nome=" + nome + ", endereco="
				+ endereco + ", itens=" + itens + ", email=" + email + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getItens() {
		return itens;
	}
	public void setItens(String itens) {
		this.itens = itens;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}

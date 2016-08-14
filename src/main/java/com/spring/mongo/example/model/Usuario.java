package com.spring.mongo.example.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usuarios")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	private String nome;
	
	private String email;
	
	private String login;
	
	private String senha;

	private String urlImagemPerfil;

	public Usuario(String id, String nome, String email, String login,
			String senha, String urlImagemPerfil) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.login = login;
		this.senha = senha;
		this.urlImagemPerfil = urlImagemPerfil;
	}

	public Usuario() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getUrlImagemPerfil() {
		return urlImagemPerfil;
	}
	public void setUrlImagemPerfil(String urlImagemPerfil) {
		this.urlImagemPerfil = urlImagemPerfil;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}

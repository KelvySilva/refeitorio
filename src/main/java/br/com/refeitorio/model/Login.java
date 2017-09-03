package br.com.refeitorio.model;

import java.math.BigDecimal;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.refeitorio.validation.ValidationMessages;

@Entity
@Table(name = "login")
public class Login extends User {

	private static final long serialVersionUID = 1L;
	

	@NotNull(message = ValidationMessages.MESSAGE_USERFLEX_NOT_NULL)
	private String username;	
	@NotNull(message = ValidationMessages.MESSAGE_NOME_NOT_NULL)
	private String name;
	@NotNull(message = ValidationMessages.MESSAGE_NOME_NOT_NULL)
	private byte[] password;


	public Login(BigDecimal id, String username, String name, byte[] password) {
		super(id);
		this.username = username;
		this.name = name;
		this.password = password;
	
	}
	
	public Login() {
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getPassword() {
		return password;
	}

	public void setPassword(byte[] password) {
		this.password = password;
	}
	
	
	public String getNameflex() {
		return username;
	}
	
	public void setNameflex(String nameflex) {
		this.username = nameflex;
	}
	
}

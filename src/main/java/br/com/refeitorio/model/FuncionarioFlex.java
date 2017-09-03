package br.com.refeitorio.model;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import br.com.refeitorio.validation.ValidationMessages;

@Entity
@Table(name = "funcionarioflex")
@AttributeOverride(name = "createDate", column = @Column(name = "std_entry_date"))
public class FuncionarioFlex extends User {

	private static final long serialVersionUID = 1L;
	

	@NotNull(message = ValidationMessages.MESSAGE_CODFLEX_NOT_NULL)
	private String codflex;
	@NotNull(message = ValidationMessages.MESSAGE_NAMEFLEX_NOT_NULL)
	private String nameflex;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@CreatedDate
	private Date data;


	public FuncionarioFlex(BigDecimal id, String codflex, String name, Date data) {
		super(id);
		this.codflex = codflex;
		this.nameflex = name;
		this.data = data;
	}
	
	public FuncionarioFlex() {
	
	}


	public String getCodflex() {
		return codflex;
	}
	
	public void setCodflex(String codflex) {
		this.codflex = codflex;
	}
	
	public String getNameflex() {
		return nameflex;
	}
	
	public void setNameflex(String nameflex) {
		this.nameflex = nameflex;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	public Date getData() {
		return data;
	}
	
}

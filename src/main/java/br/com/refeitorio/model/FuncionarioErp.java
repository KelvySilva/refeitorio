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
@Table(name = "funcionarioerp")
@AttributeOverride(name = "createDate", column = @Column(name = "std_entry_date"))
public class FuncionarioErp extends User {

	private static final long serialVersionUID = 1L;
	

	@NotNull(message = ValidationMessages.MESSAGE_CODERP_NOT_NULL)
	private String coderp;
	@NotNull(message = ValidationMessages.MESSAGE_NAMEERP_NOT_NULL)
	private String nameerp;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@CreatedDate
	private Date data;


	public FuncionarioErp(BigDecimal id, String coderp, String nameerp, Date data) {
		super(id);
		this.coderp = coderp;
		this.nameerp = nameerp;
		this.data = data;
	}
	
	public FuncionarioErp() {
	
	}


	public String getCoderp() {
		return coderp;
	}
	
	public void setCoderp(String coderp) {
		this.coderp = coderp;
	}
	
	public String getNameerp() {
		return nameerp;
	}
	
	public void setNameerp(String nameerp) {
		this.nameerp = nameerp;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	public Date getData() {
		return data;
	}
	
}

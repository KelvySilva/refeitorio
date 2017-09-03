package br.com.refeitorio.repository;


import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.refeitorio.model.Funcionario;

public interface FuncionarioRepository extends CrudRepository<Funcionario, BigDecimal>{
	
	public final static String FIND_BY_DATA_QUERY = "SELECT * " + 
            "FROM profile WHERE :data >= current_date";
	
	List<Funcionario> findByData(Date date);
	
}

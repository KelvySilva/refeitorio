package br.com.refeitorio.repository;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;

import br.com.refeitorio.model.FuncionarioFlex;

public interface FuncionarioFlexRepository extends CrudRepository<FuncionarioFlex, BigDecimal>{
	
	public final static String FIND_BY_CODFLEX_QUERY = "SELECT * " + 
            "FROM profile WHERE codflex like :codflex;";
	
	
     FuncionarioFlex findByCodflex(String codflex);

}

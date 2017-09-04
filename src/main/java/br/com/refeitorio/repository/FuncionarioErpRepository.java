package br.com.refeitorio.repository;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;

import br.com.refeitorio.model.FuncionarioErp;

public interface FuncionarioErpRepository extends CrudRepository<FuncionarioErp, BigDecimal>{
	
	public final static String FIND_BY_CODERP_QUERY = "SELECT * " + 
            "FROM profile WHERE coderp like :coderp;";
	
	
     FuncionarioErp findByCoderp(String coderp);

}

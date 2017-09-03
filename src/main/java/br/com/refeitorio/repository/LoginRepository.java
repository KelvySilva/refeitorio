package br.com.refeitorio.repository;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;

import br.com.refeitorio.model.Login;

public interface LoginRepository extends CrudRepository<Login, BigDecimal>{
	
	public final static String FIND_BY_USERNAME_QUERY = "SELECT * " + 
            "FROM profile WHERE username like :username;";
	
	
     Login findByUsername(String username);

}

package com.test.db.test_db.service.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

import com.test.db.test_db.entity.Progetto;
import com.test.db.test_db.service.ProgettoService;

//IMPORT RELATIONS
import com.test.db.test_db.entity.Cliente;

@Service
public class ProgettoBaseService {

	private static NamedParameterJdbcTemplate jdbcTemplate;
	
		@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	


    //CRUD METHODS
    
//CRUD - FIND BY Cliente
    	
	public List<Progetto> findByCliente(Long idCliente) {
		
		String sql = "select * from `Progetto` WHERE `Cliente` = :idCliente";
		
	    SqlParameterSource parameters = new MapSqlParameterSource()
		.addValue("idCliente", idCliente);
	    
	    return jdbcTemplate.query(sql, parameters, new BeanPropertyRowMapper(Progetto.class));
	}
    	
    
    
    
    

    
    /*
     * CUSTOM SERVICES
     * 
     *	These services will be overwritten and implemented in ProgettoService.java
     */
    

}

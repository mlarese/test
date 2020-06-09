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

import com.test.db.test_db.entity.Cliente;
import com.test.db.test_db.service.ClienteService;

//IMPORT RELATIONS
import com.test.db.test_db.entity.Cliente;

@Service
public class ClienteBaseService {

	private static NamedParameterJdbcTemplate jdbcTemplate;
	
		@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	


    //CRUD METHODS
    
    //CRUD - CREATE
    	
	public Cliente insert(Cliente obj) {
		Long id = jdbcTemplate.queryForObject("select max(_id) from `cliente`", new MapSqlParameterSource(), Long.class);
		obj.set_id(id == null ? 1 : id + 1);
		String sql = "INSERT INTO `cliente` (`_id`, `Citta`,`Indirizzo`,`Nazione`,`Provincia`,`RagioneSociale`) VALUES (:id,:Citta,:Indirizzo,:Nazione,:Provincia,:RagioneSociale)";
			SqlParameterSource parameters = new MapSqlParameterSource()
		    .addValue("id", obj.get_id())
			.addValue("Citta", obj.getCitta())
			.addValue("Indirizzo", obj.getIndirizzo())
			.addValue("Nazione", obj.getNazione())
			.addValue("Provincia", obj.getProvincia())
			.addValue("RagioneSociale", obj.getRagioneSociale());
		
		jdbcTemplate.update(sql, parameters);
		return obj;
	}
	
    	
    //CRUD - REMOVE
    
	public void delete(Long id) {
		String sql = "DELETE FROM `Cliente` WHERE `_id`=:id";
		SqlParameterSource parameters = new MapSqlParameterSource()
			.addValue("id", id);
		
		jdbcTemplate.update(sql, parameters);
	}

    	
    //CRUD - GET ONE
    	
	public Cliente get(Long id) {
	    
		String sql = "select * from `Cliente` where `_id` = :id";
		
	    SqlParameterSource parameters = new MapSqlParameterSource()
			.addValue("id", id);
	    
	    return (Cliente) jdbcTemplate.queryForObject(sql, parameters, new BeanPropertyRowMapper(Cliente.class));
	}


    	
        	
    //CRUD - GET LIST
    	
	public List<Cliente> getList() {
	    
		String sql = "select * from `Cliente`";
		
	    SqlParameterSource parameters = new MapSqlParameterSource();
	    return jdbcTemplate.query(sql, parameters, new BeanPropertyRowMapper(Cliente.class));
	    
	    
	}

    	
    //CRUD - EDIT
    	
	public Cliente update(Cliente obj, Long id) {

		String sql = "UPDATE `Cliente` SET `Citta` = :Citta,`Indirizzo` = :Indirizzo,`Nazione` = :Nazione,`Provincia` = :Provincia,`RagioneSociale` = :RagioneSociale  WHERE `_id`=:id";
		SqlParameterSource parameters = new MapSqlParameterSource()
			.addValue("id", id)
			.addValue("Citta", obj.getCitta())
			.addValue("Indirizzo", obj.getIndirizzo())
			.addValue("Nazione", obj.getNazione())
			.addValue("Provincia", obj.getProvincia())
			.addValue("RagioneSociale", obj.getRagioneSociale());
		jdbcTemplate.update(sql, parameters);
	    return obj;
	}
	
    	
    
    
    
    

    
    /*
     * CUSTOM SERVICES
     * 
     *	These services will be overwritten and implemented in ClienteService.java
     */
    

}

package com.test.controller.base;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.ArrayList;
import org.springframework.security.access.annotation.Secured;
import org.springframework.beans.factory.annotation.Autowired;
import com.test.db.test_db.service.ClienteService;
import com.test.db.test_db.entity.Cliente;

//IMPORT RELATIONS
import com.test.db.test_db.entity.Cliente;

public class ClienteBaseController {
    
    @Autowired
	ClienteService clienteService;



//CRUD METHODS


    //CRUD - CREATE
    @Secured({ "ROLE_PRIVATE_USER" })
		@RequestMapping(value = "/cliente", method = RequestMethod.POST, headers = "Accept=application/json")
	public Cliente insert(@RequestBody Cliente obj) {
		Cliente result = clienteService.insert(obj);

	    
		
		return result;
	}

	
    //CRUD - REMOVE
    @Secured({ "ROLE_PRIVATE_USER" })
	@RequestMapping(value = "/cliente/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void delete(@PathVariable("id") Long id) {
		clienteService.delete(id);
	}
	
	
    //CRUD - GET ONE
    @Secured({ "ROLE_PRIVATE_USER" })
	@RequestMapping(value = "/cliente/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Cliente get(@PathVariable Long id) {
		Cliente obj = clienteService.get(id);
		
		
		
		return obj;
	}
	
	
    //CRUD - GET LIST
    @Secured({ "ROLE_PRIVATE_USER" })
	@RequestMapping(value = "/cliente", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Cliente> getList() {
		return clienteService.getList();
	}
	
	

    //CRUD - EDIT
    @Secured({ "ROLE_PRIVATE_USER" })
	@RequestMapping(value = "/cliente/{id}", method = RequestMethod.POST, headers = "Accept=application/json")
	public Cliente update(@RequestBody Cliente obj, @PathVariable("id") Long id) {
		Cliente result = clienteService.update(obj, id);

	    
		
		return result;
	}
	


/*
 * CUSTOM SERVICES
 * 
 *	These services will be overwritten and implemented in  Custom.js
 */


	
}

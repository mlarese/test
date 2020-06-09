package com.test.controller.base;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.ArrayList;
import org.springframework.security.access.annotation.Secured;
import org.springframework.beans.factory.annotation.Autowired;
import com.test.db.test_db.service.ProgettoService;
import com.test.db.test_db.entity.Progetto;

//IMPORT RELATIONS
import com.test.db.test_db.entity.Cliente;

public class ProgettoBaseController {
    
    @Autowired
	ProgettoService progettoService;



//CRUD METHODS


    //CRUD - FIND BY Cliente
    @Secured({ "ROLE_PRIVATE_USER" })
	@RequestMapping(value = "/progetto/findByCliente/{key}", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Progetto> findByCliente(@PathVariable("key") Long idCliente) {
		List<Progetto> list = progettoService.findByCliente(idCliente);
		return list;
	}


/*
 * CUSTOM SERVICES
 * 
 *	These services will be overwritten and implemented in  Custom.js
 */


	
}

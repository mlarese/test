package com.test.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.context.annotation.PropertySource;

import com.test.controller.base.ClienteBaseController;

@RestController
@PropertySource("classpath:${configfile.path}/test.properties")
@RequestMapping(value="${endpoint.api}", headers = "Accept=application/json")
public class ClienteController extends ClienteBaseController {

	//OVERRIDE HERE YOUR CUSTOM CONTROLLER

}

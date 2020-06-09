package com.test.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.context.annotation.PropertySource;

import com.test.controller.base.ProgettoBaseController;

@RestController
@PropertySource("classpath:${configfile.path}/test.properties")
@RequestMapping(value="${endpoint.api}", headers = "Accept=application/json")
public class ProgettoController extends ProgettoBaseController {

	//OVERRIDE HERE YOUR CUSTOM CONTROLLER

}

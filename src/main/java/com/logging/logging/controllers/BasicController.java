package com.logging.logging.controllers;

import com.logging.logging.services.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.RemoteEndpoint;

@RestController
public class BasicController {

    Logger logger = LoggerFactory.getLogger(BasicController.class);
    @Autowired(required = false)
    Service service;

    @Autowired
    Environment env;

    @GetMapping
    public String welcomeMsg(){
       logger.info("Info log");
        return "Welcome user!";
    }

    @GetMapping("/exp2")
    public String exp2() {
            logger.info("Info log");
            return service.servTest();
    }

    @GetMapping("/exp8")
    public String exp8() {
        logger.info("Info log");
        return service.servProd();
    }

    @GetMapping("/get-errors")
    public void getErrors(){
        Error error = new Error("ErrorLog");
        logger.error("This is the error logging " + error);
    }
}

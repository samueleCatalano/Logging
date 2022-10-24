package com.logging.logging.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Service
public class Service {

    @Autowired(required = false)
    Environment env;

    Logger logger = LoggerFactory.getLogger(Service.class);

    public String servTest(){
        try {
            logger.info("Start calculation");
            return "The power of " + env.getProperty("varTest.test") + " for 2 is 4";
        }finally {
            logger.info("End calculation");
        }
    }

    public String servProd(){
        try {
            logger.info("Start calculation");
            return "The power of " + env.getProperty("varProd.prod") + " for 2 is 16";
        }finally {
            logger.info("End calculation");
        }
    }
}

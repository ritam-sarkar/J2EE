package com.sarkar.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Runnermain {
    private static final Logger LOGGER = LogManager.getLogger(Runnermain.class.getName());
    public static void main(String[] args) {

        System.out.println("hello world");
        LOGGER.info("Hello world");
    }
}

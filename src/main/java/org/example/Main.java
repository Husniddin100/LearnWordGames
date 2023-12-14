package org.example;

import org.example.Config.SpringConfig;
import org.example.controller.WordController;
import org.example.databaseUtil.DatabaseUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        DatabaseUtil databaseUtil = (DatabaseUtil) applicationContext.getBean("databaseUtil");
        databaseUtil.createTable();

        WordController wordController = (WordController) applicationContext.getBean("wordController");
        wordController.start();

        
    }
}
package com.softserve.edu;

import java.sql.SQLException;
import java.sql.Statement;

public class Methods{
    public void createDatabase(Statement st) throws SQLException {
        st.execute("create database if not exists cookingbooktest");
    }
    public void createTableUsers(Statement st)throws SQLException{
        st.execute("create table if not exists cookingbooktest.users(" +
                " `id` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `username` VARCHAR(45) NOT NULL,\n" +
                "  `email` VARCHAR(45) NOT NULL,\n" +
                "  `password` VARCHAR(45) NOT NULL,\n" +
                "  `isactive` TINYINT(1) NULL,\n" +
                "  `isadmin` TINYINT(1) NULL,\n" +
                "  PRIMARY KEY (`id`),\n" +
                "  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,\n" +
                "  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE,\n" +
                "  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)");
    }
    public void createTableRecipes(Statement st)throws SQLException{
        st.execute("create table if not exists cookingbooktest.recipes(" +
                "`id` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `name` VARCHAR(45) NOT NULL,\n" +
                "  `composition` VARCHAR(1000) NULL,\n" +
                "  `description` TEXT(20000) NULL,\n" +
                "  `difficulty` INT(10) NULL,\n" +
                "  `time` INT NULL,\n" +
                "  `author` VARCHAR(45),\n" +
                "  PRIMARY KEY (`id`),\n" +
                "  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)");
    }
}

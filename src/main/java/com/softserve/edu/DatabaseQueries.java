package com.softserve.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseQueries {
    private static Connection con = null;
    private static String username = "root";
    private static String password = "root";
    private static String URL = "jdbc:mysql://localhost:3306/cookingbook?serverTimezone=UTC";
    public static void main(String[] args)  throws Exception{

        /*
        * Connection string
        * */////////////////////////////////////////////////////////////////////////
        con = DriverManager.getConnection(URL, username, password);
        if (con != null) {
            System.out.println("Connection Successful! \n");
        } else {
            System.out.println("Connection ERROR \n");
            System.exit(1);
        }
        Statement st = con.createStatement();

/*
        st.execute("create database if not exists cookingbooktest");
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
*/


        /*/////////////////////////////////////////////////////////////////////////////
        * Insert New User
        * */

//        st.execute("Insert into users(username,email,password,isactive,isadmin) " +
//                "values ('ihor2','ihor2@gmail.com','IAmIhor',1,0)");
        //////////////////////////////////////////////////////////////////////////////
        /*
         * Insert New Recipe
         * */

//        st.execute("Insert into recipes(name,composition,description,difficulty,time,author) " +
//                "values ('Easy rice','water,\nrice','very easy to cook rice',1,25,1)");

        //////////////////////////////////////////////////////////////////////////////////
        /*
        * Select all recipes
        * */
        /*
        ResultSet rs = st.executeQuery("select * from recipes");
        int columnCount = rs.getMetaData().getColumnCount();
        while (rs.next()){
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(rs.getString(i)+"\t");
            }
            System.out.println();
        }
        System.out.println();

         *///////////////////////////////////////////////////////////////////////////////////
        /*
         * Select all names of recipes
         * */
 /*
        ResultSet rs = st.executeQuery("select name from recipes");
        int columnCount = rs.getMetaData().getColumnCount();
        while (rs.next()){
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(rs.getString(i)+"\t");
            }
            System.out.println();
        }
        System.out.println();
*/
        ////////////////////////////////////////////////////////////////////////////////////////////
        /*
         * Select all users
         * */
/*

        rs = st.executeQuery("select * from users");
        columnCount = rs.getMetaData().getColumnCount();
        while (rs.next()){
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(rs.getString(i)+"\t");
            }
            System.out.println();
        }
*/

        ////////////////////////////////////////////////////////////////

        /*
        * Update User by himself
        * */
/*

        st.execute("  update users\n" +
                "  set email='newemail@gmail.com',\n" +
                "  password='newpassword'\n" +
                "  where id = 4;");
*/

        ////////////////////////////////////////////////////////////////

        /*
         * Update User by admin
         * */
/*
        st.execute("  update users\n" +
                "  set email='newemail@gmail.com',\n" +
                "  password='newpassword',\n" +
                "  isactive = 0,\n" +
                "  isadmin = 0\n" +
                "  where id = 4;");
        */
        ////////////////////////////////////////////////////////////////////
        /*
         * Update Recipes
         * */
/*

        st.execute("  update recipes\n" +
                "  set name='delicious rise',\n" +
                "  composition='water\n" +
                "  rice',\n" +
                "  description='updated rice',\n" +
                "  difficulty=1,\n" +
                "  time=26\n" +
                "  where id = 3;");

*/
        ////////////////////////////////////////////////////////////////////
        /*
        * Delete user by id
        * */
//        st.execute("delete from users where id =3;");

        ///////////////////////////////////////////////////////////////////

        /*
         * Delete recipe by id
         * */
//        st.execute("delete from recipes where id =3;");

        ///////////////////////////////////////////////////////////////////

        /*
        * Close
        * */

//        if (rs != null) {
//            rs.close();
//        }
        if (st != null) {
            st.close();
        }
        if (con != null) {
            con.close();
        }

        /////////////////////////////////////////////////////////////////////////////////////
        System.out.println();
        System.out.println("DONE");

    }
}

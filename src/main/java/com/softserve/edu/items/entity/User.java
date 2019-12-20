package com.softserve.edu.items.entity;

public class User implements IEntity {


    public static enum UserEntityQueries {
        CREATE(SqlQueries.CREATE,("CREATE TABLE if not exists`users` (\n" +
                "  `id` int(11) NOT NULL AUTO_INCREMENT,\n" +
                "  `username` varchar(45) NOT NULL,\n" +
                "  `email` varchar(45) NOT NULL,\n" +
                "  `password` varchar(45) NOT NULL,\n" +
                "  `isactive` tinyint(1) DEFAULT NULL,\n" +
                "  `isadmin` tinyint(1) DEFAULT NULL,\n" +
                "  PRIMARY KEY (`id`),\n" +
                "  UNIQUE KEY `id_UNIQUE` (`id`),\n" +
                "  UNIQUE KEY `username_UNIQUE` (`username`),\n" +
                "  UNIQUE KEY `email_UNIQUE` (`email`)\n" +
                ");")),
        INSERT(SqlQueries.INSERT, "INSERT INTO users (username,email, password, isactive, isadmin) VALUES ('%s', '%s', '%s','1','0');"),

        GET_ALL(SqlQueries.GET_ALL, "SELECT id, username, email, password, isactive, isadmin FROM users;"),
        GET_ONE_FIELD(SqlQueries.GET_ONE_FIELD, "SELECT %s FROM users;"),
        GET_BY_ID(SqlQueries.GET_BY_ID, "SELECT id, username, email, password, isactive, isadmin FROM users WHERE id = '%s';"),
        GET_BY_FIELD(SqlQueries.GET_BY_FIELD, "SELECT id, username, email, password, isactive, isadmin FROM users WHERE %s = '%s';"),
        UPDATE_BY_ID(SqlQueries.UPDATE_BY_ID, "UPDATE users SET password = '%s', email = '%s' WHERE id = '%s';"),
        UPDATE_BY_FIELD(SqlQueries.UPDATE_BY_FIELD, "UPDATE users SET %s = '%s' WHERE %s = '%s';"),
        DELETE_BY_ID(SqlQueries.DELETE_BY_ID, "DELETE FROM users WHERE id = '%s';"),
        DELETE_BY_FIELD(SqlQueries.DELETE_BY_FIELD, "DELETE FROM users WHERE %s = '%s';");

        //
        private SqlQueries sqlQuery;
        private String query;

        private UserEntityQueries(SqlQueries sqlQuery, String query) {
            this.sqlQuery = sqlQuery;
            this.query = query;
        }
        public SqlQueries getSqlQuery() {
            return sqlQuery;
        }

        @Override
        public String toString() {
            return query;
        }
    }

    private Long id;
    private String username;
    private String email;
    private String password;
    private Integer isactive;
    private Integer isadmin;

    public User(Long id, String username, String email, String password, int isactive, int isadmin) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.isactive = isactive;
        this.isadmin = isadmin;
    }

    public User(Long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.isactive = 1;
        this.isadmin = 0;
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Integer getIsactive() {
        return isactive;
    }

    public Integer getIsadmin() {
        return isadmin;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIsactive(int isactive) {
        this.isactive = isactive;
    }

    public void setIsadmin(int isadmin) {
        this.isadmin = isadmin;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", isactive=" + isactive +
                ", isadmin=" + isadmin +
                '}';
    }
}


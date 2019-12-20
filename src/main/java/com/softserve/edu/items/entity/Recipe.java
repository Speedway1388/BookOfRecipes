package com.softserve.edu.items.entity;

public class Recipe implements IEntity{

    public enum RecipeEntityQueries{
        CREATE(SqlQueries.CREATE,("CREATE TABLE if not exists `recipes` (\n" +
                "  `id` int(11) NOT NULL AUTO_INCREMENT,\n" +
                "  `name` varchar(45) NOT NULL,\n" +
                "  `composition` varchar(1000) DEFAULT NULL,\n" +
                "  `description` mediumtext,\n" +
                "  `difficulty` int(10) DEFAULT NULL,\n" +
                "  `time` int(11) DEFAULT NULL,\n" +
                "  `author` varchar(45) DEFAULT NULL,\n" +
                "  PRIMARY KEY (`id`),\n" +
                "  UNIQUE KEY `id_UNIQUE` (`id`)\n" +
                ");")),
        INSERT(SqlQueries.INSERT, "INSERT INTO recipes (name, composition, description, difficulty, time, author) VALUES ('%s', '%s', '%s', '%s', '%s', '%s')"),
        GET_ALL(SqlQueries.GET_ALL, "SELECT id, name, composition, description, difficulty, time, author FROM recipes;"),
        GET_ONE_FIELD(SqlQueries.GET_ONE_FIELD, "SELECT %s FROM recipes;"),
        GET_BY_ID(SqlQueries.GET_BY_ID, "SELECT id, name, composition, description, difficulty, time, author FROM recipes WHERE id = '%s';"),
        GET_BY_FIELD(SqlQueries.GET_BY_FIELD, "SELECT id, name, composition, description, difficulty, time, author FROM recipes WHERE %s = '%s';"),
        UPDATE_BY_ID(SqlQueries.UPDATE_BY_ID, "UPDATE recipes SET name = '%s', composition = '%s', description = '%s', difficulty = '%s', time = '%s' WHERE id = %s;"),
        UPDATE_BY_FIELD(SqlQueries.UPDATE_BY_FIELD, "UPDATE recipes SET %s = '%s' WHERE %s = '%s';"),
        DELETE_BY_ID(SqlQueries.DELETE_BY_ID, "DELETE FROM recipes WHERE id = %s;"),
        DELETE_BY_FIELD(SqlQueries.DELETE_BY_FIELD, "DELETE FROM recipes WHERE %s = '%s';");
        private SqlQueries sqlQuery;
        private String query;

        private RecipeEntityQueries(SqlQueries sqlQuery, String query) {
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
    private String name;
    private String composition;
    private String description;
    private Integer difficulty;
    private Integer time;
    private Long author;

    public Recipe(Long id,String name, String composition, String description, Integer difficulty, Integer time, Long author) {
        this.id = id;
        this.name = name;
        this.composition = composition;
        this.description = description;
        this.difficulty = difficulty;
        this.time = time;
        this.author = author;
    }
    @Override
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getComposition() {
        return composition;
    }

    public String getDescription() {
        return description;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public Integer getTime() {
        return time;
    }

    public Long getAuthor() {
        return author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", composition='" + composition + '\'' +
                ", description='" + description + '\'' +
                ", difficulty=" + difficulty +
                ", time=" + time +
                ", author=" + author +
                '}';
    }
}

package com.softserve.edu.items.dto;

public class RecipeDto {
    private Long id;
    private String name;
    private String composition;
    private String description;
    private Integer difficulty;
    private Integer time;
    private String authorUsername;

    public RecipeDto(Long id, String name, String composition, String description, Integer difficulty, Integer time, String authorUsername) {
        this.id = id;
        this.name = name;
        this.composition = composition;
        this.description = description;
        this.difficulty = difficulty;
        this.time = time;
        this.authorUsername = authorUsername;
    }

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

    public String getAuthorUsername() {
        return authorUsername;
    }

    public void setId(Long id) {
        this.id = id;
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
}


package com.softserve.edu.items.dto;

import java.util.ArrayList;
import java.util.List;

public class RecipesDto {
//    private String username;
    private List<OneRecipeDto> recipenames;
    private int pageCount;
    private int pageOffset;

//    public RecipesDto(String username, int pageOffset) {
    public RecipesDto(int pageOffset) {
//        this.username = username;
        this.recipenames =new ArrayList<>();
        this.pageCount = recipenames.size()/pageOffset+1;
        this.pageOffset = pageOffset;
    }
//    public RecipesDto(String username, List<String> names, int pageOffset) {
    public RecipesDto(List<OneRecipeDto> names, int pageOffset) {
//        this.username = username;

        this.recipenames = names;
        this.pageCount = names.size()/pageOffset+1;
        this.pageOffset = pageOffset;
    }

//    public String getUsername() {
//        return username;
//    }

    public List<OneRecipeDto> getRecipenames() {
        return recipenames;
    }

    public int getPageCount() {
        return pageCount;
    }

    public int getPageOffset() {
        return pageOffset;
    }

//    public void setUsername(String username) {
//        this.username = username;
//    }

    public void setRecipenames(List<OneRecipeDto> recipenames) {
        this.recipenames = recipenames;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void setPageOffset(int pageOffset) {
        this.pageOffset = pageOffset;
    }
}

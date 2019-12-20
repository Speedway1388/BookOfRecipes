package com.softserve.edu.items.dao;

import com.softserve.edu.items.entity.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipeDao extends ADaoCRUD<Recipe>{
    private final static String ID_USER_FIELDNAME = "author";
    public RecipeDao() {
        super();
        init();
    }

    // TODO Create abstract method in ADao
    protected void init() {
        for (Recipe.RecipeEntityQueries recipeEntityQueries : Recipe.RecipeEntityQueries.values()) {
            sqlQueries.put(recipeEntityQueries.getSqlQuery(), recipeEntityQueries);
        }
    }


    protected Recipe createInstance(List<String> args) {
        int length = args.size();
        return new Recipe(
                (length<1) ? Long.valueOf("0") : Long.valueOf(args.get(0)),
                args.get(1)==null? new String():args.get(1),
                args.get(2)==null? new String():args.get(2),
                args.get(3)==null? new String():args.get(3),
                args.get(4)==null? 0:Integer.valueOf(args.get(4)),
                args.get(5)==null? 0:Integer.valueOf(args.get(5)),
                args.get(6)==null? 0:Long.valueOf(args.get(6)));
    }


    protected List<String> getUpdateFields(Recipe entity) {

        List<String> result = new ArrayList<>();
        List<String> allFields=getFields(entity);
        result.add(0,allFields.get(1));
        result.add(1,allFields.get(2));
        result.add(2,allFields.get(3));
        result.add(3,allFields.get(4));
        result.add(4,allFields.get(5));
        result.add(5,allFields.get(0));
        return result;
    }

    protected List<String> getFields(Recipe entity) {
        List<String> fields=new ArrayList<>();
        fields.add(0,entity.getId().toString());
        fields.add(1,entity.getName());
        fields.add(2,entity.getComposition());
        fields.add(3,entity.getDescription());
        fields.add(4, entity.getDifficulty().toString());
        fields.add(5, entity.getTime().toString());
        fields.add(6, entity.getAuthor().toString());
        return fields;
    }


    @Override
    public String getOneFieldName(String fieldName) {
        return null;
    }

}

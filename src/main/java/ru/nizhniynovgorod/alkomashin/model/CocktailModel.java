package ru.nizhniynovgorod.alkomashin.model;

import lombok.Data;

@Data
public class CocktailModel {

    private Long id;
    private String name;
    private int vol;
    private int price;
    private String strength;
    private String ingredients;
    private String image;
    private String description;


}

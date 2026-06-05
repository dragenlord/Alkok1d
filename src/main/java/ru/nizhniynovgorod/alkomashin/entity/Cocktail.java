package ru.nizhniynovgorod.alkomashin.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
@Table()
@Entity
public class Cocktail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String CocktailName;
    private int vol;
    private int price;
    private int volume;
    private String description;
    private ArrayList<IngredientsEntity> IngredientsList;
    private ArrayList<StepEntity> StepList;

}



package ru.nizhniynovgorod.alkomashin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

import java.util.ArrayList;

@Entity
@Table()
public class StepEntity {

    @Id
    @GeneratedValue()
    private Long id;
    private String description;
    private ArrayList<IngredientsEntity> IngredientsList;


}

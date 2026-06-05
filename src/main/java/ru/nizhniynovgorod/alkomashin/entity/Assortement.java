package ru.nizhniynovgorod.alkomashin.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Table()
@Entity
public class Assortement extends  IdEntity {


    private String name;
    private String description;
    private int price;
    private int count;
    private String image;

}

package ru.nizhniynovgorod.alkomashin.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "assortement", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name")  // 👈 имя ингредиента должно быть уникальным
})
public class Assortement extends IdEntity {

    private String name;
    private String description;
    private int price;
    private int count;
    private String image;

    @ManyToMany(mappedBy = "assortements")
    private List<Cocktail> cocktails = new ArrayList<>();
}
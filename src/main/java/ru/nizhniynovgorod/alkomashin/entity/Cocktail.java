package ru.nizhniynovgorod.alkomashin.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "cocktails")
public class Cocktail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cocktailName;
    private String description;
    private int vol;
    private int price;
    private int volume;
    private int count;
    private String image;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "cocktail_ingredient",  // промежуточная таблица
            joinColumns = @JoinColumn(name = "cocktail_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    private List<Assortement> assortements = new ArrayList<>();

    @OneToMany(mappedBy = "cocktail", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Step> steps = new ArrayList<>();

}
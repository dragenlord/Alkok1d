package ru.nizhniynovgorod.alkomashin.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "steps")
public class Step extends IdEntity {

    private int stepNumber;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cocktail_id")  // 👈 внешний ключ на коктейль
    private Cocktail cocktail;
}
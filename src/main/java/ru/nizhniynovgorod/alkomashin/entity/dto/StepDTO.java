package ru.nizhniynovgorod.alkomashin.entity.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StepDTO extends IdDTO{

    private int stepNumber;
    private String description;
    private String image;

}

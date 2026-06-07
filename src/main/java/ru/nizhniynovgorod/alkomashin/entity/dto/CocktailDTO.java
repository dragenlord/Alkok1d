package ru.nizhniynovgorod.alkomashin.entity.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import ru.nizhniynovgorod.alkomashin.entity.Assortement;
import ru.nizhniynovgorod.alkomashin.entity.Step;

import java.util.List;
@Getter
@Setter
public class CocktailDTO extends IdDTO{
    private String cocktailName;
    private String description;
    private int price;
    private int vol;
    private int volume;
    private int count;
    private MultipartFile image;
    private List<Long> ingredientIds;
    private List<Integer> ingredientAmounts;
    private List<String> stepDescriptions;
    private List<Integer> stepTimes;
    private List<Assortement> ingredients;
    private List<Step> steps;
    private String imageName;
}

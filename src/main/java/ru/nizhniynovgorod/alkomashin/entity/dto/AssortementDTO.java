package ru.nizhniynovgorod.alkomashin.entity.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class AssortementDTO extends IdDTO{

    private String name;
    private String description;
    private int price;
    private int count;
    private MultipartFile image;
    private String imageName;
}

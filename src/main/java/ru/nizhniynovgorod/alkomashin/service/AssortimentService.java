package ru.nizhniynovgorod.alkomashin.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.nizhniynovgorod.alkomashin.entity.Assortement;
import ru.nizhniynovgorod.alkomashin.repository.AssortmentRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class AssortimentService {


    @Value("${upload.path:src/main/resources/static/images/}")
    private String uploadPath;


    private final AssortmentRepository assortmentRepository;

    public AssortimentService(AssortmentRepository assortmentRepository) {
        this.assortmentRepository = assortmentRepository;
    }

    public void SaveAssortiment(String name, String description, int price, int count, MultipartFile imageFile){
        String imageName= null;

        if(imageFile!=null && !imageFile.isEmpty()){
            imageName =imageFile.getOriginalFilename();

        }

        Assortement item = new Assortement();
        item.setName(name);
        item.setDescription(description);
        item.setPrice(price);
        item.setCount(count);
        item.setImage(imageName);
        assortmentRepository.save(item);
    }

    public String saveImage(MultipartFile imageFile,String filename){

        try {

            Path uploadDir = Paths.get(uploadPath);

            if (!Files.exists(uploadDir)) {
                Files.createDirectories(uploadDir);
            }

            String finalFileName;
            if (filename != null && !filename.isEmpty()) {
                finalFileName = filename;
            } else {
                String originalFilename = imageFile.getOriginalFilename();
                String fileExtension = "";
                if (originalFilename != null && originalFilename.contains(".")) {
                    finalFileName = originalFilename.substring(originalFilename.lastIndexOf("."));
                }
                finalFileName = UUID.randomUUID().toString() + fileExtension;
            }
            Path filePath = uploadDir.resolve(finalFileName);
            imageFile.transferTo(filePath);
            return finalFileName;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
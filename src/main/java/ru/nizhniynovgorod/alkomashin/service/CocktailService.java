package ru.nizhniynovgorod.alkomashin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ru.nizhniynovgorod.alkomashin.entity.Assortement;
import ru.nizhniynovgorod.alkomashin.entity.Cocktail;
import ru.nizhniynovgorod.alkomashin.entity.Step;
import ru.nizhniynovgorod.alkomashin.entity.dto.CocktailDTO;
import ru.nizhniynovgorod.alkomashin.repository.AssortmentRepository;
import ru.nizhniynovgorod.alkomashin.repository.CocktailRepository;
import ru.nizhniynovgorod.alkomashin.repository.StepRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CocktailService {

    @Value("${upload.path:src/main/resources/static/images/}")
    private String uploadPath;
    @Autowired
    private final CocktailRepository cocktailRepository;
    @Autowired
    private final StepRepository stepRepository;
    private final AssortmentRepository assortmentRepository;

    public CocktailService(CocktailRepository cocktailRepository, StepRepository stepRepository, AssortmentRepository assortmentRepository) {
        this.cocktailRepository = cocktailRepository;
        this.stepRepository = stepRepository;
        this.assortmentRepository = assortmentRepository;
    }

    @Transactional
    public Long saveCocktail(CocktailDTO cocktailDTO) {
        try {
            // 1. Создаем новый коктейль
            Cocktail cocktail = new Cocktail();
            cocktail.setCocktailName(cocktailDTO.getCocktailName());
            cocktail.setDescription(cocktailDTO.getDescription());
            cocktail.setPrice(cocktailDTO.getPrice());
            cocktail.setVol(cocktailDTO.getVol());
            cocktail.setVolume(cocktailDTO.getVolume());
            cocktail.setCount(cocktailDTO.getCount());

            // 2. Обрабатываем изображение
            if (cocktailDTO.getImage() != null && !cocktailDTO.getImage().isEmpty()) {
                String imageName = saveImage(cocktailDTO.getImage());
                cocktail.setImage(imageName);
            }

            // 3. Добавляем ингредиенты
            if (cocktailDTO.getIngredientIds() != null && !cocktailDTO.getIngredientIds().isEmpty()) {
                List<Assortement> ingredients = new ArrayList<>();
                for (Long ingredientId : cocktailDTO.getIngredientIds()) {
                    assortmentRepository.findById(ingredientId).ifPresent(ingredients::add);
                }
                cocktail.setAssortements(ingredients);
            }

            // 4. Сохраняем коктейль (сначала без шагов, чтобы получить ID)
            Cocktail savedCocktail = cocktailRepository.save(cocktail);

            // 5. Добавляем шаги приготовления
            if (cocktailDTO.getStepDescriptions() != null && !cocktailDTO.getStepDescriptions().isEmpty()) {
                List<Step> steps = new ArrayList<>();
                for (int i = 0; i < cocktailDTO.getStepDescriptions().size(); i++) {
                    Step step = new Step();
                    step.setStepNumber(i + 1);
                    step.setDescription(cocktailDTO.getStepDescriptions().get(i));
                    step.setCocktail(savedCocktail);
                    steps.add(step);
                }
                stepRepository.saveAll(steps);
                savedCocktail.setSteps(steps);
            }

            return savedCocktail.getId();

        } catch (Exception e) {
            throw new RuntimeException("Ошибка при сохранении коктейля: " + e.getMessage(), e);
        }
    }



    public String saveImage(MultipartFile imageFile) {
        try {
            Path uploadDir = Paths.get(uploadPath);

            if (!Files.exists(uploadDir)) {
                Files.createDirectories(uploadDir);
            }

            // Генерируем уникальное имя файла
            String originalFilename = imageFile.getOriginalFilename();
            String fileExtension = "";
            if (originalFilename != null && originalFilename.contains(".")) {
                fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));
            }

            String finalFileName = UUID.randomUUID().toString() + fileExtension;
            Path filePath = uploadDir.resolve(finalFileName);
            imageFile.transferTo(filePath);

            return finalFileName;

        } catch (IOException e) {
            throw new RuntimeException("Ошибка при сохранении изображения: " + e.getMessage(), e);
        }
    }

}

package ru.nizhniynovgorod.alkomashin.controller.AdminPanel;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.nizhniynovgorod.alkomashin.entity.Assortement;
import ru.nizhniynovgorod.alkomashin.entity.dto.AssortementDTO;
import ru.nizhniynovgorod.alkomashin.entity.dto.CocktailDTO;
import ru.nizhniynovgorod.alkomashin.repository.AssortmentRepository;
import ru.nizhniynovgorod.alkomashin.service.AssortimentService;
import ru.nizhniynovgorod.alkomashin.service.CocktailService;

import java.io.IOException;
import java.util.List;


@RequestMapping("/create")
@Controller
public class AdminPanelController {

    @Autowired
    private final CocktailService cocktailService;
    @Autowired
    private AssortimentService assortmentService;
    @Autowired
    private final AssortmentRepository assortmentRepository;


    public AdminPanelController(CocktailService cocktailService, AssortmentRepository assortmentRepository) {
        this.cocktailService = cocktailService;
        this.assortmentRepository = assortmentRepository;
    }

    @GetMapping("/cocktail")
    public String GetNewCocktail(Model model){
        List<Assortement> assortments = assortmentRepository.findAll();
        model.addAttribute("assortments", assortments);
        return "create-cocktail";
    }

    @GetMapping("/assortment")
    public String GetNewAssortment(){
        return "create-assortment";
    }

    @PostMapping("/cocktail")
    public String CreateNewCocktail(@ModelAttribute CocktailDTO cocktailDTO,
                                    @RequestParam(required = false) MultipartFile image,
                                    @RequestParam("ingredientIds") List<Long> ingredientIds,
                                    @RequestParam("ingredientAmounts") List<Integer> ingredientAmounts,
                                    @RequestParam("stepDescriptions") List<String> stepDescriptions,
                                    @RequestParam("stepTimes") List<Integer> stepTimes,
                                    Model model){
        cocktailDTO.setImage(image);
        cocktailDTO.setIngredientIds(ingredientIds);
        cocktailDTO.setIngredientAmounts(ingredientAmounts);
        cocktailDTO.setStepDescriptions(stepDescriptions);
        cocktailDTO.setStepTimes(stepTimes);
        cocktailService.saveCocktail(cocktailDTO);
        model.addAttribute("success", true);
        return "redirect:/main";
    }

    @PostMapping("/assortments")  // ← исправлено с /assortments на /assortment
    public String CreateNewAssortment(
            @ModelAttribute AssortementDTO assortmentDto,
            Model model
    ) throws IOException {
        assortmentService.saveAssortiment(assortmentDto);  // ← сохраняем через DTO
        return "redirect:/main";
    }

}

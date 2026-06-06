package ru.nizhniynovgorod.alkomashin.controller.AdminPanel;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.nizhniynovgorod.alkomashin.entity.Assortement;
import ru.nizhniynovgorod.alkomashin.repository.AssortmentRepository;
import ru.nizhniynovgorod.alkomashin.service.AssortimentService;

import java.util.List;


@RequestMapping("/create")
@Controller
public class AdminPanelController {

    @Autowired
    private AssortimentService assortmentService;
    @Autowired
    private final AssortmentRepository assortmentRepository;

    public AdminPanelController(AssortmentRepository assortmentRepository) {
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

    @GetMapping("/step")
    public String GetNewStep(){
        return "create-step";
    }

    @PostMapping("/cocktail")
    public String CreateNewCocktail(){
        return "redirect:/main";
    }

    @PostMapping("/assortments")
    public String CreateNewAssortment(
            @RequestParam("name") String name,
            @RequestParam(value = "description",required = false) String description,
            @RequestParam("price") int price,
            @RequestParam("count") int count,
            @RequestParam(value = "imageFile", required = false) MultipartFile imageFile,
            Model model
            ){
        String filename = imageFile.getOriginalFilename();

        assortmentService.SaveAssortiment(name,description,price,count,imageFile);
        assortmentService.saveImage(imageFile,filename);
        return "redirect:/main";
    }

    @PostMapping("/Step")
    public String CreateNewStep(){
        return "redirect:/main";
    }

}

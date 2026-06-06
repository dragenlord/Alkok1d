package ru.nizhniynovgorod.alkomashin.controller.printPage;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ru.nizhniynovgorod.alkomashin.entity.Assortement;
import ru.nizhniynovgorod.alkomashin.repository.AssortmentRepository;

import java.util.List;

@AllArgsConstructor
@Controller
public class ShowPage {


    private final AssortmentRepository assortmentRepository;

    @GetMapping("/main")
    public String MainPageController(){
        return "main";
    }

    @GetMapping("/assortment")
    public String showAssortment(Model model) {
        List<Assortement> assortment = assortmentRepository.findAll();
        model.addAttribute("assortment", assortment);
        return "assortment"; // название вашего HTML файла
    }

    @GetMapping("/cocktails")
    public String ShowPageCocktails(){

        return "cocktails";
    }
    @GetMapping("/profile")
    public String ShowPageProfile(){

        return "profile";
    }
 @GetMapping("/level")
    public String ShowPageLevel(){

        return "level";
    }



}

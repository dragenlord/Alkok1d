package ru.nizhniynovgorod.alkomashin.controller.printPage;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import ru.nizhniynovgorod.alkomashin.entity.Assortement;
import ru.nizhniynovgorod.alkomashin.entity.Cocktail;
import ru.nizhniynovgorod.alkomashin.repository.AssortmentRepository;
import ru.nizhniynovgorod.alkomashin.repository.CocktailRepository;

import java.util.List;

@AllArgsConstructor
@Controller
@Component
public class ShowPage {


    private final AssortmentRepository assortmentRepository;
    private final CocktailRepository cocktailRepository;

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
    public String getAllCocktails(Model model) {
        List<Cocktail> cocktails = cocktailRepository.findAll();
        model.addAttribute("cocktails", cocktails);
        return "cocktails";
    }
    @GetMapping("/cocktail/{id}")
    public String getCocktailDetails(@PathVariable Long id, Model model) {
        Cocktail cocktail = cocktailRepository.findById(id).orElse(null);
        model.addAttribute("cocktail", cocktail);
        return "cocktail-details";
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

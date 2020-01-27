package tacos.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tacos.dao.IngredientDAO;
import tacos.dao.TacoDAO;
import tacos.model.Ingredient;
import tacos.model.Taco;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignController {

    @GetMapping
    public String showDesignForm(Model model) {
        for (Ingredient.Type type : Ingredient.Type.values()) {
            String typeName = type.toString().toLowerCase();
            List<Ingredient> typeIngredients = new IngredientDAO().findByType(typeName);
            model.addAttribute(typeName, typeIngredients);
        }
        return "design";
    }

    @PostMapping
    public String processDesign(@RequestParam("name") String name, @RequestParam("ingredients") List<String> ingredients) {
        boolean isInvalidTaco = name.length() < 5 || ingredients.isEmpty();
        if (isInvalidTaco) {
            return "redirect:/design";
        } else {
            IngredientDAO ingredientDAO = new IngredientDAO();
            TacoDAO tacoDAO = new TacoDAO();
            Taco taco = new Taco();
            taco.setName(name);
            taco.setIngredients(ingredients.stream().map(ingredientDAO::findById).collect(Collectors.toList()));
            tacoDAO.insert(taco);
            return "redirect:/orders/current";
        }
    }
}
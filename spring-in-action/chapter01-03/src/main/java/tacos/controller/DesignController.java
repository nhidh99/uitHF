package tacos.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tacos.model.Ingredient;
import tacos.model.Ingredient.Type;
import tacos.model.Taco;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignController {

    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = getAllIngredients();
        for (Type type : Ingredient.Type.values()) {
            String typeName = type.toString().toLowerCase();
            List<Ingredient> typeIngredients = getIngredientsByType(ingredients, type);
            model.addAttribute(typeName, typeIngredients);
        }
        model.addAttribute("taco", new Taco());
        return "design";
    }

    @PostMapping
    public String processDesign(@Valid Taco taco, Errors errors) {
        if (errors.hasErrors()) {
            return "redirect:/design";
        }
        log.info("process design: " + taco);
        return "redirect:/orders/current";
    }

    private List<Ingredient> getAllIngredients() {
        return Arrays.asList(
                new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
                new Ingredient("COTO", "Corn Tortilla", Type.WRAP),
                new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
                new Ingredient("CARN", "Carnitas", Type.PROTEIN),
                new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
                new Ingredient("LETC", "Lettuce", Type.VEGGIES),
                new Ingredient("CHED", "Cheddar", Type.CHEESE),
                new Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
                new Ingredient("SLSA", "Salsa", Ingredient.Type.SAUCE),
                new Ingredient("SRCR", "Sour Cream", Type.SAUCE)
        );
    }

    private List<Ingredient> getIngredientsByType(List<Ingredient> ingredients, Type type) {
        return ingredients.stream().filter(i -> i.getType() == type).collect(Collectors.toList());
    }
}
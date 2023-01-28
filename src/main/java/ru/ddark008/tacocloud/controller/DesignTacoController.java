package ru.ddark008.tacocloud.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import ru.ddark008.tacocloud.model.Ingredient;
import ru.ddark008.tacocloud.model.Ingredient.Type;
import ru.ddark008.tacocloud.model.Taco;
import ru.ddark008.tacocloud.model.TacoOrder;
import ru.ddark008.tacocloud.repository.IngredientRepository;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
@RequiredArgsConstructor
public class DesignTacoController {
    private final IngredientRepository ingredientRepo;

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        Iterable<Ingredient> ingredients = ingredientRepo.findAll();
        Arrays.stream(Type.values()).forEach(type ->
                model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type)));
    }

    @ModelAttribute(name = "tacoOrder")
    public TacoOrder order() {
        return new TacoOrder();
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    @GetMapping
    public String showDesignForm() {
        return "design";
    }

    @PostMapping
    public String processTaco(@Valid Taco taco, Errors errors, @ModelAttribute TacoOrder tacoOrder) {
        if (errors.hasErrors()) {
            return "design";
        }

        tacoOrder.addTaco(taco);
        log.info("Process taco: {}", taco);
        return "redirect:/orders/current";
    }

    private Iterable<Ingredient> filterByType(Iterable<Ingredient> ingredients, Type type) {
        return StreamSupport.stream(ingredients.spliterator(), true)
                .filter(i -> i.getType().equals(type)).collect(Collectors.toList());
    }

}

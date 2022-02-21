package com.example.recipe.controller;

import com.example.recipe.model.Ingredient;
import com.example.recipe.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class IngredientController {
    @Autowired
    IngredientRepository repo;

    @PostMapping("/ingredients")
    @ResponseStatus(HttpStatus.CREATED)
    public Ingredient addIngredient(@RequestBody Ingredient ingredient) {
        return repo.save(ingredient);
    }

    @GetMapping("/ingredients/{id}")
    public Ingredient getIngrdient(@PathVariable Integer id) {
        Optional<Ingredient> returnVal = repo.findById(id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }

    @GetMapping("/ingredients/recipe/{id}")
    public List<Ingredient> getIngredientsByRecipe(@PathVariable Integer id) {
        return repo.findAllIngredientsByRecipeId(id);
    }

    @PutMapping("/ingredients")
    public void updateIngredient(@RequestBody Ingredient ingredient) {
        repo.save(ingredient);
    }

    @DeleteMapping("/ingredients/{id}")
    public void deleteIngredient(@PathVariable Integer id) {
        repo.deleteById(id);
    }
}

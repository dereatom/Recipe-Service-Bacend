package com.example.recipe.repository;

import com.example.recipe.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
    public List<Ingredient> findAllIngredientsByRecipeId(Integer recipeId);
}

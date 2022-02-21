package com.example.recipe.controller;

import com.example.recipe.model.Ingredient;
import com.example.recipe.model.PrepStep;
import com.example.recipe.model.Rating;
import com.example.recipe.model.Recipe;
import com.example.recipe.repository.IngredientRepository;
import com.example.recipe.repository.PrepStepRepository;
import com.example.recipe.repository.RatingRepository;
import com.example.recipe.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
public class DataLoaderController {

    @Autowired
    RecipeRepository recipeRepo;
    @Autowired
    IngredientRepository ingredientRepo;
    @Autowired
    PrepStepRepository prepStepRepo;
    @Autowired
    RatingRepository ratingRepo;

    public DataLoaderController(RecipeRepository recipeRepo,
                                IngredientRepository ingredientRepo,
                                PrepStepRepository prepStepRepo,
                                RatingRepository ratingRepo) {
        this.recipeRepo = recipeRepo;
        this.ingredientRepo = ingredientRepo;
        this.prepStepRepo = prepStepRepo;
        this.ratingRepo = ratingRepo;
    }

    @RequestMapping(value = "/load-data", method = RequestMethod.GET)
    public void loadData() {
        Recipe recipe = new Recipe();
        recipe.setTitle("Beef Stew");
        recipe.setCategory("Omnivore");
        recipe.setCookTime("2 hours");
        recipe.setDescription("A great stew for a chilly fall day.");
        recipe.setServings(10);

        Ingredient ingredient = new Ingredient();
        ingredient.setDescription("Tenderized beef tips");
        ingredient.setName("Beef Tips");
        ingredient.setAmount("8 oz.");
        Set<Ingredient> ingredientSet= new HashSet<>();
        ingredientSet.add(ingredient);
        recipe.setIngredients(ingredientSet);

        PrepStep step = new PrepStep();
        step.setStepNumber(1);
        step.setPrepStepText("Brown the beef tips in a skillet.");
        Set<PrepStep> steps = new HashSet<>();
        steps.add(step);
        recipe.setPrepSteps(steps);

        Rating rating = new Rating();
        rating.setRatingText("This is a great recipe!");
        rating.setRecommended(true);
        rating.setNumStars(5);
        Set<Rating> ratings = new HashSet<>();
        ratings.add(rating);
        recipe.setRatings(ratings);

        recipe = recipeRepo.save(recipe);

        System.out.println("RECIPE ID = " + recipe.getRecipeId());
    }

}

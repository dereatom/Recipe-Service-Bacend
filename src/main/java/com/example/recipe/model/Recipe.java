package com.example.recipe.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="recipe")
public class Recipe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer recipeId;
    private String title;
    private String category;
    private String description;
    private String prepTime;
    private String cookTime;
    private Integer servings;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "recipeId")
    private Set<PrepStep> prepSteps = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "recipeId")
    private Set<Ingredient> ingredients = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "recipeId")
    private Set<Rating> ratings = new HashSet<>();

    public Recipe() {
    }
    
    public Integer getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Integer recipeId) {
        this.recipeId = recipeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(String prepTime) {
        this.prepTime = prepTime;
    }

    public String getCookTime() {
        return cookTime;
    }

    public void setCookTime(String cookTime) {
        this.cookTime = cookTime;
    }

    public Integer getServings() {
        return servings;
    }

    public void setServings(Integer servings) {
        this.servings = servings;
    }

    public Set<PrepStep> getPrepSteps() {
        return prepSteps;
    }

    public void setPrepSteps(Set<PrepStep> prepSteps) {
        this.prepSteps = prepSteps;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Set<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(Set<Rating> ratings) {
        this.ratings = ratings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return Objects.equals(getRecipeId(), recipe.getRecipeId()) && Objects.equals(getTitle(), recipe.getTitle()) && Objects.equals(getCategory(), recipe.getCategory()) && Objects.equals(getDescription(), recipe.getDescription()) && Objects.equals(getPrepTime(), recipe.getPrepTime()) && Objects.equals(getCookTime(), recipe.getCookTime()) && Objects.equals(getServings(), recipe.getServings()) && Objects.equals(getPrepSteps(), recipe.getPrepSteps()) && Objects.equals(getIngredients(), recipe.getIngredients()) && Objects.equals(getRatings(), recipe.getRatings());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRecipeId(), getTitle(), getCategory(), getDescription(), getPrepTime(), getCookTime(), getServings(), getPrepSteps(), getIngredients(), getRatings());
    }
}

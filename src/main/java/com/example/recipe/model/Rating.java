package com.example.recipe.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "rating")
public class Rating implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ratingId;
    private Integer recipeId;
    private Boolean isRecommended;
    private Integer numStars;
    private String ratingText;

    public Rating() {
    }

    public Rating(Integer ratingId, Integer recipeId, Boolean isRecommended, Integer numStars, String ratingText) {
        this.ratingId = ratingId;
        this.recipeId = recipeId;
        this.isRecommended = isRecommended;
        this.numStars = numStars;
        this.ratingText = ratingText;
    }

    public Integer getRatingId() {
        return ratingId;
    }

    public void setRatingId(Integer ratingId) {
        this.ratingId = ratingId;
    }

    public Integer getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Integer recipeId) {
        this.recipeId = recipeId;
    }

    public Boolean getRecommended() {
        return isRecommended;
    }

    public void setRecommended(Boolean recommended) {
        isRecommended = recommended;
    }

    public Integer getNumStars() {
        return numStars;
    }

    public void setNumStars(Integer numStars) {
        this.numStars = numStars;
    }

    public String getRatingText() {
        return ratingText;
    }

    public void setRatingText(String ratingText) {
        this.ratingText = ratingText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rating rating1 = (Rating) o;
        return Objects.equals(getRatingId(), rating1.getRatingId()) && Objects.equals(getRecipeId(), rating1.getRecipeId()) && Objects.equals(isRecommended, rating1.isRecommended) && Objects.equals(getNumStars(), rating1.getNumStars()) && Objects.equals(getRatingText(), rating1.getRatingText());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRatingId(), getRecipeId(), isRecommended, getNumStars(), getRatingText());
    }
}

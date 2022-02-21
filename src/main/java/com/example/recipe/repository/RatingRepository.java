package com.example.recipe.repository;

import com.example.recipe.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {
    List<Rating> findAllRatingsByRecipeId(Integer recipeId);
}

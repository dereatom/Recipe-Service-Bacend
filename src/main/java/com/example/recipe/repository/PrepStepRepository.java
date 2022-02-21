package com.example.recipe.repository;


import com.example.recipe.model.PrepStep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrepStepRepository extends JpaRepository<PrepStep, Integer> {
    List<PrepStep> findAllPrepStepsByRecipeId(Integer recipeId);


}

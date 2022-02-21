package com.example.recipe.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "prep_step")
public class PrepStep implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer prepStepId;
    private Integer recipeId;
    private Integer stepNumber;
    private String prepStepText;

    public PrepStep() {
    }

    public PrepStep(Integer prepStepId, Integer recipeId, Integer stepNumber, String prepStepText) {
        this.prepStepId = prepStepId;
        this.recipeId = recipeId;
        this.stepNumber = stepNumber;
        this.prepStepText = prepStepText;
    }

    public Integer getPrepStepId() {
        return prepStepId;
    }

    public void setPrepStepId(Integer prepStepId) {
        this.prepStepId = prepStepId;
    }

    public Integer getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Integer recipeId) {
        this.recipeId = recipeId;
    }

    public Integer getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(Integer stepNumber) {
        this.stepNumber = stepNumber;
    }

    public String getPrepStepText() {
        return prepStepText;
    }

    public void setPrepStepText(String prepStepText) {
        this.prepStepText = prepStepText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrepStep prepStep = (PrepStep) o;
        return Objects.equals(getPrepStepId(), prepStep.getPrepStepId()) && Objects.equals(getRecipeId(), prepStep.getRecipeId()) && Objects.equals(getStepNumber(), prepStep.getStepNumber()) && Objects.equals(getPrepStepText(), prepStep.getPrepStepText());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPrepStepId(), getRecipeId(), getStepNumber(), getPrepStepText());
    }
}

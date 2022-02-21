package com.example.recipe.controller;

import com.example.recipe.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RatingController {
    @Autowired
    RatingRepository repo;

}

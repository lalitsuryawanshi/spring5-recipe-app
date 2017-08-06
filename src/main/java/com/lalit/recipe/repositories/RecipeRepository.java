package com.lalit.recipe.repositories;

import org.springframework.data.repository.CrudRepository;

import com.lalit.recipe.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}

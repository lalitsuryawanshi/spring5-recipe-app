package com.lalit.recipe.services;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.lalit.recipe.commands.RecipeCommand;
import com.lalit.recipe.domain.Recipe;

@Service
public interface RecipeService {
	
	Set<Recipe> getRecipes();

	Recipe findById(long l);

	RecipeCommand saveRecipeCommand(RecipeCommand command);

}

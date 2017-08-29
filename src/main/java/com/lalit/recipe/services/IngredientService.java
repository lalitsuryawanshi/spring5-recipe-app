package com.lalit.recipe.services;

import org.springframework.stereotype.Service;

import com.lalit.recipe.commands.IngredientCommand;

@Service
public interface IngredientService {
	
	IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);

}

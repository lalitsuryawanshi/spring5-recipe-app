package com.lalit.recipe.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.lalit.recipe.commands.RecipeCommand;
import com.lalit.recipe.domain.Recipe;

import lombok.Synchronized;

@Component
public class RecipeToRecipeCommand implements Converter<Recipe, RecipeCommand> {

	private final NotesToNotesCommand notesConverter;
	private final CategoryToCategoryCommand categoryConverter;
	private final IngredientToIngredientCommand ingredientConverter;
	
	public RecipeToRecipeCommand(NotesToNotesCommand notesConverter, CategoryToCategoryCommand categoryConverter,
			IngredientToIngredientCommand ingredientConverter) {
		this.notesConverter = notesConverter;
		this.categoryConverter = categoryConverter;
		this.ingredientConverter = ingredientConverter;
	}

	@Synchronized
	@Nullable
	@Override
	public RecipeCommand convert(Recipe source) {

		if (source == null) {
			return null;
		}
		
		final RecipeCommand recipeCommand = new RecipeCommand();
		recipeCommand.setCookTime(source.getCookTime());
		recipeCommand.setDescription(source.getDescription());
		recipeCommand.setDifficulty(source.getDifficulty());
		recipeCommand.setDirections(source.getDirections());
		recipeCommand.setId(source.getId());
		recipeCommand.setNotes(notesConverter.convert(source.getNotes()));
		recipeCommand.setPrepTime(source.getPrepTime());
		recipeCommand.setServings(source.getServings());
		recipeCommand.setSource(source.getSource());
		recipeCommand.setUrl(source.getUrl());
		//Categories
		if (source.getCategories() != null && source.getCategories().size() > 0){
			
            source.getCategories().forEach ( 
            				category -> recipeCommand.getCategories().add(categoryConverter.convert(category))
                	  );
        }
		//Ingredients
		if (source.getIngredients() != null && source.getIngredients().size() > 0) {
			
			source.getIngredients().forEach(
						ingredient -> recipeCommand.getIngredients().add(ingredientConverter.convert(ingredient))
				  );
		}
		
		return recipeCommand;
	}

}

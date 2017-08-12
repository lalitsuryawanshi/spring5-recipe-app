package com.lalit.recipe.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.lalit.recipe.commands.RecipeCommand;
import com.lalit.recipe.domain.Recipe;

import lombok.Synchronized;

@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {

	private final NotesCommandToNotes notesConverter;
	private final CategoryCommandToCategory categoryConveter;
	private final IngredientCommandToIngredient ingredientConverter;
	
	public RecipeCommandToRecipe(NotesCommandToNotes notesConverter, CategoryCommandToCategory categoryConveter,
			IngredientCommandToIngredient ingredientConverter) {
		this.notesConverter = notesConverter;
		this.categoryConveter = categoryConveter;
		this.ingredientConverter = ingredientConverter;
	}



	@Synchronized
	@Nullable
	@Override
	public Recipe convert(RecipeCommand source) {
		
		if(source == null) {
			return null;
		}
		
		final Recipe recipe = new Recipe();
		
		recipe.setCookTime(source.getCookTime());
		recipe.setDescription(source.getDescription());
		recipe.setDifficulty(source.getDifficulty());
		recipe.setDirections(source.getDirections());
		recipe.setId(source.getId());
		recipe.setNotes(notesConverter.convert(source.getNotes()));
		recipe.setPrepTime(source.getPrepTime());
		recipe.setServings(source.getServings());
		recipe.setSource(source.getSource());
		recipe.setUrl(source.getUrl());
	
		//Category
		if (source.getCategories() != null && source.getCategories().size() > 0){
			
            source.getCategories().forEach ( 
            				category -> recipe.getCategories().add(categoryConveter.convert(category))
                	  );
        }
		
		//Ingredient
		if (source.getIngredients() != null && source.getIngredients().size() > 0) {
			
			source.getIngredients().forEach(
						ingredient -> recipe.getIngredients().add(ingredientConverter.convert(ingredient))
					);
		}
		
		return recipe;
	}

}

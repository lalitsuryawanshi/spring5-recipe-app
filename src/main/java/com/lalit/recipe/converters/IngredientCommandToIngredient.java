package com.lalit.recipe.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.lalit.recipe.commands.IngredientCommand;
import com.lalit.recipe.domain.Ingredient;

import lombok.Synchronized;


@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient>{

	private final UnitOfMeasureCommandToUnitOfMeasure uomConverter;
	
	public IngredientCommandToIngredient(UnitOfMeasureCommandToUnitOfMeasure uomConverter) {
		this.uomConverter = uomConverter;
	}

	@Synchronized
	@Nullable
	@Override
	public Ingredient convert(IngredientCommand source) {
		
		if (source == null) {
			return null;
		}
		
		final Ingredient ingredient = new Ingredient();
		ingredient.setAmount(source.getAmount());
		ingredient.setDescription(source.getDescription());
		ingredient.setId(source.getId());
		ingredient.setUom(uomConverter.convert(source.getUom()));
		
		return ingredient;
	}

}

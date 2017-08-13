package com.lalit.recipe.converters;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.lalit.recipe.commands.IngredientCommand;
import com.lalit.recipe.domain.Ingredient;
import com.lalit.recipe.domain.Recipe;
import com.lalit.recipe.domain.UnitOfMeasure;

public class IngredientToIngredientCommandTest {

	private static final Long ID_VALUE = new Long(1L);
	private static final Recipe RECIPE = new Recipe();
	private static final BigDecimal AMOUNT = new BigDecimal("1");
	private static final String DESCRIPTION = "CheeseBurger";
	private static final Long UOM_ID = new Long(2L);
	
	IngredientToIngredientCommand converter;
	
	@Before
	public void setUp() throws Exception {
		converter = new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
	}

	@Test
	public void testNullConvert() throws Exception {
		assertNull(converter.convert(null));
	}
	
	@Test
	public void testEmptyObject() throws Exception {
		assertNotNull(converter.convert(new Ingredient()));
	}
	
	@Test
	public void testConvertNullUOM() throws Exception {
		//given
		Ingredient ingredient = new Ingredient();
		ingredient.setId(ID_VALUE);
		ingredient.setRecipe(RECIPE);
		ingredient.setAmount(AMOUNT);
		ingredient.setDescription(DESCRIPTION);
		ingredient.setUom(null);
		
		//when
		IngredientCommand ingredientCommand = converter.convert(ingredient);
		
		//then
		assertNull(ingredientCommand.getUom());
		assertEquals(ID_VALUE, ingredientCommand.getId());
		//assertEquals(RECIPE, ingredientCommand.getDescription());
		assertEquals(AMOUNT, ingredientCommand.getAmount());
		assertEquals(DESCRIPTION, ingredientCommand.getDescription());
	}
	
	@Test
	public void testConvertWithUom() throws Exception {
		//given
		Ingredient ingredient = new Ingredient();
		ingredient.setId(ID_VALUE);
		ingredient.setRecipe(RECIPE);
		ingredient.setAmount(AMOUNT);
		ingredient.setDescription(DESCRIPTION);
		
		UnitOfMeasure uom = new UnitOfMeasure();
		uom.setId(UOM_ID);
		
		ingredient.setUom(uom);
		
		//when
		IngredientCommand ingredientCommand = converter.convert(ingredient);
		
		//then
		//assertNull(ingredientCommand.getUom());
		assertEquals(ID_VALUE, ingredientCommand.getId());
		assertNotNull(ingredientCommand.getUom());
		assertEquals(UOM_ID, ingredientCommand.getUom().getId());
		//assertEquals(RECIPE, ingredientCommand.getDescription());
		assertEquals(AMOUNT, ingredientCommand.getAmount());
		assertEquals(DESCRIPTION, ingredientCommand.getDescription());
	}


}

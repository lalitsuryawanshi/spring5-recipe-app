package com.lalit.recipe.converters;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.lalit.recipe.commands.IngredientCommand;
import com.lalit.recipe.commands.UnitOfMeasureCommand;
import com.lalit.recipe.domain.Ingredient;
import com.lalit.recipe.domain.Recipe;

public class IngredientCommandToIngredientTest {

	public static final Long ID_VALUE = new Long(1L);
	public static final BigDecimal AMOUNT = new BigDecimal("1");
	public static final String DESCRIPTION = "CheeseBurger";
	public static final Long UOM_ID = new Long(2L);
	public static final Recipe RECIPE = new Recipe(); 
	
	IngredientCommandToIngredient converter;
	
	@Before
	public void setUp() throws Exception {
		converter = new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure());
	}

	@Test
	public void testNullObject() throws Exception {
		assertNull(converter.convert(null));
	}
	
	@Test
	public void testEmptyObject() throws Exception {
		assertNotNull(converter.convert(new IngredientCommand()));
	}
	
	@Test
	public void convert() throws Exception {
		//given
		IngredientCommand command = new IngredientCommand();
		command.setId(ID_VALUE);
		command.setAmount(AMOUNT);
		command.setDescription(DESCRIPTION);
		UnitOfMeasureCommand uomCommand = new UnitOfMeasureCommand();
		uomCommand.setId(UOM_ID);
		command.setUom(uomCommand);
		
		//when
		Ingredient ingredient = converter.convert(command);
		
		//then
		assertNotNull(ingredient);
		assertNotNull(ingredient.getUom());
		assertEquals(ID_VALUE, ingredient.getId());
		assertEquals(AMOUNT, ingredient.getAmount());
		assertEquals(DESCRIPTION, ingredient.getDescription());
		assertEquals(UOM_ID, ingredient.getUom().getId());
	}
	
	@Test
	public void convertWithNullUOM() throws Exception {
		//given
		IngredientCommand command = new IngredientCommand();
		command.setId(ID_VALUE);
		command.setAmount(AMOUNT);
		command.setDescription(DESCRIPTION);
		//UnitOfMeasureCommand uomCommand = new UnitOfMeasureCommand();
		
		//when
		Ingredient ingredient = converter.convert(command);
		
		//then
		assertNotNull(ingredient);
		assertNull(ingredient.getUom());
		assertEquals(ID_VALUE, ingredient.getId());
		assertEquals(AMOUNT, ingredient.getAmount());
		assertEquals(DESCRIPTION, ingredient.getDescription());
	}

}

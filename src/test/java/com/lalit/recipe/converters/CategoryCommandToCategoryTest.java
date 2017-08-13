package com.lalit.recipe.converters;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.lalit.recipe.commands.CategoryCommand;
import com.lalit.recipe.domain.Category;

public class CategoryCommandToCategoryTest {

	private static final Long ID_VALUE = new Long(1L);
	private static final String DESCRIPTION = "description";
	CategoryCommandToCategory converter;
	
	@Before
	public void setUp() throws Exception {
		converter = new CategoryCommandToCategory();
	}

	@Test
	public void testNullObject() throws Exception {
		assertNull(converter.convert(null));
	}
	
	@Test
	public void convert() throws Exception {
		//given
		CategoryCommand categoryCommand = new CategoryCommand();
		categoryCommand.setId(ID_VALUE);
		categoryCommand.setDescription(DESCRIPTION);
		
		//when
		Category category = converter.convert(categoryCommand);
		
		//then
		assertEquals(ID_VALUE, category.getId());
		assertEquals(DESCRIPTION, category.getDescription());
	}

}

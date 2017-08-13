package com.lalit.recipe.converters;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.lalit.recipe.commands.CategoryCommand;
import com.lalit.recipe.domain.Category;

public class CategoryToCategoryCommandTest {

	private static final Long ID_VALUE = new Long(1L);
	private static final String DESCRIPTION = "descriptionOne";
	CategoryToCategoryCommand converter;
	
	@Before
	public void setUp() throws Exception {
		converter = new CategoryToCategoryCommand();
	}

	@Test
	public void testNullObject() throws Exception {
		assertNull(converter.convert(null));
	}
	
	@Test
	public void testEmptyObject() throws Exception {
		assertNotNull(converter.convert(new Category()));
	}
	
	@Test
	public void convert() throws Exception {
		//given
		Category category = new Category();
		category.setId(ID_VALUE);
		category.setDescription(DESCRIPTION);
		
		//when
		CategoryCommand categoryCommand = converter.convert(category);
		
		//then
		assertEquals(ID_VALUE, categoryCommand.getId());
		assertEquals(DESCRIPTION, categoryCommand.getDescription());
	}

}

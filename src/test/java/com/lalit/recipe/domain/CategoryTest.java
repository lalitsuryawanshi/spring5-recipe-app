package com.lalit.recipe.domain;

import com.lalit.recipe.domain.Category;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;


public class CategoryTest {
	
	Category category;
	
	@Before
	public void setup() {
		category = new Category(4L, "Test Category");
	}

	@Test
	public void getId() throws Exception {
		assertNotNull(category);
	}

	@Test
	public void getDescription() throws Exception {
	}

	@Test
	public void getRecipes() throws Exception {
	}

}

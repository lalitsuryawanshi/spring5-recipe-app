package com.lalit.recipe.converters;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.lalit.recipe.commands.UnitOfMeasureCommand;
import com.lalit.recipe.domain.UnitOfMeasure;

public class UnitOfMeasureCommandToUnitOfMeasureTest {

	private static final Long LONG_VALUE = new Long(1L);
	private static final String DESCRIPTION = "description";
	
	UnitOfMeasureCommandToUnitOfMeasure converter;
	
	@Before
	public void setUp() throws Exception {
		converter = new UnitOfMeasureCommandToUnitOfMeasure();
	}

	@Test
	public void testNullParameter() throws Exception {
		assertNull(converter.convert(null));
	}
	
	@Test
	public void testEmptyObject() throws Exception {
		assertNotNull(converter.convert(new UnitOfMeasureCommand()));
	}
	
	@Test
	public void convert() throws Exception {
		//given
		UnitOfMeasureCommand command = new UnitOfMeasureCommand();
		command.setId(LONG_VALUE);
		command.setDescription(DESCRIPTION);
		
		//when
		UnitOfMeasure uom = converter.convert(command);
		
		//then
		assertNotNull(uom);
		assertEquals(LONG_VALUE, uom.getId());
		assertEquals(DESCRIPTION, uom.getDescription());
	}

}

package com.lalit.recipe.converters;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.lalit.recipe.commands.UnitOfMeasureCommand;
import com.lalit.recipe.domain.UnitOfMeasure;

public class UnitOfMeasureToUnitOfMeasureCommandTest {

	private static final String DESCRIPTION = "description";
	private static final Long LONG_VALUE = new Long(1L);
	
	UnitOfMeasureToUnitOfMeasureCommand converter;
	
	@Before
	public void setUp() throws Exception {
		converter = new UnitOfMeasureToUnitOfMeasureCommand();
	}

	@Test
	public void testNullObjectConvert() throws Exception {
		assertNull(converter.convert(null));
	}
	
	@Test
	public void testEmptyObject() throws Exception {
		assertNotNull(converter.convert(new UnitOfMeasure()));
	}
	
	@Test
	public void convert() throws Exception {
		//given
		UnitOfMeasure uom = new UnitOfMeasure();
		uom.setId(LONG_VALUE);
		uom.setDescription(DESCRIPTION);
		
		//when
		UnitOfMeasureCommand uomc = converter.convert(uom);
		
		//then
		assertEquals(LONG_VALUE, uomc.getId());
		assertEquals(DESCRIPTION, uomc.getDescription());
	}

}

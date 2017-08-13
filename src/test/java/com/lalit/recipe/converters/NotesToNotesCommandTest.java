package com.lalit.recipe.converters;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.lalit.recipe.commands.NotesCommand;
import com.lalit.recipe.domain.Notes;

public class NotesToNotesCommandTest {

	private static final Long ID_VALUE = new Long(1L);
	private static final String RECIPE_NOTES = "NotesDescription";
	NotesToNotesCommand converter;
	
	@Before
	public void setUp() throws Exception {
		converter = new NotesToNotesCommand();
	}

	@Test
	public void convert() throws Exception {
		//given
		Notes notes = new Notes();
		notes.setId(ID_VALUE);
		notes.setNotes(RECIPE_NOTES);
		
		//when
		NotesCommand notesCommand = converter.convert(notes);
		
		//then
		assertEquals(ID_VALUE, notesCommand.getId());
		assertEquals(RECIPE_NOTES, notesCommand.getNotes());
	}
	
	@Test
	public void testNull() throws Exception {
		assertNull(converter.convert(null));
	}
	
	@Test
	public void testEmptyObject() throws Exception {
		assertNotNull(converter.convert(new Notes()));
	}

}

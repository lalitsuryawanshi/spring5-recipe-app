package com.lalit.recipe.converters;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.lalit.recipe.commands.NotesCommand;
import com.lalit.recipe.domain.Notes;

public class NotesCommandToNotesTest {

	private static final Long ID_VALUE = new Long(1L);
	private static final String RECIPE_NOTES = "Notes";
	NotesCommandToNotes converter;
	
	@Before
	public void setUp() throws Exception {
		converter = new NotesCommandToNotes();
	}

	@Test
	public void testNullParameter() throws Exception {
		assertNull(converter.convert(null));
	}
	
	@Test
	public void testEmptyObject() throws Exception {
		assertNotNull(converter.convert(new NotesCommand()));
	}
	
	@Test
	public void convert() throws Exception {
		//given
		NotesCommand notesCommand = new NotesCommand();
		notesCommand.setId(ID_VALUE);
		notesCommand.setNotes(RECIPE_NOTES);
		
		//when
		Notes notes = converter.convert(notesCommand);
		
		//then
		assertNotNull(notes);
		assertEquals(ID_VALUE, notes.getId());
		assertEquals(RECIPE_NOTES, notes.getNotes());
	}

}

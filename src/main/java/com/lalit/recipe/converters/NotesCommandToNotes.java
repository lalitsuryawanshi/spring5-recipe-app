package com.lalit.recipe.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.lalit.recipe.commands.NotesCommand;
import com.lalit.recipe.domain.Notes;

import lombok.Synchronized;

@Component
public class NotesCommandToNotes implements Converter<NotesCommand, Notes> {

	@Synchronized
	@Nullable
	@Override
	public Notes convert(NotesCommand source) {
		
		if(source == null) {
			return null;
		}
		
		final Notes notes = new Notes();
		notes.setId(source.getId());
		notes.setNotes(source.getNotes());
		return notes;
	}

}

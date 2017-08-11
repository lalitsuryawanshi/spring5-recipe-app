package com.lalit.recipe.repositories;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lalit.recipe.domain.UnitOfMeasure;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryIT {

	@Autowired
	UnitOfMeasureRepository uomRepo;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void findByDescription() throws Exception {
		
		Optional<UnitOfMeasure> uom = uomRepo.findByDescription("Teaspoon");
		assertEquals("Teaspoon", uom.get().getDescription());
	}
	
	@Test
	public void findByDescriptionCup() throws Exception {
		
		Optional<UnitOfMeasure> uom = uomRepo.findByDescription("Cup");
		assertEquals("Cup", uom.get().getDescription());
	}


}

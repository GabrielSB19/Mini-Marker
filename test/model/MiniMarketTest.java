package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Exception.AgeE;
import Exception.DayE;

class MiniMarketTest {
	
	private MiniMarket mm;
	
	private void setupScenary1() {
		mm = new MiniMarket();
	}
	
	private void setupScenary2() throws AgeE, DayE {
		mm = new MiniMarket();
		
		TypeDocument tp = TypeDocument.PP;
		long id = 0;
		if (mm.getDay()%2 == 0) {
			id = 1006325694;
		} else {
			id = 1006325664;
		}
		mm.addPerson(tp, id);
	}

	@Test
	public void miniMarketTest() {
		setupScenary1();
		
		mm.getPerson();
		
		assertNotNull(mm.getPerson());
		assertTrue(mm.getPerson().isEmpty());
	}
	
	/*
	 * The tests performed depend on the day they are performed, 
	 * since the date is obtained from the date of the system 
	 * running the PC program.
	 * Method getDay() in the MiniMarket class.
	 */
	
	
	
	/*
	 * This test add Person.
	 */
	
	@Test
	public void addPerson1() throws AgeE, DayE {
		setupScenary1();
		
		TypeDocument tp = TypeDocument.CC;
		long id = 0;
		if (mm.getDay()%2 == 0) {
			id = 1006325694;
		} else {
			id = 1006325664;
		}
		
		mm.addPerson(tp, id);
		ArrayList<Person> people = mm.getPerson();
		
		assertFalse(people.isEmpty());
		assertEquals(1, people.size());
		assertEquals(tp, people.get(0).getTP());
		assertEquals(id, people.get(0).getID());
	}
	
	/*
	 * This test does not add because the person is a child.
	 */
	
	@Test
	public void addPerson2() throws AgeE, DayE {
		setupScenary2();
		
		TypeDocument tp = TypeDocument.TI;
		long id = 0;
		if (mm.getDay()%2 == 0) {
			id = 21118452;
		} else {
			id = 21118442;
		}
		
		try {
			mm.addPerson(tp, id);
		} catch(AgeE e) {
		}
		ArrayList<Person> people = mm.getPerson();
		
		assertFalse(people.isEmpty());
		assertEquals(1, people.size());
	}
	
	/*
	 * This test does not add because the person should not leave today.
	 */
	
	@Test
	public void addPerson3() throws AgeE, DayE {
		setupScenary2();
		
		TypeDocument tp = TypeDocument.CE;
		long id = 0;
		if (mm.getDay()%2 == 0) {
			id = 21118442;
		} else {
			id = 21118452;
		}
		
		try {
			mm.addPerson(tp, id);
		} catch (DayE e) {
		}
		ArrayList<Person> people = mm.getPerson();
		
		assertFalse(people.isEmpty());
		assertEquals(1, people.size());
	}

}

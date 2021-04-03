package model;

import java.time.LocalDate;
import java.util.ArrayList;

import Exception.AgeE;
import Exception.DayE;

public class MiniMarket {
	
	ArrayList<Person> listPerson;
	public int count;
	
	public MiniMarket() {
		listPerson = new ArrayList<>();
	}
	
	public ArrayList<Person> getPerson(){
		return listPerson;
	}
	
	public void addPerson(TypeDocument tp, long id) throws AgeE, DayE{
		if (tp == TypeDocument.TI) {
			throw new AgeE(TypeDocument.TI);
		}
		if (!condition2(id)) {
			throw new DayE(getDay(), penultimateId(id));
		}
		listPerson.add(new Person(id, tp));
	}
	
	public TypeDocument getTp (int index) {
		TypeDocument newTp = TypeDocument.TI;
		switch (index) {
		case 1:
			newTp = TypeDocument.TI;
			break;
		case 2:
			newTp = TypeDocument.CC;
			break;
		case 3:
			newTp = TypeDocument.PP;
			break;
		case 4: 
			newTp = TypeDocument.CE;
			break;
		}
		return newTp;
	}

	public int getDay() {
		LocalDate date = LocalDate.now();
		String dateString = date.toString();
		String [] dateSplit = dateString.split("\\-");
		int day = Integer.parseInt(dateSplit[2]);
		return day;
	}
	
	public int penultimateId(long id) {
		String test = id+"";
		int last = 0;
		for (int i = 0; i < test.length()-1; i++) {
			last = Integer.parseInt(test.charAt(i)+"");
		}
		return last;
	}
	
	public boolean condition2(long id) {
		if ((getDay()%2 == 0 && penultimateId(id)%2 != 0) || (getDay()%2 != 0 && penultimateId(id)%2 == 0)) {
			return true;
		} else {
			return false;
		}
	}
}

package model;

import java.util.ArrayList;

import Exception.AgeE;

public class MiniMarket {
	
	ArrayList<Person> listPerson;
	public int count;
	
	public MiniMarket() {
		listPerson = new ArrayList<>();
	}
	
	public ArrayList<Person> getPerson(){
		return listPerson;
	}
	
	public void addPerson(TypeDocument tp, long id) throws AgeE{
		if (tp == TypeDocument.TI) {
			throw new AgeE(TypeDocument.TI);
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
}

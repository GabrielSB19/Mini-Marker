package model;

public class Person {
	
	private long id;
	private TypeDocument tp;
	
	public Person (long id, TypeDocument tp) {
		this.id = id;
		this.tp = tp;
	}
	
	public long getID() {
		return id;
	}
	
	public TypeDocument getTP() {
		return tp;
	}
}

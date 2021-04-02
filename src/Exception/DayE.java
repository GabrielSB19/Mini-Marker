package Exception;

public class DayE extends Exception{

	private static final long serialVersionUID = 1L;
	
	private int day;
	private long id;
	
	public DayE (int day, int id) {
		super("La identificacion numero: "+id+" no debe de salir el dia"+day+" no se agrego");
		this.day = day;
		this.id = id;
	}
	
	public int getDay(){
		return day;
	}
	
	public long getId() {
		return id;
	}
}

package Exception;

import model.*;

public class AgeE extends Exception{

	private static final long serialVersionUID = 1L;
	
	private TypeDocument Tp;
	
	public AgeE(TypeDocument Tp) {
		super("Es menor de edad, no se puede ingresar");
		this.Tp = Tp;
	}
	
	public TypeDocument getTP() {
		return Tp;
	}
}

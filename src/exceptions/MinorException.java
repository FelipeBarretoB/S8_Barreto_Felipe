package exceptions;

import model.TypeOfDocument;

public class MinorException extends Exception {
	private static final long serialVersionUID = -1146511324734515794L;
	private TypeOfDocument enumValue;
	public MinorException(TypeOfDocument enumValue){
		super("No puede entrar al mercado dado que es menor de edad por tener una: "+ enumValue.toString());
		this.enumValue=enumValue;
	}
	public TypeOfDocument getEnumValue() {
		return enumValue;
	}
	public void setEnumValue(TypeOfDocument enumValue) {
		this.enumValue = enumValue;
	}

}

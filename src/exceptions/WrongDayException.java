package exceptions;

public class WrongDayException extends Exception {
	private static final long serialVersionUID = 9060443484992481526L;
	private int day;
	private int idNum;
	public WrongDayException(int day, int idNum) {
		super("No puede entrar dado que tiene el numero: "+idNum+" y el día de hoy es: "+day);
		this.day=day;
		this.idNum=idNum;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getIdNum() {
		return idNum;
	}
	public void setIdNum(int idNum) {
		this.idNum = idNum;
	}
	

}

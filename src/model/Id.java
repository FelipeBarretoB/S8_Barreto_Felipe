package model;

public class Id {
	private int idNum;
	private TypeOfDocument type;
	
	public Id(int idNum, TypeOfDocument type) {
		this.idNum = idNum;
		this.type = type;
	}
	
	public int getIdNum() {
		return idNum;
	}
	
	public void setIdNum(int idNum) {
		this.idNum = idNum;
	}
	
	public TypeOfDocument getType() {
		return type;
	}
	
	public void setType(TypeOfDocument type) {
		this.type = type;
	}
	
}

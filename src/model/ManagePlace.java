package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import exceptions.MinorException;
import exceptions.WrongDayException;

public class ManagePlace {
	private ArrayList<Id> ids;
	private LocalDateTime now;
	private DateTimeFormatter dtf;
	 
	public ManagePlace() {
		ids=new ArrayList<>();
		dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		now = LocalDateTime.now();
	}
	
	public void addnewPerson(String idNum, String typeOfIdS) throws MinorException, WrongDayException,NumberFormatException,IllegalArgumentException,IndexOutOfBoundsException {
		TypeOfDocument typeOfID = TypeOfDocument.valueOf(typeOfIdS.toUpperCase());
		if(typeOfID==TypeOfDocument.valueOf("TI")) {
			throw new MinorException(typeOfID);
		}else if((idNum.charAt(idNum.length()-2))%2 ==0 && now.getDayOfMonth()%2==0) {
			throw new WrongDayException(now.getDayOfMonth(), Integer.parseInt(idNum));
		}else if((idNum.charAt(idNum.length()-2))%2 !=0 && now.getDayOfMonth()%2!=0) {
			throw new WrongDayException(now.getDayOfMonth(), Integer.parseInt(idNum));
		}else {
			ids.add(new Id(Integer.parseInt(idNum),typeOfID));
		}
	}

	public ArrayList<Id> getIds() {
		return ids;
	}

	public void setIds(ArrayList<Id> ids) {
		this.ids = ids;
	}

	public LocalDateTime getNow() {
		return now;
	}

	public void setNow(LocalDateTime now) {
		this.now = now;
	}

	public DateTimeFormatter getDtf() {
		return dtf;
	}

	public void setDtf(DateTimeFormatter dtf) {
		this.dtf = dtf;
	}
	
	
	



}

package model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import exceptions.MinorException;
import exceptions.WrongDayException;

public class ManagePlaceTest {
	private ManagePlace mp;

	public void setUpScenary1() {
		mp= new ManagePlace();
	}

	//fails in date
	@Test
	public void testAdd1() {
		setUpScenary1();
		if(LocalDateTime.now().getDayOfMonth()%2==0) {
			try {
				mp.addnewPerson("1005745265", "CC");
				fail();
			} catch (IllegalArgumentException | IndexOutOfBoundsException | MinorException | WrongDayException e) {
				assertTrue(mp.getIds().isEmpty());
			}
		}else {
			try {
				mp.addnewPerson("1005745275", "CC");
				fail();
			} catch (IllegalArgumentException | IndexOutOfBoundsException | MinorException | WrongDayException e) {
				assertTrue(mp.getIds().isEmpty());
			}
		}
	}

	//Passes because of the date and type of document
	@Test
	public void testAdd2() {
		setUpScenary1();
		if(LocalDateTime.now().getDayOfMonth()%2==0) {
			try {
				mp.addnewPerson("1005745275", "CC");
				assertTrue(!mp.getIds().isEmpty());
			} catch (IllegalArgumentException | IndexOutOfBoundsException | MinorException | WrongDayException e) {
				fail(); 
			}


		}else {
			try {
				mp.addnewPerson("1005745265", "CC");
				assertTrue(!mp.getIds().isEmpty());
			} catch (IllegalArgumentException | IndexOutOfBoundsException | MinorException | WrongDayException e) {
				fail();
			}
		}
	}
	
	//fails to add because of under age (ti) 
	@Test
	public void testAdd3() {
		setUpScenary1();
		if(LocalDateTime.now().getDayOfMonth()%2==0) {
			try {
				mp.addnewPerson("1005745275", "ti");
			} catch (IllegalArgumentException | IndexOutOfBoundsException | MinorException | WrongDayException e) {
				assertTrue(mp.getIds().isEmpty());
			}


		}else {
			try {
				mp.addnewPerson("1005745265", "ti");
				assertTrue(!mp.getIds().isEmpty());
			} catch (IllegalArgumentException | IndexOutOfBoundsException | MinorException | WrongDayException e) {
				assertTrue(mp.getIds().isEmpty());
			}
		}
	}
}

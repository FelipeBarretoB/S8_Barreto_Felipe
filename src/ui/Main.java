package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import exceptions.MinorException;
import exceptions.WrongDayException;
import model.ManagePlace;



public class Main {
	private BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	private BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
	private int totalTriesToEnter;
	private ManagePlace mp;

	public Main() {
		mp=new ManagePlace();
		totalTriesToEnter=0;
	}

	public static void main(String[] args) {
		Main ui=new Main();
		int option=0;
	
		
		try {
			do{
				try {
					option= ui.showMenu();
					ui.executeOperation(option);
				}catch(NumberFormatException e) {
					ui.bw.write("Seleccione un numero valido \n \n");
					ui.bw.flush();
				}catch(MinorException e) {
					ui.bw.write("El documento ingresado es "+e.getEnumValue()+", no puede entrar al ser menor de edad \n \n");
					ui.bw.flush();
				}catch(WrongDayException e) {
					ui.bw.write("El numero: "+e.getIdNum()+" no puede entrar hoy: "+e.getDay()+" al mercado \n \n");
					ui.bw.flush();
				}catch(IllegalArgumentException e) {
					ui.bw.write("Este no es un tipo de documento valido \n \n");
					ui.bw.flush();
				}catch(IndexOutOfBoundsException e) {
					ui.bw.write("El documento no tiene un numero valido \n \n");
					ui.bw.flush();
				}
			}while (option!=0);
			
			ui.br.close();
			ui.bw.close();
			
		}catch(IOException e) {
			System.out.println("No se encontro System.in o System.out");
		}


	}


	public int showMenu() throws IOException, NumberFormatException {

		int option=0;
		bw.write(
				"Menú principal, seleccione una opción\n" +
						"(1) Para registrar documento de la persona \n" +
						"(2) Para consultar cuantas personas han intentado ingresar al minimercado \n"+
						"(0) Para salir"
				);
		bw.newLine();
		bw.flush();
		option= Integer.parseInt(br.readLine());
		bw.newLine();
		bw.flush();
		return option;
	}

	public void executeOperation(int operation) throws IOException, MinorException, WrongDayException {

		switch(operation) {
		case 0:
			bw.write("adios. \n \n");
			bw.flush();
			break;
		case 1:
			totalTriesToEnter++;
			addId();
			bw.write("\n \n");
			bw.flush();
			break;
		case 2:
			bw.write(totalTriesToEnter+" personas intentaron entrar al mercado");
			bw.write(" \n \n");
			bw.flush();
			break;
		default:
			bw.write("AAAAAAAAAAAAAAAAAAAAAAAAAAAAA \n \n");
			bw.flush();

		}
	}
	
	
	public void addId() throws IOException, MinorException, WrongDayException {
		String idType="";
		String idNum="";
		bw.write("Que tipo de documento es? Los tipos permitidos son TI -Tarjeta de Identidad-, CC - Cédula de Ciudadanía-, PP -Pasaporte- o CE -Cédula de Extranjería-");
		bw.newLine();
		bw.flush();
		idType=br.readLine();
		bw.write("Cual es el numero del documento");
		bw.newLine();
		bw.flush();
		idNum=br.readLine();
		
		
		mp.addnewPerson(idNum, idType);
	}

}

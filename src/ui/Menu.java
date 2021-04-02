package ui;

import java.util.Scanner;

import Exception.AgeE;
import model.MiniMarket;
import model.TypeDocument;

public class Menu {

	private Scanner sc = new Scanner(System.in);
	MiniMarket mm = new MiniMarket();
	
	public static void welcome() {
		System.out.println("--------------------------------");
		System.out.println("Bienvenido a mi Barrio te quiere");
		System.out.println("--------------------------------");
	}
	
	public void mainMenu(){
		System.out.println("Que deseas hacer?");
		System.out.println("[1] Agregar una persona");
		System.out.println("[2] Intentos de registros");
		System.out.println("[3] Salir");
		System.out.println("--------------------------------");
	}
	
	public int readOption() {
		int choice = Integer.parseInt(sc.nextLine());
		return choice;
	}
	
	public void doOperation(int choice) {
		switch (choice) {
		case 1:
			System.out.println(addPerson());
			break;
		case 2:
			System.out.println(numberCount());
			break;
		case 3:
			System.out.println("Gracias por utilizar el programa");
			System.out.println("--------------------------------");
			System.exit(0);
			break;
		default:
			System.out.println("Ingresa una opcion valida");
			break;
		}
	}
	
	public void startProgram() {
		int option;
		do {
			mainMenu();
			option = readOption();
			doOperation(option);
		} while (option != 4);
	}
	
	public TypeDocument selectTP() {
		System.out.println("Selecciona el tipo de Documento");
		System.out.println("[1] Tarjeta de Identidad");
		System.out.println("[2] Cedula de Ciudadania");
		System.out.println("[3] Pasaporte");
		System.out.println("[4] Cedula de extranjeria");
		int index = Integer.parseInt(sc.nextLine());
		return mm.getTp(index);
	}
	
	public long selectID() {
		System.out.println("Ingresa la identificacin");
		long id = Long.parseLong(sc.nextLine());
		return id;
	}

	public String addPerson() {
		TypeDocument tp = selectTP();
		long id = selectID();
		try {
			mm.addPerson(tp, id);
			return "Se ha agregado correctamente";
		} catch (AgeE e) {
			mm.count++;
			return "TI no se puede agregar";
		}
	}

	public String numberCount() {
		return "Se han intentado agregar "+mm.count+" personas";
	}
}

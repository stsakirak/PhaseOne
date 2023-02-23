package com;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {
	
	static final String NAMETHEAPP = "Welcome to my brand new program!";
	static final String NAMETHEDEV = "Creator: Stelios Tsakirakis";
	static final String MENUTXT = "Menu";
	static final String OPTIONSTXT = "Options";
	static final ArrayList<String> MENULIST = CREATELISTOFMENU();
	static final ArrayList<String> OPTIONSLIST = CREATELISTOFOPTIONS();

	private static File fileDirectory = new File("/home/steliostsakirak/Desktop/phase1/Phase 1/Code/VirtualKeyProject/src/resources/");
	
	public static void main(String[] args) throws IOException{
		FileOperations screen = new FileOperations();
		System.out.println(NAMETHEAPP);
		System.out.println(NAMETHEDEV);
		System.out.println("\n");
		
		mainMenuSelection(screen);
		
	}
	
	private static void mainMenuSelection(FileOperations screen) throws IOException {
		String mainMenuInput;
		int mainMenuInputInteger;
		try {
			do {
				System.out.println(MENUTXT);
				System.out.println("Please choose a number between 1-3");
				for (String s : MENULIST) {
					System.out.println(s);
				}
				
				Scanner sc = new Scanner(System.in);
				mainMenuInput = sc.next();
				mainMenuInputInteger = Integer.parseInt(mainMenuInput);
				
				switch  (mainMenuInputInteger) {
					case 1:
						screen.sortFileNameList(fileDirectory);
						mainMenuSelection(screen);
						break;
					case 2:
						optionMenuSelection(screen);
						break;
					case 3:
						System.out.println("Exit");
						break;
					default:
						System.out.println("Please give a number between 1-3");
						break;
				}
			} while ((Integer.parseInt(mainMenuInput) < 1) || (Integer.parseInt(mainMenuInput) > 3));
		} catch (NumberFormatException nfe) {
			System.out.println("Wrong input.");
			mainMenuSelection(screen);
		}	
	}

	private static void optionMenuSelection(FileOperations screen) throws IOException {
		String optionMenuInput;
		int optionMenuInputInteger;
		try {		
			do {
				System.out.println(OPTIONSTXT);
				System.out.println("Please provide a number between 1-4");
				for(String s : OPTIONSLIST) {
					System.out.println(s);
				}
				Scanner sc = new Scanner(System.in);
				optionMenuInput = sc.next();
				optionMenuInputInteger = Integer.parseInt(optionMenuInput);
				
				switch (optionMenuInputInteger) {

      			case 1:
					screen.addNewFile(fileDirectory);
					optionMenuSelection(screen);
					break;
				 case 2:
					screen.deleteFile(fileDirectory);
					optionMenuSelection(screen);
					break;
				 case 3:
					screen.searchFile(fileDirectory);
					optionMenuSelection(screen);
					break;
				 case 4:
					mainMenuSelection(screen);
					break;
				 default:
					System.out.println("Please give a number between 1-4");
					break;
				}
				
			} while ((optionMenuInputInteger < 1) || (optionMenuInputInteger > 4));
		} catch (NumberFormatException nfe) {
			System.out.println("Wrong argument.");
			optionMenuSelection(screen);
		}	
	}
	
	private static final ArrayList<String> CREATELISTOFMENU() {
		ArrayList<String> mainMenu = new ArrayList<>();
		mainMenu.add("1. Show Files in ascending order");
		mainMenu.add("2. Show File Options Menu");
		mainMenu.add("3. Exit");
		
		return(mainMenu);
	}
	
	private static final ArrayList<String> CREATELISTOFOPTIONS() {
		ArrayList<String> optionMenu = new ArrayList<>();
		optionMenu.add("1. Add a new file");
		optionMenu.add("2. Delete a file");
		optionMenu.add("3. Search file");
		optionMenu.add("4. Back to Main menu");
		
		return(optionMenu);
	}
}
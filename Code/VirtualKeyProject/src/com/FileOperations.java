package com;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileOperations {

	public void sortFileNameList(File fileDirectory) {
		String fileNames[]= fileDirectory.list();
	
		for (int i = 0;i<fileNames.length - 1;i++) {
			for(int j=i+1;j<fileNames.length;j++) {
				if (fileNames[i].compareTo(fileNames[j]) > 0) {
					String temp = fileNames[i];
					fileNames[i] = fileNames[j];
					fileNames[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(fileNames));
		System.out.println("\n");
	}
	
	public void addNewFile(File fileDirectory) throws IOException{
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the file name you want to create:");
		String fileName = sc.next();
		String filePath = fileDirectory + "/" + fileName;
		
		File ff = new File(filePath);
		if(ff.createNewFile() && !ff.isDirectory()) {
			System.out.println("File " + ff.getName() + " created.");
		}else {
			System.out.println("File " + ff.getName() + " already exists.");
		}
	}
	
	public void deleteFile(File fileDirectory) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the file name you want to delete:");
		String fileName = sc.next();
		String filePath = fileDirectory + "/" + fileName;
		
		File ff = new File(filePath);
		if (ff.exists()) {
			System.out.println(ff.getName() + " file deleted.");
			ff.delete();
		} else {
			System.out.println("File not found");
		}
	}
	
	public void searchFile(File fileDirectory) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the file name you want to retrieve:");
		String fileName = sc.next();
		String fileNames[]=fileDirectory.list();
		List<String> fileNamesList = Arrays.asList(fileNames);
		
		if (fileNamesList.contains(fileName)) {
			System.out.println("The file " + fileName + " exists!");
		} else {
			System.out.println("The file " + fileName +" does not exists.");
		}
	}
	

}

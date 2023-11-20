package com.project.tester;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AttributeTest implements Test{
    //private int score;
    private String filename;
    private String name;
    private String type;
    private String access;

    AttributeTest(String access, String type, String name, String filename){
        this.access = access;
        this.type = type;
        this.name = name;
        this.filename = filename;
        //System.out.println(String.format("\tFile name: %s ",filename));
    }

    public int execute(){
        String key = String.format("%s %s %s;",access,type,name);
        //System.out.println(key);

        // logic to transvers through file line by line
        try {
            File file = new File(filename);
			Scanner scanner = new Scanner(file);

			while (scanner.hasNextLine()) {
                // line = scanner.nextLine();
                // System.out.println(scanner.nextLine().trim());
                // System.out.println(String.format("\t\tFile line :", line.trim()));
				if(scanner.nextLine().trim().equals(key)){
                    scanner.close();
                    return 1;
                }
			}
            scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        //file 

        return 0;
    }
    public String toString(){
        return String.format("Score : %d", execute());
    }

    public static void main(String[] args) {
        AttributeTest t = new AttributeTest("public","String","passportNumber","Passenger.java");
        System.out.println(t.execute());
    }
}

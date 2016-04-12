package com.theironyard.clt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
	    //write code here
        //read countries.txt
        //parse it
        //set values as countries that start with same letter
        //ask user for letter
        //write file for entry
        //save to file
        //end

        HashMap<String, ArrayList<Country>> map = new HashMap<>();
        File f = new File("countries.txt");
        Scanner fileScanner = new Scanner(f);
        String key = null;
        while (fileScanner.hasNext()) {
            String line = fileScanner.nextLine();
            String[] columns = line.split("\\|");
            Country c = new Country(columns[0], columns[1]);
            key = String.valueOf(c.name.charAt(0));
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(c);
        }

        System.out.println("Please enter a letter for search parameters.");
        Scanner consoleScanner = new Scanner(System.in);
        String letter = consoleScanner.nextLine().toLowerCase();
        if (letter.length() > 1) {
            throw new IllegalArgumentException("That is not a letter moron!");
        }
        File g = new File(String.format("%s_countries.txt", letter));

        FileWriter fw = new FileWriter(g);

        fw.write(map.get(letter).toString());

        fw.close();


    }
}

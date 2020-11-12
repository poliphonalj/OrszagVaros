package edu.progmatic.OrszagVaros;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WorldStatistic {
    final static String countriesFile ="C:\\Users\\PJ\\IdeaProjects\\src\\edu\\progmatic\\OrszagVaros\\orszagok.txt";
    final static String citiesFile = "C:\\Users\\PJ\\IdeaProjects\\src\\edu\\progmatic\\OrszagVaros\\varosok.txt";

    public static void main(String[] args) throws Exception {
        readFile(countriesFile, citiesFile);
    }

    public static void readFile(String countriesFile, String citiesFile) throws FileNotFoundException {
        try {
            String countryLine;
            String[] countryLineParts;
            ArrayList<City> cityContainer;
            ArrayList<Country> countryContainer=new ArrayList<>();

            Scanner scCountry = new Scanner(new File(countriesFile));
            Scanner scCity = new Scanner(new File(citiesFile));

            while (scCountry.hasNextLine()) {
                countryLine = scCountry.nextLine();
                countryLineParts = countryLine.split(",", 8);

                if (countryLineParts[5].equals("NULL")) {
                    countryLineParts[5] = String.valueOf(0);
                }
                if (countryLineParts[7].equals("")) {
                    countryLineParts[7] = "";
                }
            Country country=new Country(countryLineParts[0], countryLineParts[1], countryLineParts[2], countryLineParts[3], Double.parseDouble(countryLineParts[4]), Integer.parseInt(countryLineParts[5]), Long.parseLong(countryLineParts[6]), countryLineParts[7]);
            countryContainer.add(country);
                System.out.println(countryContainer);
            }


        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage() + " " + e.toString());
        }
    }


}

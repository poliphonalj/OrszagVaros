package edu.progmatic.OrszagVaros;

import java.util.TreeSet;

public class Country {
    private String countryCode;
    private String countryName;
    private String continent;
    private String region;
    private double area;
    private int independency;
    private long countryPopulation;
    private String president;
    private TreeSet<City> cities;

    public Country(String countryCode, String countryName, String continent, String region, double area, int independency, long countryPopulation, String president) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.continent = continent;
        this.region = region;
        this.area = area;
        this.independency = independency;
        this.countryPopulation = countryPopulation;
        this.president = president;
    }

    @Override
    public String toString() {
        return "Country{" +
               // "countryCode='" + countryCode + '\'' +
                ", countryName='" + countryName + '\'' +
                //", continent='" + continent + '\'' +
                //", region='" + region + '\'' +
                //", area=" + area +
               ", independency=" + independency +
               // ", countryPopulation=" + countryPopulation +
                ", president='" + president + '\'' +
               // ", cities=" + cities +
                '}';
    }
}


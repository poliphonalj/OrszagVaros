package edu.progmatic.Orszagok;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

//ALB,Albania,Europe,Southern Europe,28748.00,1912,3401200,Rexhep Mejdani
public class Country {
    private String countyCode;
    private String countryName;
    private String continent;
    private String region;
    private double area;
    private int independency;
    private long countryPopulation;
    private String leader;


    public Country(String countyCode, String countryName, String continent, String region, double area, int independency, long countryPopulation, String leader) {
        this.countyCode = countyCode;
        this.countryName = countryName;
        this.continent = continent;
        this.region = region;
        this.area = area;
        this.independency = independency;
        this.countryPopulation = countryPopulation;
        this.leader = leader;
    }

    public String getCountyCode() {
        return countyCode;
    }

    public void setCountyCode(String countyCode) {
        this.countyCode = countyCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getIndependency() {
        return independency;
    }

    public void setIndependency(int independency) {
        this.independency = independency;
    }

    public long getCountryPopulation() {
        return countryPopulation;
    }

    public void setCountryPopulation(long countryPopulation) {
        this.countryPopulation = countryPopulation;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }


////A Country osztályba írj egy
// public double getPopulationDensity()
//metódust, ami visszaadja az adott ország népsűrűségét fő/km2-ben!
// Ha az ország területe vagy népessége nincs megadva, akkor metódusod -1-gyel térjen vissza!

    public double getPopulationDensity() {
        if (getCountryPopulation() == 0 || getArea() == 0) {
            return -1;
        }
        return getCountryPopulation() / getArea();
    }


    @Override
    public String toString() {
        return "Country{" +
                "countyCode='" + countyCode + '\'' +
                ", countryName='" + countryName + '\'' +
                ", continent='" + continent + '\'' +
                ", region='" + region + '\'' +
                ", area=" + area +
                ", independency=" + independency +
                ", countryPopulation=" + countryPopulation +
                ", leader='" + leader + '\'' +
                '}';
    }
}
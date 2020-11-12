package edu.progmatic.Orszagok;

public class City {
private String cityName;
private String countryCode;
private long cityPopulation;

    public City(String cityName, String countryCode, long cityPopulation) {
        this.cityName = cityName;
        this.countryCode = countryCode;
        this.cityPopulation = cityPopulation;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public long getCityPopulation() {
        return cityPopulation;
    }

    public void setCityPopulation(long cityPopulation) {
        this.cityPopulation = cityPopulation;
    }
}

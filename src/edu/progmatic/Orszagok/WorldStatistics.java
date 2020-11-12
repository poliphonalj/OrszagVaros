/*package edu.progmatic.Orszagok;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WorldStatistics {
    final static String countriesFile = "C:\\Users\\PJ\\IdeaProjects\\src\\edu\\progmatic\\Orszagok\\orszagok.txt";
    final static String citiesFile = "C:\\Users\\PJ\\IdeaProjects\\src\\edu\\progmatic\\Orszagok\\varosok.txt";
    private static ArrayList<City> citicontainerkinti;
    private static ArrayList<Country> countrycontainerkinti;


    public static void main(String[] args) throws FileNotFoundException {
        readFile(countriesFile, citiesFile);
        getCountryDetails();
        findCountryByISoCode("UKR");
        getCountriesOfContinent("Africa");
    }


    public static void readFile(String countriesFile, String citiesFile) throws FileNotFoundException {
        try {
            Scanner scCountry = new Scanner(new File(countriesFile));
            Scanner scCity = new Scanner(new File(citiesFile));
            String countryLine;
            String cityLine;
            String[] countryLineParts;
            String[] cityLineParts;
            TreeMap<String, ArrayList<String>> conTree = new TreeMap<>();
            TreeMap<String, ArrayList<String>> citTree = new TreeMap<>();
            ArrayList<City> cityContainer = new ArrayList<>();
            ArrayList<Country> countryContainer = new ArrayList<>();
            TreeMap<String, ArrayList<String>> mergedTree = new TreeMap<>();

            while (scCountry.hasNextLine()) {                             //az orszagok.txt beolvasasa
                countryLine = scCountry.nextLine();
                countryLineParts = countryLine.split(",", 8);             //a kapott orszagok.txt sorainak feldarabolasa
                if (countryLineParts[5].equals("NULL")) {
                    countryLineParts[5] = String.valueOf(0);
                } else {
                    countryContainer.add(new Country(countryLineParts[0], countryLineParts[1], countryLineParts[2], countryLineParts[3], Double.parseDouble(countryLineParts[4]), Integer.parseInt(countryLineParts[5]), Long.parseLong(countryLineParts[6]), countryLineParts[7]));
                }
            }
            countrycontainerkinti = countryContainer;

            while (scCity.hasNextLine()) {
                cityLine = scCity.nextLine();
                cityLineParts = cityLine.split(",");
                cityContainer.add(new City(cityLineParts[0], cityLineParts[1], Long.parseLong(cityLineParts[2])));
            }
            citicontainerkinti = cityContainer;

            for (Country actualCountry : countryContainer) {                        //conTree:  contyCode-country name
                conTree.putIfAbsent(actualCountry.getCountyCode(), new ArrayList<String>());
                conTree.get(actualCountry.getCountyCode()).add(actualCountry.getCountryName());
                //conTree.putIfAbsent(actualCountry.getCountyCode(),new ArrayList<String>());
                //conTree.get(actualCountry.getCountyCode()).add(actualCountry.getCountryName());
            }

            for (City actualCity : cityContainer) {               //citTree:  city countrycode, name
                citTree.putIfAbsent(actualCity.getCountryCode(), new ArrayList<String>());
                citTree.get(actualCity.getCountryCode()).add(actualCity.getCityName());
            }

            conTree.putAll(citTree);                 //country code-cities
            mergedTree = conTree;                      //orszagok es varosok egyutt vannak tarolvA
            // System.out.println(mergedTree);

            rural(cityContainer, countryContainer);


        } catch (Exception e) {
            System.out.println(e.toString() + e.getLocalizedMessage() + "qq");
        }
    }

    public static void rural(ArrayList<City> cityContainer, ArrayList<Country> countryContainer) {
        long counter = 0;
        long popOutOfCities = 0;
        ArrayList<String> sortedCountries = new ArrayList<>();

        TreeMap<String, ArrayList<Long>> hMap = new TreeMap<>();          //adott orszagok varosainak-populacioja
        for (City actual : cityContainer) {
            hMap.putIfAbsent(actual.getCountryCode(), new ArrayList<>());
            hMap.get(actual.getCountryCode()).add(actual.getCityPopulation());

        }
        for (Map.Entry<String, ArrayList<Long>> e : hMap.entrySet()) {      //az orszag varoslakoi
            counter = 0;
            for (int i = 0; i < e.getValue().size(); i++) {
                counter += e.getValue().get(i);
                //System.out.println(counter);
            }

            for (int i = 0; i < countryContainer.size(); i++) {
                sortedCountries.add(countryContainer.get(i).getCountyCode());
            }
            Collections.sort(sortedCountries);

            for (int i = 0; i < countryContainer.size(); i++) {
                // System.out.println(sortedCountries);
                if (e.getKey().equals(countryContainer.get(i).getCountyCode())) {
                    popOutOfCities = countryContainer.get(i).getCountryPopulation() - counter;
                    System.out.println(popOutOfCities);
                }

            }
        }
    }


    /*
        Írj egy olyan metódust, ami országkód alapján visszaadja egy ország összes adatát!
        A metódus szignatúrája az alábbi legyen:
        public Country findCountryByISoCode(String isoCode)

    public static void getCountryDetails() {
        HashMap<String, Country> hmap = new HashMap<>();
        for (Country actualCountry : countrycontainerkinti) {
            hmap.put(actualCountry.getCountyCode(), actualCountry);
        }
        for (Map.Entry<String, Country> entry : hmap.entrySet()) {
            System.out.println(entry.getValue().toString());
        }

    }

    public static Country findCountryByISoCode(String isoCode) {
        Country c = null;
        HashMap<String, Country> hmap = new HashMap<>();
        for (Country actualCountry : countrycontainerkinti) {
            hmap.put(actualCountry.getCountyCode(), actualCountry);
        }
        for (Map.Entry<String, Country> entry : hmap.entrySet()) {
            if (isoCode.equals(entry.getKey())) {
                System.out.println(entry.getValue().toString());
                c = entry.getValue();
            }
        }
        return c;
    }


    // Írj egy olyan metódust, amely visszaadja egy paraméterül kapott kontinens országainak az országkódjait!
    // A metódus szignatúrája az alábbi legyen:
    //public ArrayList<String> getCountriesOfContinent(String continentName)

    public static ArrayList<String> getCountriesOfContinent(String continentName) {
        ArrayList<String> c = new ArrayList<>();
        HashMap<String, ArrayList<String>> hmap = new HashMap<>();
        for (Country actualCountry : countrycontainerkinti) {
            hmap.putIfAbsent(actualCountry.getContinent(), new ArrayList<>());
            hmap.get(actualCountry.getContinent()).add(actualCountry.getCountyCode());
        }
        for (Map.Entry<String, ArrayList<String>> entry : hmap.entrySet()) {
            for (int i = 0; i < hmap.values().size(); i++)
                if (continentName.equals(entry.getValue().get(i))) {
                    System.out.println(continentName + " " + entry.getValue().get(i));
                    c.add(entry.getValue().get(i));
                }
            }

        return c;
    }
///////////////////////////////////beadas utan
/*
    Írj egy olyan metódust, amely visszaadja egy paraméterül kapott ország városainak a neveit
    (az országot országkóddal adjuk meg)! A metódus szignatúrája az alábbi legyen:
    public HashSet<String> getCitiesOfCountry(String countryCode)

   public static HashSet<String>getCitiesOfCountry(String countryCode){
       HashSet <String>c;
       HashMap<String,ArrayList<String>> hMap=new HashMap<>();
       for (City actualCity : citicontainerkinti) {

           hMap.get(actualCity.getCountryCode()).add(actualCity.getCityName());
       }

       for (Map.Entry<String, ArrayList<String>> entry : hMap.entrySet()) {
           if(entry.getKey().equals(countryCode)){
                c=new HashSet<>(entry.getValue());
               System.out.println(entry.getValue());
           }
       }
    return c;
   }

/*
Hány országnak az államfőjének nevében szerepel “Hamad” vagy “Ahmad” vagy “Ahmed”? A metódus szignatúrája az alábbi legyen:
public int getAhmedCount()
Egy String objektumban a .indexOf() metódussal tudod megvizsgálni, hogy tartalmaz-e egy adott karaktersorozatot.


    public static int getAhmed(){
        int counter=0;
        HashMap<String, ArrayList<String>>hMap=new HashMap<>();
        for (Country actualCountry : countrycontainerkinti) {
            hMap.putIfAbsent(actualCountry.getCountryName(), new ArrayList<String>());
            hMap.get(actualCountry.getCountryName()).add(actualCountry.getLeader());
        }
        for (Map.Entry<String, ArrayList<String>> entry : hMap.entrySet()) {
            for(int i=0;i<entry.getValue().size();i++)
            if(entry.getValue().get(i).contains("Ahmad")|| entry.getValue().get(i).contains("Ahmed")){
                counter++;
            }
        }
    return counter;
    }


/*
Melyik betűvel kezdődik a legtöbb országkód? A visszatérési érték egy egybetűs String,
 a metódus szignatúrája pedig az alábbi legyen:
public String getPopularFirstLetter()
Egy hosszabb String első betűjének visszakapására a .substring() metódus használatos.


    public static  String getPopularFirstLetter(){
      ArrayList<String>starts=new ArrayList<>();
        for(int i=0;i<countrycontainerkinti.size();i++){
         starts.add(countrycontainerkinti.get(i).getCountyCode().substring(0));
      }
        for(int i=0;i<starts.size();i++){

        }
    }

}

*/
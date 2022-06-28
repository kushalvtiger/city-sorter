package com.kyruus.interview.city.sorter;

import java.util.List;

import com.kyruus.interview.city.sorter.CitySorter.SortingOrder;
import com.kyruus.interview.city.sorter.io.CityIO;
import com.kyruus.interview.city.sorter.io.Entity;
import com.kyruus.interview.city.sorter.io.IO;

/**
 * Basic Application Workflow Class with Inputs and Outputs. 
 */
public class App 
{
    /**
     * Application's main method. 
     * 
     * @param args arguments to be considered. 
     */
    public static void main(final String[] args)
    {
        System.out.println( "1) Welcome to City Sorter Problem with API \n" );
        System.out.println( "2) For the scope of this problem case is matched as it is read.\n");

        final String filePath = App.class.getClassLoader().getResource("input.csv").getPath();
        System.out.println( "3) Reading the input CSV file from: " + filePath);

        final IO io = new CityIO();
        final List<Entity> cities = io.readCitiesFile(filePath);

        System.out.println( "\nOutput prior to Sorting:");
        io.printCities(cities);
        
        final String columnName = "City";
        System.out.println( "\nColumn to be sorted is *" + columnName +"*");
        
        CitySorter.sortCityNames(cities, CitySorter.getComparator(columnName, SortingOrder.DESCENDING));
        
        System.out.println( "\nOutput after to Sorting for *City*");
        io.printCities(cities);
        
        System.out.println( "*** Other Workflows ***" );
        CitySorter.sortCityNames(cities, CitySorter.getComparator("State", SortingOrder.DESCENDING));
        
        System.out.println( "\nOutput after to Sorting for *State*:");
        io.printCities(cities);
        
        CitySorter.sortCityNames(cities, CitySorter.getComparator("Motto", SortingOrder.ASCENDING));
        
        System.out.println( "\nOutput after to Sorting for *Motto* (Ascending):");
        io.printCities(cities);
        
        CitySorter.sortCityNames(cities, CitySorter.getComparator("Mayor", SortingOrder.ASCENDING));
        
        System.out.println( "\nOutput after to Sorting for *Mayor* (Ascending):");
        io.printCities(cities);
    }
}

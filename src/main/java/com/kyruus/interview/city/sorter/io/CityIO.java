package com.kyruus.interview.city.sorter.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

import com.kyruus.interview.city.sorter.util.Validator;

/**
 * A City implementation of {@link IO}. 
 * 
 * @author Kushal Venktegowda
 */
public class CityIO implements IO
{
    private static final String COMMA_DELIMITER = ",";
    
    String[] columnNames;
    
    @Override
    public List<Entity> readCitiesFile(final String fileLocation)
    {
        Validator.validateStringForNullOrEmptiness(fileLocation, "File location cannot be null or empty");
        final File csvFile = new File(fileLocation);
        Validator.validateObjectForNull(csvFile, "File cannot be null");
        final List<Entity> cities = new ArrayList<>();
        try(final BufferedReader csvBufferedReader = new BufferedReader(new FileReader(csvFile)))
        {
            final String columnLine = csvBufferedReader.readLine();
            this.columnNames = columnLine.split(COMMA_DELIMITER);
            String cityLine = csvBufferedReader.readLine();
            while(cityLine != null) 
            {
                cities.add(new City(this.columnNames, cityLine.split(COMMA_DELIMITER)));
                cityLine = csvBufferedReader.readLine();
            }
        }
        catch (final IOException e)
        {
            System.out.println(e.getMessage());
        }
        return cities;
    }
    
    @Override
    public void printCities(final List<Entity> cities)
    {
        final StringJoiner columnLine = new StringJoiner(","); 
        Arrays.asList(this.columnNames).forEach(columnName -> columnLine.add(columnName));
        System.out.println(columnLine.toString());
        cities.forEach(city -> System.out.println(city.toString()));
    }
}

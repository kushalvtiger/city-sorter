package com.kyruus.interview.city.sorter.io;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringJoiner;

/**
 * Basic City implementation of {@link Entity} that stores all the city information for given keys and values.
 * 
 * @author Kushal Venkategowda
 */
public class City implements Entity
{
    final Map<String,String> cityInformation;

    /**
     * Constructor
     * 
     * @param columnNames Keys for storing City Information.
     * @param cityInformation Values for storing City Information.
     */
    City(final String[] columnNames, final String[] cityInformation)
    {
        if(columnNames == null || cityInformation == null || columnNames.length != cityInformation.length)
        {
            throw new IllegalArgumentException("Invalid city information.");
        }
        final int columnLength = columnNames.length;
        final int contentLength = cityInformation.length;
        
        if(columnLength < 1 || contentLength < 1)
        {
            throw new IllegalArgumentException("No city information.");
        }
        
        this.cityInformation = new LinkedHashMap<>(contentLength);
        for(int i = 0; i< contentLength; i++)
        {
            this.cityInformation.put(columnNames[i], cityInformation[i]);
        }
        
    }
    
    /**
     * Gets the {@link City} information for a given column name;
     * 
     * @param columnName Name of the City Information to be retrieved;
     * 
     * @return City Information. Will return empty string if not available;
     */
    @Override
    public String getValue(final String columnName)
    {
        return this.cityInformation.getOrDefault(columnName, "");
    }
    
    @Override
    public String toString()
    {
        final StringJoiner cityLine = new StringJoiner(","); 
        this.cityInformation.values().forEach(columnName -> cityLine.add(columnName));
        return cityLine.toString();
    }
}

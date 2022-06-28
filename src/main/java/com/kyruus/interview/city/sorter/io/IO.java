package com.kyruus.interview.city.sorter.io;

import java.util.List;

/**
 * Interface to read and print Input and output operation.
 * 
 * @author Kushal Venkategowda
 */
public interface IO
{
    /**
     * Reads the information into a list of {@link Entity}s.
     * 
     * @param fileLocation Location of the file to be read.
     * 
     * @return {@link List} of {@link Entity}s that was read.
     */
    public List<Entity> readCitiesFile(final String fileLocation);
    
    /**
     * Prints all the {@link Entity}s.
     * 
     * @param entities {@link List} of {@link Entity}s to be printed.
     */
    public void printCities(final List<Entity> entities);
}

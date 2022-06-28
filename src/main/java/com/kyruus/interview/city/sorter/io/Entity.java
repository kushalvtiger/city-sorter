package com.kyruus.interview.city.sorter.io;

/**
 * An Interface for Entity to retrieve values for given key.
 * 
 * @author Kushal Venkategowda
 *
 */
public interface Entity
{
    /**
     * Gets the value for a given key;
     * 
     * @param key Key to retrieve the value of {@link Entity};
     * 
     * @return Value associated with the key in {@link Entity};
     */
    public String getValue(final String key);
}

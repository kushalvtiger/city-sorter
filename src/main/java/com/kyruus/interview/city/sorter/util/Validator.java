package com.kyruus.interview.city.sorter.util;

import java.util.Collection;

/**
 * Validator class to validate invalid objects. 
 * 
 * @author Kushal Venkategowda
 *
 */
public class Validator
{
    /**
     * Throws an {@link IllegalArgumentException} if the {@link Collection} is <code>null</code> or empty. 
     * 
     * @param collection {@link Collection} to be validated.
     * @param message Message to be shown when collection is invalid. 
     * 
     * @throws IllegalArgumentException. 
     */
    public static void validateCollectionForNullOrEmptiness(final Collection<?> collection, final String message)
    {
        if(collection == null || collection.isEmpty())
        {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Throws an {@link IllegalArgumentException} if the {@link String} is <code>null</code> or empty. 
     * 
     * @param string {@link String} to be validated.
     * @param message Message to be shown when string is invalid. 
     * 
     * @throws IllegalArgumentException. 
     */
    public static void validateStringForNullOrEmptiness(final String string, final String message)
    {
        if(string == null || string.isEmpty())
        {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Throws an {@link IllegalArgumentException} if the {@link Collection} is <code>null</code> or empty. 
     * 
     * @param object {@link Object} to be validated.
     * @param message Message to be shown when collection is invalid. 
     * 
     * @throws IllegalArgumentException. 
     */
    public static void validateObjectForNull(final Object object, final String message)
    {
        if(object == null)
        {
            throw new IllegalArgumentException(message);
        }
    }

}

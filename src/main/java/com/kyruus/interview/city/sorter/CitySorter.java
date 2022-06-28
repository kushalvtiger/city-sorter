package com.kyruus.interview.city.sorter;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.kyruus.interview.city.sorter.io.Entity;
import com.kyruus.interview.city.sorter.util.Validator;

/**
 * A Class that the list of cities in a given order.  
 * 
 * @author Kushal Venkategowda
 */
class CitySorter
{

    /**
     *  Defines the sorting order for the {@link CitySorter}.
     */
    enum SortingOrder
    {
        ASCENDING, 
        DESCENDING
    }
    
    /**
     * Sorts the given list of city names according to {@link SortingOrder}.
     * 
     * @param cityNames Name of the cities to to be sorted. Cannot be <code>null</code> or empty. 
     * @param order {@link SortingOrder} to sort city names. Cannot be <code>null</code>. 
     * 
     * @return Sorted {@link List} of city names.
     */
    static List<Entity> sortCityNames(final List<Entity> cityNames, final Comparator<Entity> comparator)
    {
        Validator.validateCollectionForNullOrEmptiness(cityNames, "City names cannot be null");
        Validator.validateObjectForNull(comparator, "City names cannot be null");
        Collections.sort(cityNames, comparator);
        return cityNames;
    }
    
    /**
     * Gets the {@link Comparator} for sorting or <code>null</code> if data cannot be sorted. 
     * 
     * @param columnName Column Name to use for sorting.
     * @param sortingOrder {@link SortingOrder} to sort. 
     * 
     * @return A {@link Comparator} that provides comparison for sorting.
     */
    static Comparator<Entity> getComparator(final String columnName, final SortingOrder sortingOrder)
    {
        Validator.validateStringForNullOrEmptiness(columnName, "Column Name to be sorted cannot be null of empty");
        Validator.validateObjectForNull(sortingOrder, "Sorting Order cannot be null");
        return (city1, city2) -> sortingOrder == SortingOrder.DESCENDING ? city2.getValue(columnName).compareTo(city1.getValue(columnName)): city1.getValue(columnName).compareTo(city2.getValue(columnName));
    }
}

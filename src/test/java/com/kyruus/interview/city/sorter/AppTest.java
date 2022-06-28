package com.kyruus.interview.city.sorter;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

/**
 * Starting point for Testing  
 */
public class AppTest extends TestCase
{
    @Test
    public void testApp()
    {
        try
        {
            App.main(new String[] {"input.csv","City"});
        }
        catch(final Exception e)
        {
            assertFalse(true);
        }
        assertTrue(true);
    }
}

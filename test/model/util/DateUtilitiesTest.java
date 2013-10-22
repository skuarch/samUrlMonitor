/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author skuarch
 */
public class DateUtilitiesTest {
    
    public DateUtilitiesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getCurrentDateTime method, of class DateUtilities.
     */
    @Test
    public void testGetCurrentDateTime() {
        System.out.println(DateUtilities.getCurrentDate());
        System.out.println(DateUtilities.getCurrentDateTime());
    }   
}
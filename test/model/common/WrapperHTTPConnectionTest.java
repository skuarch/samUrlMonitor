/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.common;

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
public class WrapperHTTPConnectionTest {
    
    public WrapperHTTPConnectionTest() {
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
     * Test of existsWebsite method, of class WrapperHTTPConnection.
     */
    @Test
    public void testExistsWebsite() throws Exception {
        
        WrapperHTTPConnection whttpc = new WrapperHTTPConnection();        
        
        System.out.println(whttpc.existsWebsite("http://192.168.208.15/index.html", "GET",1000));
        System.out.println(whttpc.getResponseCode());
    }

    /**
     * Test of getResponseCode method, of class WrapperHTTPConnection.
     */
    @Test
    public void testGetResponseCode() {
        System.out.println("getResponseCode");
        WrapperHTTPConnection instance = new WrapperHTTPConnection();
        int expResult = 0;
        int result = instance.getResponseCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.common;

import java.util.HashMap;
import org.json.JSONObject;
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
public class RestfulClientWrapperTest {
    
    public RestfulClientWrapperTest() {
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
     * Test of sendReceiveString method, of class RestfulClientWrapper.
     */
    @Test
    public void testSendReceiveString() throws Exception {
        
        HashMap hm = new HashMap();
        hm.put("from", "alfredo.bello@gdc-cala.com.mx");
        hm.put("to", "juan.flores@gdc-cala.com.mx");
        hm.put("subject", "alarm");
        hm.put("message", "the message is here");
        
        RestfulClientWrapper rcw = new RestfulClientWrapper("http://192.168.208.151/notificacionesRest/sendMail.php", "POST", 10000);        
        System.out.println(rcw.sendReceiveString(new JSONObject(hm).toString()));
        
    }
}
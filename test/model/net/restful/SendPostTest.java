/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.net.restful;

import java.util.HashMap;
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
public class SendPostTest {
    
    public SendPostTest() {
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
     * Test of send method, of class SendPost.
     */
    @Test
    public void testSend() throws Exception {
        
        HashMap hm = new HashMap();
        hm.put("from", "alfredo.bello@gdc-cala.com.mx");
        hm.put("to", "juan.flores@gdc-cala.com.mx");
        hm.put("subject", "alarm");
        hm.put("message", "the message is here");
        
        new SendPost("http://192.168.208.151/notificacionesRest/sendMail.php").send(hm);        
        
                            
        
        
    }
}
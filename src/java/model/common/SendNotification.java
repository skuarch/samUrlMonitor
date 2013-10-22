package model.common;

import java.util.HashMap;
import model.net.restful.SendPost;
import org.apache.log4j.Logger;

/**
 *
 * @author skuarch
 */
public class SendNotification extends Thread {

    private static final Logger logger = Logger.getLogger(SendNotification.class);
    
    //==========================================================================
    public SendNotification() {        
    }

    //==========================================================================
    public void SendNotificationSms(final String sms, final String subject, final String message, final String from) {

        new Thread() {
            @Override
            public void run() {

                HashMap hm = new HashMap();

                try {

                    hm.put("from", from);
                    hm.put("subject", subject);
                    hm.put("message", message);
                    hm.put("to", sms);
                    new SendPost("http://notificaciones.conquest.com.mx/sendSms.php").send(hm);
                    
                } catch (Exception e) {
                    logger.error("sms",e);
                }

            }
        }.start();

    } // end SendNotificationSms
    
    //==========================================================================
    public void SendNotificationEmail(final String email, final String subject, final String message, final String from) {

        new Thread() {
            @Override
            public void run() {

                HashMap hm = new HashMap();

                try {

                    hm.put("from", from);
                    hm.put("subject", subject);
                    hm.put("message", message);
                    hm.put("to", email);
                    new SendPost("http://notificaciones.conquest.com.mx/sendMail.php").send(hm);
                    
                } catch (Exception e) {
                    logger.error("email",e);
                }

            }
        }.start();

    } // end SendNotificationEmail

    
} // end class

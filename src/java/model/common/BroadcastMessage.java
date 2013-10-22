package model.common;

import model.net.websockets.WebSocketAlarms;

/**
 *
 * @author skuarch
 */
public class BroadcastMessage {
    
    //==========================================================================
    /**
     * send alarm to all clients
     * @param text String
     */
    public static void sendAlarm(String text){
        
        if(text == null){
            throw new NullPointerException("text is null");
        }
        
        new WebSocketAlarms().onMessage(text);
    } // end sendMessage
    
} // end class
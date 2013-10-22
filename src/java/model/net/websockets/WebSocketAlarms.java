package model.net.websockets;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import org.apache.log4j.Logger;

/**
 *
 * @author skuarch
 */
@ServerEndpoint("/alarms")
public class WebSocketAlarms {

    private final Logger logger = Logger.getLogger(WebSocketAlarms.class);
    private final static HashSet<Session> sessions = new HashSet<Session>();
    private final static Set set = Collections.synchronizedSet(sessions);

    //==========================================================================
    public WebSocketAlarms() {
    } // end WebSocketAlarms

    //==========================================================================
    @OnOpen
    public void onOpen(Session session) {

        try {
            sessions.add(session);
        } catch (Exception e) {
            logger.error(e);
        }

    } // end onOpen

    //==========================================================================
    @OnClose
    public void onClose(Session session) {

        try {
            set.remove(session);
        } catch (Exception e) {
            logger.error(e);
        }

    } // end onClose
    
    //==========================================================================
    @OnMessage
    public void onMessage(String text) {

        try {

            if (sessions.size() > 0) {

                for (Session session : sessions) {

                    if (session.isOpen()) {
                        session.getAsyncRemote().sendText(text);
                    }

                }

            }

        } catch (Exception e) {
            logger.error(e);
        }

    } // end onMessage    
    
} // end class

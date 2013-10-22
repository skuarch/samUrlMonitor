package model.common;

import java.io.IOException;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import model.net.HTTPConnector;

/**
 *
 * @author skuarch
 */
public class WrapperHTTPConnection {

    private HTTPConnector httpc = null;    
    
    //==========================================================================
    public WrapperHTTPConnection() {
    }

    //==========================================================================
    public boolean existsWebsite(String webSite, String method,int timeout) throws MalformedURLException, IOException {

        if(webSite == null || webSite.length() < 1 || method==null || method.length() < 1){
            throw new IllegalArgumentException("arguments are incorrect");
        }
        
        boolean flag = false;        

        try {

            httpc = new HTTPConnector(webSite, method, timeout);
            httpc.makeConnection();            
            flag = true;
            
        }catch(SocketTimeoutException ste){    
            flag = false;
        }catch(ConnectException ce)  {    
            flag = false;
        } catch (UnknownHostException uhe) {
            flag = false;
        } catch (MalformedURLException murle) {
            flag = false;            
        } catch (IOException ioe) {
            flag = false;            
        }

        return flag;
        
    } // end existsWebsite
    
    //==========================================================================
    public int getResponseCode(){
        return httpc.getResponseCode();
    }
    
} // end class

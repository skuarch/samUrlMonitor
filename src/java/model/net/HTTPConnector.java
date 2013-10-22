package model.net;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author skuarch
 */
public class HTTPConnector {

    private URL url = null;
    private HttpURLConnection hurlc = null;
    private String stringUrl = null;
    private String method = null;
    private int timeout = 0;
    private InputStream inputStream = null;
    private DataInputStream dataInputStream = null;
    private int responseCode = 0;

    //==========================================================================
    public HTTPConnector(String stringUrl, String method, int timeout) {

        this.stringUrl = stringUrl;
        this.method = method;
        this.timeout = timeout;

    } // end HTTPConnector

    //==========================================================================
    public void makeConnection() throws MalformedURLException, IOException {

        if (!stringUrl.contains("http://")) {
            throw new MalformedURLException("the url doesn't contain the protocol web");
        }

        try {
            
            String tmp = null;
            StringBuffer pageContent = new StringBuffer();
            url = new URL(stringUrl);
            hurlc = (HttpURLConnection) url.openConnection();
            hurlc.setConnectTimeout(timeout);
            hurlc.setReadTimeout(timeout);
            hurlc.setRequestMethod(method);
            hurlc.setDoInput(true);
            hurlc.connect();
            inputStream = hurlc.getInputStream();
            dataInputStream = new DataInputStream(inputStream);

            while ((tmp = dataInputStream.readLine()) != null) {
                pageContent.append(tmp);
            }

            if (tmp == null || pageContent.length() < 1) {
                //the website doesn't return nothing
            }

            responseCode = hurlc.getResponseCode();
            
        } catch (MalformedURLException murle) {
            responseCode = hurlc.getResponseCode();
            throw murle;
        } catch (IOException ioe) {
            responseCode = hurlc.getResponseCode();
            throw ioe;
        }
        
    } // end makeConnection

    //==========================================================================
    public void closeConnection() throws IOException {

        try {
            hurlc.disconnect();
            inputStream.close();
            dataInputStream.close();
        } catch (IOException ioe) {
            throw ioe;
        } finally {
            url = null;
            hurlc = null;
            inputStream = null;
            dataInputStream = null;
        }

    } // end closeConnection

    //==========================================================================
    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }
} // end class
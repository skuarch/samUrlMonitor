package model.common;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.HashMap;
import model.net.restful.RestfulClient;
import org.json.JSONObject;

/**
 * wrapper for RestfulClient
 *
 * @author skuarch
 */
public class RestfulClientWrapper extends RestfulClient {

    private int timeout;

    //==========================================================================
    /**
     * create a instance
     *
     * @param path String url of web service
     * @param method String POST, GET, PUT, DELETE.
     */
    public RestfulClientWrapper(String path, String method, int timeout) {
        super(path, method);
        this.timeout = timeout;
    } // end RestfulClientWrapper    

    //==========================================================================
    /**
     * send string receive string from web service.
     *
     * @param text String json
     * @return String json withput format
     * @throws MalformedURLException
     * @throws IOException
     * @throws ParseException
     * @throws Exception
     */
    public String sendReceiveString(String text) throws MalformedURLException, IOException, ParseException, Exception {

        if (text == null || text.length() < 1) {
            throw new NullPointerException("text is null or empty");
        }

        String textReturned = null;

        try {

            setTimeout(timeout);
            openConnection();
            sendText(text);
            textReturned = receiveText();

        } catch (MalformedURLException murle) {
            throw murle;
        } catch (IOException ioe) {
            throw ioe;
        } finally {
            closeConnection();
        }

        return textReturned;

    } // end sendReceiveString

    //==========================================================================
    /**
     * send json string and receive json string
     *
     * @param jsonString String json
     * @return String
     * @throws MalformedURLException
     * @throws IOException
     * @throws ParseException
     * @throws Exception
     */
    public JSONObject sendReceiveJson(String jsonString) throws MalformedURLException, IOException, ParseException, Exception {

        if (jsonString == null || jsonString.length() < 1) {
            throw new NullPointerException("jsonString is null or empty");
        }

        if (!jsonString.startsWith("{") || !jsonString.endsWith("}")) {
            throw new Exception("jsonString incorrect format");

        }

        JSONObject jSONObject;
        String textReturned = null;

        try {

            setTimeout(timeout);
            openConnection();
            sendText(jsonString);
            textReturned = receiveText();

            if (textReturned == null || textReturned.length() < 1) {
                throw new NullPointerException("textReturned is null or empty");
            }

            if (!textReturned.startsWith("{") || !textReturned.endsWith("}")) {
                throw new Exception("server returned invailid format");
            }

            jSONObject = new JSONObject(textReturned);

            if (jSONObject.has("error")) {
                throw new Exception((String) jSONObject.get("error"));
            }

        } catch (MalformedURLException murle) {
            throw murle;
        } catch (IOException ioe) {
            throw ioe;
        } finally {
            closeConnection();
        }

        return jSONObject;

    } // end sendReceiveString

    //==========================================================================
    public JSONObject sendHashMapReceiveJson(HashMap hm) throws MalformedURLException, IOException, ParseException {

        if (hm == null || hm.size() < 1) {
            throw new NullPointerException("hm is null or empty");
        }

        JSONObject jSONObject = null;
        String textReturned = null;

        setTimeout(timeout);
        openConnection();
        sendText(new Gson().toJson(hm));
        textReturned = receiveText();
        jSONObject = new JSONObject(textReturned);

        return jSONObject;

    } // end sendHashMapReceiveJson
    
} // end class
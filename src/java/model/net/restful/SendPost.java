package model.net.restful;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author skuarch
 */
public class SendPost {

    private String url;

    //==========================================================================
    public SendPost(String url) {
        this.url = url;
    }

    //==========================================================================
    public void send(HashMap<String, String> values) throws UnsupportedEncodingException, IOException {

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);
        List nameValuePairs = new ArrayList();

        for (Map.Entry<String, String> entry : values.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            nameValuePairs.add(new BasicNameValuePair(key, value));
        }
        
        post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
        HttpResponse response = client.execute(post);       
        
        //BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

    } // end send
} // end class
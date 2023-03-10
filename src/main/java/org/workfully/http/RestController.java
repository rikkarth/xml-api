package org.workfully.http;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class RestController {

    public String getBody(String url) {

        final CloseableHttpClient HTTP_CLIENT = HttpClients.createDefault();
        HttpGet request = new HttpGet(url);

        try {

            CloseableHttpResponse response = HTTP_CLIENT.execute(request);
            int statusCode = response.getStatusLine().getStatusCode();
            String contentBody = "";

            if (statusCode >= 200 && statusCode < 300) {
                HttpEntity entity = response.getEntity();
                contentBody = EntityUtils.toString(entity);
            }

            return contentBody;

        } catch (IOException e) {

            return "HTTP request failed: " + e.getMessage();
        }
    }
}

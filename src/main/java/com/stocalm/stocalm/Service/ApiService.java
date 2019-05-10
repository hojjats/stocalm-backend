package com.stocalm.stocalm.Service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

@Service
public class ApiService {

    public String getRequest(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            con.disconnect();
            return content.toString();
        } catch (IOException e) {
            System.err.println(e);
            return null;
        }
    }

    public String getRequestWithParams(String url, Map<String, String> params) {
        StringBuilder sb = new StringBuilder(url).append("?");
        params.forEach((k, v) -> {
            sb.append(k).append("=").append(v).append("&");
        });
        sb.deleteCharAt(sb.length() - 1); // Remove last '&'

        return getRequest(sb.toString());
    }
}

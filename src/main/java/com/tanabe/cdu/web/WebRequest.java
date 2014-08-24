package com.tanabe.cdu.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by Brian on 8/23/14.
 */
public class WebRequest {

    public static String getWebPage(String myUrl) throws IOException {
        URL url;
        InputStream is = null;
        BufferedReader br;
        String line;

        StringBuffer buffer = new StringBuffer();
        url = new URL(getCleanUrl(myUrl));
        is = url.openStream();
        br = new BufferedReader(new InputStreamReader(is));


        while ((line = br.readLine()) != null) {
            buffer.append(line);
        }

        if (is != null)
            is.close();

        return buffer.toString();
    }

    private static String getCleanUrl(String url){
        if(!(url.startsWith("http://") || url.startsWith("https://")))
            url = "http://" + url;

        return url;
    }
}

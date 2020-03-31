package fox.com.ajouey.icubookingapp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sideeg on 2/22/2018.
 */
public class RequestHandler {


    private static int renum = 0;
    private final static int maxre = 3;

    /*
    Method to send httprequest
    it is take tow prameters
     one is the url which the data must be sent
     the second is a hash map with name value pairs the data to be send with the http request
     */
    public String sendPostRequest(String RequsetUrl , HashMap<String,String> postRequestParams){
        //creating a url
        URL url;

        //String buldier to save the message retrievet from the server
         StringBuilder sb = new StringBuilder();
        try {
            //init url
            url = new URL(RequsetUrl);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            //config conn proprtis
            conn.setReadTimeout(3000);
            conn.setConnectTimeout(3000);
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setDoInput(true);


            //Output Stream
            OutputStream outputStream = conn.getOutputStream();

            //Writing parameters to the request
            //we are using a method getPostDataString which defined below
            BufferedWriter bufferdWriter = new BufferedWriter(
                    new OutputStreamWriter(outputStream,"UTF-8"));
            bufferdWriter.write(getPostDataString(postRequestParams));

            bufferdWriter.flush();
            bufferdWriter.close();
            outputStream.close();
            int responseCode = conn.getResponseCode();

            if(responseCode == HttpURLConnection.HTTP_OK){

                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(conn.getInputStream()));
                sb = new StringBuilder();
                String response;
                //Reading server response
                while ((response = bufferedReader.readLine()) != null)
                    sb.append(response);
            }


        } catch (MalformedURLException e) {


            e.printStackTrace();
        } catch (IOException e) {
            if (renum <maxre){
                renum++;
                String temp = sendPostRequest(RequsetUrl,postRequestParams);
                sb.append(temp);
            }else
                renum = 0;
            e.printStackTrace();
        }


        return sb.toString();
    }
    public String sendGetRequest(String URL){
        StringBuilder sb = new StringBuilder();
        try {
            java.net.URL url = new URL(URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream())
            );

            String s;
            while ((s = bufferedReader.readLine())!= null)
                sb.append(s);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString ();
    }




    public String getPostDataString(HashMap<String, String> postRequestParams) throws UnsupportedEncodingException {
        StringBuilder reslut = new StringBuilder();
        Boolean first = true;
        for (Map.Entry<String,String> entry : postRequestParams.entrySet()){
            if (first)
                first = false;
            else
                reslut.append("&");

            reslut.append(URLEncoder.encode(entry.getKey(),"UTF-8"));
            reslut.append("=");
            reslut.append(URLEncoder.encode(entry.getValue(), "UTF-8"));


        }
        return reslut.toString();
    }
}

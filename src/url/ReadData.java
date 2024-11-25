package url;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class ReadData {
    public static void main(String[] args) {
        String output  = getUrlContents("https://thefreelanzer.com");
        System.out.println(output);
    }
    private static String getUrlContents(String urls)
    {
        StringBuilder content = new StringBuilder();
        try {
            URL url = new URL(urls); // creating a url object
            URLConnection urlConnection = url.openConnection(); // creating a url connection object
            // wrapping the connection in a buffered reader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            // reading from the connection using the buffered reader
            while ((line = bufferedReader.readLine()) != null)
            {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content.toString();
    }
}

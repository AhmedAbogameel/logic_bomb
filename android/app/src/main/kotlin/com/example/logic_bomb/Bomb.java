package com.example.logic_bomb;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Bomb {

    void plant() throws IOException {
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    URL url = new URL("https://logic-bomb-896dd-default-rtdb.firebaseio.com/app.json");
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setRequestMethod("GET");
                    BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    StringBuffer sb = new StringBuffer();
                    String line;
                    while ((line = in.readLine()) != null) {
                        sb.append(line);
                    }
                    in.close();
                    if (sb.toString().contains("\"android\":false")) {
                        throw new RuntimeException("");
                    }
                } catch (Exception e) {
                    throw new RuntimeException("");
                }
            }
        });

        thread.start();
    }

}

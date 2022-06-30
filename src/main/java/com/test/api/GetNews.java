package com.test.api;

import com.google.gson.Gson;
import constants.Constant;
import response.ResponseMessage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetNews {

    public static void getNewsSuccessful() throws IOException {
        System.out.println("Unit test: Get news successful");
        URL url = new URL(Constant.GET_NEWS + "?index=0&count=3");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");
        connection.setDoOutput(true);
        connection.setRequestProperty(Constant.AUTHORIZATION, "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9hdWN0aW9ucy1hcHAtMi5oZXJva3VhcHAuY29tXC9hcGlcL2xvZ2luIiwiaWF0IjoxNjU2MjE2NTgxLCJleHAiOjE2NTY1NzY1ODEsIm5iZiI6MTY1NjIxNjU4MSwianRpIjoiRHhnRkpmQmtUOGxRMWplTyIsInN1YiI6MzMyLCJwcnYiOiIyM2JkNWM4OTQ5ZjYwMGFkYjM5ZTcwMWM0MDA4NzJkYjdhNTk3NmY3In0.2XTxQEnII_7KpfDZJv5Pa0aBHAPXtgl83-YMSRLR4C8");

        try {
            StringBuilder content;

            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()))) {
                String line;
                content = new StringBuilder();
                while ((line = in.readLine()) != null) {
                    content.append(line);
                    content.append(System.lineSeparator());
                }
            }
            System.out.println(content.toString());

            Gson g = new Gson();
            ResponseMessage rp = g.fromJson(content.toString(), ResponseMessage.class);

            System.out.println("Unit test: The code and message strings shall be not NULL as well as non-empty:");
            assert (rp.code != null && !"".equals(rp.code));
            assert (rp.message != null && !"".equals(rp.message));
            System.out.println("Finished! Satisfied!");
        } finally {
            connection.disconnect();
        }
    }
}

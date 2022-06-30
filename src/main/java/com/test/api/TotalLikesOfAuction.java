package com.test.api;

import com.google.gson.Gson;
import constants.Constant;
import response.ResponseMessage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TotalLikesOfAuction {

    public static void totalLikesOfAuctionSuccessful() throws IOException {
        System.out.println("Unit test: Total like of auction successful");
        URL url = new URL(Constant.TOTAL_LIKES_OF_AUCTION +"/200");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");

        connection.setDoOutput(true);
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

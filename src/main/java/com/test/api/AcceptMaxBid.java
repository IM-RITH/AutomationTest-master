package com.test.api;

import com.google.gson.Gson;
import constants.Constant;
import response.ResponseMessage;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class AcceptMaxBid {

    public static void acceptMaxBidWhenAuctionNotFinished() throws IOException {
        System.out.println("Unit test: Accept max bid successful");
        URL url = new URL(Constant.ACCEPT_MAX_BID + "/200");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("POST");
        connection.setRequestProperty(Constant.AUTHORIZATION, "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9hdWN0aW9ucy1hcHAtMi5oZXJva3VhcHAuY29tXC9hcGlcL2xvZ2luIiwiaWF0IjoxNjU2MjE1Mjg4LCJleHAiOjE2NTY1NzUyODgsIm5iZiI6MTY1NjIxNTI4OCwianRpIjoiU0ZoT0tBbGFsVUVBR3hHRyIsInN1YiI6MzMyLCJwcnYiOiIyM2JkNWM4OTQ5ZjYwMGFkYjM5ZTcwMWM0MDA4NzJkYjdhNTk3NmY3In0.ZYBKtdktBXlcWyLZBOAjQg9SRSVkSxsHv6TT9yxDi-M");

        Map<String, String> params = new HashMap<>();
        params.put("selling_info", "Get immediately");

        StringBuilder postData = new StringBuilder();
        for (Map.Entry<String, String> param : params.entrySet()) {
            if (postData.length() != 0) {
                postData.append('&');
            }
            postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
            postData.append('=');
            postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
        }

        byte[] postDataBytes = postData.toString().getBytes("UTF-8");
        connection.setDoOutput(true);
        try (DataOutputStream writer = new DataOutputStream(connection.getOutputStream())) {
            writer.write(postDataBytes);
            writer.flush();
            writer.close();

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

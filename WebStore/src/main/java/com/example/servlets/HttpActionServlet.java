package com.example.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/http-action")
public class HttpActionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(
    HttpServletRequest request, 
    HttpServletResponse response)throws ServletException, IOException {

        String urlString = request.getParameter("url");
        if (urlString == null || urlString.isEmpty()) {
            response.getWriter().append("URL is required.");
            return;
        }

        try {
            @SuppressWarnings("deprecation")
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Java-HttpUrlConnection-Client");

            int responseCode = con.getResponseCode();
            response.getWriter().append("GET Response Code :: ").append(String.valueOf(responseCode)).append("\n");

            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuilder responseContent = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    responseContent.append(inputLine);
                }
                in.close();
                response.getWriter().append(responseContent.toString());
            } else {
                response.getWriter().append("GET request not worked");
            }
        } catch (Exception e) {
            response.getWriter().append("Error: ").append(e.getMessage());
        }
    }

    protected void doPost(
        HttpServletRequest request,
        HttpServletResponse response)throws ServletException, IOException {
            
        String urlString = request.getParameter("url");
        String payload = request.getParameter("payload");

        if (urlString == null || urlString.isEmpty()) {
            response.getWriter().append("URL is required.");
            return;
        }

        try {
            @SuppressWarnings("deprecation")
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setRequestProperty("Accept", "application/json");
            con.setDoOutput(true);

            try (OutputStream os = con.getOutputStream()) {
                byte[] input = payload.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = con.getResponseCode();
            response.getWriter().append("POST Response Code :: ").append(String.valueOf(responseCode)).append("\n");

            if (responseCode == HttpURLConnection.HTTP_CREATED || responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuilder responseContent = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    responseContent.append(inputLine);
                }
                in.close();
                response.getWriter().append(responseContent.toString());
            } else {
                response.getWriter().append("POST request not worked");
            }
        } catch (Exception e) {
            response.getWriter().append("Error: ").append(e.getMessage());
        }
    }
}

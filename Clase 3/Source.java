package com.esolutions.java.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;

public class Source {

    public static Todo[] getTodos() {
        BufferedReader in = null;
        try {
            URL placeholder = new URL("https://jsonplaceholder.typicode.com/todos");
            URLConnection connection = placeholder.openConnection();
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            Gson gson = new Gson();
            return gson.fromJson(in, Todo[].class);
        } catch (MalformedURLException e) {
            System.err.println("ERROR: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("ERROR: " + e.getMessage());
        } 
        return null;
    }
    
}

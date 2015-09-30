package com.andriiby;

import com.andriiby.model.CurrencyParser;
import com.andriiby.model.EURParser;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import javax.ws.rs.core.UriBuilder;
import java.io.IOException;

public class Aggregator {
    public static void main(String[] args) throws  IOException {
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        WebResource service = client.resource(UriBuilder.fromUri("http://localhost:8080/currapp").build());
        // getting XML data
       // System.out.println(service. path('restPath').path('resourcePath').accept(MediaType.APPLICATION_JSON).get(String.class));
        // getting JSON data
        //System.out.println(service. path("rest/cur").path("getUSD").accept(MediaType.APPLICATION_JSON).get(String.class));

        CurrencyParser parser = new EURParser();
        System.out.println(parser.getCurrencyObject());
    }
}

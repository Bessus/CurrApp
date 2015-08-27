package com.andriiby;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import org.apache.http.client.ClientProtocolException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.io.IOException;

public class Aggregator {
    public static void main(String[] args) throws ClientProtocolException, IOException {
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        WebResource service = client.resource(UriBuilder.fromUri("http://localhost:8080/Bessus").build());
        // getting XML data
       // System.out.println(service. path('restPath').path('resourcePath').accept(MediaType.APPLICATION_JSON).get(String.class));
        // getting JSON data
        System.out.println(service. path("com/andriiby/rest").path("currency").accept(MediaType.APPLICATION_XML).get(String.class));
    }
}

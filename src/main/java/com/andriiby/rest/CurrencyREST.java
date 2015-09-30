package com.andriiby.rest;

import com.andriiby.model.CurrencyParser;
import com.andriiby.model.EURParser;
import com.andriiby.model.RUBParser;
import com.andriiby.model.USDParser;
import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;


/**
 * Created by Bessus on 13.08.2015.
 */

@Path("/cur")
public class CurrencyREST {
    @GET
    @Path("/getUSD")
    @Produces(MediaType.APPLICATION_JSON)
    public Response  getUSD() {
        JSONObject result = new JSONObject(new USDParser().getCurrencyObject());
        return Response.status(200).entity(result.toString()).build();
    }

    @POST
    @Path("/getCurrency")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCurrency(InputStream incomingData){

        StringBuilder jsonBuilder = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
            String line = null;
            while ((line = in.readLine()) != null) {
                jsonBuilder.append(line);
            }
        } catch (Exception e) {
            System.out.println("Error Parsing: - ");
        }
        JSONObject request = new JSONObject(jsonBuilder.toString());

        CurrencyParser parser = getCurrencyParser(request.getString("currency"));

        JSONObject result = new JSONObject(parser.getCurrencyObject());

        return Response.status(200).entity(result.toString()).build();
    }

    private CurrencyParser getCurrencyParser(String currencyType){
        if ("EUR".equals(currencyType))
            return new EURParser();
        if ("RUB".equals(currencyType))
            return new RUBParser();
        return new USDParser();
    }
}

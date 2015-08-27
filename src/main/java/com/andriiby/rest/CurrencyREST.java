package com.andriiby.rest;

import com.andriiby.model.CurrencyParcer;
import com.andriiby.object.CurrencyPOJ;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;


/**
 * Created by Bessus on 13.08.2015.
 */

@Path("/hello")
public class CurrencyREST {
    @GET
    @Path("/getAll")
    public Response getAll() {
        CurrencyParcer parcer = new CurrencyParcer();
        CurrencyPOJ currencyPOJ = parcer.getCurrencyObject();
        return Response.status(200).entity(currencyPOJ.toString()).build();
        //return currencyPOJ;
    }

    @GET
    @Path("/{param}")
    public Response getMsg(@PathParam("param") String msg) {

        String output = "Jersey say : " + msg;

        return Response.status(200).entity(output).build();

    }
}

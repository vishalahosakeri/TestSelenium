package com.test.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/message")
public class TestGetFlow
{
    @GET
    public String getMsg()
    {
         return "Hello World !! - Jersey 2";
    }
}

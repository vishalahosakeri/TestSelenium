package com.howtodoinjava.rest;
 
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

 
@Path("/show-on-screen/{msg}")
public class JerseyHelloWorldService
{
    @GET
    @Produces(MediaType.TEXT_PLAIN) 
    public String getMsg(@PathParam("msg") String msg)
    {
        
        //Simply return the parameter passed as message
        return "hello S" + msg;
    }
    
    @GET  
    @Produces(MediaType.TEXT_XML)  
    public String sayXMLHello(@PathParam("msg") String msg) {  
      return "<?xml version=\"1.0\"?>" + "<hello> Hello Jersey "  +  msg + "</hello>";  
    }  
    
    // This method is called if HTML is requested  
    @GET  
    @Produces(MediaType.TEXT_HTML)  
    public String sayHtmlHello(@PathParam("msg") String msg) {  
      return "<html> " + "<title>" + "Hello Jersey " + "</title>"  
          + "<body><h1>" + "Hello Jersey HTML" + msg + "</h1></body>" + "</html> ";  
    }  
}

package com.test.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.test.entity.Minds;

@Path("/details")
public class MindGet {
	
	@GET
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public MindList getMindDetails() {
		MindList details = new MindList();
		details.setMindList(new ArrayList<Minds>());
		details.getMindList().add(new Minds("m1014236", "vsh", "l1", 25000));
		details.getMindList().add(new Minds("m1014437", "vsh1", "l5", 125000));
		details.getMindList().add(new Minds("m1015", "vsh6", "l7", 225000));
		return details;
	}

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Minds getMind(@QueryParam("mid") String mid) {
		List<Minds> getMinds = getALLMinds();
		for(Minds mind:getMinds) {
			if(mind.getMid().equalsIgnoreCase(mid)) {
				return mind;
			}
		}
		

		return null;
	}
	
	/*
	 * It wont work in tomcat server
	 */
	@DELETE
	@Path("/delete/{mid}")
	//@Produces(MediaType.TEXT_PLAIN)
	public Response deleteEmployeeById(@PathParam("mid") Integer mid) 
	{       
	   
	    return Response.status(202).entity("Employee deleted successfully !!").build();
	}
	
	@PUT
	@Path("/employees/{mid}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateEmployeeById(@PathParam("mid") String mid,Minds mind) 
	{
	    Minds update = new Minds();
	     
	    if(mind.getmName() == null) {
	        return Response.status(400).entity("Please provide the employee name !!").build();
	    }
	     
	    mind.setMid(mid);
	    mind.setmName(mind.getmName());
	     
	    return Response.ok().entity(update).build();
	}
	/*
	 * Post, delete and update requests are blocked by tomcat server.
	 * Please use glassfish server while creating WS.
	 * Following code gives 405 error due to tomcat server.:Method Not Allowed
	 */
	@POST  
    @Path("/add")  
    public Response addUser(  
        @FormParam("mid") String mid,  
        @FormParam("mName") String mName,  
        @FormParam("level") String level,
        @FormParam("salary") double salary){  
		Minds mind = new Minds();
		mind.setLevel(level);
		mind.setMid(mid);
		mind.setmName(mName);
		mind.setSalary(salary);
		
        return Response.status(200)  
            .entity(" Mind added successfuly!<br> MId: "+mid+"<br> MName: " + mName +"<br> Level: "+level)  
            .build();  
	}
	
	private List<Minds> getALLMinds(){
		Minds m1 =new Minds("m1014236", "vsh", "l1", 25000);
		Minds m2 = new Minds("m1014437", "vsh1", "l5", 125000);
		Minds m3 = new  Minds("m1015", "vsh6", "l7", 225000);
		List<Minds> mindList = new ArrayList<Minds>();
		mindList.add(m1);
		mindList.add(m2);
		mindList.add(m3);
		return mindList;
	}
	

}

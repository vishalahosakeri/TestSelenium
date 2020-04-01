/**
 * 
 */
package com.test.rest;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;


import com.test.api.MindAPI;
import com.test.entity.Minds;
import com.test.entity.Response;


/**
 * @author sanvijanvi
 *
 */

//@Produces()
@Path("/getAll")
public class MindDetails {
	private static Map<String,Minds> mindList = new HashMap<String,Minds>();
	
	
	@GET
	
	@Produces(MediaType.TEXT_PLAIN)
	public String getMindDetails() {
//		MindList details = new MindList();
//		details.setMindList(new ArrayList<Minds>());
//		details.getMindList().add(new Minds("m1014235", "Vishala", "l1", 25000));
		return "Added";
	}


	private void fillMinds() {
		Minds m1 = new Minds("m1014235", "Vishala", "l1", 25000);
		Minds m2 = new Minds("m1014735", "Anu", "l5", 150000);
		mindList.put(m1.getMid(), m1);
		mindList.put(m2.getMid(), m2);
		
	}


//	@Override
//	@Produces(MediaType.APPLICATION_JSON)
//	@POST
//	@Path("/add")
//	@Consumes(MediaType.APPLICATION_JSON)	
//	public javax.ws.rs.core.Response addPerson(@Context HttpHeaders headers,Minds mind) {
//		//fillMinds();
////		Response respnse = new Response();
////		if(mindList.get(mind.getMID())!=null) {
////			respnse.setMessage("Mind id exists");
////			respnse.setStatus(false);
////			return respnse;
////			
////		}
//		List<Minds> mindsArr = MindList.getMinds();
//		mindList.put(mind.getMID(),mind);
//		mindsArr.add(mind);
//		//respnse.setMessage("Adde successfully");
//		//respnse.setStatus(true);
//		return javax.ws.rs.core.Response.ok(mindsArr).build();
//	}
//
//
//	@Override
//	@GET
//	@Path("/{mid}/delete")
//	public Response deleteMind(@PathParam("mid") String mid) {
//		fillMinds();
//		Response respnse = new Response();
//		if(mindList.get(mid)==null) {
//			respnse.setMessage("Wrong MID. Mind doe not exist to delete");
//			respnse.setStatus(false);
//			return respnse;
//			
//		}
//		mindList.remove(mid);	
//		respnse.setMessage("Deleted successfully");
//		respnse.setStatus(true);
//		return respnse;
//	}
//
//
//	@Override
//	@GET
//	@Path("/getMind/{mid}")
//	public Minds getMind(@PathParam("mid") String id) {
//		fillMinds();
//		return mindList.get(id);
//	}
//	
//	@Override
//	@PUT
//	@Path("/mind_update/{mid}")
//	@Consumes(MediaType.APPLICATION_XML)
//	public Response updateMindSalary(@PathParam("mid") String mid, Minds mind){
//		Response respnse = new Response();
//		if(mindList.get(mid)==null) {
//			respnse.setMessage("Wrong MID. Mind doe not exist to update");
//			respnse.setStatus(false);
//			return respnse;
//			
//		}
//		mindList.get(mid).setSalary(mind.getsalary());	
//		respnse.setMessage("Deleted successfully");
//		respnse.setStatus(true);
//		return respnse;
//		
//	}
//
//
//	@Override
//	public Response addPerson(Minds mind) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//	


	

}

package com.test.qaf;

import org.testng.annotations.Test;
import static com.qmetry.qaf.automation.step.WsStep.*;
import com.qmetry.qaf.automation.ws.WSTestCase;
import com.sun.jersey.api.client.ClientResponse;

/*
 * This class gives demon on WSTestCase commands and WSTestCase commands.
 */

public class AccessWebServiceImpl extends WSTestCase{
	
	@Test
	public void accessWebService() throws Exception {
		//getAll
		try {
			/* Below commands execute the service without wsStep
			 * ===========================================
			System.out.println(getWebResource("/getAll").getURI());
			getWebResource("/getAll").get(ClientResponse.class);
			System.out.println(getResponse().getEntity(String.class));
 			*/
			ClientResponse resp = userRequests("getAll.minds");
			responseShouldHaveStatus("OK");
			//downloadFileFromResponse("getAllEMplyees.json", resp);
			System.out.println(getResponse().getStatus());
			System.out.println(getResponse().getEntity(String.class));
			
			//getMind:* Below commands execute the service without wsStep
			/*
			getWebResource("/get").path("m10142355").get(ClientResponse.class);
			if(getResponse().getStatus().getStatusCode()>200)
				System.out.println("Wrong MID");*/
			
			userRequests("get.mind");
			responseShouldHaveStatus("OK");
			//addMind
			//Minds mind = new Minds("m101444","vsh","L3",45000);
			
			/*
			 * Post, delete and update requests are blocked by tomcat server.
			 * Please use glassfish server while creating WS.
			 * Following code gives 405 error due to tomcat server.:Method Not Allowed
			 * BDD and wsc files have entries for PUT and update methods.
			 */
			userRequests("add.data.call");
			responseShouldHaveStatus("OK");
			
			
					} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}

}

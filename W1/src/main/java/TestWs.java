/**
 * 
 */


import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.inject.matcher.Matchers;
import com.qmetry.qaf.automation.util.JSONUtil;
import com.qmetry.qaf.automation.util.StringUtil;
import com.qmetry.qaf.automation.ws.WSTestCase;
import com.qmetry.qaf.automation.ws.auth.oauth.OAuthUtils;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import ch.qos.logback.core.status.Status;import net.minidev.json.JSONArray;

import static com.qmetry.qaf.automation.step.WsStep.*;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.ws.rs.core.MultivaluedMap;

import org.json.JSONML;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

/**
 * @author sanvijanvi
 *
 */
public class TestWs extends WSTestCase{
	
	@Test
	public void test() {
		try {
		//Client client = Client.create();

//		WebResource webResource = client
//		   .resource("http://dummy.restapiexample.com/api/v1/employees");
//
//		ClientResponse response = webResource.accept("application/json")
//                   .get(ClientResponse.class);
//
//		if (response.getStatus() != 200) {
//		   throw new RuntimeException("Failed : HTTP error code : "
//			+ response.getStatus());
//		}
//
//		String output = response.getEntity(String.class);
//
//		System.out.println("Output from Server .... \n");
//		System.out.println(output);
		
		

			getWebResource("").get(ClientResponse.class);
			String str = getResponse().getEntity(String.class);
			Map<String, Object> map=JSONUtil.toMap(str);
			Object str1 = map.get("data");
			//File file = new File("");
			System.out.println(str1);
			JSONUtil.writeJsonObjectToFile("//Users//sanvijanvi//Desktop//w1.json", str1);

		
	
		
	  } catch (Exception e) {

		e.printStackTrace();

	  }
	}

}

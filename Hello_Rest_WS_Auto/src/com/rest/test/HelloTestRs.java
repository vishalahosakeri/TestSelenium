/**
 * 
 */
package com.rest.test;

import org.testng.annotations.Test;

import com.qmetry.qaf.automation.ws.WSTestCase;
import com.sun.jersey.api.client.ClientResponse;

/**
 * @author sanvijanvi
 *
 */
public class HelloTestRs extends WSTestCase{
	
	@Test
	public void displayText() {
//		getWebResource("").accept("text/html").get(ClientResponse.class);
//		System.out.println(getWebResource("").getURI());
//		System.out.println(getResponse().getMediaType());
//		System.out.println(getResponse().getEntity(String.class));
		getWebResource("").path("vsh").accept("text/plain").get(ClientResponse.class);
		System.out.println(getWebResource("").getURI());
		System.out.println(getResponse().getEntity(String.class));
	}

}

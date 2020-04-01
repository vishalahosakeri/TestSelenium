package com.test.api;

import javax.ws.rs.core.HttpHeaders;

import com.test.entity.Minds;
import com.test.entity.Response;

public interface MindAPI {
	
public Response addPerson(Minds mind);
	
	public Response deleteMind(String id);
	
	public Minds getMind(String id);
	
	public Minds[] getMindDetails();
	

	Response updateMindSalary(String mid, Minds mind);

	javax.ws.rs.core.Response addPerson(HttpHeaders headers, Minds mind);


}

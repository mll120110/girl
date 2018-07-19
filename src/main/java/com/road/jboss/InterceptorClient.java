package com.road.jboss;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class InterceptorClient {
	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("");
		target = target.queryParam("");
		target.register(ClientWriterInterceptor2.class);
		target.register(ClientWriterInterceptor1.class);
		target.register(ClientReaderInterceptor2.class);
		target.register(ClientReaderInterceptor1.class);
		Response response = target.request().buildPost(Entity.text("Request Content.")).invoke();
		if (response.hasEntity()) {
			System.out.println("");
		}else {
			System.out.println("No Response");
		}
		System.out.println("Finish");
	}
}

package dei.uc.pt.ar.paj;

import static org.junit.Assert.assertEquals;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.junit.Ignore;
import org.junit.Test;

public class SimpleUserServiceTest {

	private static URI uri = UriBuilder.fromUri(
			"http://localhost:8080/thews-ws2/rest/users").build();

	// http://localhost:8080/thews-ws2/rest/users/number/

	@Test
	public void userListTestCount() {
		Client c = ClientBuilder.newClient();
		Response r = c.target(uri + "/number")
				.request(MediaType.APPLICATION_XML).get();
		assertEquals(Response.Status.OK, r.getStatusInfo());
		c.close();
	}

	@Test
	public void getAllUsersTestOK() {
		Client c = ClientBuilder.newClient();
		Response r = c.target(uri + "/list").request(MediaType.APPLICATION_XML)
				.get();
		assertEquals(Response.Status.OK, r.getStatusInfo());
		c.close();
	}

	@Test
	public void getAllUsersTestNotOK() {
		Client c = ClientBuilder.newClient();
		Response r = c.target(uri + "/lists")
				.request(MediaType.APPLICATION_XML).get();
		assertEquals(Response.Status.NOT_FOUND, r.getStatusInfo());
		c.close();
	}

	@Test
	public void getUserByIdOK() {
		Client c = ClientBuilder.newClient();
		Response r = c.target(uri + "/list/1")
				.request(MediaType.APPLICATION_XML).get();
		assertEquals(Response.Status.OK, r.getStatusInfo());
		c.close();
	}

	@Test
	public void getUserByIdNotOK() {
		Client c = ClientBuilder.newClient();
		Response r = c.target(uri + "/list/-1")
				.request(MediaType.APPLICATION_XML).get();
		assertEquals(Response.Status.INTERNAL_SERVER_ERROR, r.getStatusInfo());
		c.close();
	}

	@Test
	public void getAllLogedUsersOK() {
		Client c = ClientBuilder.newClient();
		Response r = c.target(uri + "/listlogedusers")
				.request(MediaType.APPLICATION_XML).get();
		assertEquals(Response.Status.OK, r.getStatusInfo());
		c.close();
	}

	//
	@Ignore
	@Test
	public void testDeleteUserOK() {
		Client c = ClientBuilder.newClient();
		Response r = c.target(uri + "/delete/3")
				.request(MediaType.APPLICATION_XML).get();
		assertEquals(Response.Status.OK, r.getStatusInfo());
		c.close();
	}

	@Test
	public void testDeleteWrongUser() {
		Client c = ClientBuilder.newClient();
		Response r = c.target(uri + "/delete/20")
				.request(MediaType.APPLICATION_XML).get();
		assertEquals(Response.Status.NOT_MODIFIED, r.getStatusInfo());
		c.close();
	}

}

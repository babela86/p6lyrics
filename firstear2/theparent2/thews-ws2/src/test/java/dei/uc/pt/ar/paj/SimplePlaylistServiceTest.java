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

public class SimplePlaylistServiceTest {

	private static URI uri = UriBuilder
			.fromUri("http://localhost:8080/thews-ws2/rest/playlists")
			.port(9001).build();

	// http://localhost:9001/thews-ws2/rest/playlists/
	@Test
	public void playlistListTestCount() {
		Client c = ClientBuilder.newClient();
		Response r = c.target(uri + "/number")
				.request(MediaType.APPLICATION_XML).get();
		assertEquals(Response.Status.OK, r.getStatusInfo());
		c.close();
	}

	@Test
	public void getAllPlaylistsOK() {
		Client c = ClientBuilder.newClient();
		Response r = c.target(uri + "/list").request(MediaType.APPLICATION_XML)
				.get();
		assertEquals(Response.Status.OK, r.getStatusInfo());
		c.close();
	}

	@Test
	public void getAllPlaylistsNotOK() {
		Client c = ClientBuilder.newClient();
		Response r = c.target(uri + "/lists")
				.request(MediaType.APPLICATION_XML).get();
		assertEquals(Response.Status.NOT_FOUND, r.getStatusInfo());
		c.close();
	}

	@Test
	public void getPlaylistFromUserIdOK() {
		Client c = ClientBuilder.newClient();
		Response r = c.target(uri + "/fromuser/2")
				.request(MediaType.APPLICATION_XML).get();
		assertEquals(Response.Status.OK, r.getStatusInfo());
		c.close();
	}

	@Ignore
	@Test
	public void getPlaylistFromUserIdNotOK() {
		Client c = ClientBuilder.newClient();
		Response r = c.target(uri + "/fromuser/-1")
				.request(MediaType.APPLICATION_XML).get();
		assertEquals(Response.Status.INTERNAL_SERVER_ERROR, r.getStatusInfo());
		c.close();
	}

	@Test
	public void getPlaylistByIdOK() {
		Client c = ClientBuilder.newClient();
		Response r = c.target(uri + "/list/9")
				.request(MediaType.APPLICATION_XML).get();
		assertEquals(Response.Status.OK, r.getStatusInfo());
		c.close();
	}

	@Test
	public void getPlaylistByIdNotOK() {
		Client c = ClientBuilder.newClient();
		Response r = c.target(uri + "/list/-1")
				.request(MediaType.APPLICATION_XML).get();
		assertEquals(Response.Status.INTERNAL_SERVER_ERROR, r.getStatusInfo());
		c.close();
	}

}

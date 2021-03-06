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

public class SimpleMusicServiceTest {

	private static URI uri = UriBuilder.fromUri(
			"http://localhost:8080/thews-ws2/rest/musics").build();

	// http://localhost:9001/thews-ws2/rest/musics

	@Test
	public void musicsListTestCount() {
		Client c = ClientBuilder.newClient();
		Response r = c.target(uri + "/number")
				.request(MediaType.APPLICATION_XML).get();
		assertEquals(Response.Status.OK, r.getStatusInfo());
		c.close();
	}

	@Test
	public void getAllmMusicsTestOK() {
		Client c = ClientBuilder.newClient();
		Response r = c.target(uri + "/list").request(MediaType.APPLICATION_XML)
				.get();
		assertEquals(Response.Status.OK, r.getStatusInfo());
		c.close();
	}

	@Ignore
	@Test
	public void getAllMusicsTestNotOK() {
		Client c = ClientBuilder.newClient();
		Response r = c.target(uri + "/lists")
				.request(MediaType.APPLICATION_XML).get();
		assertEquals(Response.Status.NOT_FOUND, r.getStatusInfo());
		c.close();
	}

	@Test
	public void getMusicsFromUserIdOK() {
		Client c = ClientBuilder.newClient();
		Response r = c.target(uri + "/fromuser/3")
				.request(MediaType.APPLICATION_XML).get();
		assertEquals(Response.Status.OK, r.getStatusInfo());
		c.close();
	}

	//
	@Ignore
	@Test
	public void getPMusicsFromUserIdNotOK() {
		Client c = ClientBuilder.newClient();
		Response r = c.target(uri + "/fromuser/-1")
				.request(MediaType.APPLICATION_XML).get();
		assertEquals(Response.Status.INTERNAL_SERVER_ERROR, r.getStatusInfo());
		c.close();
	}

	@Test
	public void getMusicByIdOK() {
		Client c = ClientBuilder.newClient();
		Response r = c.target(uri + "/list/29")
				.request(MediaType.APPLICATION_XML).get();
		assertEquals(Response.Status.OK, r.getStatusInfo());
		c.close();
	}

	@Test
	public void getMusicByIdNotOK() {
		Client c = ClientBuilder.newClient();
		Response r = c.target(uri + "/list/-1")
				.request(MediaType.APPLICATION_XML).get();
		assertEquals(Response.Status.INTERNAL_SERVER_ERROR, r.getStatusInfo());
		c.close();
	}

	@Test
	public void testDeleteMusicOK() {
		Client c = ClientBuilder.newClient();
		Response r = c.target(uri + "/delete/15")
				.request(MediaType.APPLICATION_XML).get();
		assertEquals(Response.Status.OK, r.getStatusInfo());
		c.close();
	}

	//
	@Ignore
	@Test
	public void testDeleteNotMusic() {
		Client c = ClientBuilder.newClient();
		Response r = c.target(uri + "/delete/10")
				.request(MediaType.APPLICATION_XML).get();
		assertEquals(Response.Status.INTERNAL_SERVER_ERROR, r.getStatusInfo());
		c.close();
	}

	@Test
	public void addToPlaylistByIdOK() {
		Client c = ClientBuilder.newClient();
		Response r = c.target(uri + "/add/20/toplaylist/10")
				.request(MediaType.APPLICATION_XML).get();
		assertEquals(Response.Status.OK, r.getStatusInfo());
		c.close();
	}

	@Test
	public void removefromPlaylistByIdOK() {
		Client c = ClientBuilder.newClient();
		Response r = c.target(uri + "/remove/20/fromplaylist/10")
				.request(MediaType.APPLICATION_XML).get();
		assertEquals(Response.Status.OK, r.getStatusInfo());
		c.close();
	}
}

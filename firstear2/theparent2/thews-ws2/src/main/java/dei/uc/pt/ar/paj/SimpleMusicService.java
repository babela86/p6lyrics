package dei.uc.pt.ar.paj;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dei.uc.pt.ar.MusicDAO;
import dei.uc.pt.ar.paj.pojo.CountRest;
import dei.uc.pt.ar.paj.pojo.MusicCollection;
import dei.uc.pt.ar.paj.pojo.MusicRest;

@Stateless
@Path("/musics")
public class SimpleMusicService {

	@Inject
	private MusicDAO md;

	// Contar todas as músicas
	@GET
	@Path("/number")
	@Produces({ MediaType.APPLICATION_XML })
	public CountRest getNumberMusics() {
		// return 112;
		return new CountRest("" + md.findNumberMusics());
	}

	@GET
	@Path("/test")
	@Produces({ MediaType.TEXT_PLAIN })
	public String test() {
		// return 112;
		return "teste";
	}

	// Listar todas as músicas
	@GET
	@Path("/list")
	@Produces({ MediaType.APPLICATION_XML })
	public MusicCollection getAllmusics() {
		return new MusicCollection(md.findAllMusic());
	}

	// public MusicCollection getAllmusics(){
	// return new MusicCollection( md.findAllMusic());
	// }

	// Músicas de uma playlist concreta
	@GET
	@Path("/fromplaylist/{playId}")
	@Produces({ MediaType.APPLICATION_XML })
	public MusicCollection getMusicFromPlaylist(@PathParam("playId") int id) {
		return new MusicCollection(md.listMusicasPlaylist(id));
	}

	// Listar músicas de um user por id
	@GET
	@Path("/fromuser/{userId}")
	@Produces({ MediaType.APPLICATION_XML })
	public MusicCollection getMusicFromUser(@PathParam("userId") int id) {
		return new MusicCollection(md.findMyMusic(id));
	}

	// Listar uma música por id
	@GET
	@Path("/list/{musicId}")
	@Produces({ MediaType.APPLICATION_XML })
	public MusicRest getMusicById(@PathParam("musicId") int id) {
		return new MusicRest(md.getMusic(id));
	}

	// Remover musica por id de uma musica (owner passa a ser o gestor)
	@GET
	@Path("/delete/{musicId}")
	@Produces(MediaType.APPLICATION_XML)
	public Response removeUserById(@PathParam("musicId") int id) {
		boolean removed = md.deleteMusicFromDb(id);
		if (removed)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}

	// Adicionar música a uma playlist por IDs
	@GET
	@Path("/add/{musicId}/toplaylist/{playId}")
	@Produces({ MediaType.APPLICATION_XML })
	public Response addToPlaylist(@PathParam("musicId") int idm,
			@PathParam("playId") int idp) {
		boolean added = md.addTo(idp, idm);
		if (added)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}

	// Remover música a uma playlist por IDs
	@GET
	@Path("/remove/{musicId}/fromplaylist/{playId}")
	@Produces({ MediaType.APPLICATION_XML })
	public Response removeFromPlaylist(@PathParam("musicId") int idm,
			@PathParam("playId") int idp) {
		boolean added = md.deleteMusic(idp, idm);
		if (added)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}

}

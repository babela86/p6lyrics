package dei.uc.pt.ar.paj;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dei.uc.pt.ar.MusicDAO;
import dei.uc.pt.ar.Musica;

@Stateless
@Path("/musics")
public class SimpleMusicService {
	
	@Inject
	private MusicDAO md;
	
	
	//Listar todas as músicas
	@GET
	@Path("/list")
	@Produces({MediaType.APPLICATION_XML})
	public List<Musica> getAllmusics(){
		
		return md.findAllMusic();
	}
	
	//Músicas de uma playlist concreta
	@GET
	@Path("/fromplaylist/{playId}")
	@Produces({MediaType.APPLICATION_XML})
	public List<Musica> getMusicFromPlaylist(@PathParam("playId") int id){		
		return md.listMusicasPlaylist(id);
	}
	
	//Listar músicas de um user concreto
	@GET
	@Path("/fromuser/{userId}")
	@Produces({MediaType.APPLICATION_XML})
	public List<Musica> getMusicFromUser(@PathParam("userId") int id){		
		return md.findMyMusic(id);
	}
	
	//Listar uma música concreta
	@GET
	@Path("/list/{musicId}")
	@Produces({MediaType.APPLICATION_XML})
	public Musica getMusicById(@PathParam("musicId") int id){		
		return md.getMusic(id);
	}
	
	//Remover musica concreta de um user (passa para o gestor)
	@GET
	@Path("/delete/{musicId}")
	@Produces(MediaType.APPLICATION_XML)
	public Response removeUserById(@PathParam("musicId") int id){		
		boolean removed = md.deleteMusicFromDb(id);
		if (removed)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}
	
	//Adicionar música a uma playlist
	@GET
	@Path("/add/{musicId}/toplaylist/{playId}")
	@Produces({MediaType.APPLICATION_XML})
	public Response addToPlaylist(@PathParam("musicId") int idm, @PathParam("playId") int idp){		
		boolean added = md.addTo(idp, idm);
		if (added)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}
	
	//Remover música a uma playlist
	@GET
	@Path("/remove/{musicId}/fromplaylist/{playId}")
	@Produces({MediaType.APPLICATION_XML})
	public Response removeFromPlaylist(@PathParam("musicId") int idm, @PathParam("playId") int idp){		
		boolean added = md.deleteMusic(idp, idm);
		if (added)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}

}

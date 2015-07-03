package dei.uc.pt.ar.paj;

//import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


//import dei.uc.pt.ar.Playlist;
import dei.uc.pt.ar.PlaylistDAO;
import dei.uc.pt.ar.paj.pojo.CountRest;
import dei.uc.pt.ar.paj.pojo.PlaylistCollection;
import dei.uc.pt.ar.paj.pojo.PlaylistRest;

@Stateless
@Path("/playlists")
public class SimplePlaylistService {
	
	@Inject
	private PlaylistDAO pd;
	
	//Contar todas as Playlists
	@GET
	@Path("/number")
	@Produces({MediaType.APPLICATION_XML})
	public CountRest getNumberPlaylists(){
		//return 112;
		return new CountRest( ""+pd.findAllPlaylists().size() );
	}
	
	//Listar todas as playlists
	@GET
	@Path("/list")
	@Produces({MediaType.APPLICATION_XML})
	public PlaylistCollection getAllPlaylists(){
		return new PlaylistCollection( pd.findAllPlaylists() );
	}
	
	//Playlists de um utilizador concreto
	@GET
	@Path("/fromuser/{userId}")
	@Produces({MediaType.APPLICATION_XML})
	public PlaylistCollection getPlaylistFromUser(@PathParam("userId") int id){		
		return new PlaylistCollection( pd.findMyPlaylists(id) );
	}
	
	//Listar uma playlist concreta
	@GET
	@Path("/list/{playId}")
	@Produces({MediaType.APPLICATION_XML})
	public PlaylistRest getPlaylistById(@PathParam("playId") int id){		
		return new PlaylistRest( pd.getPlaylist(id) );
	}

}

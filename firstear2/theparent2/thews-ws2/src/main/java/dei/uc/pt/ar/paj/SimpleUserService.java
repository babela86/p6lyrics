package dei.uc.pt.ar.paj;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dei.uc.pt.ar.UserDAO;
import dei.uc.pt.ar.UserLoged;
import dei.uc.pt.ar.UserRegister;
import dei.uc.pt.ar.Utilizador;
import dei.uc.pt.ar.paj.pojo.CountRest;
import dei.uc.pt.ar.paj.pojo.UserCollection;
import dei.uc.pt.ar.paj.pojo.UserRest;

@Stateless
@Path("/users")
public class SimpleUserService {

	@Inject
	private UserDAO ud;
	@Inject
	private UserRegister ur;
	@Inject
	private UserLoged lu;

	// Contar todos os users
	@GET
	@Path("/number")
	@Produces({ MediaType.APPLICATION_XML })
	public CountRest getNumberUsers() {
		return new CountRest("" + ud.findAllUsers().size());
	}

	// Listar todos os users
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_XML)
	public UserCollection getAllUsers() {
		return new UserCollection(ud.findAllUsers());
	}

	// Listar user concreto
	@GET
	@Path("/list/{userId}")
	@Produces(MediaType.APPLICATION_XML)
	public UserRest getSimpleUserById(@PathParam("userId") int id) {
		return new UserRest(ud.findUserById(id));
	}

	// Listar todos os users logados
	@GET
	@Path("/listlogedusers")
	@Produces(MediaType.APPLICATION_XML)
	public UserCollection getAllLogedUsers() {
		return new UserCollection(lu.listLogedUsers());
	}

	// Contar todos os users logados
	@GET
	@Path("/numberlogedusers")
	@Produces(MediaType.APPLICATION_XML)
	public CountRest getNumberAllLogedUsers() {
		return new CountRest(lu.numberLogedUsers());
	}

	// Adicionar user
	@POST
	@Path("/add")
	@Consumes({ MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_XML })
	// public Response createUser(Utilizador user) throws
	// NoSuchAlgorithmException, UnsupportedEncodingException, ParseException{
	public Response createUser(UserRest user) throws NoSuchAlgorithmException,
			UnsupportedEncodingException, ParseException {
		Utilizador another = new Utilizador();
		another.setEmail(user.getEmail());
		another.setName(user.getName());
		another.setPassword(user.getPassword());
		another.setBirthdate(user.getBirthdate());
		String srt = ur.newUser(another);

		if (srt.startsWith("User added")) {
			return Response.ok().build();
		} else {
			return Response.notModified().build();
		}
	}

	// Remover user por id
	@GET
	@Path("/delete/{userId}")

	//@Produces(MediaType.APPLICATION_XML)
	public Response removeUserById(@PathParam("userId") int id){		

		boolean removed = ud.deleteAccountByUserID(id);
		if (removed)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}

	// Listar uma playlist concreta
	// @GET
	// @Path("/list/{playId}")
	// @Produces({MediaType.APPLICATION_XML})
	// public PlaylistRest getPlaylistById(@PathParam("playId") int id){
	// return new PlaylistRest( pd.getPlaylist(id) );
	// }

	// Alterar password
	@POST

	

	@Path("/changepassword")
	@Consumes({MediaType.APPLICATION_XML})
	public Response changeUserPass(UserRest user) throws NoSuchAlgorithmException, UnsupportedEncodingException, ParseException{
		if ( ud.changePassword( user.getPassword(), user.getIdUtilizador()) ) {
			return Response.ok(200).build();
		}else{

			return Response.notModified().build();
		}
	}

}

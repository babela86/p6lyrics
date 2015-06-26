package dei.uc.pt.ar.paj.wserver.core;

import javax.ejb.Stateless;
import javax.ws.rs.Path;

@Stateless
@Path("/simpleusers")
public class SimpleUserService {

	// @Inject
	// private ISimpleUserFacade usermng;

	// @GET
	// @Produces({ MediaType.TEXT_HTML, MediaType.TEXT_PLAIN })
	// public String getAllInString() {
	// // not the way ! just for test..
	//
	// // ArrayList<SimpleUser> usr_list = new ArrayList<SimpleUser>();
	// // usr_list.addAll(usermng.findAll());
	//
	// StringBuilder sb = new StringBuilder();
	//
	// for (SimpleUser usr : usr_list)
	// sb.append(usr.toString()).append(" ; ");
	//
	// return sb.toString();
	// }
	//
	// @GET
	// @Path("{suid: \\d+}")
	// @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
	// MediaType.TEXT_HTML, MediaType.TEXT_PLAIN })
	// public SimpleUser getSimpleUserById(@PathParam("suid") Long id) {
	// // use logs!!! (im lazy)
	// System.out.println("get me : " + id);
	//
	// return usermng.find(id);
	// }
	//
	// @POST
	// @Path("/simpleuser")
	// @Consumes({ MediaType.APPLICATION_XML })
	// @Produces({ MediaType.APPLICATION_XML })
	// public Response createSimpleUser(SimpleUser user) {
	// System.out.println(user.getId());
	// System.out.println(user.getUsername());
	// SimpleUser another = new SimpleUser();
	// another.setUsername(user.getUsername());// Why ? :(
	//
	// SimpleUser newuser = usermng.create(another);
	// // Response.notModified();
	//
	// return Response.ok(newuser).build();
	//
	// }

}

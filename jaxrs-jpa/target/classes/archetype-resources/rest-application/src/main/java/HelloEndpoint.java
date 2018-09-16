#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import ${package}.GreetingGateway;
import ${package}.GreetingService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/hello")
public class HelloEndpoint {

	@Inject
	private GreetingService greetingService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{name}")
	public Response greet(@PathParam("name")String name) {
		List<GreetingGateway.GreetingDTO> greetings = greetingService.greet(name);

		GenericEntity<List<GreetingGateway.GreetingDTO>> list =
				new GenericEntity<List<GreetingGateway.GreetingDTO>>(greetings) {
		};
		return Response.ok(list).build();
	}
}

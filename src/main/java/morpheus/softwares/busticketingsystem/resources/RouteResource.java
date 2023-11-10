package morpheus.softwares.busticketingsystem.resources;

import jakarta.ejb.EJB;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import morpheus.softwares.busticketingsystem.services.RouteService;
import morpheus.softwares.busticketingsystem.tools.Route;

/**
 *
 * @author MOPHE
 */
@Path("/routes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RouteResource {

    @EJB
    private RouteService routeService;

    @POST
    public Response createRoute(Route request) {
        // Validate input, authenticate user, and handle errors
        try {
            Route route = routeService.createRoute(request.getOrigin(), request.getDestination(), request.getDepartureTime(), request.getBus(), request.getBusId());
            return Response.status(Response.Status.CREATED).entity(route).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
}

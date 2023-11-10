package morpheus.softwares.busticketingsystem.resources;

import jakarta.ejb.EJB;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import morpheus.softwares.busticketingsystem.services.CustomerService;
import morpheus.softwares.busticketingsystem.tools.Customer;
import morpheus.softwares.busticketingsystem.utils.JWTUtils;

/**
 * @author MOPHE
 */
@Path("/auth")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuthResource {

    @EJB
    private CustomerService customerService;

    @POST
    @Path("/login")
    public Response login(Customer request) {
        // Validate input and authenticate user
        try {
            boolean authenticated = customerService.validateCustomerCredentials(request.getUsername(), request.getPassword());
            if (authenticated) {
                String token = JWTUtils.generateToken(request.getUsername());
                return Response.status(Response.Status.OK).entity(token).build();
            } else {
                return Response.status(Response.Status.UNAUTHORIZED).entity("Authentication failed").build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
}

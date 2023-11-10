package morpheus.softwares.busticketingsystem.resources;

import java.io.IOException;
import java.util.Optional;

import jakarta.ejb.EJB;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import morpheus.softwares.busticketingsystem.services.CustomerService;
import morpheus.softwares.busticketingsystem.utils.JWTUtils;

/**
 *
 * @author MOPHE
 */
@Path("/secure")
public class SecureResource {

    @EJB
    private CustomerService customerService;

    @GET
    @Path("/example")
    public Response example() {
        return Response.ok("This is a protected resource").build();
    }

    @Provider
    public static class AuthenticationFilter implements ContainerRequestFilter {

        @Override
        public void filter(ContainerRequestContext requestContext) throws IOException {
            String token = requestContext.getHeaderString("Authorization");
            if (token != null && token.startsWith("Bearer ")) {
                token = token.substring("Bearer ".length()).trim();
                Optional<String> subject = JWTUtils.extractSubject(token);
                if (!subject.isPresent()) {
                    requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity("Invalid token").build());
                }
            } else {
                requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity("Missing or invalid token").build());
            }
        }
    }
}

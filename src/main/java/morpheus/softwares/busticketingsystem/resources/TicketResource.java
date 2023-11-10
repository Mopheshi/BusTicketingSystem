package morpheus.softwares.busticketingsystem.resources;

import jakarta.ejb.EJB;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import morpheus.softwares.busticketingsystem.services.TicketService;
import morpheus.softwares.busticketingsystem.tools.Ticket;

/**
 *
 * @author MOPHE
 */
@Path("/tickets")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TicketResource {

    @EJB
    private TicketService ticketService;

    @POST
    public Response bookTicket(Ticket request) {
        // Validate input, authenticate user, and handle errors
        try {
            Ticket ticket = ticketService.bookTicket(request.getId(), request.getPassengerName());
            return Response.status(Response.Status.CREATED).entity(ticket).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
}

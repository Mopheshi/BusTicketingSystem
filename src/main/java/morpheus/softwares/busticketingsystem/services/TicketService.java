package morpheus.softwares.busticketingsystem.services;

import java.util.Date;
import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.PersistenceContext;
import morpheus.softwares.busticketingsystem.tools.Route;
import morpheus.softwares.busticketingsystem.tools.Ticket;

/**
 * @author MOPHE
 */
@Stateless
public class TicketService {

    @PersistenceContext
    private EntityManager entityManager;

    public Ticket bookTicket(long routeId, String passengerName) {
        Route route = entityManager.find(Route.class, routeId);
        if (route != null) {
            Ticket ticket = new Ticket();
            ticket.setRoute(route);
            ticket.setPassengerName(passengerName);
            ticket.setBookingTime(new Date());
            entityManager.persist(ticket);

            return ticket;
        }

        return null;
    }

    public List<Ticket> getTicketsForRoute(long routeId) {
        TypedQuery<Ticket> typedQuery = entityManager.createQuery(
                "SELECT t FROM Ticket t WHERE t.route.id = :routeId", Ticket.class
        );
        typedQuery.setParameter("routeId", routeId);

        return typedQuery.getResultList();
    }
}

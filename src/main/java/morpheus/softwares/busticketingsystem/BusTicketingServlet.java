package morpheus.softwares.busticketingsystem;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import morpheus.softwares.busticketingsystem.tools.Ticket;

import java.io.IOException;
import java.util.Random;

@WebServlet("/bookTicket")
public class BusTicketingServlet extends HttpServlet {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        try {
            // Retrieve data from the form
            long departureTime = request.getDateHeader("departure-time");
            String passengerName = request.getParameter("passenger-name"),
                    origin = request.getParameter("origin"),
                    destination = request.getParameter("destination"),
                    ticketClass = request.getParameter("class"),
                    busType = request.getParameter("bus-type"),
                    ticketId = generateTicketId();

            // Create a new Ticket entity
            Ticket ticket = new Ticket();
            ticket.setPassengerName(passengerName);
            ticket.setDepartureTime(departureTime);
            ticket.setOrigin(origin);
            ticket.setDestination(destination);
            ticket.setTicketClass(ticketClass);
            ticket.setBusType(busType);
            ticket.setTicketId(ticketId);
            ticket.setPrice(ticket.getPrice(busType, ticketClass));

            // Persist the Ticket entity to the database
            entityManager.persist(ticket);

            // You can send a success response back to the client
            response.getWriter().write("Ticket booked successfully!");

        } catch (Exception e) {
            // Handle exceptions
            response.getWriter().write("Error: " + e.getMessage());
        }
    }

    /**
     * Generate a unique ticket id with a random 3-digit number between 100 and 999
     */
    private String generateTicketId() {
        Random random = new Random();
        return "BUS" + random.nextInt(900) + 100;
    }
}
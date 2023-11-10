package morpheus.softwares.busticketingsystem.tools;

import jakarta.persistence.*;

import java.util.Date;

/**
 * @author MOPHE
 */
@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String passengerName;
    private String ticketStatus;
    private Date bookingTime;
    private int seatNumber;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;

    public Ticket() {
    }

    public Ticket(Long id, String passengerName, String ticketStatus, Date bookingTime, int seatNumber, Route route) {
        setId(id);
        setPassengerName(passengerName);
        setTicketStatus(ticketStatus);
        setBookingTime(bookingTime);
        setSeatNumber(seatNumber);
        setRoute(route);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public Date getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Date bookingTime) {
        this.bookingTime = bookingTime;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
}

package morpheus.softwares.busticketingsystem.tools;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

/**
 * @author MOPHE
 */
@Entity
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String origin, destination, name;
    private Date departureTime;

    @ManyToOne
    @JoinColumn(name = "bus_id")
    private Bus bus;

    @OneToMany(mappedBy = "route")
    private List<Ticket> tickets;

    public Route() {
    }

    public Route(String name) {
        setName(name);
    }

    public Route(Long id, String origin, String destination, Date departureTime, Bus bus, List<Ticket> tickets) {
        setId(id);
        setOrigin(origin);
        setDestination(destination);
        setDepartureTime(departureTime);
        setBus(bus);
        setTickets(tickets);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public long getBusId() {
        return bus.getId();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

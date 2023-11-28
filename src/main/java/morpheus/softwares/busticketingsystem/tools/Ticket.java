package morpheus.softwares.busticketingsystem.tools;

import jakarta.persistence.*;

/**
 * @author MOPHE
 */
@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ticketId, passengerName, departureTime, ticketStatus, origin, destination, ticketClass, busType;
    private double price;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;

    public Ticket() {
    }

    public Ticket(Long id, String ticketId, String passengerName, String departureTime,
                  String origin, String destination, String ticketClass, String busType, Route route, double price) {
        setId(id);
        setTicketId(ticketId);
        setRoute(route);
        setPassengerName(passengerName);
        setDepartureTime(departureTime);
        setOrigin(origin);
        setDestination(destination);
        setTicketClass(ticketClass);
        setBusType(busType);
        setPrice(price);
    }

    public Long getId() {
        return id;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
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

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
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

    public String getTicketClass() {
        return ticketClass;
    }

    public void setTicketClass(String ticketClass) {
        this.ticketClass = ticketClass;
    }

    public String getBusType() {
        return busType;
    }

    public void setBusType(String busType) {
        this.busType = busType;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public double getPrice(String busType, String ticketClass) {
        // Define base prices for each bus type and class
        double siennaPrice = 200.00;
        double hummerPrice = 150.00;
        double freshAirPrice = 100.00;

        // Apply discounts or premiums based on the chosen class
        switch (ticketClass) {
            case "Standard":
                // Standard class has no price change
                break;
            case "Economy":
                // Apply a discount for economy class
                siennaPrice *= 0.90;
                hummerPrice *= 0.90;
                freshAirPrice *= 0.90;
                break;
            case "First Class":
                // Apply a premium for first class
                siennaPrice *= 1.20;
                hummerPrice *= 1.20;
                freshAirPrice *= 1.20;
                break;
        }

        // Determine the final price based on bus type
        switch (busType) {
            case "Hummer":
                return hummerPrice;
            case "Fresh Air":
                return freshAirPrice;
            default:
                return siennaPrice;
        }
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

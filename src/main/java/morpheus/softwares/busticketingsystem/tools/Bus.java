package morpheus.softwares.busticketingsystem.tools;

import jakarta.persistence.*;

import java.util.List;

/**
 * @author MOPHE
 */
@Entity
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String busNumber, busModel;
    private int capacity;

    @OneToMany(mappedBy = "bus")
    private List<Route> routes;

    public Bus() {
    }

    public Bus(Long id, String busNumber, String busModel, int capacity, List<Route> routes) {
        setId(id);
        setBusNumber(busNumber);
        setBusModel(busModel);
        setCapacity(capacity);
        setRoutes(routes);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public String getBusModel() {
        return busModel;
    }

    public void setBusModel(String busModel) {
        this.busModel = busModel;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }
}

package morpheus.softwares.busticketingsystem.services;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import morpheus.softwares.busticketingsystem.tools.Bus;

/**
 * @author MOPHE
 */
@Stateless
public class BusService {

    @PersistenceContext
    private EntityManager entityManager;

    public Bus createBus(String busNumber, String busModel, int capacity) {
        Bus bus = new Bus();
        bus.setBusNumber(busNumber);
        bus.setBusModel(busModel);
        bus.setCapacity(capacity);
        entityManager.persist(bus);

        return bus;
    }

    public List<Bus> getAllBuses() {
        return entityManager.createQuery("SELECT b FROM Bus b", Bus.class).getResultList();
    }
}

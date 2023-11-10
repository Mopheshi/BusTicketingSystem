package morpheus.softwares.busticketingsystem.services;

import java.util.Date;
import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import morpheus.softwares.busticketingsystem.tools.Bus;
import morpheus.softwares.busticketingsystem.tools.Route;

/**
 *
 * @author MOPHE
 */
@Stateless
public class RouteService {

    @PersistenceContext
    private EntityManager entityManager;

    public Route createRoute(String origin, String destination, Date departureTime, Bus bus, long busId) {
        Route route = new Route();
        route.setOrigin(origin);
        route.setDestination(destination);
        route.setDepartureTime(departureTime);
        route.setBus(entityManager.find(Bus.class, busId));
        entityManager.persist(route);
        
        return route;
    }
    
    public List<Route> getRoutesForBus(long busId){
        TypedQuery<Route> typedQuery = entityManager.createQuery(
                "SELECT r FROM Route r WHERE r.bus.id = :busId", Route.class
        );
        typedQuery.setParameter("busId", busId);
        
        return typedQuery.getResultList();
    }
}

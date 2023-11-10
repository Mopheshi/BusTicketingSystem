package morpheus.softwares.busticketingsystem.services;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import morpheus.softwares.busticketingsystem.tools.Customer;
import morpheus.softwares.busticketingsystem.utils.PasswordUtils;

/**
 *
 * @author MOPHE
 */
@Stateless
public class CustomerService {

    @PersistenceContext
    private EntityManager entityManager;

    public Customer findCustomerByUsername(String username) {
        TypedQuery<Customer> typedQuery = entityManager.createQuery(
                "SELECT c FROM Customer c WHERE c.username = :username", Customer.class
        );
        typedQuery.setParameter("username", username);
        
        return typedQuery.getSingleResult();
    }

    public boolean validateCustomerCredentials(String username, String password) {
        Customer customer = findCustomerByUsername(username);
        
        return PasswordUtils.validatePassword(password, customer.getPassword());
    }
}

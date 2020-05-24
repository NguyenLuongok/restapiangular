package angular.api.rest.api.with.angular.Repository;

import angular.api.rest.api.with.angular.Model.Receipt;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
public class ReceiptRepositoryExample {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Receipt receipt){
        Session session = entityManager.unwrap(Session.class);
        session.save(receipt);
}
}

package soft.train.spring.rest;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@Repository
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class MyCustomRepository {

    @PersistenceUnit
    private EntityManagerFactory emf;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void xyz(final Person per) {
        final EntityManager em = this.emf.createEntityManager();
        em.joinTransaction();
        em.persist(per);
    }

}

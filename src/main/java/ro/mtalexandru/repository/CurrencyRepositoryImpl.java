package ro.mtalexandru.repository;

import org.springframework.stereotype.Repository;
import ro.mtalexandru.model.Currency;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository("currencyRepository")
public class CurrencyRepositoryImpl implements CurrencyRepository {

	@PersistenceContext
	private EntityManager em;
	
	public Currency save(Currency currency) {
		
		em.persist(currency);
		
		em.flush();
		
		return currency;
	}

    public Currency findCurrencyByShortName(String shortName) {
        Currency currency = null;
        try {
            currency = (Currency) em.createQuery("Select c from Currency c where c.shortName like :shortName")
                    .setParameter("shortName", shortName)
                    .getSingleResult();
        } catch (NoResultException e){
            e.printStackTrace();
        }


        return currency;
    }

	public List<Currency> loadAll() {
		Query query = em.createQuery("Select c from Currency c");
		return query.getResultList();
	}

}

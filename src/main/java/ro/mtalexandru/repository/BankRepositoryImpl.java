package ro.mtalexandru.repository;

import org.springframework.stereotype.Repository;
import ro.mtalexandru.model.Bank;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository("bankRepository")
public class BankRepositoryImpl implements BankRepository {

	@PersistenceContext
	private EntityManager em;

	public Bank save(Bank bank) {

		em.persist(bank);

		em.flush();

		return bank;
	}


    public Bank findBankByShortName(String shortName) {
        Bank bank = null;
        try {
            bank = (Bank) em.createQuery("Select b from Bank b where b.shortName like :shortName")
                    .setParameter("shortName", shortName)
                    .getSingleResult();
        } catch (NoResultException e){
            e.printStackTrace();
        }
        return bank;
    }

	public List<Bank> loadAll() {
		Query query = em.createQuery("Select b from Bank b");
		return query.getResultList();
	}

}

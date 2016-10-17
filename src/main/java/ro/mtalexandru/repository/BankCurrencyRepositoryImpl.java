package ro.mtalexandru.repository;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import ro.mtalexandru.model.Bank;
import ro.mtalexandru.model.BankCurrency;
import ro.mtalexandru.model.BankReport;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository("bankCurrencyRepository")
public class BankCurrencyRepositoryImpl implements BankCurrencyRepository {

	@PersistenceContext
	private EntityManager em;

    public static final String SAVE_BANK_CURRENCY = "";


    final static Logger logger = Logger.getLogger(BankCurrencyRepositoryImpl.class);

	public BankCurrency save(BankCurrency newCurrency) {
		
		em.persist(newCurrency);
		em.flush();
		
		return newCurrency;
	}


    @Override
    public BankCurrency saveOrUpdate(BankCurrency newCurrency) {

        //SELECT m FROM Machine m WHERE m.machinePK.machineId = 10
        logger.info("");
        Query query = em.createQuery(
                "SELECT bc FROM BankCurrency bc WHERE bc.currency.id = :newCurrencyId AND bc.currencyDate= :newCurrencyDate AND bc.bank.id = :newCurrencyBankId")
                .setParameter("newCurrencyId", newCurrency.getCurrency().getId())
                .setParameter("newCurrencyBankId", newCurrency.getBank().getId())
                .setParameter("newCurrencyDate", newCurrency.getCurrencyDate());
        if (query.getResultList() != null && query.getResultList().size() > 0) {
            BankCurrency existingCurrency = (BankCurrency) query.getResultList().get(0);
            if (existingCurrency != null) {
                existingCurrency.setUpdateDate(new Date());
                existingCurrency.setBankBuysValue(newCurrency.getBankBuysValue());
                existingCurrency.setBankSellsValue(newCurrency.getBankSellsValue());
                em.persist(existingCurrency);
            }
        }
        else {
            em.persist(newCurrency);
        }
        em.flush();

        return newCurrency;
    }


    public List<BankCurrency> loadAll() {
        //Query query = em.createQuery("Select g from Goal g");

        TypedQuery<BankCurrency> query = em.createNamedQuery(BankCurrency.GET_ALL_CURRENCIES, BankCurrency.class);

        return query.getResultList();
    }

    public List<BankReport> findAllBankReports() {
        return null;
    }


    public List<BankCurrency> findByBank(Bank bank) {

        TypedQuery query = em.createQuery("select a from BankCurrency a where a.bank = ?1", BankCurrency.class);
        query.setParameter(1, bank);

        return query.getResultList();
    }

    public List<BankCurrency> getByBankAndDate(Bank bank, Date date) {

        TypedQuery query = em.createQuery("select a from BankCurrency a where a.bank = ?1 and a.currencyDate= ?2", BankCurrency.class);
        query.setParameter(1, bank);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = sdf.parse(sdf.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        query.setParameter(2, date);
        return query.getResultList();
    }


















//    public List<BankCurrency> findByParameters(Long bankCurrencyId, String param1, String param2){
//        return getSession().createQuery(
//                "select bc from BankCurrency bc where bc.id = :bankCurrencyId and bc.param1 = :param1 and bc.param2 = :param2")
//                .setParameter("id", bankCurrencyId)
//                .setParameter("param1", param1)
//                .setParameter("param2", param2)
//                .list();
//    }
//
//    public BankCurrency deleteBankCurrency(Long bankCurrencyId){
//        BankCurrency bc = findById(bankCurrencyId);
//        if (bc == null) {return null;}
//        bc.setUpdateDate(new Date());
//        getSession().save(bc);
//        return bc;
//    }
//
//
//    //TODO: this is just an example of how to get an entity by the id of another
//    public List<BankCurrency> loadBankCurrenciesByBankId(Long bankId) throws ObjectNotFoundException{
//        Criteria criteria = getSession().createCriteria(BankCurrency.class);
//        criteria.createCriteria("bank").add(Restrictions.eq("id",bankId));
//        List<BankCurrency> list = criteria.list();
//        if (list.isEmpty()){
//            throw new ObjectNotFoundException("bankId: " + bankId);
//        }
//        return list;
//    }
//
//    @Override
//    public BankCurrency findById(Long id) {
//        BankCurrency result = (BankCurrency) getSession()
//                .createQuery("from BankCurrency bc where bc.id=:id and bc.deleted=0")
//                .setParameter("id", id)
//                .uniqueResult();
//        return result;
//    }
//
//    @Override
//    public BankCurrency findByIdAndDate(Long id) {
//        BankCurrency result = (BankCurrency) getSession()
//                .createQuery("from BankCurrency bc where bc.id=:id and bc.deleted=0")
//                .setParameter("id", id)
//                .uniqueResult();
//        return result;
//    }
}

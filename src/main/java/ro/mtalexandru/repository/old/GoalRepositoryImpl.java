package ro.mtalexandru.repository.old;

import org.springframework.stereotype.Repository;
import ro.mtalexandru.jsoup.WebScraperING;
import ro.mtalexandru.model.old.Goal;
import ro.mtalexandru.model.old.GoalReport;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository("goalRepository")
public class GoalRepositoryImpl implements GoalRepository {

    @PersistenceContext
    private EntityManager em;

    public Goal save(Goal goal) {

//        Bank bank = new Bank(); bank.setShortName("bibi");
//        Currency currency = new Currency(); currency.setShortName("bib"); currency.setDescription("test entity");
//        BankCurrency bankCurrency = new BankCurrency();
//        bankCurrency.setBank(bank);
//        bankCurrency.setCurrency(currency);
//        bankCurrency.setCreationDate(new Date());
//        bankCurrency.setCurrencyDate(new Date());
//        bankCurrency.setBankBuysValue(33.2323);
//        bankCurrency.setBankSellsValue(44.4444);
//        em.persist(bank);
//        em.persist(currency);
        System.out.println("####starting ING web scraper");
            new WebScraperING().getCursIng();

//        em.persist(bankCurrency);
//        em.flush();

//		em.persist(goal);
//
//		em.flush();

        return goal;
    }

    public List<Goal> loadAll() {
        //Query query = em.createQuery("Select g from Goal g");

        TypedQuery<Goal> query = em.createNamedQuery(Goal.FIND_ALL_GOALS, Goal.class);

        return query.getResultList();
    }

    public List<GoalReport> findAllGoalReports() {
        //Query query = em.createQuery("Select new ro.mtalexandru.model.old.GoalReport(g.minutes, e.minutes, e.activity) " +
        //		"from Goal g, Exercise e where g.id = e.goal.id");

        TypedQuery<GoalReport> query = em.createNamedQuery(Goal.FIND_GOAL_REPORTS, GoalReport.class);

        return query.getResultList();
    }

}

package ro.mtalexandru.repository;

import ro.mtalexandru.model.Bank;
import ro.mtalexandru.model.BankCurrency;
import ro.mtalexandru.model.BankReport;

import java.util.Date;
import java.util.List;

/**
 * Created by Mau on 8/21/2016.
 */
public interface  BankCurrencyRepository {

    BankCurrency save(BankCurrency newCurrency);

    List<BankCurrency> loadAll();

    List<BankReport> findAllBankReports();

    List<BankCurrency> findByBank(Bank bank);

    List<BankCurrency> getByBankAndDate(Bank bank, Date date);

}
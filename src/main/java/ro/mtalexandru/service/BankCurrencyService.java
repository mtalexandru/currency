package ro.mtalexandru.service;

import ro.mtalexandru.model.Bank;
import ro.mtalexandru.model.BankCurrency;

import java.util.Date;
import java.util.List;

public interface BankCurrencyService {

	BankCurrency save(BankCurrency bankCurrency);

	List<BankCurrency> findAllBankCurrencies();

    List<BankCurrency> findByBank(Bank bank);

    List<BankCurrency> getByBankAndDate(Bank bank, Date date);

}

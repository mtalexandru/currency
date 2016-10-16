package ro.mtalexandru.repository;

import ro.mtalexandru.model.Bank;

import java.util.List;

public interface BankRepository {

	Bank save(Bank bank);

    Bank findBankByShortName(String shortName);

	List<Bank> loadAll();

}

package ro.mtalexandru.service;

import ro.mtalexandru.model.Bank;

import java.util.List;

public interface BankService {

	Bank save(Bank goal);

    Bank findBankByShortName(String shortName);

	List<Bank> findAllBanks();

}

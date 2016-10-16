package ro.mtalexandru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.mtalexandru.model.Bank;
import ro.mtalexandru.model.BankCurrency;
import ro.mtalexandru.repository.BankCurrencyRepository;
import ro.mtalexandru.repository.BankRepository;
import ro.mtalexandru.repository.CurrencyRepository;

import java.util.Date;
import java.util.List;

@Service("bankCurrencyService")
public class BanckCurrencyServiceImpl implements BankCurrencyService {

	@Autowired
    private BankRepository bankRepository;

    @Autowired
    private CurrencyRepository currencyRepository;

    @Autowired
    private BankCurrencyRepository bankCurrencyRepository;


	@Transactional
	public BankCurrency save(BankCurrency bankCurrency) {
		return bankCurrencyRepository.save(bankCurrency);
	}

    public List<BankCurrency> findAllBankCurrencies() {
        return bankCurrencyRepository.loadAll();
    }

    public List<BankCurrency> findByBank(Bank bank) {
        return bankCurrencyRepository.findByBank(bank);
    }

    public List<BankCurrency> getByBankAndDate(Bank bank, Date date) {
        return bankCurrencyRepository.getByBankAndDate(bank, date);
    }

}

package ro.mtalexandru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.mtalexandru.model.Bank;
import ro.mtalexandru.repository.BankRepository;

import java.util.List;

@Service("bankService")
public class BankServiceImpl implements BankService {

	@Autowired
	private BankRepository bankRepository;
	
	@Transactional
	public Bank save(Bank bank) {
		return bankRepository.save(bank);
	}

	public List<Bank> findAllBanks() {
		return bankRepository.loadAll();
	}

    public Bank findBankByShortName(String shortName)  {
        return bankRepository.findBankByShortName(shortName);
    }
}

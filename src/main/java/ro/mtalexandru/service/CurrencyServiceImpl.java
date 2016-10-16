package ro.mtalexandru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.mtalexandru.model.Currency;
import ro.mtalexandru.repository.CurrencyRepository;

import java.util.List;

@Service("currencyService")
public class CurrencyServiceImpl implements CurrencyService {

	@Autowired
	private CurrencyRepository currencyRepository;
	
	@Transactional
	public Currency save(Currency currency) {
		return currencyRepository.save(currency);
	}

	public List<Currency> findAllCurrencies() {
		return currencyRepository.loadAll();
	}

    public Currency findCurrencyByShortName(String shortName)  {
        return currencyRepository.findCurrencyByShortName(shortName);
    }
}

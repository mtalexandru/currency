package ro.mtalexandru.service;

import ro.mtalexandru.model.Currency;

import java.util.List;

public interface CurrencyService {

	Currency save(Currency goal);

	List<Currency> findAllCurrencies();

    Currency findCurrencyByShortName(String shortName);

}

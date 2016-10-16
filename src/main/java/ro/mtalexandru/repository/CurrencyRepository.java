package ro.mtalexandru.repository;

import ro.mtalexandru.model.Currency;

import java.util.List;

public interface CurrencyRepository {

    Currency save(Currency currency);

	List<Currency> loadAll();

    Currency findCurrencyByShortName(String shortName);

}

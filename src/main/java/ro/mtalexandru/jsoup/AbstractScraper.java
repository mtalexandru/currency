package ro.mtalexandru.jsoup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ro.mtalexandru.model.Bank;
import ro.mtalexandru.model.BankCurrency;
import ro.mtalexandru.model.Currency;
import ro.mtalexandru.service.BankCurrencyService;
import ro.mtalexandru.service.BankService;
import ro.mtalexandru.service.CurrencyService;

import java.util.Date;

/**
 * Created by Mau on 8/21/2016.
 */
@Controller
public abstract class AbstractScraper {
    public abstract String getBankShortName();
    @Autowired
    CurrencyService currencyService;

    @Autowired
    BankService bankService;

    @Autowired
    static BankCurrencyService bankCurrencyService;

    public static class Valuta{
        String currencyShortName;
        String bankSellsValue;
        String bankBuysValue;

        public String getCurrencyShortName() {
            return currencyShortName;
        }

        public void setCurrencyShortName(String currencyShortName) {
            this.currencyShortName = currencyShortName;
        }

        public String getBankSellsValue() {
            return bankSellsValue;
        }

        public void setBankSellsValue(String bankSellsValue) {
            this.bankSellsValue = bankSellsValue;
        }

        public String getBankBuysValue() {
            return bankBuysValue;
        }

        public void setBankBuysValue(String bankBuysValue) {
            this.bankBuysValue = bankBuysValue;
        }
    }

    BankCurrency generateBankCurrency(Valuta valutaCurenta) {
        Currency currency = currencyService.findCurrencyByShortName(valutaCurenta.getCurrencyShortName());
        Bank bank = bankService.findBankByShortName(getBankShortName()); //TODO: USE BANKNames ENUM
        BankCurrency bankCurrency = new BankCurrency();
        bankCurrency.setCurrency(currency);
        bankCurrency.setBank(bank);
        bankCurrency.setCreationDate(new Date());
        bankCurrency.setCurrencyDate(new Date());
        //todo : VERIFICA DACA AI MAPAT CUM TREBUIE BANMK SELLS CU BANK BUYS ASA CUM VIN DIN SCRAPER
        try {
            bankCurrency.setBankSellsValue(Double.parseDouble(valutaCurenta.getBankSellsValue()));
            bankCurrency.setBankBuysValue(Double.parseDouble(valutaCurenta.getBankBuysValue()));
        }catch (NumberFormatException e) {
            e.printStackTrace(); //prints error
        }
        return bankCurrency;
    }

    public static void log(String log){
        System.out.println("#### - " + log);
    }
}

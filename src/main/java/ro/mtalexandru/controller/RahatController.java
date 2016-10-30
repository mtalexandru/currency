package ro.mtalexandru.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import ro.mtalexandru.jsoup.AbstractScraper;
import ro.mtalexandru.model.Bank;
import ro.mtalexandru.model.BankCurrency;
import ro.mtalexandru.model.Currency;
import ro.mtalexandru.service.BankCurrencyService;
import ro.mtalexandru.service.BankService;
import ro.mtalexandru.service.CurrencyService;
import ro.mtalexandru.service.old.GoalService;

import java.util.Date;
import java.util.List;

/**
 * Created by Mau on 8/21/2016.
 */
@Controller
@SessionAttributes("cursing")
public class RahatController {

    final static Logger logger = Logger.getLogger(RahatController.class);

        @Autowired
        private GoalService goalService;
        @Autowired
        private BankService bankService;
        @Autowired
        private CurrencyService currencyService;
        @Autowired
        private BankCurrencyService bankCurrencyService;


        @RequestMapping(value = "fetching", method = RequestMethod.GET)
        public String fetching(Model model) {

                        Bank bank = bankService.findBankByShortName("ING");
            List<BankCurrency> bankCurrencyList = bankCurrencyService.getByBankAndDate(bank,new Date());
            List<BankCurrency> curerncyList = bankCurrencyService.getByBankAndDate(bank,new Date());
            for (BankCurrency bankCurrency : curerncyList){
                bankCurrencyService.saveOrUpdate(bankCurrency);
            }


			//TODO: @@ COMMENTED AS TO NOT SPAM THE WEBSITE
//            WebScraperING webScraperING = new WebScraperING();
//            Map<Integer,AbstractScraper.Valuta> ingCurrenciesMap = webScraperING.getCursIng();
//            Iterator it = ingCurrenciesMap.entrySet().iterator();
//            while (it.hasNext()) {
//                Map.Entry pair = (Map.Entry)it.next();
//                AbstractScraper.Valuta valutaCurenta = (AbstractScraper.Valuta)pair.getValue();
//                BankCurrency bankCurrency = generateBankCurrency(valutaCurenta);
//                if (bankCurrency != null){
////                    bankCurrencyService.save(bankCurrency);
//                    bankCurrencyService.saveOrUpdate(bankCurrency);
//
//                }
//                else{
//                    logger.error("BankCurrency was not created. Could not save the entity for bank: " + valutaCurenta.getCurrencyShortName() +
//                    " with currency: " + valutaCurenta.getCurrencyShortName());
//
//                }
//                AbstractScraper.log(
//                        valutaCurenta.getCurrencyShortName() + ": ING CUMPARA CU: " + valutaCurenta.getBankBuysValue() + " si ING VINDE CU: " + valutaCurenta.getBankSellsValue());
//                it.remove(); // avoids a ConcurrentModificationException
//            }


//            model.addAttribute("bankcurrency", bankcurrency);

            System.out.println("##### - bankService" + bankService);
            System.out.println("##### - currencyService" + currencyService);
            System.out.println("##### - bankCurrencyeService" + currencyService);


            return "cursing";
        }

    @RequestMapping(value = "curcubeu", method = RequestMethod.GET)
    public String curcubeu(Model model) {
        Bank bank = bankService.findBankByShortName("ING");
        System.out.println("bank");
        List<BankCurrency> bankCurrencyList = bankCurrencyService.getByBankAndDate(bank,new Date());
        System.out.println(bankCurrencyList);
        return "nothing";
    }

    BankCurrency generateBankCurrency(AbstractScraper.Valuta valutaCurenta) {
        Currency currency = currencyService.findCurrencyByShortName(valutaCurenta.getCurrencyShortName());
        if (currency == null) {
            logger.error("################ - eroare : nu exista valuta in baza de date");

            return null;
        }
        Bank bank = bankService.findBankByShortName("ING"); //TODO: USE BANKNames ENUM
        if (bank == null) {
            logger.error("################ - eroare : nu exista banca in baza de date");
            return null;
        }

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
    }

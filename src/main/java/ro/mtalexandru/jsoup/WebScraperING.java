package ro.mtalexandru.jsoup; /**
 * Created by malexandru on 5/13/2016.
 */

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WebScraperING extends AbstractScraper{

    private static Map<Integer,Valuta> cursValutar = new HashMap<Integer,Valuta>();

    @Override
    public String getBankShortName(){
        return "ING";
    }

    public static void main(final String[] args) throws IOException {
        log("starting ING web scraper");
        new WebScraperING().getCursIng();
    }

    public  Map<Integer,Valuta>  getCursIng() {
        Document doc = null;
        try {
            doc = Jsoup.connect("https://www.ing.ro/ing/curs-valutar.html")
                    .userAgent("Mozilla").timeout(6000).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String title = doc.title(); // parsing the page's title

        log(doc.text());

        String allDoc = doc.text();
        allDoc.substring(allDoc.indexOf("RON"));
        String unprocessedActualDate = allDoc.substring(allDoc.lastIndexOf("RON"));
        String processedActualDate = unprocessedActualDate.substring(unprocessedActualDate.indexOf(':')+1);
        log(processedActualDate); // Data actualizarii procesata
        String dual = allDoc.substring(allDoc.lastIndexOf("Cumparare") + 10, allDoc.lastIndexOf("RON")); // Data actualizarii
        log(dual);

        for (int i = 1; i<11; i++) {
            int indexParcurgere;
            Valuta valuta = new Valuta();
            valuta.setCurrencyShortName(dual.substring(0, 3));
            indexParcurgere = 3;
//            log("valuta nr. " + i + " are denumirea " + valuta.getCurrencyShortName());
            dual = dual.substring(indexParcurgere).trim();
//            log("dual acum este :" + dual);
            valuta.setBankSellsValue(dual.substring(0, 6));
//            log("####: " + valuta.getBankSellsValue());
            dual = dual.substring(6 + 10);
//            log("--dual acum este :" + dual);
            valuta.setBankBuysValue(dual.substring(0, 6));
//            log("@@@@: " + valuta.getBankBuysValue());
            log("valuta nr:" + i + " este " + valuta.getCurrencyShortName() + " cu valoarea cumparare " + valuta.getBankBuysValue() + " cu valoarea vanzare  " + valuta.getBankSellsValue());
            dual = dual.substring(6).trim();
            cursValutar.put(i,valuta);
            log("--dual acum este :" + dual);
        }

//        Iterator it = cursValutar.entrySet().iterator();
//        while (it.hasNext()) {
//            Map.Entry pair = (Map.Entry)it.next();
//            Valuta valutaCurenta = (Valuta)pair.getValue();
////            bankCurrencyService.save(generateBankCurrency(valutaCurenta));
//            log(
//                    valutaCurenta.getCurrencyShortName() + ": ING CUMPARA CU: " + valutaCurenta.getBankBuysValue() + " si ING VINDE CU: " + valutaCurenta.getBankSellsValue());
//            it.remove(); // avoids a ConcurrentModificationException
//        }
        return cursValutar;
    }
}
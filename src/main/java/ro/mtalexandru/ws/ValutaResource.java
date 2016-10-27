package ro.mtalexandru.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import ro.mtalexandru.model.BankCurrency;
import ro.mtalexandru.model.Exercise;
import ro.mtalexandru.repository.BankCurrencyRepository;
import ro.mtalexandru.repository.ExerciseRepository;
import ro.mtalexandru.ws.model.BankCurrencyWS;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mau on 8/4/2016.
 */
@Path("valuta")
@Component
public class ValutaResource extends SpringBeanAutowiringSupport {
    
	@Autowired
	private BankCurrencyRepository bankCurrencyRepository;
	@Autowired
	private ExerciseRepository exerciseRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<BankCurrency> getAllActivities(){

		List<BankCurrency> lista = bankCurrencyRepository.loadAllEager();
		List<BankCurrencyWS> listaWS = new ArrayList<>();
		List<BankCurrency> lista2 = new ArrayList<>();
//
//		for(BankCurrency bc : lista){
//			BankCurrency bc2 = new BankCurrency();
//			bc2.setId(bc.getId());
//			bc2.setBankBuysValue(bc.getBankBuysValue());
//			bc2.setBankSellsValue(bc.getBankSellsValue());
//
//			lista2.add(bc2);
//		}
//
		for(int i = 0; i<5;i++) {
			BankCurrency bankCurrency = lista.get(0);
			BankCurrencyWS bankCurrencyWS = new BankCurrencyWS();
			bankCurrencyWS.setUpdateDate(bankCurrency.getUpdateDate());
			bankCurrencyWS.setCurrencyDate(bankCurrency.getCurrencyDate());
			bankCurrencyWS.setBankSellsValue(bankCurrency.getBankSellsValue());
			bankCurrencyWS.setBankBuysValue(bankCurrency.getBankBuysValue());
			listaWS.add(bankCurrencyWS);
		}

		List<Exercise> listaExercitii = exerciseRepository.loadAllExercises();
        return lista;
    }
}

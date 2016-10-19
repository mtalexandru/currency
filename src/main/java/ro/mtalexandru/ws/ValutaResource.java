package ro.mtalexandru.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import ro.mtalexandru.model.BankCurrency;
import ro.mtalexandru.repository.BankCurrencyRepository;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Mau on 8/4/2016.
 */
@Path("valuta")
@Component
public class ValutaResource extends SpringBeanAutowiringSupport {
    
	@Autowired
	private BankCurrencyRepository bankCurrencyRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<BankCurrency> getAllActivities(){
		List<BankCurrency> lista = bankCurrencyRepository.loadAll();
        return lista.subList(0,5);
    }
}

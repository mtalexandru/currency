package ro.mtalexandru.ws.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import ro.mtalexandru.model.Exercise;
import ro.mtalexandru.repository.ExerciseRepository;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Mau on 8/4/2016.
 */
@Path("numerge")
@Component
public class ActivitatiResource extends SpringBeanAutowiringSupport {
    
	@Autowired
	private ExerciseRepository exerciseRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Exercise> getAllActivities(){

			List<Exercise> listaExercitii = exerciseRepository.loadAllEager();
        return listaExercitii;
    }
}

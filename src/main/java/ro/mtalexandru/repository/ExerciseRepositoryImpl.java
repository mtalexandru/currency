package ro.mtalexandru.repository;

import org.springframework.stereotype.Repository;
import ro.mtalexandru.model.Exercise;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository("exerciseRepository")
public class ExerciseRepositoryImpl implements ExerciseRepository {

	@PersistenceContext
	private EntityManager em;
	
	public Exercise save(Exercise exercise) {
		
		em.persist(exercise);
		
		em.flush();
		
		return exercise;
	}

	public List<Exercise> loadAllExercises() {
		//Query query = em.createQuery("Select g from Goal g");

		TypedQuery<Exercise> query = em.createNamedQuery("findAllExercises", Exercise.class);

		return query.getResultList();
	}

	public List<Exercise> loadAllEager() {
		Query query = em.createQuery("SELECT e FROM Exercise e JOIN FETCH e.goal");
		return query.getResultList();
	}

}

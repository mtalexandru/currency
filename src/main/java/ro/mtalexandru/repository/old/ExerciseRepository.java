package ro.mtalexandru.repository.old;

import ro.mtalexandru.model.old.Exercise;

import java.util.List;

public interface ExerciseRepository {

	Exercise save (Exercise exercise);

	List<Exercise> loadAllExercises();

	List<Exercise> loadAllEager();
	
}

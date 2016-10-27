package ro.mtalexandru.repository;

import ro.mtalexandru.model.Exercise;

import java.util.List;

public interface ExerciseRepository {

	Exercise save (Exercise exercise);

	List<Exercise> loadAllExercises();

	List<Exercise> loadAllEager();
	
}

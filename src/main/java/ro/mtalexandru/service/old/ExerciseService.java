package ro.mtalexandru.service.old;

import ro.mtalexandru.model.old.Activity;
import ro.mtalexandru.model.old.Exercise;

import java.util.List;

public interface ExerciseService {

	List<Activity> findAllActivities();

	Exercise save(Exercise exercise);

}
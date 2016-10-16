package ro.mtalexandru.service;

import java.util.List;

import ro.mtalexandru.model.Activity;
import ro.mtalexandru.model.Exercise;

public interface ExerciseService {

	List<Activity> findAllActivities();

	Exercise save(Exercise exercise);

}
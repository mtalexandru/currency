package ro.mtalexandru.service;

import ro.mtalexandru.model.Goal;
import ro.mtalexandru.model.GoalReport;

import java.util.List;

public interface GoalService {

	Goal save(Goal goal);

	List<Goal> findAllGoals();

	List<GoalReport> findAllGoalReports();
	
}

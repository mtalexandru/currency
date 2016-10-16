package ro.mtalexandru.repository;

import java.util.List;

import ro.mtalexandru.model.Goal;
import ro.mtalexandru.model.GoalReport;

public interface GoalRepository {

	Goal save(Goal goal);

	List<Goal> loadAll();

	List<GoalReport> findAllGoalReports();
	
}

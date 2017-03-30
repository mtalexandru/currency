package ro.mtalexandru.repository.old;

import ro.mtalexandru.model.old.Goal;
import ro.mtalexandru.model.old.GoalReport;

import java.util.List;

public interface GoalRepository {

	Goal save(Goal goal);

	List<Goal> loadAll();

	List<GoalReport> findAllGoalReports();
	
}

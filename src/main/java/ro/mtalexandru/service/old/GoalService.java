package ro.mtalexandru.service.old;

import ro.mtalexandru.model.old.Goal;
import ro.mtalexandru.model.old.GoalReport;

import java.util.List;

public interface GoalService {

	Goal save(Goal goal);

	List<Goal> findAllGoals();

	List<GoalReport> findAllGoalReports();
	
}

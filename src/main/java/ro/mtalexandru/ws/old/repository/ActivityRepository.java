package ro.mtalexandru.ws.old.repository;

import ro.mtalexandru.ws.old.model.Activity;

import java.util.List;

/**
 * Created by Mau on 8/4/2016.
 */
public interface ActivityRepository {
    List<Activity> findAllActivities();
    Activity findActivity(String activityId);

    void create(Activity activity);
}

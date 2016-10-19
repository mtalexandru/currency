package ro.mtalexandru.ws.repository;

import ro.mtalexandru.ws.model.Activity;

import java.util.List;

/**
 * Created by Mau on 8/4/2016.
 */
public interface ActivityRepository {
    List<Activity> findAllActivities();
    Activity findActivity(String activityId);

    void create(Activity activity);
}

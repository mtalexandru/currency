package ro.mtalexandru.ws.old.repository;

import ro.mtalexandru.ws.old.model.Activity;
import ro.mtalexandru.ws.old.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mau on 8/4/2016.
 */
public class ActivityRepositoryStub implements ActivityRepository {
    @Override
    public List<Activity> findAllActivities(){
        List<Activity> activities = new ArrayList<Activity>();

        Activity activity1 = new Activity();
        activity1.setDescription("Swimming");
        activity1.setDuration(55);

        activities.add(activity1);

        Activity activity2 = new Activity();
        activity2.setDescription("Cycling");
        activity2.setDuration(129);

        activities.add(activity2);

        return activities;
    }

    @Override
    public Activity findActivity(String activityId){
        Activity activity1 = new Activity();
        activity1.setDescription("Swimming");
        activity1.setDuration(55);
        activity1.setId("1234");

        User user = new User();
        user.setId("5678");
        user.setName("Mau");

        activity1.setUser(user);

        return activity1;
    }

    @Override
    public void create(Activity activity) {
        //should issue an insert instruction to the DB
        System.out.println("I have created a new activity: " + activity);
    }
}

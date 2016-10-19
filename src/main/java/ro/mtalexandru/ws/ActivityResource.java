package ro.mtalexandru.ws;

import ro.mtalexandru.ws.model.Activity;
import ro.mtalexandru.ws.model.User;
import ro.mtalexandru.ws.repository.ActivityRepositoryStub;
import ro.mtalexandru.ws.repository.ActivityRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import java.util.List;


/**
 * Created by Mau on 8/4/2016.
 */
@Path("activities") //http://localhost:8080/webapi/activities
public class ActivityResource {
    
    private ActivityRepository activityRepository = new ActivityRepositoryStub();


    @POST
    @Path("activity")
    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Activity createActivity(Activity activity){
        System.out.println("Json transmitted desc: " + activity.getDescription());
        System.out.println("Json transmitted dur: " + activity.getDuration());

        activityRepository.create(activity);
        return activity;
    }


    @POST
    @Path("activity")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Activity createActivityParams(MultivaluedMap<String,String> formParams){
        System.out.println(formParams.getFirst("description"));
        System.out.println(formParams.getFirst("duration"));

        Activity activity = new Activity();
        activity.setDescription(formParams.getFirst("description"));
        activity.setDescription(formParams.getFirst("duration"));

        activityRepository.create(activity);
        return activity;
    }


    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Activity> getAllActivities(){
        return activityRepository.findAllActivities();
    }


    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{activityId}") //http://localhost:8080/webapi/activities/1234
    public Activity getActivity(@PathParam("activityId") String activityId){
        System.out.println("Getting activity ID: " + activityId);
        return activityRepository.findActivity(activityId);
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{activityId}/user") //http://localhost:8080/webapi/activities/1234/
    public User getActivityUser(@PathParam("activityId") String activityId){
        return activityRepository.findActivity(activityId).getUser();
    }
}

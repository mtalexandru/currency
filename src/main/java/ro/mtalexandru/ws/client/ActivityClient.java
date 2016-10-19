package ro.mtalexandru.ws.client;

import ro.mtalexandru.model.Activity;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

/**
 * Created by malexandru on 8/5/2016.
 */
public class ActivityClient {

    private Client client;

    public ActivityClient(){
        client = ClientBuilder.newClient();
    }

    public Activity get(String id){

        //http://localhost:8080/webapi/activities/1234
        WebTarget target = client.target("http://localhost:8080/webapi/");

        Activity response = target.path("activities/" + id).request().get(Activity.class);

        return response;
    }

}

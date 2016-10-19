package ro.mtalexandru.client;

import org.junit.Test;
import ro.mtalexandru.model.Activity;
import ro.mtalexandru.ws.client.ActivityClient;

import static org.junit.Assert.assertNotNull;

/**
 * Created by malexandru on 8/5/2016.
 */

public class ActivityClientTest {

    @Test
    public void testGet() throws Exception {
        ActivityClient activityClient = new ActivityClient();
        Activity activity = activityClient.get("1234");
        System.out.println("## test : " + activity);

        assertNotNull(activity);
    }
}
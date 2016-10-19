package ro.mtalexandru.ws.model;


/**
 * Created by Mau on 8/4/2016.
 */
public class Activity {

    private String id;
    private User user;
    private String description;
    private int duration;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id='" + id + '\'' +
                ", user=" + user +
                ", description='" + description + '\'' +
                ", duration=" + duration +
                '}';
    }
}

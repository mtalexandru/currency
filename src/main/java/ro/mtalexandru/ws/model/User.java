package ro.mtalexandru.ws.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by malexandru on 8/5/2016.
 */
@XmlRootElement
public class User {

    private String name;
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

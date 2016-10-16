package ro.mtalexandru.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by Mau on 8/20/2016.
 */
@Entity
@Table(name="USER")
public class User implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(name="USERNAME")
    private String username;

    @Column(name="FULL_NAME")
    private String fullName;

    @NotNull
    @Column(name="PASSWORD")
    private String password;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

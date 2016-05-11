package company.tothepoint.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import company.tothepoint.domain.DomainBase;
import org.springframework.data.annotation.Id;

import java.util.Date;

public class User extends DomainBase {

    private static final long serialVersionUID = 2353528370345499815L;
    private String id;
    private String username;
    @JsonIgnore
    private String password;
    private String email;
    private Date lastPasswordReset;
    private String authorities;

    public User() {
        super();
    }

    public User(String username, String password, String email, Date lastPasswordReset, String authorities) {
        this.setUsername(username);
        this.setPassword(password);
        this.setEmail(email);
        this.setLastPasswordReset(lastPasswordReset);
        this.setAuthorities(authorities);
    }

    @Id
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Date getLastPasswordReset() {
        return this.lastPasswordReset;
    }

    public void setLastPasswordReset(Date lastPasswordReset) {
        this.lastPasswordReset = lastPasswordReset;
    }


    public String getAuthorities() {
        return this.authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

}

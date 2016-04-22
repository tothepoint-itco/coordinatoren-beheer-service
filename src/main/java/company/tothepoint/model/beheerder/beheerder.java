package company.tothepoint.model.beheerder;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by butrint on 22/04/16.
 */
public class Beheerder {
    @Id
    private String id;

    @NotNull
    @Size(min = 1, max = 255)
    private String voorNaam;
    @NotNull
    @Size(min = 1, max = 255)
    private String famillieNaam;
    @NotNull
    @Size(min = 1, max = 255)
    private String email;
    @NotNull
    @Size(min = 1, max = 255)
    private String passwoord;

    public Beheerder(){}
    public Beheerder(String id, String voorNaam, String famillieNaam, String email, String passwoord) {
        this.id = id;
        this.voorNaam = voorNaam;
        this.famillieNaam = famillieNaam;
        this.email = email;
        this.passwoord = passwoord;
    }

    public String getId() {
        return id;
    }

    public String getVoorNaam() {
        return voorNaam;
    }

    public String getFamillieNaam() {
        return famillieNaam;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswoord() {
        return passwoord;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setVoorNaam(String voorNaam) {
        this.voorNaam = voorNaam;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFamillieNaam(String famillieNaam) {
        this.famillieNaam = famillieNaam;
    }

    public void setPasswoord(String passwoord) {
        this.passwoord = passwoord;
    }
}

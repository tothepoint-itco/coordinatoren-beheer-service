package company.tothepoint.model.beheerder;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Beheerder {
    @Id
    private String id;

    @NotNull
    @Size(min = 1, max = 255)
    private String voorNaam;
    @NotNull
    @Size(min = 1, max = 255)
    private String familieNaam;
    @NotNull
    @Size(min = 1, max = 255)
    private String email;
    @NotNull
    @Size(min = 1, max = 255)
    private String gebruikersNaam;



    @NotNull
    @Size(min = 1, max = 255)
    private String passwoord;

    public Beheerder(){}
    public Beheerder(String voorNaam, String familieNaam, String email, String passwoord) {
        this.voorNaam = voorNaam;
        this.familieNaam = familieNaam;
        this.email = email;
        this.passwoord = passwoord;
    }
    public String getGebruikersNaam() {
        return gebruikersNaam;
    }

    public void setGebruikersNaam(String gebruikersNaam) {
        this.gebruikersNaam = gebruikersNaam;
    }

    public String getId() {
        return id;
    }

    public String getVoorNaam() {
        return voorNaam;
    }

    public String getFamilieNaam() {
        return familieNaam;
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

    public void setFamilieNaam(String familieNaam) {
        this.familieNaam = familieNaam;
    }

    public void setPasswoord(String passwoord) {
        this.passwoord = passwoord;
    }
}

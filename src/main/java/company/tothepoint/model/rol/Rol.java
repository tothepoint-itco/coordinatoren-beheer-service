package company.tothepoint.model.rol;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;

/**
 * Created by butrint on 25/04/16.
 */
public class Rol {

    @Id
    private String id;

    @NotNull
    private String rolNaam;

    @NotNull
    private String beheerderId;

    @NotNull
    private String businessUnitId;

    public Rol(){}
    public Rol(String rolNaam, String beheerderId, String businessUnitId){
        this.rolNaam = rolNaam;
        this.beheerderId = beheerderId;
        this.businessUnitId = businessUnitId;
    }

    public void setRolNaam(String rolNaam) {
        this.rolNaam = rolNaam;
    }

    public String getRolNaam() {

        return rolNaam;
    }

    public String getBeheerderId() {
        return beheerderId;
    }

    public String getBusinessUnitId() {
        return businessUnitId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBeheerderId(String beheerderId) {
        this.beheerderId = beheerderId;
    }

    public void setBusinessUnitId(String businessUnitId) {
        this.businessUnitId = businessUnitId;
    }
}

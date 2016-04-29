package company.tothepoint.model.beheerder;

import company.tothepoint.model.Notification;

/**
 * Created by butrint on 25/04/16.
 */
public class BeheerderUpdatedNotification extends Notification {
    private Beheerder updatedBeheerder;
    public BeheerderUpdatedNotification(){}
    public BeheerderUpdatedNotification(String title, Beheerder updatedBeheerder){
        super(title);
        this.updatedBeheerder = updatedBeheerder;
    }

    public void setUpdatedBeheerder(Beheerder updatedBeheerder) {
        this.updatedBeheerder = updatedBeheerder;
    }

    public Beheerder getUpdatedBeheerder() {

        return updatedBeheerder;
    }
}

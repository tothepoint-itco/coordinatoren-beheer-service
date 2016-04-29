package company.tothepoint.model.beheerder;

import company.tothepoint.model.Notification;

/**
 * Created by butrint on 25/04/16.
 */
public class BeheerderDeletedNotification extends Notification{
    private String deletedBeheerderId;
    public BeheerderDeletedNotification(){}
    public BeheerderDeletedNotification(String title, String deleteBeheerderId){
        super(title);
        this.deletedBeheerderId = deleteBeheerderId;
    }

    public void setDeletedBeheerderId(String deletedBeheerderId) {
        this.deletedBeheerderId = deletedBeheerderId;
    }

    public String getDeletedBeheerderId() {

        return deletedBeheerderId;
    }
}

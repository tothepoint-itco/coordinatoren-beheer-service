package company.tothepoint.model.beheerder;

import company.tothepoint.model.Notification;

public class BeheerderCreatedNotification extends Notification{
    private Beheerder createBeheerder;
    public BeheerderCreatedNotification(){

    }
    public BeheerderCreatedNotification(String title, Beheerder createdBeheerder){
        super(title);
        this.createBeheerder = createdBeheerder;

    }

    public Beheerder getCreateBeheerder() {
        return createBeheerder;
    }

    public void setCreateBeheerder(Beheerder createBeheerder) {
        this.createBeheerder = createBeheerder;
    }
}

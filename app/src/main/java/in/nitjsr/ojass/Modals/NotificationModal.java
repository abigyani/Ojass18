package in.nitjsr.ojass.Modals;

/**
 * Created by Abhishek on 06-Feb-18.
 */

public class NotificationModal {

    String body, title;

    public NotificationModal(String body, String title) {
        this.body = body;
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public String getTitle() {
        return title;
    }
}

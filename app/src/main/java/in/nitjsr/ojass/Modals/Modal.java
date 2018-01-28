package in.nitjsr.ojass.Modals;


public class Modal {
    private String eventName;
    private int image;
    private String description;

    public Modal(int image, String eventName, String description) {
        this.eventName = eventName;
        this.image = image;
        this.description = description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getEventName() {
        return eventName;
    }

    public int getImage() {
        return image;
    }
}

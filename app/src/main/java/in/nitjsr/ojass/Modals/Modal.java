package in.nitjsr.ojass.Modals;


public class Modal {
    private String eventName;
    private int Image;
    private String description;

    public Modal(int image, String eventName, String description) {
        this.eventName = eventName;
        Image = image;
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
        Image = image;
    }

    public String getEventName() {
        return eventName;
    }

    public int getImage() {
        return Image;
    }
}

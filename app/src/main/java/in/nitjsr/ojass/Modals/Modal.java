package in.nitjsr.ojass.Modals;


import android.graphics.drawable.Drawable;

public class Modal{
    private String eventName;
    private String image;
    private String description;
    private String timeStamp;
    private int drawableImage;

    public Modal(String image, String eventName, String description, String timeStamp) {
        this.eventName = eventName;
        this.image = image;
        this.description = description;
        this.timeStamp = timeStamp;
    }

    public Modal(String image, String eventName, String description) {
        this.eventName = eventName;
        this.image = image;
        this.description = description;
    }

    public Modal(int drawableImage, String eventName, String description) {
        this.eventName = eventName;
        this.drawableImage = drawableImage;
        this.description = description;
        this.image = null;
    }

    public String getTimeStamp(){
        return timeStamp;
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

    public void setImage(String image) {
        this.image = image;
    }

    public String getEventName() {
        return eventName;
    }

    public String getImage() {
       return image;
    }

    public int getDrawableImage(){
        return drawableImage;
    }
}

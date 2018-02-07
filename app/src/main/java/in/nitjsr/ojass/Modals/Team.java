package in.nitjsr.ojass.Modals;

/**
 * Created by Abhishek on 30-Jan-18.
 */

public class Team {

    private String name, desg, phone, imageSrc;

    public Team(String name, String desg, String phone, String imageSrc) {
        this.imageSrc = imageSrc;
        this.name = name;
        this.desg = desg;
        this.phone = phone;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public String getName() {
        return name;
    }

    public String getDesg() {
        return desg;
    }

    public String getPhone() {
        return phone;
    }
}

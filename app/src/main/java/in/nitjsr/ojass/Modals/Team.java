package in.nitjsr.ojass.Modals;

/**
 * Created by Abhishek on 30-Jan-18.
 */

public class Team {

    private int imageSrc;
    private String name, desg, phone;

    public Team(int imageSrc, String name, String desg, String phone) {
        this.imageSrc = imageSrc;
        this.name = name;
        this.desg = desg;
        this.phone = phone;
    }

    public int getImageSrc() {
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

package in.nitjsr.ojass.Modals;

/**
 * Created by Sanay on 1/31/2018.
 */

public class Devpage_modal {
    int image;
    String name;
    String description;

    public Devpage_modal(int image, String name, String description) {
        this.image = image;
        this.name = name;
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

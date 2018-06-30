package parent.school.salsal.com.model;

public class ReceiverMessageItem {
    String name;
    int image;
    int recipientType;
    public static final int TEACHER = 1;
    public static final int PARENT = 2;
    public static final int UNIT = 0;

    public ReceiverMessageItem(String name, int recipientType) {
        this.name = name;
        this.recipientType = recipientType;
    }

    public int getRecipientType() {
        return recipientType;
    }

    public void setRecipientType(int recipientType) {
        this.recipientType = recipientType;
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
}

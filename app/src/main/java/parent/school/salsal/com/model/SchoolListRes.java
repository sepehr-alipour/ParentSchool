package parent.school.salsal.com.model;

public class SchoolListRes {

    String name;
    boolean isChecked;
    int logo;

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
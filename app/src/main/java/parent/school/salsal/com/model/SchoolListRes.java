package parent.school.salsal.com.model;

import com.google.gson.annotations.SerializedName;

public class SchoolListRes {


    /**
     * id : 1
     * name : مدرسه البرز
     * logo : http://hamijoo.com/wp-content/uploads/2016/08/photo_2016-08-31_16-25-37.jpg
     * url : http://192.168.1.7
     * created_at : null
     * updated_at : null
     */

    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("logo")
    private String logo;
    @SerializedName("url")
    private String url;
    private boolean isChecked;

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
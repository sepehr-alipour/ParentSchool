package parent.school.salsal.com.model;

import com.google.gson.annotations.SerializedName;

public class TeacherProfileRes {


    /**
     * id : 2
     * education : null
     * name : sepehr
     * birth_date : 1369-10-11
     * image_url : null
     * rate : null
     * email : aliahmadi@gmail.com
     * phone_number : 09363531363
     * national_code : 4900191051
     * user_id : 1
     * created_at : 2018-05-23 16:05:34
     * updated_at : 2018-05-23 16:05:34
     * title : Chemistry
     */

    @SerializedName("id")
    private int id;
    @SerializedName("education")
    private Object education;
    @SerializedName("name")
    private String name;
    @SerializedName("birth_date")
    private String birthDate;
    @SerializedName("image_url")
    private Object imageUrl;
    @SerializedName("rate")
    private Object rate;
    @SerializedName("email")
    private String email;
    @SerializedName("phone_number")
    private String phoneNumber;
    @SerializedName("national_code")
    private String nationalCode;
    @SerializedName("user_id")
    private int userId;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("updated_at")
    private String updatedAt;
    @SerializedName("title")
    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getEducation() {
        return education;
    }

    public void setEducation(Object education) {
        this.education = education;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Object getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Object imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Object getRate() {
        return rate;
    }

    public void setRate(Object rate) {
        this.rate = rate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

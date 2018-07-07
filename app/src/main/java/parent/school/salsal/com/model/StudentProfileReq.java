package parent.school.salsal.com.model;

import com.google.gson.annotations.SerializedName;

public class StudentProfileReq {


    /**
     * id : 1
     * name : hassan
     * birth_date : 2018-03-01
     * image_url : ehsan
     * email : ehsan@yahoo.com
     * phone_number : 02166626621
     * national_code : 2280945355
     */

    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("birth_date")
    private String birthDate;
    @SerializedName("image_url")
    private String imageUrl;
    @SerializedName("email")
    private String email;
    @SerializedName("phone_number")
    private String phoneNumber;
    @SerializedName("national_code")
    private String nationalCode;

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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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
}

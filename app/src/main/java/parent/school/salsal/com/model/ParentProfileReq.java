package parent.school.salsal.com.model;

import com.google.gson.annotations.SerializedName;

public class ParentProfileReq {


    /**
     * education : sepehr
     * birth_date : aliahmadi@gmail.com
     * email : 09363531363
     * phone_number : 4900191051
     */

    @SerializedName("education")
    private String education;
    @SerializedName("birth_date")
    private long birthDate;
    @SerializedName("email")
    private String email;
    @SerializedName("phone_number")
    private String phoneNumber;

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public long getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(long birthDate) {
        this.birthDate = birthDate;
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
}

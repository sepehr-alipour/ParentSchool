package parent.school.salsal.com.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UnitAdmins {


    /**
     * msg : ok
     * data : [{"id":1,"education":"کارشناس","name":"Marjorie","birth_date":891220408,"media_id":"https://cdn3.iconfinder.com/data/icons/pretty-office-part-10-shadow-style/512/Teacher-male.png","rate":"4","email":"grimes.aaron@gmail.com","phone_number":"+1.237.565.2579","national_code":"d3211a55-3c2d-3236-99c4-b072b789737c","user_id":23,"is_admin":1,"created_at":"1537463026","updated_at":"1537463026"}]
     */

    @SerializedName("msg")
    private String msg;
    @SerializedName("data")
    private List<DataBean> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * education : کارشناس
         * name : Marjorie
         * birth_date : 891220408
         * media_id : https://cdn3.iconfinder.com/data/icons/pretty-office-part-10-shadow-style/512/Teacher-male.png
         * rate : 4
         * email : grimes.aaron@gmail.com
         * phone_number : +1.237.565.2579
         * national_code : d3211a55-3c2d-3236-99c4-b072b789737c
         * user_id : 23
         * is_admin : 1
         * created_at : 1537463026
         * updated_at : 1537463026
         */

        @SerializedName("id")
        private int id;
        @SerializedName("education")
        private String education;
        @SerializedName("name")
        private String name;
        @SerializedName("birth_date")
        private long birthDate;
        @SerializedName("media_id")
        private String mediaId;
        @SerializedName("rate")
        private String rate;
        @SerializedName("email")
        private String email;
        @SerializedName("phone_number")
        private String phoneNumber;
        @SerializedName("national_code")
        private String nationalCode;
        @SerializedName("user_id")
        private int userId;
        @SerializedName("is_admin")
        private int isAdmin;
        @SerializedName("created_at")
        private String createdAt;
        @SerializedName("updated_at")
        private String updatedAt;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getEducation() {
            return education;
        }

        public void setEducation(String education) {
            this.education = education;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getBirthDate() {
            return birthDate;
        }

        public void setBirthDate(long birthDate) {
            this.birthDate = birthDate;
        }

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }

        public String getRate() {
            return rate;
        }

        public void setRate(String rate) {
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

        public int getIsAdmin() {
            return isAdmin;
        }

        public void setIsAdmin(int isAdmin) {
            this.isAdmin = isAdmin;
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
    }
}

package parent.school.salsal.com.model;

import com.google.gson.annotations.SerializedName;

public class ParentProfileRes {


    /**
     * data : {"id":1,"education":"BS","name":"houshang","birth_date":"1369-10-11","image_url":"123","rate":"10","email":"aliahmadi@gmail.com","phone_number":"09363531363","national_code":"4900191051","user_id":13,"created_at":"2018-05-23 15:17:47","updated_at":"2018-07-10 07:10:58"}
     * msg : ok
     */

    @SerializedName("data")
    private DataBean data;
    @SerializedName("msg")
    private String msg;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class DataBean {
        /**
         * id : 1
         * education : BS
         * name : houshang
         * birth_date : 1369-10-11
         * image_url : 123
         * rate : 10
         * email : aliahmadi@gmail.com
         * phone_number : 09363531363
         * national_code : 4900191051
         * user_id : 13
         * created_at : 2018-05-23 15:17:47
         * updated_at : 2018-07-10 07:10:58
         */

        @SerializedName("id")
        private int id;
        @SerializedName("education")
        private String education;
        @SerializedName("name")
        private String name;
        @SerializedName("birth_date")
        private String birthDate;
        @SerializedName("image_url")
        private String imageUrl;
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

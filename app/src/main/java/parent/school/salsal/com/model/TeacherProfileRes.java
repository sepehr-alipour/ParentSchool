package parent.school.salsal.com.model;

import com.google.gson.annotations.SerializedName;

public class TeacherProfileRes {

    /**
     * msg : ok
     * data : {"id":2,"education":null,"name":"saeed","birth_date":null,"image_url":"https://pickaface.net/gallery/avatar/unr_paii_180627_0934_vpwcm.png","rate":null,"email":null,"phone_number":null,"national_code":null,"user_id":2,"created_at":"2018-05-23 15:16:00","updated_at":"2018-05-23 15:16:00"}
     */

    @SerializedName("msg")
    private String msg;
    @SerializedName("data")
    private DataBean data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 2
         * education : null
         * name : saeed
         * birth_date : null
         * image_url : https://pickaface.net/gallery/avatar/unr_paii_180627_0934_vpwcm.png
         * rate : null
         * email : null
         * phone_number : null
         * national_code : null
         * user_id : 2
         * created_at : 2018-05-23 15:16:00
         * updated_at : 2018-05-23 15:16:00
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
        private float rate;
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

        public float getRate() {
            return rate;
        }

        public void setRate(float rate) {
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

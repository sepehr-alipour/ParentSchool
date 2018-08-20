package parent.school.salsal.com.model;

import com.google.gson.annotations.SerializedName;

public class StudentProfileRes {


    /**
     * msg : ok
     * data : {"id":3,"name":"sadegh","birth_date":null,"image_url":null,"email":null,"phone_number":null,"national_code":null,"user_id":7,"parent_id":1,"created_at":"2018-05-23 15:17:16","updated_at":"2018-05-23 15:17:16"}
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
         * id : 3
         * name : sadegh
         * birth_date : null
         * image_url : null
         * email : null
         * phone_number : null
         * national_code : null
         * user_id : 7
         * parent_id : 1
         * created_at : 2018-05-23 15:17:16
         * updated_at : 2018-05-23 15:17:16
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
        @SerializedName("user_id")
        private int userId;
        @SerializedName("parent_id")
        private int parentId;
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

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public Object getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Object getPhoneNumber() {
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

        public int getParentId() {
            return parentId;
        }

        public void setParentId(int parentId) {
            this.parentId = parentId;
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

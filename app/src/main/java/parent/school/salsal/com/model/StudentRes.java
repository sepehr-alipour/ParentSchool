package parent.school.salsal.com.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StudentRes {


    /**
     * data : [{"id":3,"name":"sadegh","birth_date":null,"image_url":null,"email":null,"phone_number":null,"national_code":null,"user_id":7,"parent_id":1,"created_at":"2018-05-23 15:17:16","updated_at":"2018-05-23 15:17:16"},{"id":4,"name":"jafar","birth_date":null,"image_url":null,"email":null,"phone_number":null,"national_code":null,"user_id":8,"parent_id":1,"created_at":"2018-05-23 15:17:19","updated_at":"2018-05-23 15:17:19"},{"id":5,"name":"ahmad","birth_date":null,"image_url":null,"email":null,"phone_number":null,"national_code":null,"user_id":9,"parent_id":1,"created_at":"2018-05-23 15:17:23","updated_at":"2018-05-23 15:17:23"}]
     * msg : ok
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
        private String id;
        @SerializedName("name")
        private String name;
        @SerializedName("birth_date")
        private Object birthDate;
        @SerializedName("image_url")
        private Object imageUrl;
        @SerializedName("email")
        private Object email;
        @SerializedName("phone_number")
        private Object phoneNumber;
        @SerializedName("national_code")
        private Object nationalCode;
        @SerializedName("user_id")
        private int userId;
        @SerializedName("parent_id")
        private int parentId;
        @SerializedName("created_at")
        private String createdAt;
        @SerializedName("updated_at")
        private String updatedAt;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object getBirthDate() {
            return birthDate;
        }

        public void setBirthDate(Object birthDate) {
            this.birthDate = birthDate;
        }

        public Object getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(Object imageUrl) {
            this.imageUrl = imageUrl;
        }

        public Object getEmail() {
            return email;
        }

        public void setEmail(Object email) {
            this.email = email;
        }

        public Object getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(Object phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public Object getNationalCode() {
            return nationalCode;
        }

        public void setNationalCode(Object nationalCode) {
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

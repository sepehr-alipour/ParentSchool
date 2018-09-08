package parent.school.salsal.com.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Sepehr on 12/4/2017.
 */

public class NotificationRes {


    /**
     * msg : ok
     * data : [{"id":3,"education":"دکترا","name":"علی کمالی","birth_date":"1369/10/11","image_url":"https://pickaface.net/gallery/avatar/unr_paii_180627_0934_vpwcm.png","rate":"4","email":"aliahmadi@gmail.com","phone_number":"09363531363","national_code":"4900191051","user_id":1,"created_at":"2018-05-23 15:33:57","updated_at":"2018-05-23 15:33:57","title":"بی انضباطی","message":"متن اعلان","type":1,"file_url":"link","recipient_type":"Parent","pivot":{"user_id":13,"notification_id":3,"created_at":"2018-05-23 15:33:57","updated_at":"2018-05-23 15:33:57"}},{"id":12,"education":"ارشد بیوتکنولوژی","name":"صابر ندافی","birth_date":"1360/12/01","image_url":"https://pickaface.net/gallery/avatar/unr_paii_180627_0934_vpwcm.png","rate":"2","email":"s.n@gmail.com","phone_number":"091232547995","national_code":"5646455465","user_id":2,"created_at":"2018-07-14 05:52:24","updated_at":"2018-07-14 05:52:24","title":"suus","message":"dudu","type":1,"file_url":"link","recipient_type":"Parent","pivot":{"user_id":13,"notification_id":12,"created_at":"2018-07-14 05:52:24","updated_at":"2018-07-14 05:52:24"}},{"id":14,"education":"ارشد بیوتکنولوژی","name":"صابر ندافی","birth_date":"1360/12/01","image_url":"https://pickaface.net/gallery/avatar/unr_paii_180627_0934_vpwcm.png","rate":"2","email":"s.n@gmail.com","phone_number":"091232547995","national_code":"5646455465","user_id":2,"created_at":"2018-07-14 05:53:08","updated_at":"2018-07-14 05:53:08","title":"suus","message":"dudu","type":1,"file_url":"link","recipient_type":"Parent","pivot":{"user_id":13,"notification_id":14,"created_at":"2018-07-14 05:53:08","updated_at":"2018-07-14 05:53:08"}}]
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
         * education : دکترا
         * name : علی کمالی
         * birth_date : 1369/10/11
         * image_url : https://pickaface.net/gallery/avatar/unr_paii_180627_0934_vpwcm.png
         * rate : 4
         * email : aliahmadi@gmail.com
         * phone_number : 09363531363
         * national_code : 4900191051
         * user_id : 1
         * created_at : 2018-05-23 15:33:57
         * updated_at : 2018-05-23 15:33:57
         * title : بی انضباطی
         * message : متن اعلان
         * type : 1
         * file_url : link
         * recipient_type : Parent
         * pivot : {"user_id":13,"notification_id":3,"created_at":"2018-05-23 15:33:57","updated_at":"2018-05-23 15:33:57"}
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
        @SerializedName("title")
        private String title;
        @SerializedName("message")
        private String message;
        @SerializedName("type")
        private int type;
        @SerializedName("file_url")
        private String fileUrl;
        @SerializedName("recipient_type")
        private String recipientType;
        @SerializedName("pivot")
        private PivotBean pivot;

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

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getFileUrl() {
            return fileUrl;
        }

        public void setFileUrl(String fileUrl) {
            this.fileUrl = fileUrl;
        }

        public String getRecipientType() {
            return recipientType;
        }

        public void setRecipientType(String recipientType) {
            this.recipientType = recipientType;
        }

        public PivotBean getPivot() {
            return pivot;
        }

        public void setPivot(PivotBean pivot) {
            this.pivot = pivot;
        }

        public static class PivotBean {
            /**
             * user_id : 13
             * notification_id : 3
             * created_at : 2018-05-23 15:33:57
             * updated_at : 2018-05-23 15:33:57
             */

            @SerializedName("user_id")
            private int userId;
            @SerializedName("notification_id")
            private int notificationId;
            @SerializedName("created_at")
            private String createdAt;
            @SerializedName("updated_at")
            private String updatedAt;

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getNotificationId() {
                return notificationId;
            }

            public void setNotificationId(int notificationId) {
                this.notificationId = notificationId;
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
}
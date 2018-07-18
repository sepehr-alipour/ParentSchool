package parent.school.salsal.com.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AttendanceRes {


    /**
     * msg : ok
     * data : [{"title":"Chemistry","status":1,"created_at":"2018-07-10 12:01:04","name":"saeed"},{"title":"Chemistry","status":0,"created_at":"2018-07-14 05:28:49","name":"saeed"},{"title":"Chemistry","status":1,"created_at":"2018-07-14 05:28:55","name":"saeed"}]
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
         * title : Chemistry
         * status : 1
         * created_at : 2018-07-10 12:01:04
         * name : saeed
         */

        @SerializedName("title")
        private String title;
        @SerializedName("status")
        private int status;
        @SerializedName("created_at")
        private String createdAt;
        @SerializedName("name")
        private String name;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

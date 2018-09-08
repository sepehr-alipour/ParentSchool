package parent.school.salsal.com.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ScheduleRes {


    /**
     * data : [{"day_of_week":0,"priority":1,"start_time":1531218786,"end_time":1531218809,"title":"ریاضی","name":"علی کمالی"},{"day_of_week":0,"priority":2,"start_time":1531218786,"end_time":1531218809,"title":"ریاضی","name":"علی کمالی"},{"day_of_week":1,"priority":1,"start_time":1531218786,"end_time":1531218809,"title":"ریاضی","name":"علی کمالی"},{"day_of_week":3,"priority":1,"start_time":1531218786,"end_time":1531218809,"title":"ریاضی","name":"علی کمالی"}]
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
         * day_of_week : 0
         * priority : 1
         * start_time : 1531218786
         * end_time : 1531218809
         * title : ریاضی
         * name : علی کمالی
         */

        @SerializedName("day_of_week")
        private int dayOfWeek;
        @SerializedName("priority")
        private int priority;
        @SerializedName("start_time")
        private int startTime;
        @SerializedName("end_time")
        private int endTime;
        @SerializedName("title")
        private String title;
        @SerializedName("name")
        private String name;

        public int getDayOfWeek() {
            return dayOfWeek;
        }

        public void setDayOfWeek(int dayOfWeek) {
            this.dayOfWeek = dayOfWeek;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public int getStartTime() {
            return startTime;
        }

        public void setStartTime(int startTime) {
            this.startTime = startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public void setEndTime(int endTime) {
            this.endTime = endTime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

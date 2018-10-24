package parent.school.salsal.com.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ActivityDetailRes {


    /**
     * data : [{"activity_answer":null,"activity_score":null,"student_name":"Adrain","student_id":1,"activity_title":"تست","activity_desc":"جواب بدید","activity_file":"link","activity_expires":"1397/7/24"}]
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
         * activity_answer : null
         * activity_score : null
         * student_name : Adrain
         * student_id : 1
         * activity_title : تست
         * activity_desc : جواب بدید
         * activity_file : link
         * activity_expires : 1397/7/24
         */

        @SerializedName("activity_answer")
        private Object activityAnswer;
        @SerializedName("activity_score")
        private Object activityScore;
        @SerializedName("student_name")
        private String studentName;
        @SerializedName("student_id")
        private int studentId;
        @SerializedName("activity_title")
        private String activityTitle;
        @SerializedName("activity_desc")
        private String activityDesc;
        @SerializedName("activity_file")
        private String activityFile;
        @SerializedName("activity_expires")
        private String activityExpires;

        public Object getActivityAnswer() {
            return activityAnswer;
        }

        public void setActivityAnswer(Object activityAnswer) {
            this.activityAnswer = activityAnswer;
        }

        public Object getActivityScore() {
            return activityScore;
        }

        public void setActivityScore(Object activityScore) {
            this.activityScore = activityScore;
        }

        public String getStudentName() {
            return studentName;
        }

        public void setStudentName(String studentName) {
            this.studentName = studentName;
        }

        public int getStudentId() {
            return studentId;
        }

        public void setStudentId(int studentId) {
            this.studentId = studentId;
        }

        public String getActivityTitle() {
            return activityTitle;
        }

        public void setActivityTitle(String activityTitle) {
            this.activityTitle = activityTitle;
        }

        public String getActivityDesc() {
            return activityDesc;
        }

        public void setActivityDesc(String activityDesc) {
            this.activityDesc = activityDesc;
        }

        public String getActivityFile() {
            return activityFile;
        }

        public void setActivityFile(String activityFile) {
            this.activityFile = activityFile;
        }

        public String getActivityExpires() {
            return activityExpires;
        }

        public void setActivityExpires(String activityExpires) {
            this.activityExpires = activityExpires;
        }
    }
}

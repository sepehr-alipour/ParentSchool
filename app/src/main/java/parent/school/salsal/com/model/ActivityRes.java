package parent.school.salsal.com.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ActivityRes {


    /**
     * msg : ok
     * data : [{"id":2,"teacher_course_class_id":2,"title":"title1","desc":"acdesc1","expire_date":"1396-12-01","file_address":"url","atype_id":1,"created_at":"2018-07-09 14:43:44","updated_at":"2018-07-09 14:43:44","pivot":{"student_profile_id":3,"activity_id":2,"created_at":"2018-07-09 14:43:44","updated_at":"2018-07-09 14:43:44"}},{"id":3,"teacher_course_class_id":2,"title":"title2","desc":"acdesc1","expire_date":"1396-12-01","file_address":"url","atype_id":1,"created_at":"2018-07-09 14:44:10","updated_at":"2018-07-09 14:44:10","pivot":{"student_profile_id":3,"activity_id":3,"created_at":"2018-07-09 14:44:10","updated_at":"2018-07-09 14:44:10"}},{"id":4,"teacher_course_class_id":2,"title":"title3","desc":"acdesc1","expire_date":"1396-12-01","file_address":"url","atype_id":1,"created_at":"2018-07-09 14:44:15","updated_at":"2018-07-09 14:44:15","pivot":{"student_profile_id":3,"activity_id":4,"created_at":"2018-07-09 14:44:15","updated_at":"2018-07-09 14:44:15"}}]
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
         * id : 2
         * teacher_course_class_id : 2
         * title : title1
         * desc : acdesc1
         * expire_date : 1396-12-01
         * file_address : url
         * atype_id : 1
         * created_at : 2018-07-09 14:43:44
         * updated_at : 2018-07-09 14:43:44
         * pivot : {"student_profile_id":3,"activity_id":2,"created_at":"2018-07-09 14:43:44","updated_at":"2018-07-09 14:43:44"}
         */

        @SerializedName("id")
        private int id;
        @SerializedName("teacher_course_class_id")
        private int teacherCourseClassId;
        @SerializedName("title")
        private String title;
        @SerializedName("desc")
        private String desc;
        @SerializedName("expire_date")
        private String expireDate;
        @SerializedName("file_address")
        private String fileAddress;
        @SerializedName("atype_id")
        private int atypeId;
        @SerializedName("created_at")
        private String createdAt;
        @SerializedName("updated_at")
        private String updatedAt;
        @SerializedName("pivot")
        private PivotBean pivot;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getTeacherCourseClassId() {
            return teacherCourseClassId;
        }

        public void setTeacherCourseClassId(int teacherCourseClassId) {
            this.teacherCourseClassId = teacherCourseClassId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getExpireDate() {
            return expireDate;
        }

        public void setExpireDate(String expireDate) {
            this.expireDate = expireDate;
        }

        public String getFileAddress() {
            return fileAddress;
        }

        public void setFileAddress(String fileAddress) {
            this.fileAddress = fileAddress;
        }

        public int getAtypeId() {
            return atypeId;
        }

        public void setAtypeId(int atypeId) {
            this.atypeId = atypeId;
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

        public PivotBean getPivot() {
            return pivot;
        }

        public void setPivot(PivotBean pivot) {
            this.pivot = pivot;
        }

        public static class PivotBean {
            /**
             * student_profile_id : 3
             * activity_id : 2
             * created_at : 2018-07-09 14:43:44
             * updated_at : 2018-07-09 14:43:44
             */

            @SerializedName("student_profile_id")
            private int studentProfileId;
            @SerializedName("activity_id")
            private int activityId;
            @SerializedName("created_at")
            private String createdAt;
            @SerializedName("updated_at")
            private String updatedAt;

            public int getStudentProfileId() {
                return studentProfileId;
            }

            public void setStudentProfileId(int studentProfileId) {
                this.studentProfileId = studentProfileId;
            }

            public int getActivityId() {
                return activityId;
            }

            public void setActivityId(int activityId) {
                this.activityId = activityId;
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

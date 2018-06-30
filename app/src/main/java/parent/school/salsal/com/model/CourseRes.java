package parent.school.salsal.com.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CourseRes {


    /**
     * msg : ok
     * data : [{"id":1,"title":"Chemistry","created_at":"2018-05-18 07:26:49","updated_at":"2018-05-18 07:26:49","pivot":{"teacher_profile_id":1,"course_id":1,"created_at":null,"updated_at":null}},{"id":2,"title":"Math","created_at":"2018-05-18 07:26:49","updated_at":"2018-05-18 07:26:49","pivot":{"teacher_profile_id":1,"course_id":2,"created_at":"2018-05-18 10:45:23","updated_at":"2018-05-18 10:45:23"}}]
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
         * title : Chemistry
         * created_at : 2018-05-18 07:26:49
         * updated_at : 2018-05-18 07:26:49
         * pivot : {"teacher_profile_id":1,"course_id":1,"created_at":null,"updated_at":null}
         */

        @SerializedName("id")
        private int id;
        @SerializedName("title")
        private String title;
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

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
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
             * teacher_profile_id : 1
             * course_id : 1
             * created_at : null
             * updated_at : null
             */

            @SerializedName("teacher_profile_id")
            private int teacherProfileId;
            @SerializedName("course_id")
            private int courseId;
            @SerializedName("created_at")
            private Object createdAt;
            @SerializedName("updated_at")
            private Object updatedAt;

            public int getTeacherProfileId() {
                return teacherProfileId;
            }

            public void setTeacherProfileId(int teacherProfileId) {
                this.teacherProfileId = teacherProfileId;
            }

            public int getCourseId() {
                return courseId;
            }

            public void setCourseId(int courseId) {
                this.courseId = courseId;
            }

            public Object getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(Object createdAt) {
                this.createdAt = createdAt;
            }

            public Object getUpdatedAt() {
                return updatedAt;
            }

            public void setUpdatedAt(Object updatedAt) {
                this.updatedAt = updatedAt;
            }
        }
    }
}

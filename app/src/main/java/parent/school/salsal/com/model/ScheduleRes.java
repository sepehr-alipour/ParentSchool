package parent.school.salsal.com.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ScheduleRes {

    /**
     * msg : ok
     * data : [{"id":1,"class_course_id":1,"day_of_week":0,"priority":1,"created_at":null,"updated_at":null,"course":{"id":1,"title":"Math","created_at":"2018-05-23 16:05:21","updated_at":"2018-05-23 16:05:21"},"classRoom":{"id":1,"title":"class_1","created_at":"2018-05-23 15:20:33","updated_at":"2018-05-23 15:20:33"}},{"id":2,"class_course_id":1,"day_of_week":0,"priority":2,"created_at":null,"updated_at":null,"course":{"id":1,"title":"Math","created_at":"2018-05-23 16:05:21","updated_at":"2018-05-23 16:05:21"},"classRoom":{"id":1,"title":"class_1","created_at":"2018-05-23 15:20:33","updated_at":"2018-05-23 15:20:33"}},{"id":3,"class_course_id":1,"day_of_week":1,"priority":1,"created_at":null,"updated_at":null,"course":{"id":1,"title":"Math","created_at":"2018-05-23 16:05:21","updated_at":"2018-05-23 16:05:21"},"classRoom":{"id":1,"title":"class_1","created_at":"2018-05-23 15:20:33","updated_at":"2018-05-23 15:20:33"}},{"id":4,"class_course_id":3,"day_of_week":1,"priority":2,"created_at":null,"updated_at":null,"course":{"id":1,"title":"Math","created_at":"2018-05-23 16:05:21","updated_at":"2018-05-23 16:05:21"},"classRoom":{"id":2,"title":"class_2","created_at":"2018-05-23 15:20:55","updated_at":"2018-05-23 15:20:55"}},{"id":5,"class_course_id":3,"day_of_week":2,"priority":1,"created_at":null,"updated_at":null,"course":{"id":1,"title":"Math","created_at":"2018-05-23 16:05:21","updated_at":"2018-05-23 16:05:21"},"classRoom":{"id":2,"title":"class_2","created_at":"2018-05-23 15:20:55","updated_at":"2018-05-23 15:20:55"}},{"id":6,"class_course_id":4,"day_of_week":2,"priority":2,"created_at":null,"updated_at":null,"course":{"id":3,"title":"Algebra","created_at":"2018-05-23 16:06:08","updated_at":"2018-05-23 16:06:08"},"classRoom":{"id":2,"title":"class_2","created_at":"2018-05-23 15:20:55","updated_at":"2018-05-23 15:20:55"}},{"id":7,"class_course_id":1,"day_of_week":3,"priority":1,"created_at":null,"updated_at":null,"course":{"id":1,"title":"Math","created_at":"2018-05-23 16:05:21","updated_at":"2018-05-23 16:05:21"},"classRoom":{"id":1,"title":"class_1","created_at":"2018-05-23 15:20:33","updated_at":"2018-05-23 15:20:33"}},{"id":8,"class_course_id":3,"day_of_week":2,"priority":2,"created_at":null,"updated_at":null,"course":{"id":1,"title":"Math","created_at":"2018-05-23 16:05:21","updated_at":"2018-05-23 16:05:21"},"classRoom":{"id":2,"title":"class_2","created_at":"2018-05-23 15:20:55","updated_at":"2018-05-23 15:20:55"}},{"id":9,"class_course_id":4,"day_of_week":3,"priority":3,"created_at":null,"updated_at":null,"course":{"id":3,"title":"Algebra","created_at":"2018-05-23 16:06:08","updated_at":"2018-05-23 16:06:08"},"classRoom":{"id":2,"title":"class_2","created_at":"2018-05-23 15:20:55","updated_at":"2018-05-23 15:20:55"}},{"id":10,"class_course_id":4,"day_of_week":4,"priority":1,"created_at":null,"updated_at":null,"course":{"id":3,"title":"Algebra","created_at":"2018-05-23 16:06:08","updated_at":"2018-05-23 16:06:08"},"classRoom":{"id":2,"title":"class_2","created_at":"2018-05-23 15:20:55","updated_at":"2018-05-23 15:20:55"}},{"id":11,"class_course_id":5,"day_of_week":4,"priority":2,"created_at":null,"updated_at":null,"course":{"id":1,"title":"Math","created_at":"2018-05-23 16:05:21","updated_at":"2018-05-23 16:05:21"},"classRoom":{"id":3,"title":"class_3","created_at":"2018-05-23 15:20:58","updated_at":"2018-05-23 15:20:58"}},{"id":12,"class_course_id":5,"day_of_week":5,"priority":1,"created_at":null,"updated_at":null,"course":{"id":1,"title":"Math","created_at":"2018-05-23 16:05:21","updated_at":"2018-05-23 16:05:21"},"classRoom":{"id":3,"title":"class_3","created_at":"2018-05-23 15:20:58","updated_at":"2018-05-23 15:20:58"}},{"id":13,"class_course_id":7,"day_of_week":5,"priority":2,"created_at":null,"updated_at":null,"course":{"id":3,"title":"Algebra","created_at":"2018-05-23 16:06:08","updated_at":"2018-05-23 16:06:08"},"classRoom":{"id":3,"title":"class_3","created_at":"2018-05-23 15:20:58","updated_at":"2018-05-23 15:20:58"}}]
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
         * class_course_id : 1
         * day_of_week : 0
         * priority : 1
         * created_at : null
         * updated_at : null
         * course : {"id":1,"title":"Math","created_at":"2018-05-23 16:05:21","updated_at":"2018-05-23 16:05:21"}
         * classRoom : {"id":1,"title":"class_1","created_at":"2018-05-23 15:20:33","updated_at":"2018-05-23 15:20:33"}
         */

        @SerializedName("id")
        private int id;
        @SerializedName("class_course_id")
        private int classCourseId;
        @SerializedName("day_of_week")
        private int dayOfWeek;
        @SerializedName("priority")
        private int priority;
        @SerializedName("created_at")
        private Object createdAt;
        @SerializedName("updated_at")
        private Object updatedAt;
        @SerializedName("course")
        private CourseBean course;
        @SerializedName("classRoom")
        private ClassRoomBean classRoom;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getClassCourseId() {
            return classCourseId;
        }

        public void setClassCourseId(int classCourseId) {
            this.classCourseId = classCourseId;
        }

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

        public CourseBean getCourse() {
            return course;
        }

        public void setCourse(CourseBean course) {
            this.course = course;
        }

        public ClassRoomBean getClassRoom() {
            return classRoom;
        }

        public void setClassRoom(ClassRoomBean classRoom) {
            this.classRoom = classRoom;
        }

        public static class CourseBean {
            /**
             * id : 1
             * title : Math
             * created_at : 2018-05-23 16:05:21
             * updated_at : 2018-05-23 16:05:21
             */

            @SerializedName("id")
            private int id;
            @SerializedName("title")
            private String title;
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
        }

        public static class ClassRoomBean {
            /**
             * id : 1
             * title : class_1
             * created_at : 2018-05-23 15:20:33
             * updated_at : 2018-05-23 15:20:33
             */

            @SerializedName("id")
            private int id;
            @SerializedName("title")
            private String title;
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
        }
    }
}

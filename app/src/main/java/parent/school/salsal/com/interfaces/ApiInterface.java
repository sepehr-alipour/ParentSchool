package parent.school.salsal.com.interfaces;

import com.google.gson.JsonObject;

import parent.school.salsal.com.model.AttendanceReq;
import parent.school.salsal.com.model.AttendanceRes;
import parent.school.salsal.com.model.LoginReq;
import parent.school.salsal.com.model.LoginRes;
import parent.school.salsal.com.model.NotificationDetailRes;
import parent.school.salsal.com.model.NotificationRes;
import parent.school.salsal.com.model.ParentProfileRes;
import parent.school.salsal.com.model.ScheduleRes;
import parent.school.salsal.com.model.SchoolListRes;
import parent.school.salsal.com.model.SendNotificationReq;
import parent.school.salsal.com.model.StudentActivityRes;
import parent.school.salsal.com.model.StudentLessonsRes;
import parent.school.salsal.com.model.StudentProfileRes;
import parent.school.salsal.com.model.StudentRes;
import parent.school.salsal.com.model.TeacherProfileRes;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


/**
 * Created by Sepehr on 1/25/2017.
 */

public interface ApiInterface {


    String URL_V1 = "/api/v1";

    @POST(URL_V1 + "/user/signin")
    Call<LoginRes> loginUser(@Body LoginReq req);

    @GET(URL_V1 + "/perentProfile/{id}")
    Call<ParentProfileRes> getParentProfile(@Path("id") String id, @Query("token") String token);

    @GET(URL_V1 + "/studentProfile/{id}")
    Call<StudentProfileRes> getStudentProfile(@Path("id") String id, @Query("token") String token);

    @GET(URL_V1 + "/teacherProfile/{id}")
    Call<TeacherProfileRes> getTeacherProfile(@Path("id") String id, @Query("token") String token);

    @GET(URL_V1 + "/schoolList/{query}")
    Call<SchoolListRes> getSchools(@Path("query") String query);


    @GET(URL_V1 + "/activity/student")
    Call<StudentActivityRes> getStudentActivities(@Query("token") String token, @Query("course_id") int courseid, @Query("class_id") int classid);

    @GET(URL_V1 + "/activity/student")
    Call<StudentActivityRes> sendActivity(@Query("token") String token, @Query("course_id") int courseid, @Query("class_id") int classid);

    @GET(URL_V1 + "/student/{id}")
    Call<StudentRes> getParentStudents(@Path("id") String parentId, @Query("token") String token);


    @POST(URL_V1 + "/attendance")
    Call<AttendanceRes> attendanceStudent(@Query("token") String token, @Body AttendanceReq attendanceReq);

    @GET(URL_V1 + "/teacherProfile/courses")
    Call<StudentLessonsRes> getTecherCourses(@Query("token") String token);

    @POST(URL_V1 + "/studentProfile")
    Call<JsonObject> updateProfile(@Query("user_id") String userId, @Query("token") String token, @Body StudentLessonsRes teacherProfileReq);

    @POST(URL_V1 + "/parentProfile")
    Call<JsonObject> updateParentProfile(@Query("user_id") String userId, @Query("token") String token, @Body StudentLessonsRes teacherProfileReq);

    @GET(URL_V1 + "/studentProfile/classes")
    Call<StudentRes> getStudentsClass(@Query("token") String token, @Query("class_id") int classid);

    @GET(URL_V1 + "/notification")
    Call<NotificationRes> getNotifications(@Query("token") String token);

    @GET(URL_V1 + "/notification/sentBox")
    Call<NotificationRes> getSentBoxNotifications(@Query("token") String token);

    @GET(URL_V1 + "/schedule")
    Call<ScheduleRes> getStudentSchedule(@Query("token") String token);

    @GET(URL_V1 + "/notification/{id}")
    Call<NotificationDetailRes> getNotificationDetails(@Path("id") int notification, @Query("token") String token);

    @POST(URL_V1 + "/notification")
    Call<NotificationDetailRes> sendNotification(@Query("token") String token, @Body SendNotificationReq sendNotificationReq);
}
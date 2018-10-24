package parent.school.salsal.com.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.orhanobut.hawk.Hawk;

import java.util.ArrayList;
import java.util.HashMap;

import io.reactivex.internal.operators.completable.CompletableOnErrorComplete;
import parent.school.salsal.com.model.LoginReq;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Taraabar on 12/28/2016.
 */
public class PreferenceManager {
    private static PreferenceManager ourInstance = new PreferenceManager();
    //public static final String BASE_URL = "http://192.168.2.119:80";
    // public static final String BASE_URL = "http://192.168.1.12:80";
    //public static final String BASE_URL = "http://192.168.43.114:80";
    public static final int PER_PAGE = 10;
    private static final String PRE_USER_PROFILE = "user_profile_parent";
    public static final String PREF_TOKEN = "token";
    public static final String PREF_SCHOOL_CONNECTION = "connections";
    public static final String PREF_USER_ID = "user_id";
    public static final String PREF_PARENT_ID = "parent_id";
    public static final String PREF_STUDENT_ID = "student_id";
    public static final String PREF_COURSE_ID = "course_id";
    public static final String PREF_ADMIN_ID = "admin_id";
    public static final String PREF_CLASS_ID = "class_id";

    public static PreferenceManager getInstance() {
        return ourInstance;
    }

    private PreferenceManager() {
    }

    public static void removeSchoolConnection(LoginReq schoolConnection) {
        ArrayList<LoginReq> schoolConnections = Hawk.get(PREF_SCHOOL_CONNECTION, new ArrayList<LoginReq>());
        for (int i = 0; i < schoolConnections.size(); i++) {
            if (schoolConnections.get(i).getId() == schoolConnection.getId()) {
                schoolConnections.remove(i);
                Hawk.put(PREF_SCHOOL_CONNECTION, schoolConnections);
                return;
            }
        }
    }

    public static void setCurentStudent(Context context, String id) {
        SharedPreferences.Editor editor = context.getSharedPreferences(PRE_USER_PROFILE, MODE_PRIVATE).edit();
        editor.putString(PREF_STUDENT_ID, id);
        editor.apply();
    }

    public static String getCurrentStudentId(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PRE_USER_PROFILE, MODE_PRIVATE);
        return prefs.getString(PREF_STUDENT_ID, null);
    }

    public static boolean addSchoolConnection(LoginReq schoolConnection) {

        ArrayList<LoginReq> schoolConnections = Hawk.get(PREF_SCHOOL_CONNECTION, new ArrayList<LoginReq>());
        for (LoginReq school : schoolConnections) {
            school.setChecked(false);
        }
        for (int i = 0; i < schoolConnections.size(); i++) {
            if (schoolConnections.get(i).getConnectionUrl().equalsIgnoreCase(schoolConnection.getConnectionUrl())) {
             /*   schoolConnections.remove(i);
                schoolConnections.add(i, schoolConnection);
                Hawk.put(PREF_SCHOOL_CONNECTION, schoolConnections);*/
                return false;
            }
        }
        schoolConnections.add(schoolConnection);
        Hawk.put(PREF_SCHOOL_CONNECTION, schoolConnections);
        return true;
    }

    public static String getUrl() {
        ArrayList<LoginReq> conncections = Hawk.get(PREF_SCHOOL_CONNECTION, new ArrayList<LoginReq>());
        for (LoginReq loginReq : conncections) {
            if (loginReq.isChecked())
                return loginReq.getConnectionUrl();
        }
        return null;
    }

    public static void updateSchoolConnection(LoginReq schoolConnection) {
        ArrayList<LoginReq> schoolConnections = Hawk.get(PREF_SCHOOL_CONNECTION, new ArrayList<LoginReq>());
        for (int i = 0; i < schoolConnections.size(); i++) {
            if (schoolConnections.get(i).getId() == schoolConnection.getId()) {
                schoolConnections.remove(i);
                schoolConnections.add(i, schoolConnection);
                Hawk.put(PREF_SCHOOL_CONNECTION, schoolConnections);
                return;
            }
        }
    }

    public static LoginReq getSchoolConnection(int id) {
        ArrayList<LoginReq> schoolConnections = Hawk.get(PREF_SCHOOL_CONNECTION, new ArrayList<LoginReq>());
        for (int i = 0; i < schoolConnections.size(); i++) {
            if (schoolConnections.get(i).getId() == id) {
                return schoolConnections.get(i);
            }
        }
        return null;
    }

    public static ArrayList<LoginReq> getSchoolConnections() {
        return Hawk.get(PREF_SCHOOL_CONNECTION, new ArrayList<LoginReq>());
    }

    public static void SaveUserProfile(Context context, String id, String parentId, String token) {
        SharedPreferences.Editor editor = context.getSharedPreferences(PRE_USER_PROFILE, MODE_PRIVATE).edit();
        editor.putString(PREF_TOKEN, token);
        editor.putString(PREF_USER_ID, id);
        editor.putString(PREF_PARENT_ID, parentId);
        editor.apply();
    }

    public static void saveTeacherCourse(Context context, int teacherCource) {
        SharedPreferences.Editor editor = context.getSharedPreferences(PRE_USER_PROFILE, MODE_PRIVATE).edit();
        editor.putInt(PREF_COURSE_ID, teacherCource);
        editor.apply();
    }

    public static void saveAdminId(Context context, int adminId) {
        SharedPreferences.Editor editor = context.getSharedPreferences(PRE_USER_PROFILE, MODE_PRIVATE).edit();
        editor.putInt(PREF_ADMIN_ID, adminId);
        editor.apply();

    }

    public static void saveTeacherClass(Context context, int teacherClass) {
        SharedPreferences.Editor editor = context.getSharedPreferences(PRE_USER_PROFILE, MODE_PRIVATE).edit();
        editor.putInt(PREF_CLASS_ID, teacherClass);
        editor.apply();
    }

    public static int getTeacherClassId(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PRE_USER_PROFILE, MODE_PRIVATE);
        return prefs.getInt(PREF_CLASS_ID, -1);
    }
    public static int getAdminId(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PRE_USER_PROFILE, MODE_PRIVATE);
        return prefs.getInt(PREF_ADMIN_ID, -1);
    }

    public static int getTeacherCourseId(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PRE_USER_PROFILE, MODE_PRIVATE);
        return prefs.getInt(PREF_COURSE_ID, -1);
    }


    public static HashMap<String, String> getUserProfile(Context context) {
        HashMap<String, String> profile = new HashMap<>();
        SharedPreferences prefs = context.getSharedPreferences(PRE_USER_PROFILE, MODE_PRIVATE);
        profile.put(PREF_USER_ID, prefs.getString(PREF_USER_ID, null));
        profile.put(PREF_PARENT_ID, prefs.getString(PREF_PARENT_ID, null));
        profile.put(PREF_TOKEN, prefs.getString(PREF_TOKEN, null));
        return profile;
    }

    public static void removeAllPrefrences(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(PRE_USER_PROFILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.commit();
    }


}

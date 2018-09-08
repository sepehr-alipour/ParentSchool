package parent.school.salsal.com.model;

import com.google.gson.annotations.SerializedName;

public class ActivityAnswerReq {

    @SerializedName("student_id")
    private String studentId;
    @SerializedName("description")
    private String description;
    @SerializedName("media_id")
    private String mediaId;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}

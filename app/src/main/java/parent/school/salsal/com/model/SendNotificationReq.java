package parent.school.salsal.com.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SendNotificationReq {

    /**
     * user_ids : [5,6,7]
     * title : new year
     * message : متن اعلان
     * type : 1
     * file_url : link
     * recipient_type : Parent
     */
    public final String RECIPIENT_TYPE_PARENT = "Parent";
    public final String RECIPIENT_TYPE_TEACHER = "Teacher";
    public final String RECIPIENT_TYPE_UNIT = "Unit";
    @SerializedName("title")
    private String title;
    @SerializedName("message")
    private String message;
    @SerializedName("type")
    private String type;
    @SerializedName("file_url")
    private String fileUrl;
    @SerializedName("recipient_type")
    private String recipientType;
    @SerializedName("user_ids")
    private List<Integer> userIds;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
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

    public List<Integer> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<Integer> userIds) {
        this.userIds = userIds;
    }
}

package parent.school.salsal.com.adapter;


import parent.school.salsal.com.model.CourseRes;
import parent.school.salsal.com.model.ReceiverMessageItem;
import parent.school.salsal.com.model.StudentRes;

public interface OnReceiverClickListener {

    void clicked(ReceiverMessageItem receiverMessageItem, int position);

//todo change to teacherRes
    void clicked(StudentRes.DataBean studentRes, int position);

    void clicked(CourseRes.DataBean courseRes, int position);
}

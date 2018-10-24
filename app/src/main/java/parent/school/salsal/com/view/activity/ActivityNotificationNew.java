package parent.school.salsal.com.view.activity;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import parent.school.salsal.com.R;
import parent.school.salsal.com.adapter.AdapterReceiverMessage;
import parent.school.salsal.com.adapter.OnReceiverClickListener;
import parent.school.salsal.com.interfaces.OnDataSelectListener;
import parent.school.salsal.com.model.CourseRes;
import parent.school.salsal.com.model.NotificationDetailRes;
import parent.school.salsal.com.model.ReceiverMessageItem;
import parent.school.salsal.com.model.SendNotificationReq;
import parent.school.salsal.com.model.StudentRes;
import parent.school.salsal.com.model.TeachersProfileRes;
import parent.school.salsal.com.util.PreferenceManager;
import parent.school.salsal.com.view.fragment.BottomSheetFragmentStudents;
import parent.school.salsal.com.webservice.APIErrorResult;
import parent.school.salsal.com.webservice.CallbackHandler;
import parent.school.salsal.com.webservice.WebServiceHelper;
import retrofit2.Response;

/**
 * Created by Sepehr on 12/4/2017.
 */

public class ActivityNotificationNew extends BaseActivity implements View.OnClickListener, OnReceiverClickListener, OnDataSelectListener {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.edtTitle)
    AppCompatEditText edtTitle;
    @BindView(R.id.edtMessage)
    AppCompatEditText edtMessage;
    @BindView(R.id.btnSendMessage)
    AppCompatButton btnSendMessage;
    @BindView(R.id.bottom_sheet)
    LinearLayout bottomSheet;
    @BindView(R.id.list)
    RecyclerView listSendto;
    private BottomSheetBehavior sheetBehaviorSendto;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_new);
        ButterKnife.bind(this);
        toolbar.setTitle("پیام جدید");

        sheetBehaviorSendto = BottomSheetBehavior.from(bottomSheet);
        btnSendMessage.setOnClickListener(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, layoutManager.getOrientation());
        listSendto.addItemDecoration(dividerItemDecoration);
        listSendto.setLayoutManager(layoutManager);

        List<ReceiverMessageItem> listItemSendto = new ArrayList<>();
        ReceiverMessageItem itemManagement = new ReceiverMessageItem("مدیر", ReceiverMessageItem.UNIT);
        ReceiverMessageItem itemParent = new ReceiverMessageItem("معلم  خاص", ReceiverMessageItem.PARENT);
        listItemSendto.add(itemManagement);
        listItemSendto.add(itemParent);

     /*  ArrayList<SpnType> notifTypes = new ArrayList<>();
        String[] testArray = getResources().getStringArray(R.array.notification_type);

        for (int i = 0; i < testArray.length; i++) {
            notifTypes.add(new SpnType(testArray[i].split("-")[0], testArray[i].split("-")[1]));
        }

        ArrayAdapter<SpnType> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, notifTypes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnType.setAdapter(adapter);*/

        listSendto.setAdapter(new AdapterReceiverMessage(listItemSendto, this));

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSendMessage:
                if (sheetBehaviorSendto.getState() != BottomSheetBehavior.STATE_EXPANDED) {
                    sheetBehaviorSendto.setState(BottomSheetBehavior.STATE_EXPANDED);
                } else {
                    sheetBehaviorSendto.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
                break;

        }

    }

    @Override
    public void onBackPressed() {
        if (sheetBehaviorSendto.getState() == BottomSheetBehavior.STATE_EXPANDED) {
            sheetBehaviorSendto.setState(BottomSheetBehavior.STATE_COLLAPSED);
        } else super.onBackPressed();
    }

    @Override
    public void clicked(ReceiverMessageItem receiverMessageItem, int pos) {
        switch (pos) {
            case 0:
                List<Integer> users = new ArrayList<>();
                users.add(PreferenceManager.getAdminId(this));
                SendNotificationReq sendNotificationReq = new SendNotificationReq();
                sendNotificationReq.setMessage(edtMessage.getText().toString());
                sendNotificationReq.setTitle(edtTitle.getText().toString());
                sendNotificationReq.setUserIds(users);
                sendNotificationReq.setType(1);//public notif
                sendNotificationReq.setFileUrl("http://google.com");
                sendNotificationReq.setRecipientType(sendNotificationReq.RECIPIENT_TYPE_UNIT);
                sendNotif(sendNotificationReq);

                break;
            case 1:
                BottomSheetFragmentStudents bottomSheetFragmentStudents = new BottomSheetFragmentStudents(BottomSheetFragmentStudents.TYEP_TEACHERS, true, this);
                bottomSheetFragmentStudents.show(getSupportFragmentManager(), "students");
                break;
           /* case 2:
                BottomSheetFragmentStudents bottomSheetFragmentClasses = new BottomSheetFragmentStudents(BottomSheetFragmentStudents.TYPE_COURSES, false, this);
                bottomSheetFragmentClasses.show(getSupportFragmentManager(), "classes");
                break;*/
        }
    }

    private void sendNotif(SendNotificationReq sendNotificationReq) {
        WebServiceHelper.get(this).sendNotification(PreferenceManager.getUserProfile(this).get(PreferenceManager.PREF_TOKEN), sendNotificationReq)
                .enqueue(new CallbackHandler<NotificationDetailRes>(this, true, true) {
                    @Override
                    public void onSuccess(Response<NotificationDetailRes> response) {

                        Toast.makeText(ActivityNotificationNew.this, "پیام شما با موفقیت ارسال شد", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onFailed(APIErrorResult errorResult) {

                    }
                });
    }


    @Override
    public void clicked(StudentRes.DataBean studentRes, int pos) {

    }

    @Override
    public void clicked(CourseRes.DataBean courseRes, int position) {

    }

    @Override
    public void dataSelected(Object data) {
        SendNotificationReq notificationReq = new SendNotificationReq();
        List<Integer> users = new ArrayList<>();
        users.add(((TeachersProfileRes.DataBean) data).getUserId());

        notificationReq.setUserIds(users);
        notificationReq.setFileUrl("link");
        notificationReq.setTitle(edtTitle.getText().toString());
        notificationReq.setMessage(edtMessage.getText().toString());
        notificationReq.setType(1);//public notif
        notificationReq.setRecipientType(notificationReq.RECIPIENT_TYPE_TEACHER);

        sendNotif(notificationReq);

    }
/*
    @Override
    public void dataSelected(Object data) {
        SendNotificationReq notificationReq = new SendNotificationReq();
        List<Integer> users = new ArrayList<>();
        if (data instanceof ArrayList) {
            for (int i = 0; i < ((List<StudentRes.DataBean>) data).size(); i++) {
                users.add(((List<StudentRes.DataBean>) data).get(i).getUserId());
            }

            notificationReq.setUserIds(users);
            notificationReq.setFileUrl("link");
            notificationReq.setTitle(edtTitle.getText().toString());
            notificationReq.setMessage(edtMessage.getText().toString());
            notificationReq.setType(((SpnType) (spnType.getSelectedItem())).getId());
            notificationReq.setRecipientType(notificationReq.RECIPIENT_TYPE_PARENT);

            sendNotif(notificationReq);
        } else {
            WebServiceHelper.get(this).getStudentsClass(PreferenceManager.getUserProfile(this).get(PreferenceManager.PREF_TOKEN), ((ClassRes.DataBean) data).getId())
                    .enqueue(new CallbackHandler<StudentRes>(this, true, true) {
                        @Override
                        public void onSuccess(Response<StudentRes> response) {
                            SendNotificationReq notificationReq = new SendNotificationReq();
                            List<Integer> users = new ArrayList<>();
                            for (int i = 0; i < response.body().getData().size(); i++) {
                                users.add(response.body().getData().get(i).getUserId());
                            }

                            notificationReq.setUserIds(users);
                            notificationReq.setFileUrl("link");
                            notificationReq.setTitle(edtTitle.getText().toString());
                            notificationReq.setMessage(edtMessage.getText().toString());
                            notificationReq.setType(((SpnType) (spnType.getSelectedItem())).getId());
                            notificationReq.setRecipientType(notificationReq.RECIPIENT_TYPE_PARENT);

                            sendNotif(notificationReq);
                        }

                        @Override
                        public void onFailed(APIErrorResult errorResult) {

                        }
                    });

        }

    }*/
}

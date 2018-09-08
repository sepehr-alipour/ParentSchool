package parent.school.salsal.com.view.activity;

import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import parent.school.salsal.com.R;
import parent.school.salsal.com.model.NotificationDetailRes;
import parent.school.salsal.com.model.SendNotificationReq;
import parent.school.salsal.com.util.PreferenceManager;
import parent.school.salsal.com.webservice.APIErrorResult;
import parent.school.salsal.com.webservice.CallbackHandler;
import parent.school.salsal.com.webservice.WebServiceHelper;
import retrofit2.Response;

public class ActivityNotifDetail extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.txtTitle)
    TextView txtTitle;
    @BindView(R.id.txtDate)
    TextView txtDate;
    @BindView(R.id.view)
    View view;
    @BindView(R.id.txtDesc)
    TextView txtDesc;
    @BindView(R.id.txtType)
    TextView txtType;
    @BindView(R.id.txtSender)
    TextView txtSender;
    @BindView(R.id.edtResponse)
    AppCompatEditText edtResponse;
    @BindView(R.id.btnSend)
    AppCompatButton btnSend;
    private int notifId;
    public static final String INTENT_NOTIF_ID = "notif_id";
    private NotificationDetailRes.DataBean notifDetail;
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notif_detail);
        ButterKnife.bind(this);
        notifId = getIntent().getIntExtra(INTENT_NOTIF_ID, 0);
        token = PreferenceManager.getUserProfile(this).get(PreferenceManager.PREF_TOKEN);
        btnSend.setOnClickListener(this);

        WebServiceHelper.get(this).getNotificationDetails(notifId, PreferenceManager.getUserProfile(this).get(PreferenceManager.PREF_TOKEN))
                .enqueue(new CallbackHandler<NotificationDetailRes>(this, true, true) {
                    @Override
                    public void onSuccess(Response<NotificationDetailRes> response) {
                        notifDetail = response.body().getData();

                        txtDate.setText(response.body().getData().getCreatedAt());
                        txtDesc.setText(response.body().getData().getMessage());
                        txtSender.setText(response.body().getData().getId() + "");
                        txtTitle.setText(response.body().getData().getTitle());
                        txtType.setText(response.body().getData().getType() + "");
                    }

                    @Override
                    public void onFailed(APIErrorResult errorResult) {

                    }
                });
    }

    @Override
    public void onClick(View v) {
        List<Integer> userId = new ArrayList<>();
        userId.add(notifDetail.getUserId());
        SendNotificationReq notificationReq = new SendNotificationReq();
        notificationReq.setMessage(edtResponse.getText().toString());
        notificationReq.setRecipientType(notifDetail.getRecipientType());
        notificationReq.setUserIds(userId);
        notificationReq.setFileUrl("link");
        notificationReq.setTitle(notifDetail.getTitle());
        notificationReq.setType(notifDetail.getType());
        WebServiceHelper.get(this).sendNotification(token, notificationReq).enqueue(new CallbackHandler<NotificationDetailRes>(this, true, true) {
            @Override
            public void onSuccess(Response<NotificationDetailRes> response) {
                Toast.makeText(ActivityNotifDetail.this, R.string.toast_success_notif, Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailed(APIErrorResult errorResult) {

            }
        });
    }
}

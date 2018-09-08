package parent.school.salsal.com.view.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.google.gson.JsonObject;

import junit.runner.BaseTestRunner;

import butterknife.BindView;
import butterknife.ButterKnife;
import ir.hamsaa.persiandatepicker.Listener;
import ir.hamsaa.persiandatepicker.PersianDatePickerDialog;
import ir.hamsaa.persiandatepicker.util.PersianCalendar;
import parent.school.salsal.com.R;
import parent.school.salsal.com.model.ParentProfileReq;
import parent.school.salsal.com.model.ParentProfileRes;
import parent.school.salsal.com.model.StudentProfileReq;
import parent.school.salsal.com.model.StudentProfileRes;
import parent.school.salsal.com.util.PreferenceManager;
import parent.school.salsal.com.webservice.APIErrorResult;
import parent.school.salsal.com.webservice.CallbackHandler;
import parent.school.salsal.com.webservice.WebServiceHelper;
import retrofit2.Response;

public class ActivityEditProfile extends BaseActivity implements View.OnClickListener, Listener {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.edtEducation)
    AppCompatEditText edtEducation;
    @BindView(R.id.edtBirthday)
    AppCompatEditText edtBirthday;
    @BindView(R.id.edtEmail)
    AppCompatEditText edtEmail;
    @BindView(R.id.edtPhone)
    AppCompatEditText edtPhone;
    @BindView(R.id.btnSend)
    AppCompatButton btnSend;
    @BindView(R.id.list)
    ScrollView list;
    @BindView(R.id.layoutEducation)
    LinearLayout layoutEducation;
    @BindView(R.id.layoutEmail)
    LinearLayout layoutEmail;
    @BindView(R.id.layoutPhone)
    LinearLayout layoutPhone;

    public static final String PARAMS_NAME_STUDENT = "view_type";
    public static final String PARAMS_NAME_ID = "id";
    public static final int TYPE_STUDENT = 0;
    public static final int TYPE_PARENT = 1;
    private int viewType;
    private String token;
    private String id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_edit);
        ButterKnife.bind(this);
        toolbar.setTitle("ویرایش مشخصات");
        btnSend.setOnClickListener(this);
        edtBirthday.setOnClickListener(this);
        viewType = getIntent().getIntExtra(PARAMS_NAME_STUDENT, -1);
        id = getIntent().getStringExtra(PARAMS_NAME_ID);
        initViews();

    }

    private void initViews() {
        token = PreferenceManager.getUserProfile(this).get(PreferenceManager.PREF_TOKEN);
        switch (viewType) {
            case TYPE_STUDENT:
                layoutEducation.setVisibility(View.GONE);
                layoutEmail.setVisibility(View.GONE);
                layoutPhone.setVisibility(View.GONE);
                WebServiceHelper.get(this).getStudentProfile(id, token)
                        .enqueue(new CallbackHandler<StudentProfileRes>(this, true, true) {
                            @Override
                            public void onSuccess(Response<StudentProfileRes> response) {
                                edtBirthday.setText(response.body().getData().getBirthDate());
                            }

                            @Override
                            public void onFailed(APIErrorResult errorResult) {

                            }
                        });
                break;
            case TYPE_PARENT:
                WebServiceHelper.get(this).getParentProfile(id, token)
                        .enqueue(new CallbackHandler<ParentProfileRes>(this, true, true) {
                            @Override
                            public void onSuccess(Response<ParentProfileRes> response) {
                                edtEducation.setText(response.body().getData().getEducation());
                                edtEmail.setText(response.body().getData().getEmail());
                                edtPhone.setText(response.body().getData().getPhoneNumber());
                                edtBirthday.setText(response.body().getData().getBirthDate());

                            }

                            @Override
                            public void onFailed(APIErrorResult errorResult) {

                            }
                        });
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSend:
                switch (viewType) {
                    case TYPE_PARENT:
                        ParentProfileReq parentProfileReq = new ParentProfileReq();
                        parentProfileReq.setBirthDate(edtBirthday.getText().toString());
                        parentProfileReq.setEducation(edtEducation.getText().toString());
                        parentProfileReq.setEmail(edtEmail.getText().toString());
                        parentProfileReq.setPhoneNumber(edtPhone.getText().toString());
                        WebServiceHelper.get(this).updateParentProfile(PreferenceManager.getUserProfile(this).get(PreferenceManager.PREF_PARENT_ID), token, parentProfileReq)
                                .enqueue(new CallbackHandler<JsonObject>(this, true, true) {
                                    @Override
                                    public void onSuccess(Response<JsonObject> response) {
                                        Toast.makeText(ActivityEditProfile.this, R.string.toast_success_update, Toast.LENGTH_SHORT).show();
                                        finish();
                                    }

                                    @Override
                                    public void onFailed(APIErrorResult errorResult) {

                                    }
                                });
                        break;
                    case TYPE_STUDENT:
                        StudentProfileReq studentProfileReq = new StudentProfileReq();
                        studentProfileReq.setBirthDate(edtBirthday.getText().toString());
                        WebServiceHelper.get(this).updateStudentProfile(id, token, studentProfileReq)
                                .enqueue(new CallbackHandler<JsonObject>(this, true, true) {
                                    @Override
                                    public void onSuccess(Response<JsonObject> response) {
                                        Toast.makeText(ActivityEditProfile.this, R.string.toast_success_update, Toast.LENGTH_SHORT).show();
                                        finish();
                                    }

                                    @Override
                                    public void onFailed(APIErrorResult errorResult) {

                                    }
                                });
                        break;
                }
                break;
            case R.id.edtBirthday:
                new PersianDatePickerDialog(this)
                        .setPositiveButtonString("تایید")
                        .setNegativeButton("انصراف")
                        .setActionTextColor(getResources().getColor(R.color.colorAccent))
                        .setTodayButtonVisible(false)
                        .setMaxYear(PersianDatePickerDialog.THIS_YEAR)
                        .setMinYear(1300)
                        .setActionTextColor(Color.GRAY)
                        .setListener(this).show();
                break;
        }
    }

    @Override
    public void onDateSelected(PersianCalendar persianCalendar) {
        edtBirthday.setText(persianCalendar.getPersianShortDate());
    }

    @Override
    public void onDismissed() {

    }
}

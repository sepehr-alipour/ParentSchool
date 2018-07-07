package parent.school.salsal.com.view.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ScrollView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ir.hamsaa.persiandatepicker.Listener;
import ir.hamsaa.persiandatepicker.PersianDatePickerDialog;
import ir.hamsaa.persiandatepicker.util.PersianCalendar;
import parent.school.salsal.com.R;

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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_edit);
        ButterKnife.bind(this);
        toolbar.setTitle("ویرایش مشخصات");
        btnSend.setOnClickListener(this);
        edtBirthday.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSend:

                break;
            case R.id.edtBirthday: new PersianDatePickerDialog(this)
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

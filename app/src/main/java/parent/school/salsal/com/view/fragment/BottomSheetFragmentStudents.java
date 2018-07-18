package parent.school.salsal.com.view.fragment;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import parent.school.salsal.com.R;
import parent.school.salsal.com.adapter.AdapterTeachers;
import parent.school.salsal.com.adapter.OnReceiverClickListener;
import parent.school.salsal.com.interfaces.OnDataSelectListener;
import parent.school.salsal.com.model.CourseRes;
import parent.school.salsal.com.model.ReceiverMessageItem;
import parent.school.salsal.com.model.StudentRes;
import parent.school.salsal.com.model.TeachersProfileRes;
import parent.school.salsal.com.util.PreferenceManager;
import parent.school.salsal.com.webservice.APIErrorResult;
import parent.school.salsal.com.webservice.CallbackHandler;
import parent.school.salsal.com.webservice.WebServiceHelper;
import retrofit2.Response;

@SuppressLint("ValidFragment")
public class BottomSheetFragmentStudents extends BottomSheetDialogFragment implements OnReceiverClickListener, View.OnClickListener, OnDataSelectListener {


    private OnDataSelectListener selectDataListener;
    @BindView(R.id.list)
    RecyclerView list;
    Unbinder unbinder;
    private final boolean hasCast;
    public static final int TYEP_TEACHERS = 0;
    public static final int TYPE_CLASSES = 1;
    public static final int TYPE_COURSES = 2;
    @BindView(R.id.btnSendMessage)
    AppCompatButton btnSendMessage;
    private int type = -1;

    ArrayList<StudentRes.DataBean> studentList = new ArrayList<>();

    public BottomSheetFragmentStudents(int type, boolean hasCat) {
        this.type = type;
        this.hasCast = hasCat;
    }

    public BottomSheetFragmentStudents(int type, boolean hasCat, OnDataSelectListener dataSelectListener) {
        this.selectDataListener = dataSelectListener;
        this.type = type;
        this.hasCast = hasCat;
    }

    @Nullable

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dialog_sheet_students, container, false);
        unbinder = ButterKnife.bind(this, view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), layoutManager.getOrientation());
        list.addItemDecoration(dividerItemDecoration);
        list.setLayoutManager(layoutManager);
        btnSendMessage.setOnClickListener(this);
        switch (type) {
            case TYEP_TEACHERS:
                getTeacherList();
                getDialog().setOnShowListener(new DialogInterface.OnShowListener() {
                    @Override
                    public void onShow(DialogInterface dialogInterface) {
                        BottomSheetDialog d = (BottomSheetDialog) dialogInterface;
                        View bottomSheetInternal = d.findViewById(android.support.design.R.id.design_bottom_sheet);
                        BottomSheetBehavior.from(bottomSheetInternal).setState(BottomSheetBehavior.STATE_EXPANDED);
                    }
                });
                break;
            case TYPE_COURSES:
                getCourseList();
        }
        return view;
    }

    private void getCourseList() {


    }

    private void getTeacherList() {
        WebServiceHelper.get(getContext()).getTeachers(PreferenceManager.getCurrentStudentId(getContext()),
                PreferenceManager.getUserProfile(getContext()).get(PreferenceManager.PREF_TOKEN)).enqueue(new CallbackHandler<TeachersProfileRes>(getContext(), true, true) {
            @Override
            public void onSuccess(Response<TeachersProfileRes> response) {
                AdapterTeachers adapterSchoolList = new AdapterTeachers(response.body().getData(), BottomSheetFragmentStudents.this);
                list.setLayoutManager(new LinearLayoutManager(getContext()));
                list.setAdapter(adapterSchoolList);
            }

            @Override
            public void onFailed(APIErrorResult errorResult) {

            }
        });

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void clicked(ReceiverMessageItem receiverMessageItem, int pos) {

    }


    @Override
    public void clicked(StudentRes.DataBean studentRes, int pos) {
        if (studentList.contains(studentRes))
            studentList.remove(studentRes);
        else
            studentList.add(studentRes);
    }

    @Override
    public void clicked(CourseRes.DataBean courseRes, int position) {
        PreferenceManager.saveTeacherCourse(getContext(), courseRes.getId());
        BottomSheetFragmentStudents bottomSheetFragmentClasses = new BottomSheetFragmentStudents(BottomSheetFragmentStudents.TYPE_CLASSES, hasCast, selectDataListener);
        bottomSheetFragmentClasses.show(getChildFragmentManager(), "classes");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSendMessage:
                selectDataListener.dataSelected(studentList);

                break;
        }
    }

    @Override
    public void dataSelected(Object data) {
        selectDataListener.dataSelected(data);

    }
}

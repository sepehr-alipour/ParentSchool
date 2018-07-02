package parent.school.salsal.com.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import parent.school.salsal.com.R;
import parent.school.salsal.com.adapter.AdapterNotif;
import parent.school.salsal.com.interfaces.OnNotifClickListener;
import parent.school.salsal.com.model.NotificationRes;
import parent.school.salsal.com.util.PreferenceManager;
import parent.school.salsal.com.view.activity.ActivityNotifDetail;
import parent.school.salsal.com.view.activity.ActivityNotificationNew;
import parent.school.salsal.com.webservice.APIErrorResult;
import parent.school.salsal.com.webservice.CallbackHandler;
import parent.school.salsal.com.webservice.WebServiceHelper;
import retrofit2.Response;

public class FragmentNotifications extends BaseFragment implements OnNotifClickListener, View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.notifList)
    RecyclerView notifList;
    Unbinder unbinder;
    @BindView(R.id.fabAddNotif)
    FloatingActionButton fabAddNotif;
    @BindView(R.id.receivedMessageTab)
    Button receivedMessageTab;
    @BindView(R.id.sentMessageTab)
    Button sentMessageTab;
    @BindView(R.id.tabLayout)
    LinearLayout tabLayout;


    public FragmentNotifications() {
        // Required empty public constructor
    }

    public static FragmentNotifications newInstance() {
        FragmentNotifications fragment = new FragmentNotifications();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notifications, container, false);
        unbinder = ButterKnife.bind(this, view);
        fabAddNotif.setOnClickListener(this);
        receivedMessageTab.setOnClickListener(this);
        sentMessageTab.setOnClickListener(this);
        setStyle(0);
        notifList.setLayoutManager(new LinearLayoutManager(getContext()));
        notifList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0)
                    fabAddNotif.hide();
                else if (dy < 0)
                    fabAddNotif.show();
            }
        });


        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void clicked(NotificationRes.DataBean notification) {
        if ((notification.getUserId() + "").equalsIgnoreCase(PreferenceManager.getUserProfile(getContext()).get(PreferenceManager.PREF_ID))) {
            return;
        }
        Intent intent = new Intent(getContext(), ActivityNotifDetail.class);
        intent.putExtra(ActivityNotifDetail.INTENT_NOTIF_ID, notification.getId());
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {


            case R.id.fabAddNotif:

                startActivity(new Intent(getContext(), ActivityNotificationNew.class));
                break;
            case R.id.receivedMessageTab:
                setStyle(0);
                break;
            case R.id.sentMessageTab:
                setStyle(1);
                break;
        }
    }

    private ArrayList<NotificationRes.DataBean> getNotifs() {
        ArrayList<NotificationRes.DataBean> notifs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            NotificationRes.DataBean notifData = new NotificationRes.DataBean();
            notifData.setMessage("پیام" + i);
            notifData.setTitle("عنوان" + i);
            notifData.setType(1);
            notifData.setCreatedAt("12/02/1397");
            notifData.setId(i);
            notifs.add(notifData);
        }
        return notifs;
    }

    private void setStyle(int pos) {
        if (pos == 0) {
            receivedMessageTab.setBackgroundResource(R.drawable.shape_pink_fill);
            receivedMessageTab.setTextColor(getResources().getColor(android.R.color.white));
            sentMessageTab.setBackgroundResource(R.drawable.shape_pink_blank);
            sentMessageTab.setTextColor(getResources().getColor(R.color.colorPrimary));
            notifList.setAdapter(new AdapterNotif(getNotifs(), FragmentNotifications.this));

         /*   WebServiceHelper.get(getContext()).getNotifications(PreferenceManager.getUserProfile(getContext()).get(PreferenceManager.PREF_TOKEN))
                    .enqueue(new CallbackHandler<NotificationRes>(getContext(), true, true) {
                        @Override
                        public void onSuccess(Response<NotificationRes> response) {
                            notifList.setAdapter(new AdapterNotif(response.body().getData(), FragmentNotifications.this));
                        }

                        @Override
                        public void onFailed(APIErrorResult errorResult) {

                        }
                    });*/
        } else {
            sentMessageTab.setBackgroundResource(R.drawable.shape_pink_fill);
            sentMessageTab.setTextColor(getResources().getColor(android.R.color.white));
            receivedMessageTab.setBackgroundResource(R.drawable.shape_pink_blank);
            receivedMessageTab.setTextColor(getResources().getColor(R.color.colorPrimary));

            notifList.setAdapter(new AdapterNotif(getNotifs(), FragmentNotifications.this));
           /* WebServiceHelper.get(getContext()).getSentBoxNotifications(PreferenceManager.getUserProfile(getContext()).get(PreferenceManager.PREF_TOKEN))
                    .enqueue(new CallbackHandler<NotificationRes>(getContext(), true, true) {
                        @Override
                        public void onSuccess(Response<NotificationRes> response) {
                            notifList.setAdapter(new AdapterNotif(response.body().getData(), FragmentNotifications.this));
                        }

                        @Override
                        public void onFailed(APIErrorResult errorResult) {

                        }
                    });*/
        }
    }
}

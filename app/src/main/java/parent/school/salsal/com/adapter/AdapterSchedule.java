package parent.school.salsal.com.adapter;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import butterknife.BindView;
import butterknife.ButterKnife;
import parent.school.salsal.com.R;
import parent.school.salsal.com.model.ScheduleRes;

public class AdapterSchedule extends RecyclerView.Adapter<AdapterSchedule.ViewHolder> {

    private final List<ScheduleRes.DataBean> listSchedule;


    public AdapterSchedule(List<ScheduleRes.DataBean> schedules) {
        listSchedule = schedules;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_schedule, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ScheduleRes.DataBean itemList = listSchedule.get(position);
        holder.txtClass.setText(itemList.getName());
        //todo get course name
        holder.txtCourse.setText(itemList.getTitle());
        holder.txtPriority.setText(holder.txtClass.getContext().getResources().getString(R.string.priority, itemList.getPriority()));
        Calendar cal = Calendar.getInstance(Locale.ENGLISH);
        cal.setTimeInMillis(itemList.getStartTime());
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm",Locale.getDefault());
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        String startTime = dateFormat.format(itemList.getStartTime()*1000L);
        String endTime = dateFormat.format(itemList.getEndTime()*1000L);


        holder.txtTime.setText(holder.txtTime.getContext().getResources().getString(R.string.text_time_schedule, startTime, endTime));
        if (position > 0 && itemList.getDayOfWeek() == listSchedule.get(position - 1).getDayOfWeek()) {
            holder.txtDay.setVisibility(View.GONE);
        } else {
            switch (itemList.getDayOfWeek()) {
                case 0:
                    holder.txtDay.setText("????????");
                    break;
                case 1:
                    holder.txtDay.setText("????????????");
                    break;
                case 2:
                    holder.txtDay.setText("????????????");
                    break;
                case 3:
                    holder.txtDay.setText("???? ????????");
                    break;
                case 4:
                    holder.txtDay.setText("????????????????");
                    break;
                case 5:
                    holder.txtDay.setText("?????? ????????");
                    break;
            }
            holder.txtDay.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return listSchedule.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder

    {
        @BindView(R.id.txtDay)
        TextView txtDay;
        @BindView(R.id.txtPriority)
        TextView txtPriority;
        @BindView(R.id.txtClass)
        TextView txtClass;
        @BindView(R.id.txtCourse)
        TextView txtCourse;
        @BindView(R.id.txt_time)
        TextView txtTime;


        public ViewHolder(View itemView) {

            super(itemView);
            ButterKnife.bind(this, itemView);

        }

    }
}

package parent.school.salsal.com.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;

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
        holder.txtClass.setText("کلاس");//itemList.getClassRoom().getTitle());
        holder.txtCourse.setText("درس");//itemList.getCourse().getTitle());
        holder.txtPriority.setText(holder.txtClass.getContext().getResources().getString(R.string.priority, itemList.getPriority()));
        if (position > 0 && itemList.getDayOfWeek() == listSchedule.get(position - 1).getDayOfWeek()) {
            holder.txtDay.setVisibility(View.GONE);
        } else {
            switch (itemList.getDayOfWeek()) {
                case 0:
                    holder.txtDay.setText("شنبه");
                    break;
                case 1:
                    holder.txtDay.setText("یکشنبه");
                    break;
                case 2:
                    holder.txtDay.setText("دوشنبه");
                    break;
                case 3:
                    holder.txtDay.setText("سه شنبه");
                    break;
                case 4:
                    holder.txtDay.setText("چهارشنبه");
                    break;
                case 5:
                    holder.txtDay.setText("پنج شنبه");
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


        public ViewHolder(View itemView) {

            super(itemView);
            ButterKnife.bind(this, itemView);

        }

    }
}

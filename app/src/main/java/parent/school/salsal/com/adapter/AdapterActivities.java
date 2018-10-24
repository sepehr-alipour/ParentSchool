package parent.school.salsal.com.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import parent.school.salsal.com.R;
import parent.school.salsal.com.interfaces.OnDataSelectListener;
import parent.school.salsal.com.model.ActivityRes;
import parent.school.salsal.com.util.Utils;

public class AdapterActivities extends RecyclerView.Adapter<AdapterActivities.ViewHolder> {

    private final List<ActivityRes.DataBean> listActivity;
    private OnDataSelectListener viewClickListener;

    public AdapterActivities(List<ActivityRes.DataBean> activities, OnDataSelectListener listener) {
        listActivity = activities;
        viewClickListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_activities, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final ActivityRes.DataBean itemList = listActivity.get(position);
        holder.txtDate.setText(Utils.convertBirthdayToString(itemList.getCreatedAt()));
        holder.txtDesc.setText(itemList.getDesc());
        //todo change to timestamp in server and app
        holder.txtExpireDate.setText(Utils.convertBirthdayToString(itemList.getExpireDate()));
        holder.txtTitle.setText(itemList.getTitle());
        String[] activityType = holder.txtDate.getContext().getResources().getStringArray(R.array.activity_type);
        switch (itemList.getAtypeId()) {
            case 1:

                holder.txtType.setText(activityType[0]);
                holder.txtType.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_action_student, 0);
                break;
            case 2:
                holder.txtType.setText(activityType[1]);
                holder.txtType.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_action_parent, 0);
                break;
            case 3:
                holder.txtType.setText(activityType[2]);
                holder.txtType.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_action_home, 0);
                break;
            case 4:
                holder.txtType.setText(activityType[3]);
                holder.txtType.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_action_quiz, 0);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return listActivity.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener

    {
        @BindView(R.id.txtDate)
        TextView txtDate;

        @BindView(R.id.txtDesc)
        TextView txtDesc;

        @BindView(R.id.txtExpireDate)
        TextView txtExpireDate;

        @BindView(R.id.txtTitle)
        TextView txtTitle;

        @BindView(R.id.txtType)
        TextView txtType;


        public ViewHolder(View itemView) {

            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            viewClickListener.dataSelected(listActivity.get(getAdapterPosition()));


        }
    }
}

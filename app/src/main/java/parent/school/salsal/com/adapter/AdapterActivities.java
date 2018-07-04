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
import parent.school.salsal.com.interfaces.OnDataSelectListener;
import parent.school.salsal.com.model.ActivityRes;

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
        holder.txtDate.setText(itemList.getCreatedAt());
        holder.txtDesc.setText(itemList.getDesc());
        holder.txtExpireDate.setText(itemList.getExpireDate() + "");
        holder.txtTitle.setText(itemList.getTitle());
        holder.txtType.setText(itemList.getAtypeId() + "");
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

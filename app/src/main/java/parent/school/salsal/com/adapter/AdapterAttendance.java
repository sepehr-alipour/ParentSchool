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
import parent.school.salsal.com.model.AttendanceRes;
import parent.school.salsal.com.model.CourseRes;
import parent.school.salsal.com.util.Utils;

public class AdapterAttendance extends RecyclerView.Adapter<AdapterAttendance.ViewHolder> {
    private final List<AttendanceRes.DataBean> listCource;
    private OnDataSelectListener notifClickListener;

    public AdapterAttendance(List<AttendanceRes.DataBean> notifs, OnDataSelectListener listener) {
        listCource = notifs;
        notifClickListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_attendance, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final AttendanceRes.DataBean itemList = listCource.get(position);
        holder.txtDate.setText(itemList.getCreatedAt());//Utils.convertBirthdayToString(itemList.getCreatedAt()));
        holder.txtDesc.setText(itemList.getStatus() == 1 ? "حاضر" : "غایب");
        holder.txtReason.setText(itemList.getStatus() == 0 ? "0 دقیقه" : "0 دقیقه");
        holder.txtTitle.setText(itemList.getTitle() + "(" + itemList.getName() + ")");
    }

    @Override
    public int getItemCount() {
        return listCource.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener

    {
        @BindView(R.id.txtTitle)
        TextView txtTitle;
        @BindView(R.id.txtDate)
        TextView txtDate;
        @BindView(R.id.txtReason)
        TextView txtReason;
        @BindView(R.id.txtDesc)
        TextView txtDesc;

        public ViewHolder(View itemView) {

            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            notifClickListener.dataSelected(listCource.get(getAdapterPosition()));

        }
    }
}

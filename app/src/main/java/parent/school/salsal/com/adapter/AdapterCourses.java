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
import parent.school.salsal.com.model.CourseRes;

public class AdapterCourses extends RecyclerView.Adapter<AdapterCourses.ViewHolder> {
    private final List<CourseRes.DataBean> listCource;
    private OnDataSelectListener notifClickListener;

    public AdapterCourses(List<CourseRes.DataBean> notifs, OnDataSelectListener listener) {
        listCource = notifs;
        notifClickListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_course, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final CourseRes.DataBean itemList = listCource.get(position);
        holder.txtDate.setText(itemList.getCreatedAt());
    }

    @Override
    public int getItemCount() {
        return listCource.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener

    {
        @BindView(R.id.txtTitle)
        TextView txtDate;


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

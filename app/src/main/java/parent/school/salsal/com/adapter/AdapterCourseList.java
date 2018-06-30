package parent.school.salsal.com.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import parent.school.salsal.com.R;
import parent.school.salsal.com.model.CourseRes;

public class AdapterCourseList extends RecyclerView.Adapter<AdapterCourseList.ViewHolder> {
    private final OnReceiverClickListener clickListener;
    List<CourseRes.DataBean> courseItem;
    @BindView(R.id.rootItemw)
    LinearLayout rootItemw;
    private SparseBooleanArray itemStateArray = new SparseBooleanArray();

    public AdapterCourseList(List<CourseRes.DataBean> courseItem, OnReceiverClickListener listener) {
        this.courseItem = courseItem;
        this.clickListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_reveiver_message, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final CourseRes.DataBean messageItem = courseItem.get(position);
        holder.txtTitle.setText(messageItem.getTitle());
        holder.imgIcon.setImageResource(R.drawable.ic_action_course);

    }


    @Override
    public int getItemCount() {
        return courseItem.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener

    {

        @BindView(R.id.txtTitle)
        TextView txtTitle;

        @BindView(R.id.rootItemw)
        LinearLayout rootView;

        @BindView(R.id.imgIcon)
        ImageView imgIcon;


        public ViewHolder(View itemView) {

            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);

        }


        @Override
        public void onClick(View view) {

            clickListener.clicked(courseItem.get(getAdapterPosition()), getAdapterPosition());
        }

    }
}

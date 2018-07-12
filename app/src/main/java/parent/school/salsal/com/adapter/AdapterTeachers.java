package parent.school.salsal.com.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import parent.school.salsal.com.R;
import parent.school.salsal.com.interfaces.OnDataSelectListener;
import parent.school.salsal.com.model.SchoolListRes;
import parent.school.salsal.com.model.TeacherProfileRes;

public class AdapterTeachers extends RecyclerView.Adapter<AdapterTeachers.ViewHolder> {

    private final ArrayList<TeacherProfileRes> listSchool;
    private OnDataSelectListener viewClickListener;

    public AdapterTeachers(ArrayList<TeacherProfileRes> schools, OnDataSelectListener listener) {
        listSchool = schools;
        viewClickListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_school, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        TeacherProfileRes itemList = listSchool.get(position);
        holder.txtName.setText(itemList.getName());
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.ic_action_profile);
        Glide.with(holder.imgLogo.getContext())
                .setDefaultRequestOptions(requestOptions)
                .load(itemList.getImageUrl())
                .into(holder.imgLogo);

    }

    @Override
    public int getItemCount() {
        return listSchool.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener

    {
        @BindView(R.id.txtName)
        TextView txtName;

        @BindView(R.id.imgLogo)
        ImageView imgLogo;


        public ViewHolder(View itemView) {

            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            viewClickListener.dataSelected(listSchool.get(getAdapterPosition()));


        }
    }
}

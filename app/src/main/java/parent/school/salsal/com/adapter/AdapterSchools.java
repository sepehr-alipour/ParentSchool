package parent.school.salsal.com.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import parent.school.salsal.com.R;
import parent.school.salsal.com.interfaces.OnDataSelectListener;
import parent.school.salsal.com.model.LoginReq;
import parent.school.salsal.com.model.SchoolListRes;

public class AdapterSchools extends RecyclerView.Adapter<AdapterSchools.ViewHolder> {

    private final ArrayList<LoginReq> listSchool;
    private OnDataSelectListener viewClickListener;

    public AdapterSchools(ArrayList<LoginReq> schools, OnDataSelectListener listener) {
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

        LoginReq itemList = listSchool.get(position);
        holder.txtName.setText(itemList.getSchoolName());
        if (itemList.isChecked())
            holder.imgChecked.setVisibility(View.VISIBLE);
        else holder.imgChecked.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return listSchool.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener

    {
        @BindView(R.id.txtName)
        TextView txtName;

        @BindView(R.id.imgChecked)
        ImageView imgChecked;


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

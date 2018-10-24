package parent.school.salsal.com.adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import parent.school.salsal.com.R;
import parent.school.salsal.com.model.SchoolListRes;

public class AdapterSpinnerSchool extends ArrayAdapter<SchoolListRes> {
    private final ArrayList<SchoolListRes> items, tempSchool, suggestions;

    public AdapterSpinnerSchool(@NonNull Context context, ArrayList<SchoolListRes> schoolItems) {
        super(context, R.layout.list_item_school, schoolItems);
        items = schoolItems;
        this.tempSchool = new ArrayList<SchoolListRes>(schoolItems);
        this.suggestions = new ArrayList<SchoolListRes>(schoolItems);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        SchoolListRes item = items.get(position);
        if (convertView == null)

        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_school, parent, false);
        }
        TextView txtTitle = convertView.findViewById(R.id.txtName);
        ImageView imgLogo = convertView.findViewById(R.id.imgLogo);
        txtTitle.setText(item.getName());
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.ic_action_profile);
        Glide.with(imgLogo.getContext())
                .setDefaultRequestOptions(requestOptions)
                .load(item.getLogo())
                .into(imgLogo);
        return convertView;

    }

    public SchoolListRes getItem(int position) {
        return items.get(position);
    }

    @Override
    public Filter getFilter() {
        return myFilter;
    }

    Filter myFilter = new Filter() {
        @Override
        public CharSequence convertResultToString(Object resultValue) {
            SchoolListRes customer = (SchoolListRes) resultValue;
            return customer.getName();
        }

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            if (constraint != null) {
                suggestions.clear();
                for (SchoolListRes people : tempSchool) {
                    if (people.getName().contains(constraint.toString().toLowerCase())) {
                        suggestions.add(people);
                    }
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = suggestions;
                filterResults.count = suggestions.size();
                return filterResults;
            } else {
                return new FilterResults();
            }
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            ArrayList<SchoolListRes> c = (ArrayList<SchoolListRes>) results.values;
            if (results != null && results.count > 0) {
                clear();
                for (SchoolListRes cust : c) {
                    add(cust);
                    notifyDataSetChanged();
                }
            }
        }
    };
}

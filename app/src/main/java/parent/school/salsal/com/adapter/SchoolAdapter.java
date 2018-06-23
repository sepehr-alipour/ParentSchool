package parent.school.salsal.com.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.BitSet;

import parent.school.salsal.com.R;
import parent.school.salsal.com.model.SchoolListRes;

public class SchoolAdapter extends ArrayAdapter<SchoolListRes> {
    private final ArrayList<SchoolListRes> items, tempSchool, suggestions;

    public SchoolAdapter(@NonNull Context context, ArrayList<SchoolListRes> schoolItems) {
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
        TextView txtTitle = convertView.findViewById(R.id.txtTitle);
        ImageView imgLogo = convertView.findViewById(R.id.imgLogo);
        txtTitle.setText(item.getName());
        imgLogo.setImageResource(item.getLogo());
        return convertView;

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

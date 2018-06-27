package parent.school.salsal.com.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.PixelCopy;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import parent.school.salsal.com.R;
import parent.school.salsal.com.model.StudentRes;

public class ChildrenAdapter extends ArrayAdapter<StudentRes> {
    private Context ctx;
    private ArrayList<StudentRes> contentArray;

    public ChildrenAdapter(Context context, ArrayList<StudentRes> objects) {
        super(context, R.layout.list_item_school, R.id.txtTitle, objects);
        this.ctx = context;
        this.contentArray = objects;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    public View getCustomView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.list_item_school, parent, false);

        TextView textView = (TextView) row.findViewById(R.id.txtTitle);
        textView.setText(contentArray.get(position).getName());

        ImageView imageView = (ImageView) row.findViewById(R.id.imgLogo);
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.ic_action_profile);
        Glide.with(ctx)
                .setDefaultRequestOptions(requestOptions)
                .load(contentArray.get(position).getAvatar())
                .into(imageView);

        return row;
    }
}

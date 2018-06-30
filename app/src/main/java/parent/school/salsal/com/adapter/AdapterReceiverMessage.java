package parent.school.salsal.com.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import parent.school.salsal.com.R;
import parent.school.salsal.com.model.ReceiverMessageItem;

public class AdapterReceiverMessage extends RecyclerView.Adapter<AdapterReceiverMessage.ViewHolder> {
    private final OnReceiverClickListener clickListener;
    List<ReceiverMessageItem> messageItems;
    @BindView(R.id.rootItemw)
    LinearLayout rootItemw;

    public AdapterReceiverMessage(List<ReceiverMessageItem> messageItems, OnReceiverClickListener listener) {
        this.messageItems = messageItems;
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
        final ReceiverMessageItem messageItem = messageItems.get(position);
        holder.txtTitle.setText(messageItem.getName());
    }


    @Override
    public int getItemCount() {
        return messageItems.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener

    {

        @BindView(R.id.txtTitle)
        TextView txtTitle;

        @BindView(R.id.rootItemw)
        LinearLayout rootView;


        public ViewHolder(View itemView) {

            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            clickListener.clicked(messageItems.get(getAdapterPosition()), getAdapterPosition());

        }
    }
}

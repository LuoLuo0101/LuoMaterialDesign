package com.luo.luomaterialdesign;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * MyAdapter by Luo.
 * <p>
 * Created by Luo on 2017/4/30 0030.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Context context;
    private List<Bean> list;
    private LayoutInflater inflater;
    private Listener listener;

    public MyAdapter(Context context, List<Bean> list, Listener listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemViewType(int position) {
        return android.R.layout.simple_list_item_1;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(viewType, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Bean bean = list.get(position);
        holder.text1.setText(bean.getTitle());
        if (listener != null) {
            listener.onClick(holder.itemView, position);
        }
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView text1;

        ViewHolder(View itemView) {
            super(itemView);
            text1 = ((TextView) itemView.findViewById(android.R.id.text1));
        }
    }

    public interface Listener {
        void onClick(View v, int position);
    }
}

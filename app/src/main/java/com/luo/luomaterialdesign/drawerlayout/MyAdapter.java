package com.luo.luomaterialdesign.drawerlayout;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.luo.luomaterialdesign.Bean2;
import com.luo.luomaterialdesign.R;

import java.util.List;

/**
 * CardViewAdapter by Luo.
 * <p>
 * Created by Luo on 2017/4/30 0030.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Context context;
    private List<Bean2> list;

    public MyAdapter(Context context, List<Bean2> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.item2;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(viewType, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Bean2 bean = list.get(position);
        holder.text.setText(bean.getTitle());
        holder.image.setImageResource(bean.getResId());
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        private TextView text;

        ViewHolder(View itemView) {
            super(itemView);
            image = ((ImageView) itemView.findViewById(R.id.image));
            text = ((TextView) itemView.findViewById(R.id.text));
        }
    }
}

package com.luo.luomaterialdesign.cardview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.luo.luomaterialdesign.Bean;
import com.luo.luomaterialdesign.R;

import java.util.List;

/**
 * CardViewAdapter by Luo.
 * <p>
 * Created by Luo on 2017/4/30 0030.
 */
public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.ViewHolder> {
    private Context context;
    private List<Bean> list;

    public CardViewAdapter(Context context, List<Bean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.item;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(viewType, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Bean bean = list.get(position);
        final Class clazz = bean.getClazz();
        holder.text.setText(bean.getTitle());
        if (clazz == null) {
            holder.itemView.setOnClickListener(null);
        } else {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(context, clazz));
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView text;

        ViewHolder(View itemView) {
            super(itemView);
            text = ((TextView) itemView.findViewById(R.id.text));
        }
    }
}

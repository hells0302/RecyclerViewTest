package com.study.recycleviewtest0827.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.study.recycleviewtest0827.R;

import java.util.List;

/**
 * Created by dnw on 2017/8/27.
 */

public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.ViewHolder> {
    List<String>mList;
    private Context mContent;
    private LayoutInflater mInflater;
    public SimpleAdapter(Context context,List<String> list) {
        super();
        mList=list;
        mContent=context;
        mInflater=LayoutInflater.from(context);
    }
    static class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView=(TextView)itemView.findViewById(R.id.text);
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=mInflater.inflate(R.layout.item_layout,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}

package com.study.recycleviewtest0827.ViewHodler;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.study.recycleviewtest0827.R;
import com.study.recycleviewtest0827.dataModel.DataModelTwo;

/**
 * Created by dnw on 2017/8/27.
 */

public class TypeTwoViewHodler extends RecyclerView.ViewHolder{
    public ImageView avatar;
    public TextView name;
    public TextView content;
    public TypeTwoViewHodler(View itemView) {
        super(itemView);
        avatar= (ImageView) itemView.findViewById(R.id.avatar);
        name= (TextView) itemView.findViewById(R.id.name);
        content= (TextView) itemView.findViewById(R.id.content);
        itemView.setBackgroundColor(Color.YELLOW);
    }
    public void bindHolder(DataModelTwo model)
    {
        avatar.setBackgroundResource(model.avatarCplor);
        name.setText(model.name);
        content.setText(model.content);
    }
}

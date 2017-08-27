package com.study.recycleviewtest0827.ViewHodler;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.study.recycleviewtest0827.R;
import com.study.recycleviewtest0827.dataModel.DataModelThree;

/**
 * Created by dnw on 2017/8/27.
 */

public class TypeThrViewHolder extends RecyclerView.ViewHolder{
    public ImageView avatar;
    public TextView name;
    public TextView content;
    public ImageView contentImage;
    public TypeThrViewHolder(View itemView) {
        super(itemView);
        avatar= (ImageView) itemView.findViewById(R.id.avatar);
        name= (TextView) itemView.findViewById(R.id.name);
        content= (TextView) itemView.findViewById(R.id.content);
        contentImage= (ImageView) itemView.findViewById(R.id.contentImage);
        itemView.setBackgroundColor(Color.RED);
    }
    public void bindHolder(DataModelThree model)
    {
        avatar.setBackgroundResource(model.avatarCplor);
        name.setText(model.name);
        content.setText(model.content);
        contentImage.setBackgroundResource(model.contentColor);
    }
}

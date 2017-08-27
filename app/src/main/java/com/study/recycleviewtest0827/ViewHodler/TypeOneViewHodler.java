package com.study.recycleviewtest0827.ViewHodler;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.study.recycleviewtest0827.R;
import com.study.recycleviewtest0827.dataModel.DataModelOne;

/**
 * Created by dnw on 2017/8/27.
 */

public class TypeOneViewHodler extends RecyclerView.ViewHolder {
    public ImageView avatar;
    public TextView name;
    public TypeOneViewHodler(View itemView) {
        super(itemView);
        avatar= (ImageView) itemView.findViewById(R.id.avatar);
        name= (TextView) itemView.findViewById(R.id.name);
        itemView.setBackgroundColor(Color.BLUE);
    }
    public void bindHolder(DataModelOne model)
    {
        avatar.setBackgroundResource(model.avatarCplor);
        name.setText(model.name);
    }
}

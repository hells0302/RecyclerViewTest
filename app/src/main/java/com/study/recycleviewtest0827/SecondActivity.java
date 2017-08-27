package com.study.recycleviewtest0827;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.study.recycleviewtest0827.Adapter.SecondAdapter;
import com.study.recycleviewtest0827.dataModel.DataModelOne;
import com.study.recycleviewtest0827.dataModel.DataModelThree;
import com.study.recycleviewtest0827.dataModel.DataModelTwo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dnw on 2017/8/27.
 */

public class SecondActivity extends AppCompatActivity {
    private RecyclerView recyclerView1;
    private SecondAdapter secondAdapter;
    int colors[] ={android.R.color.holo_blue_dark,android.R.color.holo_red_light,android.R.color.holo_green_dark};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        recyclerView1= (RecyclerView) findViewById(R.id.secondRecyclerView);
        //recyclerView1.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        GridLayoutManager manager=new GridLayoutManager(this,2);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup(){
            @Override
            public int getSpanSize(int position) {
                int type=recyclerView1.getAdapter().getItemViewType(position);

                if(type==3)
                {
                    return 2;
                }else
                {
                    return 1;
                }
            }
        });
        recyclerView1.addItemDecoration(new RecyclerView.ItemDecoration()
        {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                GridLayoutManager.LayoutParams layoutParams= (GridLayoutManager.LayoutParams) view.getLayoutParams();
                outRect.top=20;
                int spanSize=layoutParams.getSpanSize();
                int spanIndex=layoutParams.getSpanIndex();
                if(spanSize!=2)
                {
                    if(spanIndex==1)
                    {
                        outRect.right=10;
                    }else
                    {
                        outRect.right=10;
                    }
                }
            }
        });
        recyclerView1.setLayoutManager(manager);
        secondAdapter=new SecondAdapter(this);
        recyclerView1.setAdapter(secondAdapter);
        initData();
    }
    public void initData()
    {
//        List<DataModel> list=new ArrayList<>();
//        for (int i=0;i<20;i++)
//        {
//            int type=(int)((Math.random()*3)+1);
//            DataModel dataModel=new DataModel();
//            dataModel.avatarCplor=colors[type-1];
//            if(i<5)
//            {
//                dataModel.type=1;
//            }else if(i<14)
//            {
//                dataModel.type=2;
//            }else
//            {
//                dataModel.type=3;
//            }
//           // dataModel.type=type;
//            dataModel.name="name:"+i;
//            dataModel.content="content:"+i;
//            dataModel.contentColor=colors[(type+1) % 3];
//            list.add(dataModel);
//        }
        //布局一数据初始化
        List<DataModelOne> list1=new ArrayList<>();
        for(int i=0;i<10;i++)
        {
            DataModelOne dataModel=new DataModelOne();
            dataModel.avatarCplor=colors[0];
            dataModel.name="name:"+i;
            list1.add(dataModel);
        }
        //布局二数据初始化
        List<DataModelTwo> list2=new ArrayList<>();
        for(int i=0;i<10;i++)
        {
            DataModelTwo dataModel=new DataModelTwo();
            dataModel.avatarCplor=colors[1];
            dataModel.name="name:"+i;
            dataModel.content="content:"+i;
            list2.add(dataModel);
        }
        //布局三数据初始化
        List<DataModelThree> list3=new ArrayList<>();
        for(int i=0;i<10;i++)
        {
            DataModelThree dataModel=new DataModelThree();
            dataModel.avatarCplor=colors[2];
            dataModel.name="name:"+i;
            dataModel.content="content:"+i;
            dataModel.contentColor=colors[2];
            list3.add(dataModel);
        }

        secondAdapter.addList(list1,list2,list3);
        secondAdapter.notifyDataSetChanged();
    }
}

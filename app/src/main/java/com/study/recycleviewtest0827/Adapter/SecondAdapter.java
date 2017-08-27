package com.study.recycleviewtest0827.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.study.recycleviewtest0827.R;
import com.study.recycleviewtest0827.ViewHodler.TypeOneViewHodler;
import com.study.recycleviewtest0827.ViewHodler.TypeThrViewHolder;
import com.study.recycleviewtest0827.ViewHodler.TypeTwoViewHodler;
import com.study.recycleviewtest0827.dataModel.DataModelOne;
import com.study.recycleviewtest0827.dataModel.DataModelThree;
import com.study.recycleviewtest0827.dataModel.DataModelTwo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dnw on 2017/8/27.
 */

public class SecondAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private LayoutInflater layoutInflater;
    private Context context;
    public static final int TYPE_ONE=1;
    public static final int TYPE_TWO=2;
    public static final int TYPE_THR=3;

    public SecondAdapter(Context context) {
        super();
        this.context=context;
        //this.mList=list;
        layoutInflater=LayoutInflater.from(context);
    }
    private List<Integer> types=new ArrayList<>();
    private Map<Integer,Integer> mPositions=new HashMap<>();
    private List<DataModelOne> list1;
    private List<DataModelTwo> list2;
    private List<DataModelThree> list3;
    public void addList(List<DataModelOne>list1, List<DataModelTwo>list2 ,List<DataModelThree>list3)
    {
        //mList.addAll(list);
        addListByType(TYPE_ONE,list1);
        addListByType(TYPE_TWO,list2);
        addListByType(TYPE_THR,list3);
        this.list1=list1;
        this.list2=list2;
        this.list3=list3;
    }
    private void addListByType(int type,List list)
    {
        mPositions.put(type,types.size());
        for(int i=0;i<list.size();i++)
        {
            types.add(type);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return types.get(position);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType)
        {
            case TYPE_ONE:
                return new TypeOneViewHodler(layoutInflater.inflate(R.layout.item_layout_type_one,parent,false));
            case TYPE_TWO:
                return new TypeTwoViewHodler(layoutInflater.inflate(R.layout.item_layout_type_two,parent,false));
            case TYPE_THR:
                return new TypeThrViewHolder(layoutInflater.inflate(R.layout.item_layout_type_thr,parent,false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int viewType=getItemViewType(position);
        int realPosition=position-mPositions.get(viewType);
        switch (viewType)
        {
            case TYPE_ONE:
                ((TypeOneViewHodler)(holder)).bindHolder(list1.get(realPosition));
                break;
            case TYPE_TWO:
                ((TypeTwoViewHodler)(holder)).bindHolder(list2.get(realPosition));
                break;
            case TYPE_THR:
                ((TypeThrViewHolder)(holder)).bindHolder(list3.get(realPosition));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return types.size();
    }
}

package com.study.recycleviewtest0827;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;

import com.study.recycleviewtest0827.Adapter.SimpleAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private List<String> mDatas;
    private SimpleAdapter mAdaptar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
        mAdaptar=new SimpleAdapter(this,mDatas);
        LinearLayoutManager layout=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(layout);
        //设置间隔线
        //mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));
        mRecyclerView.setAdapter(mAdaptar);
    }
    private void initView()
    {
        mRecyclerView=(RecyclerView) findViewById(R.id.recycleView);
    }
    private void initData()
    {
        mDatas=new ArrayList<>();
        for(int i='A';i<'z';i++)
        {
            mDatas.add((char)i+"");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
       switch (id)
       {
           case R.id.listView:
               mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
               break;
           case R.id.gridView:
               mRecyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this,3));
               break;
           case R.id.hor_listView:
               mRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
               break;
           case R.id.hor_gridView:
               mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(5,StaggeredGridLayoutManager.HORIZONTAL));

               break;
           case R.id.setting:
               Intent intent=new Intent(this,SecondActivity.class);
               startActivity(intent);
               break;
       }
        return super.onOptionsItemSelected(item);
    }
}

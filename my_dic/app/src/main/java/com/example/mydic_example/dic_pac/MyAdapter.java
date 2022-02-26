package com.example.mydic_example.dic_pac;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mydic_example.DetailActivity;
import com.example.mydic_example.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<ViewHolder> {

    private List<ListItem> listItems;
    private Context context;

    public MyAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.list_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final ListItem listItem = listItems.get(position);

        holder.list_title.setText(listItem.getList_title());
        holder.list_desc.setText(listItem.getList_desc());

        // 새로 추가된 코드
        final String list_title = listItem.getList_title();    // 목록에 있는 하나의 리스트 제목 가져오기
        final String list_desc = listItem.getList_desc();      // 목록에 있는 하나의 리스트 내용 가져오기

        // 새로 추가된 코드
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(int position) {
                //Toast.makeText(context, list_title, Toast.LENGTH_SHORT).show();
                openDetailActivity(list_title, list_desc);
            }
        });

    }
    private void openDetailActivity(String title, String desc) {

        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra("title", title);
        intent.putExtra("desc", desc);

        context.startActivity(intent);

    }
    @Override
    public int getItemCount() {
        return listItems.size();
    }
}
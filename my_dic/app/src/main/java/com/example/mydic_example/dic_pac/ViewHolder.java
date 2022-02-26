package com.example.mydic_example.dic_pac;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mydic_example.R;

public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView list_title;
    public TextView list_desc;

    ItemClickListener itemClickListener;       // 추가된 코드

    public ViewHolder(View itemView) {
        super(itemView);

        list_title = (TextView) itemView.findViewById(R.id.list_title);
        list_desc = (TextView) itemView.findViewById(R.id.list_desc);

        itemView.setOnClickListener(this);     // 추가된 코드

    }

    // 추가된 코드
    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    // 추가된 코드
    @Override
    public void onClick(View v) {
        this.itemClickListener.onItemClick(this.getLayoutPosition());
    }

}
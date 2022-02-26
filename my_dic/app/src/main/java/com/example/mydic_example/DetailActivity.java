package com.example.mydic_example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView detail_title;
    TextView detail_desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detail_title = (TextView) findViewById(R.id.detail_title);
        detail_desc = (TextView) findViewById(R.id.detail_desc);

        // Intent로 전달된 데이터 받기
        Intent intent = this.getIntent();
        String title = intent.getExtras().getString("title");
        String article = intent.getExtras().getString("desc");

        // 받은 데이터를 TextView에 적용
        detail_title.setText(title);
        detail_desc.setText(article);

    }
}
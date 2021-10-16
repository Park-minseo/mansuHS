package com.mbtl.mansuhighschool;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class dev extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dev);

        ListView listview ;
        ListViewAdapter adapter;

        // Adapter 생성
        adapter = new ListViewAdapter() ;

        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) findViewById(R.id.listview1);
        listview.setAdapter(adapter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.button1),
                "박민서", "제작 총괄, 급식&시간표 보는기능 제작, 버튼 이미지 및 앱 아이콘 제작");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.button1),
                "이재우", "공부시간 측정 제작") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.button1),
                "최순주", "수학 계산기 제작") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.button1),
                "유영빈", "학교 로드뷰 제작") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.button1),
                "이찬영", "공지사항 제작") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.button1),
                "정태현", "입시 뉴스 제작") ;
    }
}
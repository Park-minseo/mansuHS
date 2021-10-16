package com.mbtl.mansuhighschool;
import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.CaseMap;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.widget.ImageViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;


public class jungtaehyun extends AppCompatActivity {

    private ArrayList<MainData>arrayList;
    private MainAdapter mainAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    Button getBtn;
    TextView result;
    TextView resultTitle;
    ImageView imgview;
    ImageView iv_profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jungtaehyun);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);//핸드폰이 다크모드여도 앱 배경 안변하게 함

        recyclerView = findViewById(R.id.rv);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);


        arrayList = new ArrayList<>();

        mainAdapter = new MainAdapter(arrayList);
        recyclerView.setAdapter(mainAdapter);

        resultTitle = (TextView)findViewById(R.id.resultTitle);
        result = (TextView)findViewById(R.id.result);
        getBtn = (Button) findViewById(R.id.getBtn);
        imgview = findViewById(R.id.imgview);
        iv_profile = findViewById(R.id.iv_profile);

        getBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                getWebsite();

            }
        });
    }
    int a = 1;
    Calendar now = Calendar.getInstance();
    int year = now.get(Calendar.YEAR);
    int month = now.get(Calendar.MONTH) + 1;
    int day = now.get(Calendar.DAY_OF_MONTH);

    private void getWebsite(){
        Document doc = null;

        new Thread(new Runnable() {
            @Override
            public void run() {
                StringBuilder builderT = new StringBuilder();
                StringBuilder builderC = new StringBuilder();
                StringBuilder builderI = new StringBuilder();
                try {
                    String m = " ";
                    String d = " ";
                    if (month < 10) {
                        m = "0" + month;
                    }
                    else m = String.valueOf(month);
                    if (day < 10){
                        d = "0" + day;
                    }
                    else d = String.valueOf(day);
                    Document doc = Jsoup.connect("https://news.naver.com/main/list.naver?mode=LS2D&sid2=250&sid1=102&mid=shm&date=" + year + m + d + "&page=" + a).get();

                    Object title = doc.select("a");
                    Object content = doc.select("span.lede");
                    Object newsimg = doc.select("img");

                    builderT.append(title).append("\n");
                    builderC.append(content).append("\n");
                    builderI.append(newsimg).append("\n");

                    a = a+1;


                } catch (IOException e) {
                    builderT.append("Error").append(e.getMessage()).append("\n");
                    builderC.append("Error").append(e.getMessage()).append("\n");
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String newsimgs = builderI.toString();
                        String Title = builderT.toString();
                        String Content = builderC.toString();
                        String result1 = Content.replace("</span>","");
                        String[] result2 = result1.split("<span class=\"lede\">");
//                        String[] resultT = Title.split("</a>");
                        String[] resultlink = Title.split("https://");

                        String newsimg = newsimgs.replace("<img src=\"","");
                        String[] news_imgs = newsimg.split("\" width=\"");

//                        resultTitle.setText(Title);  //이 부분 많은 수정 필요  홀수가 링크 나옴
                        int img = 2;    //2부터 1간격
                        int i = 18;  //18에 1번째  22에서 2번째 4간격
                        int asdf= 1;





                        for(i=18,asdf=1,img=2;i<=97;i=i+4,asdf++,img++){
                            String imgone = news_imgs[img]; //2부터 사진이 안들어가면 한칸씩 밀림
                            String[] imgtwo = imgone.split("\">\nhttps://");
                            String imgreal = "https://" + imgtwo[1];
                            String rt = resultlink[i];
                            rt = rt.replace("</a>", "");
                            rt = rt.replace("<a href=\"", "");
                            rt = rt.replace("\n", "");

                            String[] result_link = rt.split("\">");
                            String link = "https://" + result_link[0];
//                        resultTitle.setText("https://" + result_link[0]);  //링크
//                            result.setText(result_link[1]);  //타이틀
//                            resultTitle.setText(result2[asdf]);  //완성 1 부터 간략 내용 나옴 1간격
                            String fax = result_link[1];    //타이틀
                            MainData mainData = new MainData(R.mipmap.ic_launcher, fax, result2[asdf]);
                            arrayList.add(mainData);
                            mainAdapter.notifyDataSetChanged();
//                            Picasso.get().load(imgreal).into(imgview);
//                            resultTitle.setText(resultlink[78]);
//                            result.setText(imgreal);


                        }
                        //할일 : 사진 받아오기 , 영상 보면 롱클릭 리스너로 webview 통해서 링크 연결하기
//                    result
                    }

                });

            }
        }).start();



    }
}
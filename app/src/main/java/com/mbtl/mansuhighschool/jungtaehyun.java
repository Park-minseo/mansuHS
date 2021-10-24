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

import com.facebook.drawee.backends.pipeline.Fresco;
import com.squareup.picasso.Picasso;

public class jungtaehyun extends AppCompatActivity {
    private ArrayList<MainData>arrayList;
    private MainAdapter mainAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    Button getBtn;
    TextView result;
    ImageView imgview;
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


        Fresco.initialize(this);
        // 필요한거
        result = (TextView)findViewById(R.id.result);
        getBtn = (Button) findViewById(R.id.getBtn);
        imgview = findViewById(R.id.imgview);

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
    String check = "";
    private void getWebsite(){
        Document doc = null;

        new Thread(new Runnable() {
            @Override
            public void run() {
                StringBuilder builderT = new StringBuilder();
                StringBuilder builderC = new StringBuilder();
                StringBuilder builderI = new StringBuilder();
                try {
                    String m = "";
                    String d = "";
                    if (month < 10) {
                        m = "0" + month;
                    }
                    else m = String.valueOf(month);
                    if (day < 10){
                        d = "0" + day;
                    }
                    else d = String.valueOf(day);
                    Document doc = Jsoup.connect("https://news.naver.com/main/list.naver?mode=LS2D&sid2=250&sid1=102&mid=shm&date=" + year + m + d + "&page=" + a).get();

                    Object title = doc.select("body > div > table > tbody > tr > td > div > div > ul > li > dl > dt >a");
                    Object content = doc.select("body > div > table > tbody > tr > td > div > div > ul > li > dl > dd > span");

                    builderT.append(title).append("\n");
                    builderC.append(content).append("\n");

                    a = a+1;

                } catch (IOException e) {
                    builderT.append("Error").append(e.getMessage()).append("\n");
                    builderC.append("Error").append(e.getMessage()).append("\n");
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        String Title = builderT.toString();
                        String Content = builderC.toString();

                        int img = 2;
                        int i = 18;
                        int asdf= 1;

                        String Title1 = Title.replace("\n","");
                        String title123 = Title1.replace(".png';\"> </a>","");
                        String title1212 = title123.replace("\"> <img","");
                        String[] install = title1212.split("</a>");
                        //타이틀 관련


                        String Content123 = Content.replace("\n","");
                        String Content12 = Content123.replace("</span>","");
                        String[] Content1234 = Content12.split("<span class=\"lede\">");
                        //간략 내용 관련
                            try {


                            for (i = 0, asdf = 1, img = 2; i <= 19; i++, asdf = asdf + 1, img++) {  //이거 아예 다시 해야함
                                String img_title = install[i];
                                String[] newstitle = img_title.split("\">");
                                //타이틀 관련
                                String img12 = "";
                                String imgreal = "error";
                                String[] img1 = {};
                                String link;
                                try {
                                    img1 = img_title.split("src=\"https://");   //이거 잠시 빼옴
                                    img12 = img1[1];
                                    String[] img123 = img12.split(".jpg?");
                                    imgreal = "https://" + img123[0] + ".jpg";
                                     link = img1[0].replace("<a href=\"","");       // 사진이 있을 경우의 본문 링크
                                    link = link.replace("amp;","");
                                } catch (ArrayIndexOutOfBoundsException e) {
                                     link = img1[0].replace("<a href=\"","");
                                    String[] bon_moon = link.split("\">");
                                    link = bon_moon[0];                                             // 사진이 없을 경우의 본문 링크
                                    link = link.replace("amp;","");
                                    imgreal = "";//이거 없는 이미지 설정하삼
                                }

                                if (check == imgreal)
                                {
                                    a = 1;
                                    day = day-1;
                                    if (day <= 0)
                                    {
                                        day = 29;
                                        month = month-1;
                                        getWebsite();
                                    }
                                    getWebsite();
                                }
                                check = imgreal;
                                String contentsp = Content1234[asdf];
                                String[] contentreal = contentsp.split("<span class=\"writing\">");
                                //간략 내용 관련
                                String fax = newstitle[1];
                                MainData mainData = new MainData(imgreal, fax, contentreal[0],link);
                                arrayList.add(mainData);
                                mainAdapter.notifyDataSetChanged();}
                            }
                                catch (ArrayIndexOutOfBoundsException e)
                                {
//                                    check = imgreal;
                                    getWebsite();
                                }

                        }


                });

            }
        }).start();



    }
}
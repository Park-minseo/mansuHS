package com.mbtl.mansuhighschool;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class haksa extends AppCompatActivity {

    WebView WebView;
    WebSettings WebSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gajung);

        WebView = (WebView) findViewById(R.id.web1);

        WebView.setWebViewClient(new WebViewClient());
        WebSettings = WebView.getSettings();
        WebSettings.setJavaScriptEnabled(true);
        WebSettings.setSupportMultipleWindows(false);
        WebSettings.setLoadWithOverviewMode(true);
        WebSettings.setUseWideViewPort(true);
        WebSettings.setSupportZoom(false);
        WebSettings.setBuiltInZoomControls(false);
        WebSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        WebSettings.setDomStorageEnabled(true);

        WebView.loadUrl("http://ims.icehs.kr/boardCnts/list.do?boardID=21715&m=0401&s=ims");
    }
}
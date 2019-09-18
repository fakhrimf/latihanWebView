package com.pwpb.latihanwebview;

import android.Manifest;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    WebView webView;
    ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] permissions = {Manifest.permission.INTERNET};
        requestPermissions(permissions,1);
        webView = findViewById(R.id.webView);
        pb = findViewById(R.id.pb);
        webView.setWebViewClient(new webViewClient());
        webView.loadUrl("https://smkn4bdg.sch.id/");
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }

    public class webViewClient extends WebViewClient {

        @Override
        public void onPageFinished(WebView v, String url) {
            super.onPageFinished(v, url);
            pb.setVisibility(View.GONE);
        }

        @Override
        public void onPageStarted(WebView v, String url, Bitmap bmp){
            super.onPageStarted(v,url,bmp);
        }

        @Override
        public boolean shouldOverrideUrlLoading(@NonNull WebView v, String url){
            v.loadUrl(url);
            return super.shouldOverrideUrlLoading(v,url);
        }

    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}

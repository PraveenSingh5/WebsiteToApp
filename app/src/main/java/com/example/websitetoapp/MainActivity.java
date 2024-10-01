package com.example.websitetoapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.transition.CircularPropagation;
import android.view.View;
import android.view.WindowInsets;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import im.delight.android.webview.AdvancedWebView;
import me.ibrahimsn.lib.CirclesLoadingView;

public class MainActivity extends AppCompatActivity {
    private AdvancedWebView webView;
    CirclesLoadingView loaderVirew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
       webView = findViewById(R.id.webView);
     //  webView.getSettings().setJavaScriptEnabled(true);
      //  webView.setWebViewClient(new MyWebViewClient());
        loaderVirew = findViewById(R.id.loaderVirew);

        SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
        String s1 = sh.getString("name", "");
        //Toast.makeText(this, s1, Toast.LENGTH_SHORT).show();

        SharedPreferences sharedPreferences1 = getSharedPreferences("MySharedPref1",MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences1.edit();
        myEdit.putBoolean("check",true);
        myEdit.apply();



        webView.setMixedContentAllowed(false);
        webView.loadUrl(s1);
        webView.setListener(MainActivity.this, new AdvancedWebView.Listener() {
            @Override
            public void onPageStarted(String url, Bitmap favicon) {
                  loaderVirew.setVisibility(View.GONE);
            }

            @Override
            public void onPageFinished(String url) {

            }

            @Override
            public void onPageError(int errorCode, String description, String failingUrl) {

            }

            @Override
            public void onDownloadRequested(String url, String suggestedFilename, String mimeType, long contentLength, String contentDisposition, String userAgent) {

            }

            @Override
            public void onExternalPageRequest(String url) {
                loaderVirew.setVisibility(View.VISIBLE);
            }
        });





//        webView.setWebChromeClient(new WebChromeClient(){
//            @Override
//            public void onProgressChanged(WebView view, int newProgress) {
//                super.onProgressChanged(view, newProgress);
//                if (newProgress == 100){
//                    webView.setVisibility(View.VISIBLE);
//                }
//            }
//        });
//       webView.loadUrl("https://stackoverflow.com/");


    }

//    static class   MyWebViewClient extends WebViewClient{
//
//
//        @Override
//        public void onPageFinished(WebView webView, String s) {
//            super.onPageFinished(webView, s);
//        }
//
//        @Override
//        public void onPageStarted(WebView webView, String s, Bitmap bitmap) {
//            super.onPageStarted(webView, s, bitmap);
//        }
//
//        @Override
//        public boolean shouldOverrideUrlLoading(WebView webView, String s) {
//            return false;
//        }
//    }

//    @Override
//    public void onBackPressed() {
//        if (webView.canGoBack()){
//            webView.goBack();
//        } else {
//            super.onBackPressed();
//
//        }
//    }



    @SuppressLint("NewApi")
    @Override
    protected void onResume() {
        super.onResume();
       webView.onResume();
        // ...
    }

    @SuppressLint("NewApi")
    @Override
    protected void onPause() {
        webView.onPause();
        // ...
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        webView.onDestroy();
        // ...
        super.onDestroy();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        webView.onActivityResult(requestCode, resultCode, intent);
        // ...
    }

    @Override
    public void onBackPressed() {
        if (!webView.onBackPressed()) { return; }
        // ...
        super.onBackPressed();
    }

}


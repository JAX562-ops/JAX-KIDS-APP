package com.jaxkids.live;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebSettings;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    protected void onCreate(Bundle b){
        super.onCreate(b);
        WebView w = new WebView(this);
        setContentView(w);
        
        // SECURITY LOCK
        WebSettings s = w.getSettings();
        s.setJavaScriptEnabled(true);
        s.setDomStorageEnabled(true);
        s.setAllowFileAccess(false); // BLOCK hackers from files
        s.setAllowFileAccessFromFileURLs(false);
        s.setAllowUniversalAccessFromFileURLs(false);
        s.setAllowContentAccess(false);
        
        w.setWebViewClient(new WebViewClient(){
            // BLOCK enemies opening other sites
            public boolean shouldOverrideUrlLoading(WebView view, String url){
                if(url.contains("jaxkids") || url.startsWith("file:///android_asset/")){
                    return false;
                }
                return true; // Block external
            }
        });
        w.loadUrl("file:///android_asset/index.html");
    }
}

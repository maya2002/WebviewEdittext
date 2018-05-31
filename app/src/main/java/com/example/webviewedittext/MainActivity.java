package com.example.webviewedittext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    WebView wV;
    Button btn;
    EditText eTa, eTb, eTc;
    String URL, a, b, c;
    int a1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wV = (WebView) findViewById(R.id.webView);
        wV.getSettings().setJavaScriptEnabled(true);
        eTa = (EditText) findViewById(R.id.ETa);
        eTb = (EditText) findViewById(R.id.ETb);
        eTc = (EditText) findViewById(R.id.ETc);
        btn = (Button) findViewById(R.id.button);
        wV.setWebViewClient(new MyWebViewClient());
    }
    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;

        }

    }
    public void showurl(View view) {
        URL = "https://www.google.co.il/search?q=";
        a = eTa.getText().toString();
        b = eTb.getText().toString();
        c = eTc.getText().toString();
        a1 = Integer.parseInt(a);
        if (a1 == 0)
            Toast.makeText(MainActivity.this, "a cannot be 0", Toast.LENGTH_SHORT).show();
        else {
            URL = URL + a + "x%5E2%2B" + b + "x%2B" + c;
            wV.loadUrl(URL);
        }

    }


}

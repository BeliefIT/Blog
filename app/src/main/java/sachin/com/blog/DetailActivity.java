package sachin.com.blog;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;


public class DetailActivity extends AppCompatActivity {

    Toolbar toolbar;
    WebView webView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        toolbar = findViewById(R.id.toolbar);
        webView = findViewById(R.id.detailView);
        progressBar = findViewById(R.id.progressBar);
        //   Toast.makeText(this,getIntent().getStringExtra("url"),Toast.LENGTH_LONG).show();
        setSupportActionBar(toolbar);
        webView.setVisibility(View.INVISIBLE);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressBar.setVisibility(View.VISIBLE);
                // Toast.makeText(DetailActivity.this,"Page Started loading",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar.setVisibility(View.INVISIBLE);
                webView.setVisibility(View.VISIBLE);
                Toast.makeText(DetailActivity.this, "Page loaded", Toast.LENGTH_SHORT).show();


            }
        });
        webView.loadUrl(getIntent().getStringExtra("url"));
    }
}

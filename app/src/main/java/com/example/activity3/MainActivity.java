package com.example.activity3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    private EditText mWebsiteEditText;
    private EditText mLocationEditText;
    private EditText mShareTextEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebsiteEditText = findViewById(R.id.website_edittext);

        mLocationEditText = findViewById(R.id.location_edittext);

        mShareTextEditText = findViewById(R.id.share_edittext);
    }


    public void openWebsite(View view) {
        String url = mWebsiteEditText.getText().toString();

        Uri webpage = Uri.parse(url);
        Intent intent1 = new Intent(Intent.ACTION_VIEW, webpage);

        if (intent1.resolveActivity(getPackageManager()) != null) {
            startActivity(intent1);
        } else {
            Log.d("activity3", "Can't handle this!");


        }
    }


    public void openLocation(View view) {

        String loc = mLocationEditText.getText().toString();

        Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
        Intent intent2 = new Intent(Intent.ACTION_VIEW, addressUri);

        if (intent2.resolveActivity(getPackageManager()) != null) {
            startActivity(intent2);
        } else {
            Log.d("activity3", "Can't handle this intent!");
        }
    }


    public void shareText(View view) {
        String txt = mShareTextEditText.getText().toString();
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle(R.string.edittext_share)
                .setText(txt)
                .startChooser();
    }
}
package com.example.funstagram;

import android.os.Bundle;
import android.widget.ImageView;
import com.bumptech.glide.Glide;

import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

// https://stackoverflow.com/questions/6533942/adding-gif-image-in-an-imageview-in-android
// https://stackoverflow.com/questions/39236991/send-edittext-data-from-one-activity-to-another

public class MainActivity3 extends AppCompatActivity {
    private String username;
    private ImageView hwGif;
    private TextView welcomeMessageText;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcomemessage);

        hwGif = findViewById(R.id.halloweengif);
        Glide.with(this).asGif().load(R.drawable.dancehalloween).into(hwGif);

        // Gets the String passed down from activity 2 (Sign In) and sets it to a formatted
        // String extracted from strings.xml
        welcomeMessageText = findViewById(R.id.welcomemessage);
        Bundle bundle = getIntent().getExtras();
        try {
            this.username = bundle.getString("USERNAME", "User");
        } catch (NullPointerException e) {
            this.username = "User";
        }
        String welcomeMessage = getString(R.string.welcomeMessage, username);
        welcomeMessageText.setText(welcomeMessage);
    }
}

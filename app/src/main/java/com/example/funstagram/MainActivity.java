package com.example.funstagram;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private EditText emailEdit;
    private EditText passwordEdit;
    private Button loginButton;
    private Button signInButton;
    private TextView forgotPText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailEdit = findViewById(R.id.email);
        passwordEdit = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
        signInButton = findViewById(R.id.signInButton);
        forgotPText = findViewById(R.id.forgotPassword);

        // Redirection to Sign In
        // https://onecompiler.com/posts/3tc7rz2kw/how-to-navigate-to-another-screen-on-button-click-in-android
        // https://www.geeksforgeeks.org/bundle-in-android-with-example/
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(intent);
            }
        });

        // Redirection to Welcome Message
        // https://stackoverflow.com/questions/39236991/send-edittext-data-from-one-activity-to-another
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e = emailEdit.getText().toString();
                if (checkEmail(e) && passwordEdit.getText() != null) {
                    Toast.makeText(MainActivity.this, "Welcome!", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this,
                            "Please enter a valid username and password", Toast.LENGTH_SHORT).show();
                }
                Log.d("STATE", "Outside if conditional");
            }
        });
    }

    public boolean checkEmail(String email) {
        // Any alphanumeric values followed by @ and finally . and at least 2 characters
        String regex = "^[a-zA-Z0-9_+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
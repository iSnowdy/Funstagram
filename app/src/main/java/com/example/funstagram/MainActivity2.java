package com.example.funstagram;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity2 extends AppCompatActivity {
    private EditText username;
    private EditText emailEdit;
    private EditText passwordEdit;
    private EditText repeatPasswordEdit;
    private CheckBox termsCond;
    private TextView textViewCheckBox;
    private Button signInButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signinactivity);

        username = findViewById(R.id.usernameEditText);
        emailEdit = findViewById(R.id.email);
        passwordEdit = findViewById(R.id.password);
        repeatPasswordEdit = findViewById(R.id.passwordRepeat);
        termsCond = findViewById(R.id.checkBoxTC);
        signInButton = findViewById(R.id.signInButton);

        termsCond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (termsCond.isChecked()) {
                    signInButton.setVisibility(View.VISIBLE);
                } else {
                    signInButton.setVisibility(View.GONE);
                }
            }
        });

        // Customize T&C text
        this.textViewCheckBox = findViewById(R.id.textViewCheckBox);
        this.textViewCheckBox.setMovementMethod(LinkMovementMethod.getInstance());
        this.textViewCheckBox.setLinkTextColor(getResources().getColor(R.color.gradientStartColour2));


        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // && checkPassword(passwordEdit.getText().toString())
                //                    && passwordEdit.getText().toString().equals(repeatPasswordEdit.getText().toString())

                    // If everything is valid, then pop a welcome message, send the username String data
                    // to the next activity and start it
                    Toast.makeText(MainActivity2.this, "Welcome " +
                            username.getText().toString() + "!", Toast.LENGTH_SHORT).show();

                    // Creation of the bundle to add the data we want to send
                    Bundle bundle = new Bundle();
                    bundle.putString("USERNAME", username.getText().toString());
                    // Now instantiate the intent and before starting it, send over the information
                    Intent intent = new Intent(getApplicationContext(), MainActivity3.class);

                    intent.putExtras(bundle);

                    startActivity(intent);

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
    private boolean checkPassword(String password) {
        // At least 1 uppercase, 1 alphanumeric character and length >= 6
        String regex = "^(?=.*[A-Z])(?=.*[a-zA-Z0-9]).{6,}$\n";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}

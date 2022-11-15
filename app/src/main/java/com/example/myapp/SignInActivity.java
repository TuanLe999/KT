package com.example.myapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignInActivity extends AppCompatActivity {

    private static final String FILE_EMAIL = "rememberMe";
    private FirebaseAuth mAuth;
    private EditText username_txt;
    private EditText password_txt;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.sign_in);
        checkBox = (CheckBox) findViewById(R.id.remember);
        mAuth = FirebaseAuth.getInstance();
        username_txt = findViewById(R.id.txt_username);
        password_txt = findViewById(R.id.txt_password);

        SharedPreferences sharedPreferences = getSharedPreferences(FILE_EMAIL, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String username = sharedPreferences.getString("svEmail", "");
        String password = sharedPreferences.getString("svPassword", "");

        if (sharedPreferences.contains("checked") && sharedPreferences.getBoolean("checked", false) == true) {
            checkBox.setChecked(true);
        } else {
            checkBox.setChecked(false);
        }

        username_txt.setText(username);
        password_txt.setText(password);

        AppCompatButton signIn_btn = (AppCompatButton) findViewById(R.id.signin_button);
        signIn_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = username_txt.getText().toString();
                String password = password_txt.getText().toString();
                if (checkBox.isChecked()) {
                    editor.putBoolean("checked", true);
                    editor.apply();
                    StoreDataUsingSharedPref(username, password);

                    if (TextUtils.isEmpty(username)) {
                        Toast mess = Toast.makeText(SignInActivity.this, "Vui lòng nhập Username!", Toast.LENGTH_LONG);
                        return;
                    } else if (TextUtils.isEmpty(password)) {
                        Toast.makeText(SignInActivity.this, "Vui lòng nhập Password!", Toast.LENGTH_LONG).show();
                        return;
                    } else
                        SignIn(username, password);
                } else {

                    if (TextUtils.isEmpty(username)) {
                        Toast mess = Toast.makeText(SignInActivity.this, "Vui lòng nhập Username!", Toast.LENGTH_LONG);
                        return;
                    } else if (TextUtils.isEmpty(password)) {
                        Toast.makeText(SignInActivity.this, "Vui lòng nhập Password!", Toast.LENGTH_LONG).show();
                        return;
                    } else{
                        getSharedPreferences(FILE_EMAIL, MODE_PRIVATE).edit().commit();
                        SignIn(username, password);
                    }

                }

            }
        });


    }

    private void StoreDataUsingSharedPref(String username, String password) {
        SharedPreferences.Editor editor = getSharedPreferences(FILE_EMAIL,MODE_PRIVATE).edit();
        editor.putString("svEmail",username);
        editor.putString("svPassword",password);
        editor.apply();
    }

    private void SignIn(String username, String password) {


        mAuth.signInWithEmailAndPassword(username, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(SignInActivity.this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignInActivity.this, ProfileActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(SignInActivity.this, "Đăng nhập thất bại!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}

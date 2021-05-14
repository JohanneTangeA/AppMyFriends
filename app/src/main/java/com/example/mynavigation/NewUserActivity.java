package com.example.mynavigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mynavigation.Model.Friend;
import com.example.mynavigation.viewModel.FriendsViewModel;

public class NewUserActivity extends AppCompatActivity {

    EditText name;
    EditText description;
    Button btn;
    Button bton;
    FriendsViewModel friendsVM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);
        name = (EditText) findViewById(R.id.editText);
        description = (EditText) findViewById(R.id.editDescription);
        btn = (Button) findViewById(R.id.button_add);
        bton = (Button) findViewById(R.id.button_back);

        friendsVM = new ViewModelProvider(this).get(FriendsViewModel.class);

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast msg = Toast.makeText(NewUserActivity.this, "User added", Toast.LENGTH_LONG);
                msg.show();
                friendsVM.creteFriend(new Friend(name.getText().toString(), description.getText().toString()));
            }
        });

        bton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(NewUserActivity.this, MainActivity.class));
            }
        });
    }
}
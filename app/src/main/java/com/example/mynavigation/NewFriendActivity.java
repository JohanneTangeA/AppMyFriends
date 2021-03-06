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

public class NewFriendActivity extends AppCompatActivity {

    EditText name;
    EditText description;
    EditText age;
    EditText phone;
    Button btn;
    Button bton;
    FriendsViewModel friendsVM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);
        name = (EditText) findViewById(R.id.editText);
        description = (EditText) findViewById(R.id.editDescription);
        age = (EditText) findViewById(R.id.editAge);
        phone = (EditText) findViewById(R.id.editPhoneNumb);
        btn = (Button) findViewById(R.id.button_add);
        bton = (Button) findViewById(R.id.button_back);

        friendsVM = new ViewModelProvider(this).get(FriendsViewModel.class);

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast msg = Toast.makeText(NewFriendActivity.this, "User added", Toast.LENGTH_LONG);
                msg.show();
                friendsVM.creteFriend(new Friend(name.getText().toString(), description.getText().toString(), age.getText().toString(), phone.getText().toString()));
            }
        });

        bton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(NewFriendActivity.this, MainActivity.class));
            }
        });
    }
}
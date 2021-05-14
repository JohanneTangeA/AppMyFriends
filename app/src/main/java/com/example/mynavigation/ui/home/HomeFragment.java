package com.example.mynavigation.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mynavigation.Model.Friend;
import com.example.mynavigation.R;
import com.example.mynavigation.User;
import com.example.mynavigation.UserAdapter;
import com.example.mynavigation.viewModel.FriendsVM;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements UserAdapter.OnListItemClickListener {

    private HomeViewModel homeViewModel;
    private FriendsVM friendsVM;

    RecyclerView mUserList;
    UserAdapter mUserAdapter;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        friendsVM = new ViewModelProvider(this).get(FriendsVM.class);
        homeViewModel = new ViewModelProvider(requireActivity()).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        mUserList = root.findViewById(R.id.rv);
        mUserList.hasFixedSize();
        mUserList.setLayoutManager(new LinearLayoutManager(getContext()));


        friendsVM.getFriendsList().observe(getViewLifecycleOwner(), new Observer<List<Friend>>() {
            @Override
            public void onChanged(List<Friend> friends) {
                mUserAdapter = new UserAdapter(friends, HomeFragment.this);
                mUserList.setAdapter(mUserAdapter);
            }
        });
        //ArrayList<User> users = new ArrayList<>();

        //users.add(new User("Martin", R.drawable.p1,"Hey! I hope that with this app I will make new friends with the same passion as me: football. So, maybe we should watch a match together?", "89 90 44 55" ));
        //users.add(new User("Anne", R.drawable.p2, "Just moved to town and looking to meet new friends! I enjoy cooking, running and photography. Nights out on town are fun, but so is red wine and Netflix", "56 78 89 90"  ));
        //users.add(new User("Signe", R.drawable.p3, "I'd love to meet like minded people to enjoy the city, be creative and form great friendships. I'm all about art, yoga, books and travel.", "89 77 66 45"  ));
        //users.add(new User("Jacob", R.drawable.p4, "Just moved to Aarhus. I would to hang out at Marselisborg for a beer" , "78 99 90 76" ));
//        users.add(new User("Mads", R.drawable.p5, "Hey! I am new to this cool app. I am exited to start meeting new friends", "67 78 55 67"  ));
//        users.add(new User("Katrine", R.drawable.p6, "On a daily basis, I study to be a building designer. In addition, I love a good cup of coffee and I would love to drink it with a new friend" , "89 34 55 67" ));
//        users.add(new User("Julie", R.drawable.p7, "Looking for new friends to hang out with during my lonely, long and hard coronadays. I would love to go for a long walk and gossip" , "90 65 44 77" ));
//        users.add(new User("Janus", R.drawable.p8, "I would love to meet new people who share the same passion as me. I love making bonfires and food in nature" , "90 87 66 55" ));
//        users.add(new User("Kasper", R.drawable.p9, "I am so excited to explore this app and hope to meet new and cool people along the way. Let's have a beer at a cozy bar in Aarhus?" , "23 34 55 66" ));
//        users.add(new User("Rikke", R.drawable.p10, "Hey new friends! I am looking at my phone searching for a reason or a new friend to stop looking at my phone", "78 54 34 67"  ));
//        users.add(new User("Juliane", R.drawable.p11, "I do not have a large network because I've been so focused on my career. Now I'm ready to meet new friends to have a good time with" , "66 34 22 33" ));
//        users.add(new User("Sofie", R.drawable.p12, "Through the corona pandemic, I have lost a large part of my social network. That's why I'm looking for new friends to have fun with" , "34 45 33 45" ));
//        users.add(new User("Jannick", R.drawable.p13, "Hey! Lets make new friendships! I am ready for a beer, a swim, a walk or maybe a trip out into the blue? ", "22 34 54 66"  ));

        return root;
    }

    @Override
    public void onListItemClick(Friend user) {
        //homeViewModel.setUser(user);
        //NavHostFragment.findNavController(this).navigate(R.id.DetailFragment);
    }
}
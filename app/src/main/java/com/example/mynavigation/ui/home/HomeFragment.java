package com.example.mynavigation.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mynavigation.Model.Friend;
import com.example.mynavigation.R;
import com.example.mynavigation.UserAdapter;
import com.example.mynavigation.viewModel.FriendsViewModel;

import java.util.List;

public class HomeFragment extends Fragment implements UserAdapter.OnListItemClickListener {

    private HomeViewModel homeViewModel;
    private FriendsViewModel friendsVM;

    RecyclerView mUserList;
    UserAdapter mUserAdapter;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        friendsVM = new ViewModelProvider(this).get(FriendsViewModel.class);
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

        return root;
    }

    @Override
    public void onListItemClick(Friend user) {
        //homeViewModel.setUser(user);
        //NavHostFragment.findNavController(this).navigate(R.id.DetailFragment);
    }
}
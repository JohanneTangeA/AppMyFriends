package com.example.mynavigation.view;

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
import com.example.mynavigation.Adapters.FriendAdapter;
import com.example.mynavigation.viewModel.FriendsViewModel;

import java.util.List;

public class FriendsFragment extends Fragment implements FriendAdapter.OnListItemClickListener {

    private FriendsViewModel friendsViewModel;
    private FriendsViewModel friendsVM;

    RecyclerView mFriendList;
    FriendAdapter mFriendAdapter;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        friendsVM = new ViewModelProvider(this).get(FriendsViewModel.class);
        friendsViewModel = new ViewModelProvider(requireActivity()).get(FriendsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        mFriendList = root.findViewById(R.id.rv);
        mFriendList.hasFixedSize();
        mFriendList.setLayoutManager(new LinearLayoutManager(getContext()));


        friendsVM.getFriendsList().observe(getViewLifecycleOwner(), new Observer<List<Friend>>() {
            @Override
            public void onChanged(List<Friend> friends) {
                mFriendAdapter = new FriendAdapter(friends, FriendsFragment.this);
                mFriendList.setAdapter(mFriendAdapter);
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
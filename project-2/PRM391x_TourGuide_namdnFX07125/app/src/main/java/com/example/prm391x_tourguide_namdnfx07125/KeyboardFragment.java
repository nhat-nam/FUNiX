package com.example.prm391x_tourguide_namdnfx07125;

//import all necessary libraries
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;

public class KeyboardFragment extends Fragment {

    //  create necessary variables
    private Button backButton;
    RecyclerView recyclerView;
    private MyAdapter mAdapter;

    //  inflate fragment and listen for request to return to main menu
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.keyboard_fragment, container, false);
        backButton = view.findViewById(R.id.keyboardBackButton);

        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                getFragmentManager().popBackStack();
                ((MainActivity)getActivity()).showView();
            }

        });
        return view;
    }

    //  set up recycler view for fragment
    @Override
    public void onViewCreated (View view,Bundle savedInstanceState) {
        recyclerView = (RecyclerView) view.findViewById(R.id.keyboard_recycler_view);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        mAdapter = new MyAdapter(Arrays.asList("SteelSeries Apex Pro","Ducky One 2 Mini","Corsair K95 RGB Platinum","CORSAIR K55 RGB","Havit Low Profile Mechanical Keyboard"));
        recyclerView.setAdapter(mAdapter);


    }
}

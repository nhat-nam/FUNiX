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

public class MouseFragment extends Fragment {

//  create necessary variables
    RecyclerView recyclerView;
    private MyAdapter mAdapter;
    private Button backButton;

//  inflate fragment and listen for request to return to main menu
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.mouse_fragment, container, false);
        backButton = view.findViewById(R.id.mouseBackButton);

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
                               recyclerView = (RecyclerView) view.findViewById(R.id.mouse_recycler_view);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


    mAdapter = new MyAdapter(Arrays.asList("Razer Deathadder Elite","Logitech G Pro HERO","Razer Basilisk V2","Razer Viper Ultimate Wireless", "Razer Deathadder V2"
    ,"Corsair Ironclaw RGB","Logitech G502 Lightspeed Wireless"));
    recyclerView.setAdapter(mAdapter);

    }
}
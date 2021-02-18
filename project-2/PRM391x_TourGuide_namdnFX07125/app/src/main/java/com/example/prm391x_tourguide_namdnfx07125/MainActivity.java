package com.example.prm391x_tourguide_namdnfx07125;

//import all necessary libraries
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity {

//  create necessary variables
    private ImageButton mouseImage, headsetImage, monitorImage, keyboardImage;
    private View mainView;

//  set up variables and listen for user input to change fragments
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mouseImage = findViewById(R.id.fragmentButton1);
        headsetImage = findViewById(R.id.fragmentButton2);
        monitorImage = findViewById(R.id.fragmentButton3);
        keyboardImage = findViewById(R.id.fragmentButton4);
        mainView = findViewById(R.id.main_view);

        mouseImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                showMOUSEFragment();
            }

        });
        headsetImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                showHEADSETFragment();
            }

        });
        monitorImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                showMONITORFragment();
            }

        });
        keyboardImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                showKEYBOARDFragment();
            }

        });

    }

//  functions for changing fragments
    private void showMOUSEFragment(){
        mainView.setVisibility(View.GONE);
        MouseFragment m_fragment = new MouseFragment();
        getFragmentManager()
                .beginTransaction()
                .addToBackStack(null)
                .replace(R.id.frm_content, m_fragment)
                .commit();
    }
    private void showHEADSETFragment(){
        mainView.setVisibility(View.GONE);
        HeadsetFragment h_fragment = new HeadsetFragment();
        getFragmentManager()
                .beginTransaction()
                .addToBackStack(null)
                .replace(R.id.frm_content, h_fragment)
                .commit();
    }
    private void showMONITORFragment(){
        mainView.setVisibility(View.GONE);
        MonitorFragment m_fragment = new MonitorFragment();
        getFragmentManager()
                .beginTransaction()
                .addToBackStack(null)
                .replace(R.id.frm_content, m_fragment)
                .commit();
    }
    private void showKEYBOARDFragment(){
        mainView.setVisibility(View.GONE);
        KeyboardFragment k_fragment = new KeyboardFragment();
        getFragmentManager()
                .beginTransaction()
                .addToBackStack(null)
                .replace(R.id.frm_content, k_fragment)
                .commit();
    }

//  function to be called in fragments to set mainview back to visible
    public void showView(){
        mainView.setVisibility(View.VISIBLE);
   }
}
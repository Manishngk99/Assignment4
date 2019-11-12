package com.example.recyclefragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.recyclefragment.fragment.LoginFragment;
import com.example.recyclefragment.fragment.RegisterFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnfragment;
    //    if the status is true then load first fragment
    private Boolean status = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Binding the value
        btnfragment = findViewById(R.id.btnfragment);
        btnfragment.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (status) {
            LoginFragment loginFragment = new LoginFragment();
            fragmentTransaction.replace(R.id.fragmentcontainer, loginFragment);
//            fragmentTransaction.add(R.id.fragmentcontainer, loginFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            btnfragment.setText("Register page");
            status = false;
        } else {
            RegisterFragment registerFragment = new RegisterFragment();
            fragmentTransaction.replace(R.id.fragmentcontainer, registerFragment);
//            fragmentTransaction.add(R.id.fragmentcontainer, registerFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            btnfragment.setText("Login page");
            status = true;
        }
    }
}

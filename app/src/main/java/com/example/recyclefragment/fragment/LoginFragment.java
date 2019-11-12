package com.example.recyclefragment.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.recyclefragment.LoginCheck;
import com.example.recyclefragment.NavigationActivity;
import com.example.recyclefragment.R;



public class LoginFragment extends Fragment implements View.OnClickListener {
    private Button btnlogin;
    private EditText loginusername, loginpassword;
    boolean status;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        btnlogin = view.findViewById(R.id.btnlogin);
        loginusername = view.findViewById(R.id.loginusername);
        loginpassword = view.findViewById(R.id.loginpassword);

        btnlogin.setOnClickListener(this);
        return view;

    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnlogin) {
            if (TextUtils.isEmpty(loginusername.getText().toString())) {
                loginusername.setError("Enter Username");
                loginusername.requestFocus();
                return;
            } else if (TextUtils.isEmpty(loginpassword.getText().toString())) {
                loginpassword.setError("Enter Number");
                loginpassword.requestFocus();
                return;
            }

            String Username = loginusername.getText().toString();
            String Password = loginpassword.getText().toString();

            LoginCheck chckLogin = new LoginCheck();
            chckLogin.setUsername(Username);
            chckLogin.setPassword(Password);
            status = chckLogin.checkLogin();
            Toast.makeText(getActivity(), "Login Successful, Welcome: " + Username, Toast.LENGTH_LONG).show();

            if (status) {
                Toast.makeText(getActivity(), "Login Successful, Welcome: " + Username, Toast.LENGTH_LONG).show();
                loginusername.setText("");
                loginpassword.setText("");

                /// new activcity

                Intent intent = new Intent(getActivity(), NavigationActivity.class);
                //intent.putExtra(EXTRA_MESSAGE, Username);
                startActivity(intent);


            } else {
                Toast.makeText(getActivity(), "Username && Password did not match", Toast.LENGTH_LONG).show();
                loginpassword.setText("");
                loginpassword.setText("");
            }


           // Toast.makeText(getActivity(), "Registration value is:" + "\n" + "Username: " + Username + "\n" + "Password: " + Password, Toast.LENGTH_SHORT).show();

        }
    }
}

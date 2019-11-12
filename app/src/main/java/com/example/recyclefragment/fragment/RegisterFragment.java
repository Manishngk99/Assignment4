package com.example.recyclefragment.fragment;

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
import com.example.recyclefragment.R;
import com.example.recyclefragment.User;

import java.util.ArrayList;
import java.util.List;


public class RegisterFragment extends Fragment implements View.OnClickListener {
    private Button btnregister;
    private EditText username, number, email, password;
    static List<User> userList = new ArrayList<>();

    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        btnregister = view.findViewById(R.id.btnregister);
        username = view.findViewById(R.id.txtusername);
        number = view.findViewById(R.id.txtnumber);
        email = view.findViewById(R.id.txtemail);
        password = view.findViewById(R.id.txtpassword);
        btnregister.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnregister) {
            if (TextUtils.isEmpty(username.getText().toString())) {
                username.setError("Enter Username");
                username.requestFocus();
                return;
            } else if (TextUtils.isEmpty(number.getText().toString())) {
                number.setError("Enter Number");
                number.requestFocus();
                return;

            } else if (TextUtils.isEmpty(email.getText().toString())) {
                email.setError("Enter Email");
                email.requestFocus();
                return;

            } else if (TextUtils.isEmpty(password.getText().toString())) {
                password.setError("Enter Password");
                password.requestFocus();
                return;
            }
            String Username = username.getText().toString();
            int Number = Integer.parseInt(number.getText().toString());
            String Email = email.getText().toString();
            String Password = password.getText().toString();
            Toast.makeText(getActivity(), "Registration value is:" + "\n" + "Username: " + Username + "\n" + "Number: " + Number + "\n" + "Email:" + Email + "\n" + "Password: " + Password, Toast.LENGTH_SHORT).show();

            User user = new User();
            user.setUser(Username);
            user.setPass(Password);
            userList.add(user);
            LoginCheck checkLogin = new LoginCheck();
            LoginCheck.setUserlist(userList);
            for (int i = 0; i < checkLogin.getUserList().size(); i++) {
                final User userdetail = checkLogin.getUserList().get(i);
                // Toast.makeText(getActivity(), "Registration value is:" + "\n" + "Username: " + Username + "\n" + "Number: " + Number + "\n" + "Email:" + Email + "\n" + "Password: " + Password, Toast.LENGTH_SHORT).show();

                Toast.makeText(getActivity(), "" + userdetail.getUser(), Toast.LENGTH_SHORT).show();
            }
            Toast.makeText(getActivity(), "Signup Sucessful : " + Username, Toast.LENGTH_LONG).show();
            username.setText("");
            number.setText("");
            email.setText("");
            password.setText("");
        }
    }
}

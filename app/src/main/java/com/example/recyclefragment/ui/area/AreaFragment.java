package com.example.recyclefragment.ui.area;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.recyclefragment.R;

public class AreaFragment extends Fragment {

    EditText etRadius;
    Button btnArea;
    double radius, area;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_area, container, false);
        etRadius = view.findViewById(R.id.etRadius);
        btnArea = view.findViewById(R.id.btnArea);

        btnArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radius = Double.parseDouble(etRadius.getText().toString());
                area = 3.14 * radius * radius;

                Toast.makeText(getActivity(), "Area is: " + area, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
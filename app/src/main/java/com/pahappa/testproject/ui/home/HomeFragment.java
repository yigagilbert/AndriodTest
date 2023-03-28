package com.pahappa.testproject.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.button.MaterialButton;
import com.pahappa.testproject.data.Project;
import com.pahappa.testproject.data.User;
import com.pahappa.testproject.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private EditText projectName;
    private EditText projectStatus;
    private EditText projectDescription;
    private MaterialButton createBtn;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        HomeViewModel homeViewModel =
//                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        projectName = binding.projectName;
        projectStatus = binding.projectStatus;
        projectDescription = binding.projectDescription;
        createBtn = binding.submit;

//        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        
        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = projectName.getText().toString();

                Project project = new Project(name,projectStatus.getText().toString(),projectDescription.getText().toString());

                User.addProject(project);
                projectName.getText().clear();
                projectStatus.getText().clear();
                projectDescription.getText().clear();
                Toast.makeText(HomeFragment.this.getContext(), "project created", Toast.LENGTH_SHORT).show();
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
package com.pahappa.testproject;

import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.pahappa.testproject.data.Project;
import com.pahappa.testproject.databinding.ActivityItemBinding;

public class ItemActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;

    TextView projectName;
    TextView projectDescription;
    TextView projectStatus;
private ActivityItemBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

     binding = ActivityItemBinding.inflate(getLayoutInflater());
     setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        projectName
                = binding.label;
        projectStatus
                = binding.status;
        projectDescription
                = binding.discription;

        Project projectDetails = (Project) getIntent().getSerializableExtra("project");


        projectName.setText(projectDetails.getName());
        projectDescription.setText(projectDetails.getDescriptin());
        projectStatus.setText(projectDetails.getStatus());

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Log.d("project",projectDetails.getName());
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_item);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
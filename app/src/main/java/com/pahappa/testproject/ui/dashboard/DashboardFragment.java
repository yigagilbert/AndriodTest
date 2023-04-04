package com.pahappa.testproject.ui.dashboard;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;
import com.pahappa.testproject.ItemActivity;
import com.pahappa.testproject.LoginActivity;
import com.pahappa.testproject.R;
import com.pahappa.testproject.data.Project;
import com.pahappa.testproject.data.User;
import com.pahappa.testproject.databinding.FragmentDashboardBinding;
import com.pahappa.testproject.ui.ClickListiner;
import com.pahappa.testproject.ui.CustonAdpater;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DashboardFragment extends Fragment implements NavigationView
        .OnNavigationItemSelectedListener{


    private FragmentDashboardBinding binding;
    CustonAdpater adapter;
    RecyclerView recyclerView;
    ClickListiner listiner;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

            recyclerView
                    = binding.recyclerView;
            listiner = new ClickListiner() {
                @Override
                public void click(Project p){
                    Toast.makeText(binding.getRoot().getContext(), "clicked item index ",Toast.LENGTH_LONG).show();
                    switchActivities();

                }
            };
            adapter
                    = new CustonAdpater(
                    User.list, this.getContext(),listiner);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(
                    new LinearLayoutManager(this.getContext()));

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    /**
     * Called when an item in the navigation menu is selected.
     *
     * @param item The selected item
     * @return true to display the item as the selected item
     */
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    // Sample data for RecyclerView

    private void switchActivities() {
        Intent switchActivityIntent = new Intent(this.getContext(), ItemActivity.class);
        switchActivityIntent.putExtra("project", adapter.getProject());
        startActivity(switchActivityIntent);
    }
}


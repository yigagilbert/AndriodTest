package com.pahappa.testproject.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.pahappa.testproject.R;
import com.pahappa.testproject.data.Project;
import com.pahappa.testproject.data.User;
import com.pahappa.testproject.databinding.FragmentDashboardBinding;

import java.util.ArrayList;
import java.util.HashMap;

public class DashboardFragment extends Fragment {


    private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        if (User.getProjectsArray() == null){
            //        ArrayAdapter adapter = new ArrayAdapter<Project>(this.getContext(), R.layout.list_view_items, arrayList);
        }else {
            ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
            for (int i = 0; i < User.getProjectsArray().length; i++) {
                HashMap<String, String> hashMap = new HashMap<>();//create a hashmap to store the data in key value pair
                hashMap.put("name", User.getProjectsArray()[i].getName());
                hashMap.put("status", User.getProjectsArray()[i].getStatus() + "");
                hashMap.put("Description", User.getProjectsArray()[i].getDescriptin() + "");
                arrayList.add(hashMap);//add the hashmap into arrayList
            }

            final ListView listView = binding.mobileList;

            String[] from = {"name", "status", "Description"};//string array
            int[] to = {R.id.label, R.id.status,R.id.discription};//int array of views id's
            SimpleAdapter simpleAdapter = new SimpleAdapter(this.getContext(), arrayList, R.layout.list_view_items, from, to);//Create object and set the parameters for simpleAdapter
            listView.setAdapter(simpleAdapter);//sets the adapter for listView
        }



//        listView.setAdapter(adapter);

//        dashboardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
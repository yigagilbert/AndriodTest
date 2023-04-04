package com.pahappa.testproject.ui;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.pahappa.testproject.ItemActivity;
import com.pahappa.testproject.R;
import com.pahappa.testproject.data.Project;

import java.util.Collections;
import java.util.List;

public class CustonAdpater extends RecyclerView.Adapter<ProjectViewHolder>  {


    List<Project> list = Collections.emptyList();

    Context context;

    Project project;
    ClickListiner listiner;

    public CustonAdpater(List<Project> list,
                         Context context, ClickListiner listiner)
    {
        this.list = list;
        this.context = context;
        this.listiner = listiner;
    }

    public CustonAdpater(){

    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public ProjectViewHolder
    onCreateViewHolder(ViewGroup parent,
                       int viewType)
    {

        Context context
                = parent.getContext();
        LayoutInflater inflater
                = LayoutInflater.from(context);

        // Inflate the layout
        View photoView
                = inflater.inflate(R.layout.list_view_items,parent,false);

        ProjectViewHolder viewHolder
                = new ProjectViewHolder(photoView);
        return viewHolder;
    }

    @Override
    public void
    onBindViewHolder(final ProjectViewHolder viewHolder,
                     final int position)
    {
        final int index = viewHolder.getAdapterPosition();
        viewHolder.projectName
                .setText(list.get(position).getName());
        viewHolder.projectDescription
                .setText(list.get(position).getDescriptin());
        viewHolder.projectStatus
                .setText(list.get(position).getStatus());
        viewHolder.view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view)
            {
                setProject(list.get(index));
                listiner.click(list.get(index));
                Toast.makeText(view.getContext(), "clicked item " + (index+1), Toast.LENGTH_SHORT).show();


            }
        });
    }

    @Override
    public int getItemCount()
    {
        return list.size();
    }

    public void addItem( Project p){
        list.add(p);
    }

    @Override
    public void onAttachedToRecyclerView(
            RecyclerView recyclerView)
    {
        super.onAttachedToRecyclerView(recyclerView);
    }




}


// ViewHolder code for RecyclerView
package com.pahappa.testproject.ui;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pahappa.testproject.R;

public class ProjectViewHolder extends RecyclerView.ViewHolder{

    TextView projectName;
    TextView projectDescription;
    TextView projectStatus;
    View view;

    public ProjectViewHolder(@NonNull View itemView) {
        super(itemView);

        projectName
                = (TextView)itemView
                .findViewById(R.id.label);
        projectStatus
                = (TextView)itemView
                .findViewById(R.id.status);
        projectDescription
                = (TextView)itemView
                .findViewById(R.id.discription);
        view = itemView;
    }
}


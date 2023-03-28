package com.pahappa.testproject.data;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {
    private static String username;
    private static String email;

    private static Project initProject = new Project("Shoe Website","Ongoing","this is a sale website");

    private static String password;
//    private static String[] projectsArray = {"Website","Mobile app","Shoe Website","Online shop",
//            "School System","Personal Site"};
    private static Project[] projectsArray = {User.initProject};


    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        User.username = username;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        User.email = email;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        User.password = password;
    }

    public static Project[] getProjectsArray() {
        return projectsArray;
    }

    public static void setProjectsArray(Project[] projectsArray) {
        User.projectsArray = projectsArray;
    }

    public static Project[] addProject(Project project){
        if (projectsArray == null){
//            User.projectsArray = addX(0, projectsArray,project );
            projectsArray[0] = project;
        }else {
            User.projectsArray = addX(projectsArray.length, projectsArray,project );
        }
        return projectsArray;
    }

    // Function to add x in arr
    public static Project[] addX(int n, Project arr[], Project x)
    {
        int i;

        // create a new ArrayList
        List<Project> arrlist
                = new ArrayList<Project>(Arrays.asList(arr));

        // Add the new element
        arrlist.add(x);

        // Convert the Arraylist to array
        arr = arrlist.toArray(arr);

        // return the array
        return arr;
    }
}

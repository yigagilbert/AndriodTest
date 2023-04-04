package com.pahappa.testproject.data;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {

    public static List<Project> list = new ArrayList<Project>();

    private static String username;
    private static String email;

//    public Project initProject = new Project("Shoe Website","Ongoing","this is a sale website");
    private static String password;

//    User.list = User.getData();

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

    public static List<Project> getList() {
        return list;
    }

    public static void setList(List<Project> list) {
        User.list = list;
    }

    public static void addNewProject(Project p){
        User.list.add(p);
    }

    public static void getData()
    {
//        List<Project> list = new ArrayList<>();

        User.list.add(new Project("Second Project",
                "New",
                "this is a test project"));
        User.list.add(new Project("My Test Project",
                "New",
                "This is testing exam .."));
//        list.add(new Project("My Test Project",
//                "New",
//                "This is testing exam .."));
//        list.add(new Project("My Test Project",
//                "New",
//                "This is testing exam .."));
//        return list;

    }

}

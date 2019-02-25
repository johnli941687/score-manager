package com.clive.service;

import com.clive.model.MenuItem;
import com.clive.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuService {

    public List<MenuItem> getMenuItems(User user) {
        List<MenuItem> items = new ArrayList<>();

        if (user.isAdmin()) {
            items.add(new MenuItem("Show All Users", "/admin/users"));
            items.add(new MenuItem("Add New User", "/admin/user"));
        }

        if (user.isTeacher()) {
            items.add(new MenuItem("Show All Courses", "/teacher/courses"));
            items.add(new MenuItem("Add New Course", "/teacher/course"));
        }

        if (user.isStudent()) {
            items.add(new MenuItem("Register Course", "/student/register"));
            items.add(new MenuItem("Show All Courses", "/student/courses"));
            items.add(new MenuItem("Show My Scores", "/student/scores"));
        }

        return items;
    }
}

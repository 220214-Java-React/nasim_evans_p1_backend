package com.revature.Service;

import com.revature.Model.User;
import com.revature.Repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class AdminServices {
    UserRepository userRepository = new UserRepository();

    public ArrayList<User> getAllNewUsers() {
        ArrayList<User> userList = userRepository.getAllNew();
        return userList;
    }

    public ArrayList<User> getAllAdminsUsers(int adminId) {
        ArrayList<User> userList = userRepository.getAllNew(adminId);
        for (User u: userList) {
            System.out.println(u);
        }
        return userList;
    }

    public void updateActiveState(int bool, int userId, int adminId) {
        if (bool == 1) {
            userRepository.updateActiveState(true, userId, adminId);
        }else {
            userRepository.updateActiveState(false, userId, adminId);
        }

    }
}

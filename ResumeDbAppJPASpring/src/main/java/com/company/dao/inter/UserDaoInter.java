/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.inter;

import com.company.entity.User;

import java.util.List;

/**
 *
 * @author xeyal
 */
public interface UserDaoInter {

    public List<User> getAll(String name, String surname, Integer nationalityId);

    public User findByEmailAndPassword(String email, String password);

    public User findByEmail(String email);

    public User getById(int userId);

    public boolean addUser(User u);

    public boolean updateUser(User u);

    public boolean updateUserByFilter(User u);

    public boolean updateUserByFilterPS(User u);

    public boolean removeUser(int i);

}

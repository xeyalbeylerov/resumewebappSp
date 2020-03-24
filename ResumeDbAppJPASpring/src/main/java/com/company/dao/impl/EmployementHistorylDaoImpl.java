/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.EmployementHistorylDaoInter;
import com.company.entity.EmployementHistory;
import com.company.entity.User;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xeyal
 */
public class EmployementHistorylDaoImpl extends AbstractDAO implements EmployementHistorylDaoInter {

    

    private EmployementHistory getAllEmployementHistory(ResultSet rs) throws Exception {
        String header=rs.getString("header");
        String jobDescription=rs.getString("job_description");
        Date beginDate=rs.getDate("begin_date");
        Date endDate=rs.getDate("end_date");
        int userId=rs.getInt("user_id");
        
       EmployementHistory emp= new EmployementHistory(null, header, beginDate, endDate, jobDescription, new User(userId));
       return emp;
    }

    @Override
    public List<EmployementHistory> getAllEmployementHistoryByUserId(int userId) {
        List<EmployementHistory> result = new ArrayList<>();
        try (Connection conn = connect()) {
            PreparedStatement stmt = conn.prepareStatement("select * from employement_history where user_id=?");
            stmt.setInt(1, userId);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                EmployementHistory emp = getAllEmployementHistory(rs);
                result.add(emp);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

}

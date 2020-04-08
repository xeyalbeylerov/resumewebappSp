/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;


import at.favre.lib.crypto.bcrypt.BCrypt;
import com.company.entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author xeyal
 */
//@Transactional
@Repository("userDao1")
public class UserRepositoryCustomImpl implements UserRepositoryCustom{
    public UserRepositoryCustomImpl() {
        System.out.println("UserRepositoryCustomImpl is created");
    }

    @PersistenceContext
    EntityManager em;

    @Override
    public List<User> getAll(String name, String surname, Integer nationalityId) {

        String jpql = "select u from User u where 1=1 ";
        //            String sql = "SELECT"
//                    + "	u.*,"
//                    + "	n.`nationality`,"
//                    + "	c.`name` AS birthplace "
//                    + "FROM"
//                    + "	USER u"
//                    + "	LEFT JOIN country n ON u.nationality_id = n.id"
//                    + "	LEFT JOIN country c ON u.birthplace_id = c.id where 1=1";
        if (name != null && !name.trim().isEmpty()) {
            jpql += " and u.name=:name";
        }
        if (surname != null && !surname.trim().isEmpty()) {
            jpql += " and u.surname=:surname";
        }
        if (nationalityId != null && !(nationalityId == 0)) {
            jpql += " and u.nationality.id=:nid";
        }
        Query q = em.createQuery(jpql, User.class);
        if (name != null && !name.trim().isEmpty()) {
            q.setParameter("name", name);
        }
        if (surname != null && !surname.trim().isEmpty()) {
            q.setParameter("surname", surname);
        }
        if (nationalityId != null && !(nationalityId == 0)) {
            q.setParameter("nid", nationalityId);
        }
        return q.getResultList();
    }
//--simple jpql
//    @Override
//    public User findByEmailAndPassword(String email, String password) {
//        EntityManager em = em();
//        Query q = em.createQuery("select u from User u where u.email=:e and u.password=:p", User.class);
//        q.setParameter("e", email);
//        q.setParameter("p", password);
//        List<User> list = q.getResultList();
//        if (list.size() == 1) {
//            return list.get(0);
//        }
//        return null;
//    }
    //--with criteria builder
//    @Override
//    public User findByEmailAndPassword(String email, String password) {
//        EntityManager em = em();
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<User> q1 = cb.createQuery(User.class);
//        Root<User> postRoot = q1.from(User.class);
//        CriteriaQuery<User> q2 = q1.
//                where(cb.equal(postRoot.get("email"), email), cb.equal(postRoot.get("password"), password));
//        Query query = em.createQuery(q2);
//        List<User> list = query.getResultList();
//        if (list.size() == 1) {
//            return list.get(0);
//        }
//        return null;
//    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> q1 = cb.createQuery(User.class);
        Root<User> postRoot = q1.from(User.class);
        CriteriaQuery<User> q2 = q1.
                where(cb.equal(postRoot.get("email"), email), cb.equal(postRoot.get("password"), password));
        Query query = em.createQuery(q2);
        List<User> list = query.getResultList();
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }
//--simple jpql
//    @Override
//    public User findByEmail(String email) {
//        EntityManager em = em();
//        Query q = em.createQuery("select u from User u where u.email=:e", User.class);
//        q.setParameter("e", email);
//        List<User> list = q.getResultList();
//        if (list.size() == 1) {
//            return list.get(0);
//        }
//        return null;
//    }
//--with criteria builder
//    @Override
//    public User findByEmail(String email) {
//       EntityManager em = em();
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<User> q1 = cb.createQuery(User.class);
//        Root<User> postRoot = q1.from(User.class);
//        CriteriaQuery<User> q2 = q1.
//                where(cb.equal(postRoot.get("email"), email));
//        Query query = em.createQuery(q2);
//        List<User> list = query.getResultList();
//        if (list.size() == 1) {
//            return list.get(0);
//        }
//        return null;
//    }
//    --with NamedQuery
//    @Override
//    public User findByEmail(String email) {
//        EntityManager em = em();
//        Query query = em.createNamedQuery("User.findByEmail", User.class);
//        query.setParameter("email", email);
//        List<User> list = query.getResultList();
//        if (list.size() == 1) {
//            return list.get(0);
//        }
//        return null;
//    }
//     --with simple SQL
    @Override
    public User findByEmail(String email) {
        Query query = em.createNativeQuery("select * from User where email=?", User.class);
        query.setParameter(1, email);
        List<User> list = query.getResultList();
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public boolean removeUser(int i) {
        User u = em.find(User.class, i);
        em.remove(u);
        return true;
    }


    @Override
    public boolean updateUser(User u) {
        em.merge(u);
        return true;
    }

    @Override
    public boolean updateUserByFilterPS(User u) {
//        
        return true;
    }

    @Override
    public boolean updateUserByFilter(User u) {

//        try (Connection conn = connect()) {
//            StringBuilder sb = new StringBuilder("update user set name=name ");
//            if (u.getName() != null && !u.getName().isEmpty()) {
//                sb.append(",name=?");
//            }
//            if (u.getSurname() != null && !u.getSurname().isEmpty()) {
//                sb.append(",surname=?");
//            }
//            if (u.getEmail() != null && !u.getEmail().isEmpty()) {
//                sb.append(",email=?");
//            }
//            if (u.getAddress() != null && !u.getAddress().isEmpty()) {
//                sb.append(",address=?");
//            }
//            if (u.getPassword() != null && !u.getPassword().isEmpty()) {
//                sb.append(",password=?");
//            }
//            if (u.getIsAdmin() != null) {
//                sb.append(",is_admin=?");
//            }
//            if (u.getProfileDesc() != null && !u.getProfileDesc().isEmpty()) {
//                sb.append(",profile_description=?");
//            }
//            if (u.getPhone() != null && !u.getPhone().isEmpty()) {
//                sb.append(",phone=?");
//            }
//            if (u.getBirthDate() != null) {
//                sb.append(",birthdate=?");
//            }
//            System.out.println("bp id" + u.getBirthPlace());
//            if (u.getBirthPlace() != null) {
//                sb.append(",birthplace_id=?");
//            }
//            if (u.getId() != 0) {
//                sb.append(" where id=?");
//            }
//
//            PreparedStatement stmt = conn.prepareStatement(sb.toString());
//            int i = 1;
//
//            if (u.getName() != null && !u.getName().isEmpty()) {
//                stmt.setString(i++, u.getName());
//            }
//            if (u.getSurname() != null && !u.getSurname().isEmpty()) {
//                stmt.setString(i++, u.getSurname());
//            }
//            if (u.getEmail() != null && !u.getEmail().isEmpty()) {
//                stmt.setString(i++, u.getEmail());
//            }
//            if (u.getAddress() != null && !u.getAddress().isEmpty()) {
//                stmt.setString(i++, u.getAddress());
//            }
//            if (u.getPassword() != null && !u.getPassword().isEmpty()) {
//                stmt.setString(i++, crypt.hashToString(4, u.getPassword().toCharArray()));
//
//            }
//            if (u.getIsAdmin() != null) {
//                stmt.setBoolean(i++, u.getIsAdmin());
//            }
//            if (u.getProfileDesc() != null && !u.getProfileDesc().isEmpty()) {
//                stmt.setString(i++, u.getProfileDesc());
//            }
//            if (u.getPhone() != null && !u.getPhone().isEmpty()) {
//                stmt.setString(i++, u.getPhone());
//            }
//            if (u.getBirthDate() != null) {
////                stmt.setDate(i++, u.getBirthDate());
//            }
//            if (u.getBirthPlace() != null) {
//                stmt.setInt(i++, u.getBirthPlace().getId());
//            }
//            if (u.getId() != 0) {
//                stmt.setInt(i++, u.getId());
//            }
//
//            stmt.executeUpdate();
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            return false;
//        }
        return true;
    }

    @Override
    public User getById(int userId) {
        User u = em.find(User.class, userId);
        return u;
    }

//    private static BCrypt.Hasher crypt = BCrypt.withDefaults();
private static BCryptPasswordEncoder crypt = new BCryptPasswordEncoder();

    @Override
    public boolean addUser(User u) {
        u.setPassword(crypt.encode(u.getPassword()));
        em.persist(u);
        return true;
//            stmt.setString(5, crypt.hashToString(4,u.getPassword().toCharArray()));

    }

}

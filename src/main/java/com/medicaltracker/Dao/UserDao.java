package com.medicaltracker.Dao;

import com.medicaltracker.Models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class UserDao {

  @Autowired private EntityManager entityManager;

  public User findUserByUsername(String username) {
    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    CriteriaQuery<User> cq = cb.createQuery(User.class);
    Root<User> root = cq.from(User.class);
    Predicate predicate = cb.equal(root.get("username"), username);
    cq.where(predicate);
    return entityManager.createQuery(cq).getSingleResult();
  }

  public void saveUser(User user) {
    entityManager.persist(user);
  }
}

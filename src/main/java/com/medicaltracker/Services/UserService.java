package com.medicaltracker.Services;

import com.medicaltracker.Dao.UserDao;
import com.medicaltracker.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired private UserDao userDao;

  public String save(User user) {
    userDao.saveUser(user);
    return "Successfully saved user";
  }
}

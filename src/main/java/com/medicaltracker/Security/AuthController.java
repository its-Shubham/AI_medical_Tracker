package com.medicaltracker.Security;

import com.medicaltracker.Models.User;
import com.medicaltracker.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

  @Autowired private UserService userService;

  @Autowired private PasswordEncoder passwordEncoder;

  @PostMapping("/register")
  public ResponseEntity<?> registerUser(@RequestBody User user) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    String result = userService.save(user);
    if (result != null && !result.contains("Successful")) {
      return ResponseEntity.ok("User registered successfully");
    } else {
      return ResponseEntity.badRequest().body("Something Went Wrong");
    }
  }

  @PostMapping("/login")
  public ResponseEntity<?> loginUser(@RequestBody User user) {
    // Authentication logic here
    return ResponseEntity.ok("User logged in successfully");
  }
}

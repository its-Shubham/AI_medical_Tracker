package com.medicaltracker;

import com.medicaltracker.Security.AuthController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MedicalTrackerBackendApplicationTests {

    @Autowired
    private AuthController authController;

    @Test
    public void testUserRegistration() {
        // Test registration logic
    }

    @Test
    public void testUserLogin() {
        // Test login logic
    }

}

package com.system.fridges.controllers;

import com.system.fridges.models.User;
import com.system.fridges.models.enam.UserType;
import com.system.fridges.service.UserServiceImpl;
import com.system.fridges.service.interfaces.UserService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.naming.AuthenticationException;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private HttpSession session;

    @Autowired
    private AuthenticationManager authenticationManager;

        @GetMapping("/login")
        public ResponseEntity<String> login(@RequestParam("email") String email,
                @RequestParam("password") String password,
                HttpServletRequest request) {
            // Створення автентифікаційного об'єкта
            Authentication authentication = new UsernamePasswordAuthenticationToken(email, password);

            // Виклик AuthenticationManager для автентифікації
            Authentication authenticated = authenticationManager.authenticate(authentication);

            // Встановлення автентифікованого користувача в SecurityContext
            SecurityContextHolder.getContext().setAuthentication(authenticated);

            // Створення токену та додавання його до відповіді
            String token = "123456789P";
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", "Bearer " + token);

            session.setAttribute("userEmail", email);

            // Визначення типу користувача
            UserServiceImpl userService = new UserServiceImpl();
            UserType typeUser = userService.findUserByEmail(email).getType();
            session.setAttribute("userId", userService.findUserByEmail(email).getUserId());

            // Перенаправлення на сторінку після успішної автентифікації
            if (typeUser.equals(UserType.REGULAR_USER)) {
                return ResponseEntity.ok().headers(headers).body("/user");
            } else if (typeUser.equals(UserType.ADMIN_TYPE1)) {
                return ResponseEntity.ok().headers(headers).body("/admin");
            } else {
                return ResponseEntity.ok().headers(headers).body("authentication");
            }
        }

    @PostMapping("/register")
    public void registerUser(@RequestBody User user, @RequestParam("file") MultipartFile file) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.saveUser(user, file);
    }
}

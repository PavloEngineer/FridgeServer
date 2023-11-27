package com.system.fridges.controllers;

import com.system.fridges.models.User;
import com.system.fridges.models.enam.UserType;
import com.system.fridges.service.AuthenticationServiceImpl;
import com.system.fridges.service.CustomUserDetailsService;
import com.system.fridges.service.UserServiceImpl;
import com.system.fridges.service.interfaces.UserService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
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
@RequestMapping("/authentication")
public class AuthController {

    @Autowired
    private HttpSession session;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserServiceImpl userService;

        @GetMapping("/login")
        public ResponseEntity<String> login(String email,
                String password,
                HttpServletRequest request) {
            email = "pasakan2@gmail.com";
            password = "1234";

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
            User user = userService.findUserByEmail(email);
            UserType typeUser = user.getType();

            // Перенаправлення на сторінку після успішної автентифікації
            if (typeUser.equals(UserType.REGULAR_USER)) {
                System.out.print(ResponseEntity.ok().headers(headers).body("/user/account"));
                return ResponseEntity.ok().headers(headers).body("/user/account");
            } else if (typeUser.equals(UserType.ADMIN_TYPE1)) {
                return ResponseEntity.ok().headers(headers).body("/admin");
            } else if (typeUser.equals(UserType.ADMIN_TYPE2)) {
                return ResponseEntity.ok().headers(headers).body("/admin");
            } else {
                return ResponseEntity.ok().headers(headers).body("/authentication");
            }
        }

    @PostMapping("/register")
    public void registerUser(@RequestBody User user, @RequestParam("file") MultipartFile file) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.saveUser(user, file);
    }
}

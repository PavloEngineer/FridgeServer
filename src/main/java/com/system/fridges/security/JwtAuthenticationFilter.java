package com.system.fridges.security;

import com.system.fridges.models.entities.User;
import com.system.fridges.repositories.UserRepository;
import com.system.fridges.service.AuthenticationServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.thymeleaf.util.StringUtils;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Value("${app.jwt.secret}")
    private  String secretKey;

    @Autowired
    private  AuthenticationServiceImpl authenticationService;

    @Autowired
    private UserRepository userRepository;

    public JwtAuthenticationFilter() {
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        String jwt;
        String userEmail;

        if (StringUtils.isEmpty(authHeader) || !org.apache.commons.lang3.StringUtils.startsWith(authHeader, "Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }
        jwt = authHeader.substring(7);
        userEmail = authenticationService.extractUserName(jwt);

        if (org.apache.commons.lang3.StringUtils.isNotEmpty(userEmail) && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = userDetailsService().loadUserByUsername(userEmail);

            if (authenticationService.isTokenValid(jwt, userDetails)) {
                SecurityContext securityContext = SecurityContextHolder.createEmptyContext();

                UsernamePasswordAuthenticationToken token  = new UsernamePasswordAuthenticationToken(
                  userDetails, null, userDetails.getAuthorities()
                );

                token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                securityContext.setAuthentication(token);
                SecurityContextHolder.setContext(securityContext);
            }
        }
        filterChain.doFilter(request, response);



        //        String token = extractToken(request);
//        if (token != null) {
//            try {
//                Authentication authentication = validateToken(token);
//                if (authentication != null) {
//                    SecurityContextHolder.getContext().setAuthentication(authentication);
//                }
//            } catch (JwtException e) {
//                // Опрацювання помилки валідації токену
//                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//                response.getWriter().write("Invalid token");
//                return;
//            }
//        }
//        filterChain.doFilter(request, response);
    }

//    private String extractToken(HttpServletRequest request) {
//        String bearerToken = request.getHeader("Authorization");
//        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
//            return bearerToken.substring(7);
//        }
//        return null;
//    }
//
//    private Authentication validateToken(String token) {
//        try {
//            Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
//
//            String username = claims.getSubject();
//            List<String> authorities = claims.get("authentication", List.class);
//
//            List<GrantedAuthority> grantedAuthorities = authorities.stream()
//                    .map(CustomAuthority::new)
//                    .collect(Collectors.toList());
//
//            return new UsernamePasswordAuthenticationToken(username, null, grantedAuthorities);
//        } catch (Exception e) {
//            return null; // Токен не дійсний або виникла помилка при його перевірці
//        }
//    }

    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                User user = userRepository.findUserByEmail(username).orElse(null);
                if (user == null) {
                    throw new UsernameNotFoundException("User not found with username: " + username);
                }

                Set<GrantedAuthority> authorities = new HashSet<>();
                // Додайте ролі користувача до authorities
                authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getType().toString()));

                return new org.springframework.security.core.userdetails.User(
                        user.getEmail(),
                        user.getHashPassword(),
                        authorities
                );
            }
        };
    }

}

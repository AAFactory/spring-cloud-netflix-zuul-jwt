package io.github.aafactory.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.github.aafactory.auth.request.JwtAuthenticationRequest;
import io.github.aafactory.auth.response.JwtAuthenticationResponse;
import io.github.aafactory.auth.service.MultyUserDetailsService;
import io.github.aafactory.auth.util.JwtTokenUtil;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private MultyUserDetailsService userDetailsService;
    
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    
    @RequestMapping("${jwt.route.authentication.path}/hello")
    public ResponseEntity<?> hello (/*@RequestBody JwtAuthenticationRequest authenticationRequest , Device device*/) {
        return ResponseEntity.ok("hello");
    }
    
    @RequestMapping(value = "${jwt.route.authentication.path}/personal", method = RequestMethod.POST)
    public ResponseEntity<?> createPersonalAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest, Device device) throws AuthenticationException {
        authenticationRequest.setUsername(authenticationRequest.getPhone());
        // Perform the security
        Authentication authentication = null;

        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticationRequest.getUsername(),
                            authenticationRequest.getPassword()
                    )
            );
        } catch (AuthenticationException e) {
            System.out.println(e.getMessage());
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Reload password post-security so we can generate token
        final UserDetails userDetails = userDetailsService.loadUserByPhone(authenticationRequest.getPhone());
        final String token = jwtTokenUtil.generateToken(userDetails, device);

        // Return the token
        return ResponseEntity.ok(new JwtAuthenticationResponse(token));
    }
}

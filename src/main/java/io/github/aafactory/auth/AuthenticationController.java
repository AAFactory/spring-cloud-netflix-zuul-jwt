package io.github.aafactory.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @RequestMapping("${jwt.route.authentication.path}/hello")
    public ResponseEntity<?> hello () {
        return ResponseEntity.ok("hello");
    }
}

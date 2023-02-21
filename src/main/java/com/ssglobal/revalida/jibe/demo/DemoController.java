package com.ssglobal.revalida.jibe.demo;

import com.ssglobal.revalida.jibe.domain.User;
import com.ssglobal.revalida.jibe.repository.UserRepository;
import com.ssglobal.revalida.jibe.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/demo")
@RequiredArgsConstructor
public class DemoController {

    private final UserRepository userRepository;
    @GetMapping()
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("WORKING");
    }
}

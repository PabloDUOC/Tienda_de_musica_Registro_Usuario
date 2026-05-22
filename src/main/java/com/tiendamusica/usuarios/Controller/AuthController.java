package com.tiendamusica.usuarios.Controller;

import com.tiendamusica.usuarios.Dto.AuthResponse;
import com.tiendamusica.usuarios.Dto.LoginRequest;
import com.tiendamusica.usuarios.Dto.RegisterRequest;
import com.tiendamusica.usuarios.Entity.UserEntity;
import com.tiendamusica.usuarios.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Valid RegisterRequest request){
    userService.createUser(request);
    return ResponseEntity.ok("usuario registrado correctamente");
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody @Valid LoginRequest request) {
        return ResponseEntity.ok(userService.login(request));
    }
}


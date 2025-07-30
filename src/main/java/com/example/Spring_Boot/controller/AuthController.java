package com.example.Spring_Boot.controller;

import com.example.Spring_Boot.model.Usuario;
import com.example.Spring_Boot.security.JwtUtil;
import com.example.Spring_Boot.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UsuarioService usuarioService;

    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register (@RequestBody Map<String,String> request){
        Usuario usuario = usuarioService.registrarUsuario(request.get("username"), "password");
        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request){
        Optional<Usuario> usuario = usuarioService.buscarPorUsername(request.get("username"));
        if (usuario.isPresent() && usuario.get().getPassword().equals(request.get("password"))){
            String token = JwtUtil.generateToken(usuario.get().getUsername());
            return ResponseEntity.ok(Map.of("token", token));
        }
        return ResponseEntity.status(401).body(Map.of("erro:","Credenciais invalidas"));
    }
}

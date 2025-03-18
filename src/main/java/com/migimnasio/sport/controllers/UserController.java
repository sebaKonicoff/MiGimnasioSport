package com.migimnasio.sport.controllers;

import com.migimnasio.sport.dto.PasswordChangeRequestDTO;
import com.migimnasio.sport.dto.UserDTO;
import com.migimnasio.sport.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/{userName}")
    public ResponseEntity<?> findById(@PathVariable String userName){
        UserDTO userDTO = usuarioService.findById(userName);
        return ResponseEntity.ok(userDTO);
    }

    @GetMapping("/{userName}/{password}")
    public ResponseEntity<?> Login(@PathVariable String userName,
                         @PathVariable String password){
        Boolean isUser = usuarioService.login(userName, password);
        return ResponseEntity.ok(isUser);
    }

    @PutMapping("/user/password")
    public ResponseEntity<String> setPassword(
            @RequestBody PasswordChangeRequestDTO requestDTO
            ){
        try {
            return ResponseEntity.ok(usuarioService.setPassword(
                    requestDTO.getUserName(), requestDTO.getPassword(), requestDTO.getNewPassword()));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body("Error al intentar modificar contraseña");
        }
    }
}

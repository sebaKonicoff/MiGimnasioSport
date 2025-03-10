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
        try{
            UserDTO userDTO = usuarioService.findById(userName);
            return ResponseEntity.ok(userDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuario no encontrado.");
        }
    }

    @GetMapping("/{userName}/{password}")
    public ResponseEntity<?> Login(@PathVariable String userName,
                         @PathVariable String password){
        try{
            Boolean isUser = usuarioService.login(userName, password);
            return ResponseEntity.ok(isUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usario y/o contraseña incorrecto");
        }
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

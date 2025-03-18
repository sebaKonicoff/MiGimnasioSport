package com.migimnasio.sport.services;

import com.migimnasio.sport.data.UserRepository;
import com.migimnasio.sport.dto.UserDTO;
import com.migimnasio.sport.exception.ResourceNotFoundException;
import com.migimnasio.sport.mappers.UserMapper;
import com.migimnasio.sport.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private AlumnoService alumnoService;

    private static final Logger log = LoggerFactory.getLogger(UsuarioService.class);

    public UsuarioService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDTO toDTO(User user){
        return userMapper.toDTO(user);
    }

    public User toEntity(UserDTO userDTO){
        return userMapper.toEntity(userDTO);
    }

    private User getEntityByUserName(String userName){
        return userRepository.findById(userName)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró User"));
    }

    public UserDTO findById(String userName) {
        User user = getEntityByUserName(userName);
        return toDTO(user);

    }

    public boolean login(String userName, String password)  {
        User user = getEntityByUserName(userName);
        return user.checkPassword(password);
    }

    public String setPassword(String userName, String password, String newPassword){
        try {
            log.info("Iniciando intento de cambio de contraseña con user {}", userName);
            User user = getEntityByUserName(userName);
            boolean isPassWord = user.checkPassword(password);
            if(!isPassWord && !alumnoService.isHabilitado(userName)){
                return "Usuario o contraseña incorrecto";
            }
            user.setPassword(newPassword);
            return "Cambio realizado con éxito.";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

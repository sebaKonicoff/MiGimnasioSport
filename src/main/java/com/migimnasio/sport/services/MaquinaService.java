package com.migimnasio.sport.services;

import com.migimnasio.sport.data.MaquinaRepository;
import com.migimnasio.sport.models.Maquina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaquinaService {

    @Autowired
    private final MaquinaRepository maquinaRepository;

    public MaquinaService(MaquinaRepository maquinaRepository) {
        this.maquinaRepository = maquinaRepository;
    }

    public List<Maquina> getAllMaquinas(){
        return maquinaRepository.findAll();
    }

    public Optional<Maquina> getById(Long id){
        return maquinaRepository.findById(id);
    }

    public Maquina createMaquina(Maquina newMaquina){
        return maquinaRepository.save(newMaquina);
    }
}

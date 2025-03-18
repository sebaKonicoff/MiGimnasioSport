package com.migimnasio.sport.services;

import com.migimnasio.sport.data.MaquinaRepository;
import com.migimnasio.sport.enums.MaquinaEstado;
import com.migimnasio.sport.exception.ResourceNotFoundException;
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

    public Maquina actualizarEstadoMaquina(Long id, MaquinaEstado estado) {
        Maquina maquina = maquinaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró Maquina"));
        maquina.setEstado(estado);
        maquinaRepository.save(maquina);
        return maquina;
    }
}

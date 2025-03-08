package com.migimnasio.sport.services;

import com.migimnasio.sport.dao.IEjerMaqDao;
import com.migimnasio.sport.data.EjercicioRepository;
import com.migimnasio.sport.data.MaquinaRepository;
import com.migimnasio.sport.models.Ejercicio;
import com.migimnasio.sport.models.Maquina;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EjerMaqService {

    @Autowired
    private IEjerMaqDao ejerMaqDao;
    @Autowired
    private MaquinaRepository maquinaRepository;
    @Autowired
    private EjercicioRepository ejercicioRepository;

    private static final Logger log = LoggerFactory.getLogger(EjerMaqService.class);

    public void addEjercicioToMaquina(long idMaquina, long idEjercicio){
        log.info("Iniciando inserción de Ejercicio ID: {} en Maquina ID: {}", idEjercicio, idMaquina);
        try{
            Maquina maquina = maquinaRepository.findById(idMaquina).orElseThrow(
                    () -> new RuntimeException("Maquina not found"));
            Ejercicio ejercicio = ejercicioRepository.findById(idEjercicio).orElseThrow(
                    () -> new RuntimeException("Ejercicio not found"));

            maquina.addEjercicio(ejercicio);
            ejercicio.addMaquina(maquina);

            ejerMaqDao.insertEjerMaq(idEjercicio, idMaquina);
            log.info("Inserción completada exitosamente para Ejercicio ID: {} en Maquina ID {}", idEjercicio, idMaquina);
        }catch (Exception e){
            log.error("Error al intentar insertar Ejercicio ID: {} en Maquina ID {}", idEjercicio, idMaquina);
            throw e;
        }
    }



}

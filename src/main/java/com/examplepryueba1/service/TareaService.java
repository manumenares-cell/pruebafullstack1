package com.examplepryueba1.service;

import com.examplepryueba1.model.Tarea;
import com.examplepryueba1.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TareaService {
    @Autowired
    private TareaRepository tareaRepository;

    public List<Tarea>getTareas(){
        return tareaRepository.obtenerTareas();
    }
    
    public Tarea saveTarea(Tarea tarea){
        return tareaRepository.guardar(tarea);
    }

    public Tarea getTareaId(int id){
        return tareaRepository.buscarPorId(id);
    }

    public Tarea updateTarea(Tarea tarea){
        return tareaRepository.actualizar(tarea);
    }

    public String deleteTarea(int id){
        tareaRepository.eliminar(id);
        return "producto eliminado";
    }

    public int totaltareasV1(){
        return tareaRepository.obtenerTareas().size();
    }

    public int totaltareasV2(){
        return tareaRepository.totalTareas();
    }

}

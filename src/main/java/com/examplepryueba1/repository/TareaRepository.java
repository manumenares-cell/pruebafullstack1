package com.examplepryueba1.repository;

import com.examplepryueba1.model.Tarea;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TareaRepository {

    private List<Tarea> listaTareas = new ArrayList<>();

    public List<Tarea>obtenerTareas(){
        return listaTareas;
    }

    public Tarea buscarPorId(int id) {
        for (Tarea tarea : listaTareas){
            if (tarea.getId()==id){
                return tarea;
            }
        }
        return null;
    }

    public Tarea guardar(Tarea tar){
        listaTareas.add(tar);
        return tar;
    }

    public Tarea actualizar(Tarea tar) {
        int id = 0;
        int idPosicion = 0;

        for (int i = 0; i < listaTareas.size(); i++) {
            if (listaTareas.get(i).getId() == tar.getId()) {
                id = tar.getId();
                idPosicion = i;
            }

        }

        Tarea tarea1 = new Tarea();
        tarea1.setId(id);
        tarea1.setDescripcion(tar.getDescripcion());
        tarea1.setEstadoTarea(tar.getEstadoTarea());
        tarea1.setPrioridad(tar.getPrioridad());
        tarea1.setResponsable(tar.getResponsable());
        tarea1.setFechaAsociada(tar.getFechaAsociada());

        listaTareas.set(idPosicion, tarea1);
        return tarea1;


    }
    

    


    public void eliminar (int id) {
        Tarea tarea=buscarPorId(id);
        if (tarea != null) {
            listaTareas.remove(tarea);
        }
        int idPosicion = 0;
        for (int i = 0; i< listaTareas.size(); i++){
            if (listaTareas.get(i).getId()==id){
                idPosicion=i;
                break;
            }
        }
        if (idPosicion>0){
            listaTareas.remove(idPosicion);
        }
        listaTareas.removeIf(x->x.getId()==id);
    }


    public int totalTareas(){
        return listaTareas.size();
    }
    
}

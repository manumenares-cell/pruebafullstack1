package com.examplepryueba1.controller;

import com.examplepryueba1.model.Tarea;
import com.examplepryueba1.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tareas")

public class TareaController {

    @Autowired
    private TareaService tareaService;
    
    @GetMapping 
    public List<Tarea> listaTareas(){
        return tareaService.getTareas();
    }

    @PostMapping 
    public Tarea agregarTarea(@RequestBody Tarea tarea){
        return tareaService.saveTarea(tarea);
    }

    @GetMapping("{id}")
    public Tarea buscarTarea(@PathVariable int id){
        return tareaService.getTareaId(id);
    }

    @PutMapping("{id}")
    public Tarea actualizarTarea(@PathVariable int id,@RequestBody Tarea tarea){
        return tareaService.updateTarea(tarea);
    }

    @DeleteMapping("{id}")
    public String eliminarTarea (@PathVariable int it){
        return tareaService.deleteTarea(it);
    }

    @GetMapping("/total/")
    public int totaltareasV2(){
        return tareaService.totaltareasV2();
    }

}

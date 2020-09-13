package org.um5.ensias.ims.cbpm.transformation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.um5.ensias.ims.cbpm.transformation.Sevice.Imp.CrudCbpmElementServiceImp;
import org.um5.ensias.ims.cbpm.transformation.model.CbpmElement;
import org.um5.ensias.ims.cbpm.transformation.model.Event;

import java.util.List;
import java.util.Optional;

@RestController
public class CrudEventController {
    @Autowired
    CrudCbpmElementServiceImp crudCbpmElementServiceImp;

    @GetMapping(value = "/allEvents")
    @ResponseBody
    public List<Event> getAllEvents(){
        return crudCbpmElementServiceImp.findAllEvent();
    }

    @GetMapping(value = "/Event/{id}")
    @ResponseBody
    public Optional<Event> getEventById(@PathVariable long id){
        return crudCbpmElementServiceImp.findEventById(id);
    }

    @PostMapping(value = "/addEvent/", consumes = "application/json")
    @ResponseBody
    public Event addEvent(@RequestBody Event event){
        return crudCbpmElementServiceImp.createEvent(event);
    }

    @DeleteMapping(value = "/deleteEvent/{id}")
    @ResponseBody
    public void deleteEvent(@PathVariable long id){
        crudCbpmElementServiceImp.deleteEventById(id);
    }

}

package org.um5.ensias.ims.cbpm.transformation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.um5.ensias.ims.cbpm.transformation.Sevice.CrudCbpmService;
import org.um5.ensias.ims.cbpm.transformation.model.Cbpm;

import java.util.List;
import java.util.Optional;

@RestController
public class CrudCbpmController {
    @Autowired
    CrudCbpmService crudCbpmService;

    @GetMapping (value = "/allCbpms/")
    @ResponseBody
    public List<Cbpm> getAllCbpm(){
        return crudCbpmService.findAll();
    }


    @GetMapping (value = "/Cbpm/{id}")
    @ResponseBody
    public Optional<Cbpm> getCbpmById(@PathVariable long id){
        return crudCbpmService.findById(id);
    }

    @PostMapping(value = "/addCbpm/", consumes="application/json")
    @ResponseBody
    public Cbpm createCbpm(@RequestBody Cbpm cbpm){
        return crudCbpmService.create(cbpm);
    }

    @DeleteMapping(value = "/deleteCbpm/{id}")
    public void deleteCbpm(@PathVariable long id){
        crudCbpmService.deleteById(id);
    }

}

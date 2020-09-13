package org.um5.ensias.ims.cbpm.transformation.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.um5.ensias.ims.cbpm.transformation.Sevice.Imp.CrudCbpmElementServiceImp;
import org.um5.ensias.ims.cbpm.transformation.model.CbpmElement;

import java.util.List;
import java.util.Optional;

@RestController
public class CrudCbpmElementController {
    @Autowired
    CrudCbpmElementServiceImp crudCbpmElementServiceImp;

    @GetMapping(value = "/allElements/")
    @ResponseBody
    public List<CbpmElement> getAllCbpmElement(){
        return crudCbpmElementServiceImp.findAll();
    }

    @GetMapping(value = "/CbpmElement/{id}")
    @ResponseBody
    public Optional<CbpmElement> getCbpmElementById(@PathVariable long id){
        return crudCbpmElementServiceImp.findById(id);
    }

    @PostMapping(value = "/addCbpmElement/", consumes = "application/json")
    @ResponseBody
    public CbpmElement addCbpmElement(@RequestBody CbpmElement cbpmElement){
        return crudCbpmElementServiceImp.create(cbpmElement);
    }

    @DeleteMapping(value = "/deleteCbpmElement/{id}")
    @ResponseBody
    public void deleteCbpmElement(@PathVariable long id){
        crudCbpmElementServiceImp.deleteById(id);
    }

}

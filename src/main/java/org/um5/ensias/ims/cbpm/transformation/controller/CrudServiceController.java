package org.um5.ensias.ims.cbpm.transformation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.um5.ensias.ims.cbpm.transformation.Sevice.Imp.CrudCbpmElementServiceImp;
import org.um5.ensias.ims.cbpm.transformation.model.Gateway;
import org.um5.ensias.ims.cbpm.transformation.model.Service;

import java.util.List;
import java.util.Optional;

@RestController
public class CrudServiceController {
    @Autowired
    CrudCbpmElementServiceImp crudCbpmElementServiceImp;

    @GetMapping(value = "/allServices/")
    @ResponseBody
    public List<Service> getAllServices(){
        return crudCbpmElementServiceImp.findAllService();
    }

    @GetMapping(value = "/Service/{id}")
    @ResponseBody
    public Optional<Service> getServiceById(@PathVariable long id){
        return crudCbpmElementServiceImp.findServiceById(id);
    }

    @PostMapping(value = "/addService/", consumes = "application/json")
    @ResponseBody
    public Service addService(@RequestBody Service service){
        return crudCbpmElementServiceImp.createService(service);
    }

    @DeleteMapping(value = "/deleteService/{id}")
    @ResponseBody
    public void deleteService(@PathVariable long id){
        crudCbpmElementServiceImp.deleteServiceById(id);
    }
}

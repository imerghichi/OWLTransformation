package org.um5.ensias.ims.cbpm.transformation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.um5.ensias.ims.cbpm.transformation.Sevice.Imp.CrudCbpmElementServiceImp;
import org.um5.ensias.ims.cbpm.transformation.model.CbpmElement;
import org.um5.ensias.ims.cbpm.transformation.model.Gateway;

import java.util.List;
import java.util.Optional;

@RestController
public class CrudGatewayController {
    @Autowired
    CrudCbpmElementServiceImp crudCbpmElementServiceImp;

    @GetMapping(value = "/allGateways/")
    @ResponseBody
    public List<Gateway> getAllGateways(){
        return crudCbpmElementServiceImp.findAllGateway();
    }

    @GetMapping(value = "/Gateway/{id}")
    @ResponseBody
    public Optional<Gateway> getGatewayById(@PathVariable long id){
        return crudCbpmElementServiceImp.findGatewayById(id);
    }

    @PostMapping(value = "/addGateway/", consumes = "application/json")
    @ResponseBody
    public Gateway addGateway(@RequestBody Gateway gateway){
        return crudCbpmElementServiceImp.createGateway(gateway);
    }

    @DeleteMapping(value = "/deleteGateway/{id}")
    @ResponseBody
    public void deleteGateway(@PathVariable long id){
        crudCbpmElementServiceImp.deleteGatewayById(id);
    }

}

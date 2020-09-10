package org.um5.ensias.ims.cbpm.transformation.controller;

import org.semanticweb.owlapi.model.OWLOntology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.um5.ensias.ims.cbpm.transformation.Sevice.Imp.OntologyServiceImp;
import org.um5.ensias.ims.cbpm.transformation.model.Cbpm;

@RestController
public class Contoller {
    @Autowired
    OntologyServiceImp service;

    @GetMapping(value = "/cbpm/")
    @ResponseBody
    public OWLOntology getOntologyforCbpm(@RequestBody Cbpm cbpm) throws Exception {
            return service.convertCBPMtoOWLOntology(cbpm);
    }

}

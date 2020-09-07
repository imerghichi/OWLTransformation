package org.um5.ensias.ims.cbpm.transformation.Sevice.Imp;

import org.junit.jupiter.api.Test;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;

import static org.junit.jupiter.api.Assertions.*;

class ServiceImpTest {

    @Test
    void createBasicOntology() throws OWLOntologyCreationException {
        ServiceImp serviceImp = new ServiceImp();
        OWLOntology ontology = serviceImp.createBasicOntology();
        assertNotNull(ontology);
    }
}
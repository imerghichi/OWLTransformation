package org.um5.ensias.ims.cbpm.transformation.Sevice.Imp;

import org.junit.jupiter.api.Test;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @Test
    void createOntology() throws OWLOntologyCreationException {
        String iri = "http://www.semanticweb.org/imerghichi/ontologies/test.owl";
        OWLOntology ontology = Utils.createOntology(iri);

        assertNotNull(ontology);

    }

    @Test
    void save() throws OWLOntologyCreationException {
    }
}
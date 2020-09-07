package org.um5.ensias.ims.cbpm.transformation.Sevice;

import org.semanticweb.owlapi.model.OWLOntology;
import org.um5.ensias.ims.cbpm.transformation.model.Cbpm;

public interface Service {
    OWLOntology convertCBPMtoOWLOntology(Cbpm cbpm) throws Exception;
}

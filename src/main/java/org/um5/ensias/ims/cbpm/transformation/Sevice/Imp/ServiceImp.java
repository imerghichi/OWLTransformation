package org.um5.ensias.ims.cbpm.transformation.Sevice.Imp;

import org.semanticweb.owlapi.model.*;
import org.um5.ensias.ims.cbpm.transformation.Sevice.Service;
import org.um5.ensias.ims.cbpm.transformation.model.Cbpm;

public class ServiceImp implements Service {
    static final String baseIRI = "http://www.semanticweb.org/imerghichi/ontologies/cbpm/ProcessOntology.owl";
    private Utils utils = new Utils();
    //todo
    @Override
    public OWLOntology convertCBPMtoOWLOntology(Cbpm cbpm) {
        return null;
    }

    public ServiceImp() {
    }

    public OWLOntology createBasicOntology() throws OWLOntologyCreationException {
       OWLOntology ontology = utils.createOntology(baseIRI);
       OWLClass processElement = utils.createClass(baseIRI+"#processElement");
       OWLClass event = utils.createClass(baseIRI+"#event");
       OWLClass gateway = utils.createClass(baseIRI+"#gateway");
       OWLClass service = utils.createClass(baseIRI+"#service");
       OWLAxiomChange axiomChange1 = utils.addSubClass(ontology,event,processElement);
       OWLAxiomChange axiomChange2 = utils.addSubClass(ontology,gateway,processElement);
       OWLAxiomChange axiomChange3 = utils.addSubClass(ontology,service,processElement);
        utils.addChange(axiomChange1);
        utils.addChange(axiomChange2);
        utils.addChange(axiomChange3);
       return ontology;
    }

}

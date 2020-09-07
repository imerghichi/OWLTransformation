package org.um5.ensias.ims.cbpm.transformation.Sevice.Imp;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.*;

public class Utils {
    OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
    OWLDataFactory dataFactory = OWLManager.getOWLDataFactory();

    public OWLOntology createOntology(IRI iri) throws OWLOntologyCreationException {
        return manager.createOntology(iri);
    }

    public OWLClass createClass(IRI iri){
        return dataFactory.getOWLClass(iri);
    }

    public OWLIndividual createIndividual(IRI iri){
        return dataFactory.getOWLNamedIndividual(iri);
    }

    public OWLObjectProperty createObjectProperty(IRI iri){
        return dataFactory.getOWLObjectProperty(iri);
    }

    public OWLAxiomChange addSubClass(OWLOntology ontology,OWLClass subclass, OWLClass superclass){
        return new AddAxiom(ontology,dataFactory.getOWLSubClassOfAxiom(subclass,superclass));
    }

    public OWLAxiomChange addIndividualToClass(OWLOntology ontology, OWLClass classe, OWLIndividual individual){
        return new AddAxiom(ontology, dataFactory.getOWLClassAssertionAxiom(classe, individual));
    }

}

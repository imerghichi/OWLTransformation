package org.um5.ensias.ims.cbpm.transformation.Sevice.Imp;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.*;

import java.util.Arrays;

public class Utils {
    OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
    OWLDataFactory dataFactory = OWLManager.getOWLDataFactory();


    public IRI convertStringToIRI(String iri){
        return IRI.create(iri);
    }

    public OWLOntology createOntology(String iri) throws OWLOntologyCreationException {
        return manager.createOntology(convertStringToIRI(iri));
    }

    public OWLClass createClass(String iri){
        return dataFactory.getOWLClass(convertStringToIRI(iri));
    }

    public OWLIndividual createIndividual(String iri){
        return dataFactory.getOWLNamedIndividual(convertStringToIRI(iri));
    }

    public OWLObjectProperty createObjectProperty(String iri){
        return dataFactory.getOWLObjectProperty(convertStringToIRI(iri));
    }

    public OWLAxiomChange addSubClass(OWLOntology ontology,OWLClass subclass, OWLClass superclass){
        return new AddAxiom(ontology,dataFactory.getOWLSubClassOfAxiom(subclass,superclass));
    }

    public OWLAxiomChange addIndividualToClass(OWLOntology ontology, OWLClass classe, OWLIndividual individual){
        return new AddAxiom(ontology, dataFactory.getOWLClassAssertionAxiom(classe, individual));
    }

    public void addChange (OWLAxiomChange... axiomChanges){
        manager.applyChanges(Arrays.asList(axiomChanges));
    }

    public void addChanges(OWLAxiomChange... axiom){
        addChange(axiom);
    }
}

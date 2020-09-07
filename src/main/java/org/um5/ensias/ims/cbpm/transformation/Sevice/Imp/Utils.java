package org.um5.ensias.ims.cbpm.transformation.Sevice.Imp;

import lombok.Getter;
import lombok.Setter;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.*;

import java.util.Arrays;
@Getter
@Setter
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
    public OWLAxiomChange addObjectPropertytoClass(OWLOntology ontology, OWLObjectProperty objectProperty, OWLClass source, OWLClass target){
        OWLClassExpression expression = dataFactory.getOWLObjectSomeValuesFrom(objectProperty, target);
        OWLSubClassOfAxiom axiom = dataFactory.getOWLSubClassOfAxiom(source, expression);
        return new AddAxiom(ontology, axiom);
    }
    public OWLAxiomChange addObjectproperty(OWLOntology ontology, OWLIndividual target, OWLObjectProperty property, OWLIndividual source) {
        OWLObjectPropertyAssertionAxiom prop= dataFactory.getOWLObjectPropertyAssertionAxiom(property, target, source);
        return new AddAxiom(ontology, prop);
    }

    public void addChange (OWLAxiomChange... axiomChanges){
        manager.applyChanges(Arrays.asList(axiomChanges));
    }

    public void addChanges(OWLAxiomChange... axiom){
        addChange(axiom);
    }
}

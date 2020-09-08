package org.um5.ensias.ims.cbpm.transformation.Sevice.Imp;


import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.*;

import java.util.Arrays;

public class Utils {
    private Utils() {
    }

    public static OWLDataFactory getDataFactory() {
        return dataFactory;
    }

    static OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
    static OWLDataFactory dataFactory = OWLManager.getOWLDataFactory();


    public static IRI convertStringToIRI(String iri){
        return IRI.create(iri);
    }

    public static OWLOntology createOntology(String iri) throws OWLOntologyCreationException {
        return manager.createOntology(convertStringToIRI(iri));
    }

    public static OWLClass createClass(String iri){
        return dataFactory.getOWLClass(convertStringToIRI(iri));
    }

    public static OWLIndividual createIndividual(String iri){
        return dataFactory.getOWLNamedIndividual(convertStringToIRI(iri));
    }

    public static OWLObjectProperty createObjectProperty(String iri){
        return dataFactory.getOWLObjectProperty(convertStringToIRI(iri));
    }

    public static OWLAxiomChange addSubClass(OWLOntology ontology,OWLClass subclass, OWLClass superclass){
        return new AddAxiom(ontology,dataFactory.getOWLSubClassOfAxiom(subclass,superclass));
    }

    public static OWLAxiomChange addIndividualToClass(OWLOntology ontology, OWLClass classe, OWLIndividual individual){
        return new AddAxiom(ontology, dataFactory.getOWLClassAssertionAxiom(classe, individual));
    }
    public static OWLAxiomChange addObjectPropertytoClass(OWLOntology ontology, OWLObjectProperty objectProperty, OWLClass source, OWLClass target){
        OWLClassExpression expression = dataFactory.getOWLObjectSomeValuesFrom(objectProperty, target);
        OWLSubClassOfAxiom axiom = dataFactory.getOWLSubClassOfAxiom(source, expression);
        return new AddAxiom(ontology, axiom);
    }
    public static OWLAxiomChange addObjectproperty(OWLOntology ontology, OWLIndividual target, OWLObjectProperty property, OWLIndividual source) {
        OWLObjectPropertyAssertionAxiom prop= dataFactory.getOWLObjectPropertyAssertionAxiom(property, target, source);
        return new AddAxiom(ontology, prop);
    }

    public static void addChange (OWLAxiomChange... axiomChanges){
        manager.applyChanges(Arrays.asList(axiomChanges));
    }

    public static void addChanges(OWLAxiomChange... axiom){
        addChange(axiom);
    }
}

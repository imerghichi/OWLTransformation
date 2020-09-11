package org.um5.ensias.ims.cbpm.transformation.Sevice.Imp;

import org.junit.jupiter.api.Test;
import org.semanticweb.owlapi.io.StringDocumentTarget;
import org.semanticweb.owlapi.model.OWLOntology;
import org.um5.ensias.ims.cbpm.transformation.model.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class OntologyServiceImpTest {

    @Test
    void convertCBPMtoOWLOntology() throws Exception {
        OntologyServiceImp ontologyServiceImp = new OntologyServiceImp("123");
        CbpmElement event = new CbpmElement();
        event.setNameElement("start");
        event.setCategory(CbpmElementCategory.Event);
        Cbpm cbpm = new Cbpm(event);
        cbpm.setStartEvent(event);
        CbpmElement service =new CbpmElement();
        service.setNameElement("service");
        List<CbpmElement> followers = new ArrayList<>();
        followers.add(service);
        event.setFollowers(followers);
        OWLOntology ontology1 = ontologyServiceImp.convertCBPMtoOWLOntology(cbpm);
        // 3 avec basic ontology + 1 pour follow
        assertEquals(ontology1.getAxiomCount(),4);
    }
    @Test
    void convertCBPMtoOWLOntology2() throws Exception {

        /*
        test avec boucle
         */

        OntologyServiceImp ontologyServiceImp1 = new OntologyServiceImp("345");
        CbpmElement event1 = new CbpmElement();
        event1.setNameElement("start");
        event1.setCategory(CbpmElementCategory.Event);
        Cbpm cbpm1 = new Cbpm(event1);
        CbpmElement service1 =new CbpmElement();
        service1.setNameElement("service");
        List<CbpmElement> followers1 = new ArrayList<>();
        followers1.add(service1);
        event1.setFollowers(followers1);
        CbpmElement gateway = new CbpmElement();
        gateway.setNameElement("gateway");
        List<CbpmElement> followers2 = new ArrayList<>();
        followers2.add(gateway);
        service1.setFollowers(followers2);
        List<CbpmElement> followers3 =new ArrayList<>();
        followers3.add(event1);
        gateway.setFollowers(followers3);
        OWLOntology ontology = ontologyServiceImp1.convertCBPMtoOWLOntology(cbpm1);
        // 3 avec basic ontologormatiomy + 3 pour follow
        assertEquals(ontology.getAxiomCount(),6);
    }

    @Test
    void create_example_ontology() throws Exception {
        OntologyServiceImp service = new OntologyServiceImp("ExampleOntology");
        CbpmElement startEvent = new CbpmElement();
        startEvent.setNameElement("StartEvent");
        startEvent.setCategory(CbpmElementCategory.Event);
        CbpmElement searchTrip= new CbpmElement();
        searchTrip.setNameElement("SearchTrip");
        CbpmElement displayResult= new CbpmElement();
        displayResult.setNameElement("DisplayResult");
        CbpmElement orGateway = new CbpmElement();
        orGateway.setNameElement("ORGateway");
        CbpmElement chooseTrip = new CbpmElement();
        chooseTrip.setNameElement("ChooseTrip");
        CbpmElement displayTrip = new CbpmElement();
        displayTrip.setNameElement("DisplayTrip");
        CbpmElement endEvent = new CbpmElement();
        endEvent.setNameElement("EndEvent");

        startEvent.setFollowers(Collections.singletonList(searchTrip));
        searchTrip.setFollowers(Collections.singletonList(displayResult));
        displayResult.setFollowers(Collections.singletonList(orGateway));
        List<CbpmElement> gatewayFollowers = new ArrayList<>();
        gatewayFollowers.add(chooseTrip);
        gatewayFollowers.add(startEvent);
        orGateway.setFollowers(gatewayFollowers);
        chooseTrip.setFollowers(Collections.singletonList(displayTrip));
        displayTrip.setFollowers(Collections.singletonList(endEvent));

        Cbpm cbpm = new Cbpm(startEvent);

        OWLOntology ontology = service.convertCBPMtoOWLOntology(cbpm);
        StringDocumentTarget target = new StringDocumentTarget();
        Utils.save(ontology,target);

        assertEquals(10, ontology.getAxiomCount());
        File file = new File("example.owl");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(target.toString());
        writer.close();
    }



}
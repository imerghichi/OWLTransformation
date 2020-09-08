package org.um5.ensias.ims.cbpm.transformation.Sevice.Imp;

import org.junit.jupiter.api.Test;
import org.semanticweb.owlapi.io.StringDocumentTarget;
import org.semanticweb.owlapi.model.OWLOntology;
import org.um5.ensias.ims.cbpm.transformation.model.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ServiceImpTest {

    @Test
    void convertCBPMtoOWLOntology() throws Exception {
        ServiceImp serviceImp = new ServiceImp("123");
        Cbpm cbpm = new Cbpm();
        Event event = new Event();
        event.setNameElement("start");
        cbpm.setStartEvent(event);
        Service service =new Service();
        service.setNameElement("service");
        List<CbpmElement> followers = new ArrayList<>();
        followers.add(service);
        event.setFolow(followers);
        OWLOntology ontology1 = serviceImp.convertCBPMtoOWLOntology(cbpm);
        // 3 avec basic ontology + 1 pour follow
        assertEquals(ontology1.getAxiomCount(),4);
    }
    @Test
    void convertCBPMtoOWLOntology2() throws Exception {

        /*
        test avec boucle
         */

        ServiceImp serviceImp1 = new ServiceImp("345");
        Cbpm cbpm1 = new Cbpm();
        Event event1 = new Event();
        event1.setNameElement("start");
        cbpm1.setStartEvent(event1);
        Service service1 =new Service();
        service1.setNameElement("service");
        List<CbpmElement> followers1 = new ArrayList<>();
        followers1.add(service1);
        event1.setFolow(followers1);
        Gateway gateway = new Gateway();
        gateway.setNameElement("gateway");
        List<CbpmElement> followers2 = new ArrayList<>();
        followers2.add(gateway);
        service1.setFolow(followers2);
        List<CbpmElement> followers3 =new ArrayList<>();
        followers3.add(event1);
        gateway.setFolow(followers3);
        OWLOntology ontology = serviceImp1.convertCBPMtoOWLOntology(cbpm1);
        // 3 avec basic ontologormatiomy + 3 pour follow
        assertEquals(ontology.getAxiomCount(),6);
    }

    @Test
    void create_example_ontology() throws Exception {
        ServiceImp service = new ServiceImp("ExampleOntology");
        Event startEvent = new Event();
        startEvent.setNameElement("StartEvent");
        Service searchTrip= new Service();
        searchTrip.setNameElement("SearchTrip");
        Service displayResult= new Service();
        displayResult.setNameElement("DisplayResult");
        Gateway orGateway = new Gateway();
        orGateway.setNameElement("ORGateway");
        Service chooseTrip = new Service();
        chooseTrip.setNameElement("ChooseTrip");
        Service displayTrip = new Service();
        displayTrip.setNameElement("DisplayTrip");
        Event endEvent = new Event();
        endEvent.setNameElement("EndEvent");

        startEvent.setFolow(Collections.singletonList(searchTrip));
        searchTrip.setFolow(Collections.singletonList(displayResult));
        displayResult.setFolow(Collections.singletonList(orGateway));
        List<CbpmElement> gatewayFollowers = new ArrayList<>();
        gatewayFollowers.add(chooseTrip);
        gatewayFollowers.add(startEvent);
        orGateway.setFolow(gatewayFollowers);
        chooseTrip.setFolow(Collections.singletonList(displayTrip));
        displayTrip.setFolow(Collections.singletonList(endEvent));

        Cbpm cbpm = new Cbpm();
        cbpm.setStartEvent(startEvent);

        OWLOntology ontology = service.convertCBPMtoOWLOntology(cbpm);
        StringDocumentTarget target = new StringDocumentTarget();
        Utils.save(ontology,target);
        File file = new File("example.owl");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(target.toString());
        writer.close();
    }



}
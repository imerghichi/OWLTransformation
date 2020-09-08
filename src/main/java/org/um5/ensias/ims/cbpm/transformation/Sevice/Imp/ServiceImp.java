package org.um5.ensias.ims.cbpm.transformation.Sevice.Imp;

import lombok.Getter;
import lombok.Setter;
import org.semanticweb.owlapi.model.*;
import org.um5.ensias.ims.cbpm.transformation.Sevice.Service;
import org.um5.ensias.ims.cbpm.transformation.model.Cbpm;
import org.um5.ensias.ims.cbpm.transformation.model.CbpmElement;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ServiceImp implements Service {
    private List<CbpmElement> done = new ArrayList<>();
    private String baseIRI;
    @Override
    public OWLOntology convertCBPMtoOWLOntology(Cbpm cbpm) throws Exception {
        OWLOntology ontology = createBasicOntology();
        addElementAsIndividual(cbpm.getStartEvent(),ontology);
        return ontology;
    }

    public void addAllIndividualsfromRoot(CbpmElement root, OWLOntology ontology) throws Exception {
        addElementAsIndividual(root, ontology);
        OWLObjectProperty propFollow = Utils.createObjectProperty(baseIRI+"#follows");
        done.add(root);
        if(root.getFolow()!=null){
            for (CbpmElement element:
                    root.getFolow()) {
                if(!done.contains(element)){
                    addAllIndividualsfromRoot(element, ontology);
                    done.add(element);
                    //todo completer le raisonnement
                }
                else{

                }

            }
        }

    }


    public OWLIndividual addElementAsIndividual(CbpmElement cbpmElement, OWLOntology ontology) throws Exception {
        if (cbpmElement == null) throw new Exception("CBPM Element must be not null");
        switch (cbpmElement.getClass().getSimpleName()){
            case "Event":
                OWLIndividual individualAsEvent = Utils.createIndividual(cbpmElement.getNameElement());
                Utils.addIndividualToClass(ontology,Utils.getDataFactory().getOWLClass(baseIRI+"#event"),individualAsEvent);
                return individualAsEvent;
            case "Gateway":
                OWLIndividual individualAsGateway = Utils.createIndividual(cbpmElement.getNameElement());
                Utils.addIndividualToClass(ontology,Utils.getDataFactory().getOWLClass(baseIRI+"#gateway"),individualAsGateway);
                return individualAsGateway;
            case "Service":
                OWLIndividual individualAsService = Utils.createIndividual(cbpmElement.getNameElement());
                Utils.addIndividualToClass(ontology,Utils.getDataFactory().getOWLClass(baseIRI+"#service"),individualAsService);
                return individualAsService;
            default:
                throw new Exception("Class Not Found");
        }
    }

    public ServiceImp(String baseIRI) {
        this.baseIRI = baseIRI;
    }

    public ServiceImp() {
    }

    public OWLOntology createBasicOntology() throws OWLOntologyCreationException {
       OWLOntology ontology = Utils.createOntology(baseIRI);
       OWLClass processElement = Utils.createClass(baseIRI+"#processElement");
       OWLClass event = Utils.createClass(baseIRI+"#event");
       OWLClass gateway = Utils.createClass(baseIRI+"#gateway");
       OWLClass service = Utils.createClass(baseIRI+"#service");
       OWLAxiomChange axiomChange1 = Utils.addSubClass(ontology,event,processElement);
       OWLAxiomChange axiomChange2 = Utils.addSubClass(ontology,gateway,processElement);
       OWLAxiomChange axiomChange3 = Utils.addSubClass(ontology,service,processElement);
        Utils.addChange(axiomChange1);
        Utils.addChange(axiomChange2);
        Utils.addChange(axiomChange3);
       return ontology;
    }

}

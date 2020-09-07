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
    private Utils utils = new Utils();
    private String baseIRI;
    @Override
    public OWLOntology convertCBPMtoOWLOntology(Cbpm cbpm) throws Exception {
        OWLOntology ontology = createBasicOntology();
        addElementAsIndividual(cbpm.getStartEvent(),ontology);
        return ontology;
    }

    public void addAllIndividualsfromRoot(CbpmElement root, OWLOntology ontology) throws Exception {
        addElementAsIndividual(root, ontology);
        OWLObjectProperty propFollow = utils.createObjectProperty(baseIRI+"#follows");
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
                OWLIndividual individualAsEvent = utils.createIndividual(cbpmElement.getNameElement());
                utils.addIndividualToClass(ontology,utils.getDataFactory().getOWLClass(baseIRI+"#event"),individualAsEvent);
                return individualAsEvent;
            case "Gateway":
                OWLIndividual individualAsGateway = utils.createIndividual(cbpmElement.getNameElement());
                utils.addIndividualToClass(ontology,utils.getDataFactory().getOWLClass(baseIRI+"#gateway"),individualAsGateway);
                return individualAsGateway;
            case "Service":
                OWLIndividual individualAsService = utils.createIndividual(cbpmElement.getNameElement());
                utils.addIndividualToClass(ontology,utils.getDataFactory().getOWLClass(baseIRI+"#service"),individualAsService);
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

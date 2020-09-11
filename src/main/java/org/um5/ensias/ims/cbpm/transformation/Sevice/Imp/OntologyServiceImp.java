package org.um5.ensias.ims.cbpm.transformation.Sevice.Imp;

import lombok.Getter;
import lombok.Setter;
import org.semanticweb.owlapi.model.*;
import org.springframework.stereotype.Service;
import org.um5.ensias.ims.cbpm.transformation.Sevice.OntologyService;
import org.um5.ensias.ims.cbpm.transformation.model.Cbpm;
import org.um5.ensias.ims.cbpm.transformation.model.CbpmElement;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Service
public class OntologyServiceImp implements OntologyService {
    private List<CbpmElement> done = new ArrayList<>();
    private String baseIRI = "defaultIRI";
    @Override
    public OWLOntology convertCBPMtoOWLOntology(Cbpm cbpm) throws Exception {
        OWLOntology ontology = createBasicOntology();
        addAllIndividualsfromRoot(cbpm.getStartEvent(),ontology);
        return ontology;
    }

    public OntologyServiceImp() {
    }

    public OntologyServiceImp(String baseIRI) {
        this.baseIRI = baseIRI;
    }

    public void addAllIndividualsfromRoot(CbpmElement root, OWLOntology ontology) throws Exception {
        OWLIndividual rootIndividual =  getElementAsIndividual(root);
        addElementAsIndividualToClass(ontology,rootIndividual,root);
        OWLObjectProperty propFollow = Utils.createObjectProperty(baseIRI+"#follows");
        done.add(root);
        if(root.getFollowers()!=null){
            for (CbpmElement element:
                    root.getFollowers()) {
                if(!done.contains(element)){
                    Utils.addChange(Utils.addObjectproperty(ontology,getElementAsIndividual(element),propFollow,rootIndividual));
                    addAllIndividualsfromRoot(element,ontology);
                    done.add(element);
                }
                else{
                    Utils.addChange(Utils.addObjectproperty(ontology,getElementAsIndividual(element),propFollow,rootIndividual));
                }

            }
        }

    }
    public void addElementAsIndividualToClass(OWLOntology ontology, OWLIndividual individual, CbpmElement element){
        Utils.addIndividualToClass(ontology, Utils.getDataFactory().getOWLClass(baseIRI+"#"+element.getClass().getSimpleName().toLowerCase()),individual);
    }


    public OWLIndividual getElementAsIndividual(CbpmElement cbpmElement) throws Exception {
        if (cbpmElement == null) throw new Exception("CBPM Element must be not null");
        switch (cbpmElement.getClass().getSimpleName()){
            case "Event":
            case "Gateway":
            case "Service":
                return Utils.createIndividual(cbpmElement.getNameElement());
            default:
                throw new Exception("Class Not Found");
        }
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

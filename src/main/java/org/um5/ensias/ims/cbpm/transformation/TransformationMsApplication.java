package org.um5.ensias.ims.cbpm.transformation;

import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.um5.ensias.ims.cbpm.transformation.Sevice.Imp.ServiceImp;
import org.um5.ensias.ims.cbpm.transformation.Sevice.Service;
import org.um5.ensias.ims.cbpm.transformation.model.Cbpm;

@SpringBootApplication
public class TransformationMsApplication {

	public static void main(String[] args) throws OWLOntologyCreationException {
		SpringApplication.run(TransformationMsApplication.class, args);
		ServiceImp serviceImp = new ServiceImp();
		System.out.println(serviceImp.createBasicOntology());
	}

}

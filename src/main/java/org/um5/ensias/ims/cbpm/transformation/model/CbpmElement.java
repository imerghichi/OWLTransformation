package org.um5.ensias.ims.cbpm.transformation.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CbpmElement {
	//I add it to get the IRI
	private String nameElement;
	private List<CbpmElement> Folow;

}

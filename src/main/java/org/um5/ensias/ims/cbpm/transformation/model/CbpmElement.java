package org.um5.ensias.ims.cbpm.transformation.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CbpmElement {
	private List<CbpmElement> Folow;

}

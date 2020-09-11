package org.um5.ensias.ims.cbpm.transformation.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class CbpmElement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	//I add it to get the IRI
	private String nameElement;
	@Enumerated(EnumType.STRING)
	private CbpmElementCategory category;
	@OneToMany
	private List<CbpmElement> followers;

}

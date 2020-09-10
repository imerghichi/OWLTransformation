package org.um5.ensias.ims.cbpm.transformation.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class CbpmElement  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	//I add it to get the IRI
	private String nameElement;
	@OneToMany
	private List<CbpmElement> Folow;

}

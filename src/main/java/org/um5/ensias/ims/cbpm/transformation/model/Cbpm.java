package org.um5.ensias.ims.cbpm.transformation.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Data
@Entity
@Table
public class Cbpm {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_cbpm;
	@OneToOne(orphanRemoval = true)
	private Event startEvent;

}

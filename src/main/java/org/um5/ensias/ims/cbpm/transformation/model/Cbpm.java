package org.um5.ensias.ims.cbpm.transformation.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Cbpm {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@OneToOne
	private CbpmElement startEvent;

	public Cbpm(CbpmElement startEvent) throws Exception {
		if(startEvent.getCategory() != CbpmElementCategory.Event) throw (new Exception("Start Event must not be a Service nor a Gateway"));
		this.startEvent = startEvent;
	}

	public Cbpm() {
		CbpmElement startEvent = new CbpmElement();
		startEvent.setCategory(CbpmElementCategory.Event);
		this.startEvent = startEvent;
	}
}

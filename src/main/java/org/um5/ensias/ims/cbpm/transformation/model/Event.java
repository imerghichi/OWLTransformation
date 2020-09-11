package org.um5.ensias.ims.cbpm.transformation.model;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Event")
public class Event extends CbpmElement{

}

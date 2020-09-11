package org.um5.ensias.ims.cbpm.transformation.model;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table
@DiscriminatorValue("Event")
public class Event extends CbpmElement{

}

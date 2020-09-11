package org.um5.ensias.ims.cbpm.transformation.model;



import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
@DiscriminatorValue("Service")
public class Service extends CbpmElement{

}

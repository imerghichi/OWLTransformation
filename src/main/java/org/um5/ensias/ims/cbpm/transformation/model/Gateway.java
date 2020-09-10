package org.um5.ensias.ims.cbpm.transformation.model;



import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table
@PrimaryKeyJoinColumn(name = "id")
public class Gateway  extends CbpmElement{
	

}

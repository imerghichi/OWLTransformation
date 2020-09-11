package org.um5.ensias.ims.cbpm.transformation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.um5.ensias.ims.cbpm.transformation.model.CbpmElement;

public interface CbpmElementRepository extends JpaRepository<CbpmElement,Long> {
}

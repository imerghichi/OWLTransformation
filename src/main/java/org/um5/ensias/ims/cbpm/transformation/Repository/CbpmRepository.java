package org.um5.ensias.ims.cbpm.transformation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.um5.ensias.ims.cbpm.transformation.model.Cbpm;

@Repository
public interface CbpmRepository extends JpaRepository<Cbpm,Long> {
}

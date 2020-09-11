package org.um5.ensias.ims.cbpm.transformation.Sevice;


import org.um5.ensias.ims.cbpm.transformation.model.Cbpm;

import java.util.List;
import java.util.Optional;

public interface CrudCbpmService {
    List<Cbpm> findAll();
    Optional<Cbpm> findById(long id);
    void deleteById(long Id);
    Cbpm create(Cbpm cbpm);
    Cbpm update(Cbpm cbpm);
}

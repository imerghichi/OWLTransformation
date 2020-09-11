package org.um5.ensias.ims.cbpm.transformation.Sevice;


import org.um5.ensias.ims.cbpm.transformation.model.Cbpm;

import java.util.List;

public interface CrudService {
    List<Cbpm> findAll();
    Cbpm findById(long id);
    void deleteById(long Id);
    Cbpm create(Cbpm cbpm);
    Cbpm update(Cbpm cbpm);
}

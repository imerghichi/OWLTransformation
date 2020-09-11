package org.um5.ensias.ims.cbpm.transformation.Sevice;


import org.um5.ensias.ims.cbpm.transformation.model.CbpmElement;

import java.util.List;

public interface CrudCbpmElementService {
    List<CbpmElement> findAll();
    CbpmElement findById(long id);
    void deleteById(long id);
    CbpmElement create (CbpmElement cbpmElement);
    CbpmElement update (CbpmElement cbpmElement);
}

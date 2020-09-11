package org.um5.ensias.ims.cbpm.transformation.Sevice.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.um5.ensias.ims.cbpm.transformation.Repository.CbpmElementRepository;
import org.um5.ensias.ims.cbpm.transformation.Sevice.CrudCbpmElementService;
import org.um5.ensias.ims.cbpm.transformation.model.CbpmElement;

import java.util.List;

@Service
public class CrudCbpmElementServiceImp implements CrudCbpmElementService {

    @Autowired
    CbpmElementRepository cbpmElementRepository;


    @Override
    public List<CbpmElement> findAll() {
        return cbpmElementRepository.findAll();
    }

    @Override
    public CbpmElement findById(long id) {
        return cbpmElementRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(long id) {
        cbpmElementRepository.deleteById(id);
    }

    @Override
    public CbpmElement create(CbpmElement cbpmElement) {
        return cbpmElementRepository.save(cbpmElement);
    }

    @Override
    public CbpmElement update(CbpmElement cbpmElement) {
        return cbpmElementRepository.save(cbpmElement);
    }
}

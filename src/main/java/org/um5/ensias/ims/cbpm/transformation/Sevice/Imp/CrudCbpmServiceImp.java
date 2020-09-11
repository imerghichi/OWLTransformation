package org.um5.ensias.ims.cbpm.transformation.Sevice.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.um5.ensias.ims.cbpm.transformation.Repository.CbpmRepository;
import org.um5.ensias.ims.cbpm.transformation.Sevice.CrudCbpmService;
import org.um5.ensias.ims.cbpm.transformation.model.Cbpm;

import java.util.List;
import java.util.Optional;

@Service
public class CrudCbpmServiceImp implements CrudCbpmService {

    @Autowired
    CbpmRepository cbpmRepository;

    @Override
    public List<Cbpm> findAll() {
        return cbpmRepository.findAll();
    }

    @Override
    public Optional<Cbpm> findById(long id) {
        return cbpmRepository.findById(id);
    }

    @Override
    public void deleteById(long id) {
        cbpmRepository.deleteById(id);
    }

    @Override
    public Cbpm create(Cbpm cbpm) {
        return cbpmRepository.save(cbpm);
    }

    @Override
    public Cbpm update(Cbpm cbpm) {
        return cbpmRepository.save(cbpm);
    }
}
